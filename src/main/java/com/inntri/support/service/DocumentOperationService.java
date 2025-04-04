package com.inntri.support.service;

import com.inntri.support.dto.request.pdf.InvoicePdfRequest;

public interface DocumentOperationService {
    String generateInvoiceBulkHires(InvoicePdfRequest request);

    String generatePdfFromHtml(String html, String fileName, String s3UploadFolderName);
}
