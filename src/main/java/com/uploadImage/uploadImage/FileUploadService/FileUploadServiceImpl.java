package com.uploadImage.uploadImage.FileUploadService;

import com.uploadImage.uploadImage.Model.UploadedFiles;
import com.uploadImage.uploadImage.Model.Users;
import com.uploadImage.uploadImage.Repo.UploadedFilesRepo;
import com.uploadImage.uploadImage.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadServiceImpl {
@Autowired
private UserRepo userRepo;

@Autowired
private UploadedFilesRepo uploadedFilesRepo;
private String uploadFolderPath="C:\\Users\\Public\\Pictures\\";
    public void saveImage(MultipartFile file) {
        UploadedFiles uploadedFiles=new UploadedFiles();
        uploadedFiles.setFileName(file.getOriginalFilename());
        uploadedFilesRepo.save(uploadedFiles);
        try {
            byte[] data= file.getBytes();
            Path path= Paths.get(uploadFolderPath+file.getOriginalFilename());
            Files.write(path,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveUserImage(MultipartFile multipartFile) {
        Users users=new Users();
        users.setFileName(multipartFile.getOriginalFilename());
        users.setFileType(multipartFile.getContentType());
        try {
            users.setFileData(multipartFile.getBytes());
            userRepo.save(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Users downloadImage(Long fid) {

        return userRepo.findById(fid).get();
    }

    public String getImageUrl(Long fid) {

       UploadedFiles uploadedFilesreturn= uploadedFilesRepo.findById(fid).get();
    return uploadFolderPath+uploadedFilesreturn.getFileName();
    }
}
