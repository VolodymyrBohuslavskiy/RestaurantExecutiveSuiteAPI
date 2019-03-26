package com.example.res.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
public class TransferFileService {

    public void transfer(MultipartFile file, String path) throws IOException {
        file.transferTo(new File(path, Objects.requireNonNull(file.getOriginalFilename())));
    }

    public void transfer(MultipartFile file) throws IOException {
        file.transferTo(new File("D:\\Q2", Objects.requireNonNull(file.getOriginalFilename())));

    }
}
