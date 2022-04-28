package com.example.module11requestpartphotoupload.controller;

import com.example.module11requestpartphotoupload.memory.InMemoryPhotoStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

@Controller
public class PhotoController {

    @Autowired
    private InMemoryPhotoStore inMemoryPhotoStore;

    @ModelAttribute("files")
    public Set<String> getFileNames() {
        return this.inMemoryPhotoStore.getFileNames();
    }

    @GetMapping({"/", "/images"})
    public String index(
            @ModelAttribute("files") Set<String> files
    ) {
        return "/index";
    }

    @GetMapping("/load-photo/{fileName}")
    @ResponseBody
    public byte[] loadPhoto(
            @PathVariable(name = "fileName") String fileName
    ) {
        return this.inMemoryPhotoStore.getFile(fileName);
    }

    @PostMapping("/save-photo")
    public String savePhoto(
            @RequestPart("fileName") MultipartFile multipartFile
    ) throws IOException {

        this.inMemoryPhotoStore.save(multipartFile.getOriginalFilename(), multipartFile.getBytes());
        return "redirect:/images";
    }
}
