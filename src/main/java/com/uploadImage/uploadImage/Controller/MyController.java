package com.uploadImage.uploadImage.Controller;

import com.uploadImage.uploadImage.FileHandle.FileUploadUtil;
import com.uploadImage.uploadImage.FileUploadService.FileUploadServiceImpl;
import com.uploadImage.uploadImage.Model.Users;
import com.uploadImage.uploadImage.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
public class MyController {
    @Autowired
    private UserRepo repo;

    @Autowired
    private FileUploadServiceImpl fileUploadService;
    @PostMapping("/users/save/image")
    public void saveUser(@RequestParam("file") MultipartFile multipartFile) throws IOException {
fileUploadService.saveUserImage(multipartFile);

    }

    @PostMapping("saveImage")
    public void saveImage(@RequestParam("file") MultipartFile file)
    {
        fileUploadService.saveImage(file);
    }

    @GetMapping("/downloadImage/{Id}")
    public Users download(@PathVariable("Id") Long fid)
    {
        return fileUploadService.downloadImage(fid);
    }

    @GetMapping("/getImageUrl/{Id}")
    public String getImageUrl(@PathVariable("Id") Long fid)
    {
        return fileUploadService.getImageUrl(fid);
    }
}
