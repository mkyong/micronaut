package com.mkyong.controller;

import com.mkyong.service.ExcelService;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@Controller("/excel")
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    // Run this download on a separate thread pool that does not block the main Event loop.
    @ExecuteOn(TaskExecutors.BLOCKING)
    @Get(uri = "/download", produces = MediaType.APPLICATION_OCTET_STREAM)
    public HttpResponse<byte[]> downloadExcel() throws Exception {
        byte[] excelData = excelService.generateExcelFile();

        return HttpResponse.ok(excelData)
                // force the browser to download a file instead of displaying it inline
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employees.xlsx");
    }

}
