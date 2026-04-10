package com.example.demo.service;

import com.example.demo.model.BitacoraEvento;
import com.example.demo.repository.BitacoraRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

@Service
public class BitacoraService {

    @Autowired
    private BitacoraRepository repository;

    @Autowired
    private ObjectMapper objectMapper; // Para convertir objetos a JSON

    public List<BitacoraEvento> listar() {
        return repository.findAllByOrderByFechaDeEventoDesc();
    }

    /**
     * Método centralizado para registrar eventos 
     */
    public void registrarEvento(String tabla, String tipo, String descripcion, Object anterior, Object posterior, Exception ex) {
        BitacoraEvento evento = new BitacoraEvento();
        evento.setTablaDeEvento(tabla);
        evento.setTipoDeEvento(tipo);
        evento.setFechaDeEvento(new Date());
        evento.setDescripcionDeEvento(descripcion);
        
        // Manejo de StackTrace en caso de error [cite: 125]
        if (ex != null) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            evento.setStackTrace(sw.toString());
            if(descripcion == null) evento.setDescripcionDeEvento(ex.getMessage());
        } else {
            evento.setStackTrace("N/A");
        }

        // Conversión a JSON de datos anteriores y posteriores 
        try {
            if (anterior != null) evento.setDatosAnteriores(objectMapper.writeValueAsString(anterior));
            if (posterior != null) evento.setDatosPosteriores(objectMapper.writeValueAsString(posterior));
        } catch (Exception e) {
            evento.setDescripcionDeEvento("Error serializando JSON: " + e.getMessage());
        }

        repository.save(evento);
    }
}