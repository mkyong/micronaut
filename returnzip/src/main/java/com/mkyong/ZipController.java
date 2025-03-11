package com.mkyong;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.server.types.files.StreamedFile;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller("/zip")
public class ZipController {

    // Run this download on a separate thread pool that does not block the main Event loop.
    @ExecuteOn(TaskExecutors.BLOCKING)
    @Get(uri = "/download", produces = MediaType.APPLICATION_OCTET_STREAM)
    public HttpResponse<StreamedFile> downloadZip() throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (ZipOutputStream zos = new ZipOutputStream(baos)) {
            // Adding first file
            zos.putNextEntry(new ZipEntry("file1.txt"));
            zos.write("Hello from file 1".getBytes());
            zos.closeEntry();

            // Adding second file
            zos.putNextEntry(new ZipEntry("file2.txt"));
            zos.write("Hello from file 2".getBytes());
            zos.closeEntry();

            // Adding a physical file from resources folder
            try (InputStream resourceStream = getClass().getResourceAsStream("/application.properties")) {
                if (resourceStream != null) {
                    zos.putNextEntry(new ZipEntry("application.properties"));
                    resourceStream.transferTo(zos);
                    zos.closeEntry();
                }
            }

        }

        ByteArrayInputStream inputStream = new ByteArrayInputStream(baos.toByteArray());
        StreamedFile streamedFile = new StreamedFile(inputStream, MediaType.APPLICATION_OCTET_STREAM_TYPE)
                // StreamedFile.attach() sets the Content-Disposition header automatically
                .attach("files.zip");

        return HttpResponse.ok(streamedFile);
    }
}
