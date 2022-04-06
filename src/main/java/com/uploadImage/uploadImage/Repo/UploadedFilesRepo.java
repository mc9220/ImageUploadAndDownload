package com.uploadImage.uploadImage.Repo;

import com.uploadImage.uploadImage.Model.UploadedFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadedFilesRepo extends JpaRepository<UploadedFiles,Long> {
}
