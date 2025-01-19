package com.inntri.support.service;

import java.io.File;

public interface FileOperationService {
    File generateFileFromBase64String(String base64Str);

    void deleteFileFromThePath(File image);

    String uploadObjectToS3(String base64String, String folderName);

    String uploadFile(File file, String folderName);
}
