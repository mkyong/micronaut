package com.mkyong.controller;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.server.types.files.StreamedFile;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.io.*;

@Controller("/pdf")
public class PdfController {

    // Micronaut will by default run end user operations in the same thread that executes the request.
    // This annotation can be used to indicate that a different thread should be used when executing an operation.

    // Run this download on a separate thread pool that does not block the main Event loop.
    @ExecuteOn(TaskExecutors.BLOCKING)
    @Get("/download")
    HttpResponse<StreamedFile> download() throws IOException {

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // Create PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(new Paragraph("Hello, Micronaut!"));
            document.newPage(); // page 2
            document.add(new Paragraph("This is a dynamically generated PDF using OpenPDF."));
            document.close();

            // Convert to InputStream for efficient streaming
            InputStream pdfStream = new ByteArrayInputStream(outputStream.toByteArray());

            return HttpResponse.ok(new StreamedFile(pdfStream, MediaType.APPLICATION_PDF_TYPE))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF);

        } catch (DocumentException e) {
            return HttpResponse.serverError();
        }

    }

}