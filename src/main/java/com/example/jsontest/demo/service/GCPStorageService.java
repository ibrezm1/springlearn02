package com.example.jsontest.demo.service;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class GCPStorageService {

    @Autowired
    private Storage storage;

    // Upload JSON string to GCP storage in a given bucket and folder path
    public void uploadJsonToGCPStorage(String bucketName, String folderPath, String fileName, String jsonString) {
        String blobName = folderPath + "/" + fileName;
        BlobId blobId = BlobId.of(bucketName, blobName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/json").build();
        storage.create(blobInfo, jsonString.getBytes(StandardCharsets.UTF_8));
    }
}
