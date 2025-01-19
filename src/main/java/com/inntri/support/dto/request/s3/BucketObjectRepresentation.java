package com.inntri.support.dto.request.s3;

import lombok.Data;

@Data
public class BucketObjectRepresentation {

    private String folderName;

    private String objectName;

    private String base64String;
}
