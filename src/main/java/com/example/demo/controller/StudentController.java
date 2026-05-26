package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.Map;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.cloudinary.utils.ObjectUtils;
import com.cloudinary.Cloudinary;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private Cloudinary cloudinary;  // ✅ Movido DENTRO de la clase

    // =========================
    // GET ALL
    // =========================
    @GetMapping
    public List<Student> listar() {
        return service.listar();
    }

    // =========================
    // SAVE STUDENT
    // =========================
    @PostMapping
    public Student guardar(@RequestBody Student student) {

        student.setId(null);

        return service.guardar(student);
    }

    // =========================
    // UPLOAD FACE TO CLOUDINARY (NUEVO)
    // =========================
    @PostMapping("/upload-face-cloudinary")
    public String uploadFaceToCloudinary(
            @RequestBody Map<String, String> body
    ) {

        try {

            String fullName = body.get("fullName");
            String image = body.get("image");

            image = image.replace(
                    "data:image/jpeg;base64,",
                    ""
            );

            byte[] imageBytes = Base64
                    .getDecoder()
                    .decode(image);

            Map uploadResult = cloudinary.uploader().upload(
                    imageBytes,
                    ObjectUtils.asMap(
                            "folder",
                            "smartattendance/" + fullName
                    )
            );

            return uploadResult.get("secure_url").toString();

        } catch (Exception e) {

            return e.getMessage();
        }
    }

    // =========================
    // UPLOAD FACE TO LOCAL DATASET (TU MÉTODO ORIGINAL)
    // =========================
    @PostMapping("/upload-face-local")
    public String uploadFaceLocal(
            @RequestBody Map<String, String> body
    ) {

        try {

            String fullName = body.get("fullName");

            String image = body.get("image");

            // quitar encabezado base64
            image = image.replace(
                    "data:image/jpeg;base64,",
                    ""
            );

            byte[] imageBytes = Base64.getDecoder().decode(image);

            File folder = new File(
                    "dataset/" + fullName
            );

            if (!folder.exists()) {
                folder.mkdirs();
            }

            int count = folder.listFiles().length;

            File file = new File(
                    folder,
                    count + ".jpg"
            );

            FileOutputStream fos = new FileOutputStream(file);

            fos.write(imageBytes);

            fos.close();

            return "Saved";

        } catch (Exception e) {

            return e.getMessage();
        }
    }

    @PostMapping("/upload-face")
    public String uploadFace(
            @RequestBody Map<String, String> body
    ) {

        try {

            String image = body.get("image");

            image = image.replace(
                    "data:image/jpeg;base64,",
                    ""
            );

            byte[] imageBytes = Base64
                    .getDecoder()
                    .decode(image);

            Map uploadResult = cloudinary.uploader().upload(
                    imageBytes,
                    ObjectUtils.asMap(
                            "folder",
                            "smartattendance"
                    )
            );

            return uploadResult.get("secure_url").toString();

        } catch (Exception e) {

            return e.getMessage();
        }
    }

    // =========================
    // START FACE REGISTRATION
    // =========================
    @PostMapping("/start-registration")
    public String startRegistration(
            @RequestParam String name,
            @RequestParam String email
    ) {

        try {

            ProcessBuilder processBuilder = new ProcessBuilder(
                    "cmd.exe",
                    "/c",
                    "start",
                    "cmd.exe",
                    "/k",
                    "python C:/Users/cerda/smartattendance/ai-service/register_student.py \""
                    + name + "\" \"" + email + "\""
            );

            processBuilder.start();

            return "Camera opened";

        } catch (Exception e) {

            e.printStackTrace();

            return e.getMessage();
        }
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
