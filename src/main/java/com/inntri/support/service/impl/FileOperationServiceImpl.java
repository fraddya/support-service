package com.inntri.support.service.impl;


import com.inntri.support.component.S3BucketIntegration;
import com.inntri.support.service.FileOperationService;
import com.inntri.support.utils.SupportConstant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Service
@AllArgsConstructor
public class FileOperationServiceImpl implements FileOperationService {

    private final S3BucketIntegration s3BucketIntegration;



    /*@Override
    public File generateFileFromBase64String(String base64Str) {
        File file = null;
        //jpg,jpeg,png,gif
        if (base64Str.contains("data:image/jpeg;")) {
            //log.info("data:image/jpeg; => {}",base64Str.contains("data:image/jpeg;"));
            base64Str = base64Str.replace("data:image/jpeg;base64,", "");
            file = writeToFile(base64Str,"jpeg");
        } else if (base64Str.contains("data:/jpeg;")) {
            //log.info("base64Str data:image/jpg; => {}",base64Str.contains("data:image/jpg;"));
            base64Str = base64Str.replace("data:/jpeg;base64,", "");
            file = writeToFile(base64Str,"jpeg");
        }else if (base64Str.contains("data:image/jpg;")) {
            //log.info("base64Str data:image/jpg; => {}",base64Str.contains("data:image/jpg;"));
            base64Str = base64Str.replace("data:image/jpg;base64,", "");
            file = writeToFile(base64Str,"jpg");
        } else if (base64Str.contains("data:image/png;")) {
            //log.info("base64Str data:image/png => {}",base64Str.contains("data:image/png;"));
            base64Str = base64Str.replace("data:image/png;base64,", "");
            file = writeToFile(base64Str,"png");
        } else if (base64Str.contains("data:image/gif;")) {
            //log.info("base64Str data:image/gif => {}",base64Str.contains("data:image/gif;"));
            base64Str = base64Str.replace("data:image/gif;base64,", "");
            file = writeToFile(base64Str,"gif");
        } else if (base64Str.contains("data:application/pdf;")) {
            //log.info("base64Str data:application/pdf; => {}",base64Str.contains("data:application/pdf;"));
            base64Str = base64Str.replace("data:application/pdf;base64,", "");
            file = writeToFile(base64Str,"pdf");
        } else if (base64Str.contains("data:text/plain;base64,")){
            base64Str = base64Str.replace("data:text/plain;base64,", "");
            file = writeToFile(base64Str,"txt");
        } else if (base64Str.contains("data:/png;base64,")) {
            base64Str = base64Str.replace("data:/png;base64,", "");
            file = writeToFile(base64Str,"png");
        }
        else {
            file = writeToFile(base64Str,"txt");
        }
        return file;
    }*/


    @Override
    public File generateFileFromBase64String(String base64Str) {
        File file = null;
        //jpg,jpeg,png,gif
        if (base64Str.contains("data:image/jpeg;")) {
            base64Str = base64Str.replace("data:image/jpeg;base64,", "");
            file = writeToFile(base64Str,"jpeg");
        } else if (base64Str.contains("data:/jpeg;")) {
            //log.info("base64Str data:image/jpg; => {}",base64Str.contains("data:image/jpg;"));
            base64Str = base64Str.replace("data:/jpeg;base64,", "");
            file = writeToFile(base64Str,"jpeg");
        }else if (base64Str.contains("data:image/jpg;")) {
            //log.info("base64Str data:image/jpg; => {}",base64Str.contains("data:image/jpg;"));
            base64Str = base64Str.replace("data:image/jpg;base64,", "");
            file = writeToFile(base64Str,"jpg");
        } else if (base64Str.contains("data:image/png;")) {
            //log.info("base64Str data:image/png => {}",base64Str.contains("data:image/png;"));
            base64Str = base64Str.replace("data:image/png;base64,", "");
            file = writeToFile(base64Str,"png");
        } else if (base64Str.contains("data:image/gif;")) {
            //log.info("base64Str data:image/gif => {}",base64Str.contains("data:image/gif;"));
            base64Str = base64Str.replace("data:image/gif;base64,", "");
            file = writeToFile(base64Str,"gif");
        } else if (base64Str.contains("data:application/pdf;")) {
            //log.info("base64Str data:application/pdf; => {}",base64Str.contains("data:application/pdf;"));
            base64Str = base64Str.replace("data:application/pdf;base64,", "");
            file = writeToFile(base64Str,"pdf");
        } else if (base64Str.contains("data:text/plain;base64,")){
            base64Str = base64Str.replace("data:text/plain;base64,", "");
            file = writeToFile(base64Str,"txt");
        } else if (base64Str.contains("data:/png;base64,")) {
            base64Str = base64Str.replace("data:/png;base64,", "");
            file = writeToFile(base64Str,"png");
        }else if (base64Str.contains("data:video/mp4;base64,")) {
            base64Str = base64Str.replace("data:video/mp4;base64,", "");
            file = writeToFile(base64Str,"mp4");
        } else if (base64Str.contains("data:video/webm;base64,")) {
            base64Str = base64Str.replace("data:video/webm;base64,", "");
            file = writeToFile(base64Str,"webm");
        } else if (base64Str.contains("data:video/ogg;base64,")) {
            base64Str = base64Str.replace("data:video/ogg;base64,", "");
            file = writeToFile(base64Str,"ogg");
        }
        else {
            file = writeToFile(base64Str,"txt");
        }
        return file;
    }

    //@Override
    /*public File generateFileFromBase64String(String base64Str) {
        File file = null;

        // Sanitize the MIME type if malformed
        base64Str = sanitizeMimeType(base64Str);

        // Regular expression to extract the MIME type
        Pattern pattern = Pattern.compile("^data:([a-zA-Z0-9+/.-]+);base64,");

        // Remove the data URI prefix if it exists
        if (base64Str.startsWith("data:")) {
            base64Str = base64Str.substring(base64Str.indexOf(",") + 1);
        }

        Matcher matcher = pattern.matcher(base64Str);

        String extension = "txt"; // Default extension

        if (matcher.find()) {
            String mimeType = matcher.group(1); // e.g., image/png, application/pdf
            switch (mimeType) {
                case "image/jpeg":
                case "/jpeg":
                    extension = "jpeg";
                    break;
                case "image/jpg":
                    extension = "jpg";
                    break;
                case "image/png":
                case "/png":
                    extension = "png";
                    break;
                case "image/gif":
                    extension = "gif";
                    break;
                case "application/pdf":
                    extension = "pdf";
                    break;
                case "text/plain":
                    extension = "txt";
                    break;
                default:
                    extension = "txt";
                    break;
            }

        }

        // Now write to file using the extracted extension
        file = writeToFile(base64Str, extension);
        return file;
    }*/

    private String sanitizeMimeType(String base64Str) {
        return base64Str
                .replace("data:@file/pdf", "data:application/pdf")
                .replace("data:@file/png", "data:image/png")
                .replace("data:@file/jpeg", "data:image/jpeg")
                .replace("data:@file/jpg", "data:image/jpg")
                .replace("data:@file/txt", "data:text/plain")
                .replace("data:@file/gif", "data:image/gif");
    }


    @Override
    public void deleteFileFromThePath(File file) {
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }


    private File writeToFile(String base64Str, String fileType) {
        byte[] fileBytes = Base64.getDecoder().decode(base64Str);
        String fileName = generateUniqueFileName(fileType);
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(fileName);

    }

    private String generateUniqueFileName(String suffix) {
        String filename = "";
        long millis = System.currentTimeMillis();
        String datetime = new Date().toGMTString();
        datetime = datetime.replace(" ", "");
        datetime = datetime.replace(":", "");
        String rndchars = RandomStringUtils.randomAlphanumeric(16);
        filename = rndchars + "_" + datetime + "_" + millis+"."+suffix;
        return SupportConstant.TEMP_FILE_PATH+"/"+filename;
    }

    @Override
    public String uploadObjectToS3(String base64String, String folderName) {
        log.info("representation folderName {}", folderName);
        File file = generateFileFromBase64String(base64String);
        try {
            if (file != null) {
                 return uploadFile(file, folderName);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String uploadFile(File file, String folderName) {
        try {
            if (file != null) {
                s3BucketIntegration.uploadFileToS3Bucket(file, folderName);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return folderName+"/"+file.getName();
    }

}
