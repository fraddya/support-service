package com.inntri.support.utils;

import com.lowagie.text.DocumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

@Slf4j
@Component
public class PdfGeneratorUtil {
    private static final String PDF_RESOURCES = "/pdf-resources/";
    public void generatePdfFromHtml(String html, String filePath, String fileName) throws IOException, DocumentException {
        String outputFolder = filePath + File.separator + fileName;
        log.info("file path :{}", filePath);
        OutputStream outputStream = new FileOutputStream(outputFolder);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }
}
