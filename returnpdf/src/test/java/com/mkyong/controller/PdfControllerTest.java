package com.mkyong.controller;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class PdfControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testDownloadPdf() throws IOException {
        HttpResponse<byte[]> response = client.toBlocking().exchange("/pdf/download", byte[].class);

        assertEquals(200, response.getStatus().getCode());
        assertTrue(response.getHeaders().contains(HttpHeaders.CONTENT_DISPOSITION));
        assertTrue(response.getHeaders().get(HttpHeaders.CONTENT_DISPOSITION).contains("attachment; filename=document.pdf"));
        assertTrue(response.getHeaders().contains(HttpHeaders.CONTENT_TYPE));
        assertEquals(MediaType.APPLICATION_PDF, response.getHeaders().getContentType().orElse(null));
        assertNotNull(response.getBody().orElse(null));
        assertTrue(response.getBody().get().length > 0);

        byte[] pdfBytes = response.body();
        // Test Page 1
        String firstPageText = textAtPage(pdfBytes, 1);
        assertEquals("Hello, Micronaut!", firstPageText);

        // Test Page 2
        String secondPageText = textAtPage(pdfBytes, 2);
        assertEquals("This is a dynamically generated PDF using OpenPDF.", secondPageText);

    }

    private static String textAtPage(byte[] pdfBytes, int pageNumber) throws IOException {
        try (PdfReader pdfReader = new PdfReader(pdfBytes)) {
            return textAtPage(pdfReader, pageNumber);
        }
    }

    private static String textAtPage(PdfReader pdfReader, int pageNumber) throws IOException {
        PdfTextExtractor pdfTextExtractor = new PdfTextExtractor(pdfReader);
        return pdfTextExtractor.getTextFromPage(pageNumber);
    }

}
