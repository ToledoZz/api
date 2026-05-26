package com.example.demo.controller;

import com.example.demo.model.StudentFace;
import com.example.demo.service.StudentFaceService;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/faces")
@CrossOrigin
public class StudentFaceController {

    @Autowired
    private StudentFaceService service;

    @Autowired
    private Cloudinary cloudinary;

    // =========================
    // GUARDAR FOTO EN CLOUDINARY + DB
    // =========================
    @PostMapping
    public StudentFace save(@RequestBody Map<String, String> body) {

        try {

            // 1. recibir datos desde React
            String image = body.get("imageUrl");
            Integer studentId = Integer.parseInt(body.get("studentId"));

            // 2. limpiar base64
            image = image.replace("data:image/jpeg;base64,", "");

            byte[] imageBytes = Base64.getDecoder().decode(image);

            // 3. subir a Cloudinary
            Map upload = cloudinary.uploader().upload(
                    imageBytes,
                    ObjectUtils.asMap(
                            "folder",
                            "smartattendance"
                    )
            );

            String url = upload.get("secure_url").toString();

            // 4. guardar en BD
            StudentFace face = new StudentFace();
            face.setStudentId(studentId);
            face.setImageUrl(url);

            return service.guardar(face);

        } catch (Exception e) {
            throw new RuntimeException("Error uploading face: " + e.getMessage());
        }
    }

    // =========================
    // OBTENER TODAS LAS FACES
    // =========================
    @GetMapping
    public List<StudentFace> listar() {
        return service.listar();
    }

    // =========================
    // OBTENER FACES POR ESTUDIANTE (MUY IMPORTANTE PARA PYTHON)
    // =========================
    @GetMapping("/student/{studentId}")
    public List<StudentFace> getByStudent(@PathVariable Integer studentId) {
        return service.listar().stream()
                .filter(f -> f.getStudentId().equals(studentId))
                .toList();
    }
}