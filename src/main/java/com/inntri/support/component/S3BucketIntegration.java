package com.inntri.support.component;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.inntri.support.config.AppPropertiesConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Slf4j
@Data
@Component
public class S3BucketIntegration {

    @Autowired
    private AppPropertiesConfig propertiesConfig;

    private AWSCredentials credentials;

    private AmazonS3 s3client;

    /*@Value("${ftp.uploadedFolderName}")
    private String uploadedFolderLocation;*/

    /*@Value("${ftp.uploadedReport}")
    private String reportUploaded;*/

    /*@Value("${ftp.s3Key}")
    private String s3Key;
    @Value("${ftp.s3SecretKey}")
    private String s3SecretKey;

    @Value("${ftp.bucketName}")
    private String bucketName;*/

    /*@Value("${ftp.downloadFolderName}")
    private String downloadFolderName;*/

    private AmazonS3 getS3client() {
        if (this.s3client == null) {
            log.info("<=== this.s3Key ===> {}", propertiesConfig.getS3().getAccessKey());
            log.info("<=== this.s3SecretKey ===> {}", propertiesConfig.getS3().getSecretKey());
            credentials = new BasicAWSCredentials(propertiesConfig.getS3().getAccessKey(), propertiesConfig.getS3().getSecretKey());//initialize s3 bucket
            this.s3client = new AmazonS3Client(credentials);
        }
        return s3client;
    }

    public String uploadFileToS3Bucket(File file,String type) throws SdkClientException, AmazonServiceException {
        String filePathName = propertiesConfig.getS3().getUploadedFolderName() + type + "/" + file.getName();
        getS3client().putObject(new PutObjectRequest(propertiesConfig.getS3().getBucketName(), filePathName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        return filePathName;
    }

    public String uploadFileToS3BucketWithFilePath(File file,String filePathName) throws SdkClientException, AmazonServiceException {
        //String filePathName = propertiesConfig.getS3().getUploadedFolderName() + type + "/" + file.getName();
        getS3client().putObject(new PutObjectRequest(propertiesConfig.getS3().getBucketName(), filePathName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        return filePathName;
    }


    public String uploadWithoutPrefixed(String location,File file,String type) throws SdkClientException, AmazonServiceException {
        String filePathName = location + type + "/" + file.getName();
        getS3client().putObject(new PutObjectRequest(propertiesConfig.getS3().getBucketName(), filePathName, file)
          .withCannedAcl(CannedAccessControlList.PublicRead));
        return type + "/" + file.getName();
    }

    public String uploadAssociationFile(String location,File file,String type) throws SdkClientException, AmazonServiceException {
        String filePathName = location + type + "/" + file.getName();
        getS3client().putObject(new PutObjectRequest(propertiesConfig.getS3().getBucketName(), filePathName, file)
          .withCannedAcl(CannedAccessControlList.PublicRead));
        return filePathName;
    }

    public void deleteFromS3(String filePathName) {
        getS3client().deleteObject(propertiesConfig.getS3().getBucketName(), filePathName);
        log.debug("deleted successfully : " + filePathName);
    }

    public S3Object downloadFile(String fileName, String type) {
        log.info("file name : {} {}" ,propertiesConfig.getS3().getBucketName(), fileName);
        //https://cdn.cse.lk/cmt/upload_report_file/371_1338979336307.pdf
        if (fileName != null) {
            //String fileName = new File(filePathName).getName();
            log.info("file type : {}" ,type);
            String filePathName = propertiesConfig.getS3().getUploadedFolderName() + type + "/" + fileName;

            File localFile = new File(filePathName);
            try {
                getS3client().getObject(new GetObjectRequest(propertiesConfig.getS3().getBucketName(), filePathName), localFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean success = localFile.exists() && localFile.canRead();
            log.info("file name : {}" ,success);
        }

        return null;
    }
}
