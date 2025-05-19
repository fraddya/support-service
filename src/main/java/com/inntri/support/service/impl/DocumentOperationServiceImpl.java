package com.inntri.support.service.impl;

import com.inntri.support.dto.request.pdf.InvoicePdfRequest;
import com.inntri.support.service.DocumentOperationService;
import com.inntri.support.service.FileOperationService;
import com.inntri.support.utils.PdfGeneratorUtil;
import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@Slf4j
@AllArgsConstructor
public class DocumentOperationServiceImpl implements DocumentOperationService {

    private final PdfGeneratorUtil pdfGeneratorUtil;

    private final FileOperationService fileOperationService;

    @Override
    public String generateInvoiceBulkHires(InvoicePdfRequest request) {
        String outputFolder = System.getProperty("user.home")+"/PDF";
        log.info("outputFolder 3 {}", outputFolder);

        try {
            String fileName = request.getInvoiceNumber() + "_" + LocalDateTime.now()+".pdf";
            pdfGeneratorUtil.generatePdfFromHtml(request.getHtml(), outputFolder, fileName);
            outputFolder = outputFolder + File.separator + fileName;
            log.info("outputFolder {}", outputFolder);
            //filesPath.add(outputFolder);
            //s3 upload
            byte[] inFileBytes = Files.readAllBytes(Paths.get(outputFolder));
            String encodedString = Base64.getEncoder().encodeToString(inFileBytes);
            //log.info("encodedString {}", encodedString);

            String appendWithFormat = appendFileFormat(encodedString,".pdf");
            //log.info("appendWithFormat {}", appendWithFormat);
            String s3FilePath = fileOperationService.uploadObjectToS3(appendWithFormat, request.getS3UploadFolderName());
            log.info("return from s3 : {}", s3FilePath);
            return s3FilePath;

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }

    /*This method will return local file path*/
    @Override
    public String generatePdfFromHtml(String html, String fileName, String s3UploadFolderName, String outputFolder) {
        //String outputFolder = System.getProperty("user.home")+"/PDF";
        log.info("outputFolder 3 {}", outputFolder);

        try {
            pdfGeneratorUtil.generatePdfFromHtml(html, outputFolder, fileName);
            outputFolder = outputFolder + File.separator + fileName;
            log.info("outputFolder {}", outputFolder);
            //filesPath.add(outputFolder);
            //s3 upload
            byte[] inFileBytes = Files.readAllBytes(Paths.get(outputFolder));
            String encodedString = Base64.getEncoder().encodeToString(inFileBytes);
            log.info("encodedString {}", encodedString);

            String appendWithFormat = appendFileFormat(encodedString,".pdf");
            log.info("appendWithFormat {}", appendWithFormat);
            String s3FilePath = fileOperationService.uploadObjectToS3(appendWithFormat, s3UploadFolderName);
            log.info("return from s3 : {}", s3FilePath);
            return outputFolder;

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public String generateAndReturnPdfPath(String html, String fileName, String s3UploadFolderName, String outputFolder) {
        //String outputFolder = System.getProperty("user.home")+"/PDF";
        log.info("outputFolder 3 {}", outputFolder);

        try {
            pdfGeneratorUtil.generatePdfFromHtml(html, outputFolder, fileName);
            outputFolder = outputFolder + File.separator + fileName;
            log.info("outputFolder {}", outputFolder);
            //filesPath.add(outputFolder);
            //s3 upload
            byte[] inFileBytes = Files.readAllBytes(Paths.get(outputFolder));
            String encodedString = Base64.getEncoder().encodeToString(inFileBytes);
            log.info("encodedString {}", encodedString);

            String appendWithFormat = appendFileFormat(encodedString,".pdf");
            log.info("appendWithFormat {}", appendWithFormat);
            String s3FilePath = fileOperationService.uploadObjectToS3(appendWithFormat, s3UploadFolderName);
            log.info("return from s3 : {}", s3FilePath);
            return s3FilePath;

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String appendFileFormat(String encodedString, String fileFormat) {
        if (fileFormat.equals(".pdf")) {
            return "data:application/pdf;base64,"+encodedString;
        }
        return encodedString;
    }


}
