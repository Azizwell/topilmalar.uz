package org.example.topilma.controller;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/file")
public class FileController {
  @PostMapping
  public String saveFile(@RequestParam MultipartFile file) throws IOException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    String timestamp = LocalDateTime.now().format(formatter);

    String fileName = timestamp + "_" + file.getOriginalFilename();

    try (FileOutputStream outputStream = new FileOutputStream("files/" + fileName)) {
      outputStream.write(file.getBytes());

    }

    return fileName;
  }

  @GetMapping("/{name}")
  public void getFile(@PathVariable String name, HttpServletResponse response) throws IOException {
    FileInputStream inputStream = new FileInputStream("files/" + name);
    ServletOutputStream outputStream = response.getOutputStream();
    inputStream.transferTo(outputStream);
    outputStream.close();

  }

}
