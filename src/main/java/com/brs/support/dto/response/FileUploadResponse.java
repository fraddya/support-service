package com.brs.support.dto.response;

import lombok.Data;

@Data
public class FileUploadResponse {

    private String filePath;

    public FileUploadResponse(){}
    public FileUploadResponse(String filePath){
        this.filePath = filePath;
    }

}
