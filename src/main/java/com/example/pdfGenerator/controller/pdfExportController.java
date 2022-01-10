package com.example.pdfGenerator.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.example.pdfGenerator.service.pdfGeneratorService;
import com.itextpdf.text.DocumentException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pdfExportController {
    private final pdfGeneratorService generatorService;

    public pdfExportController(pdfGeneratorService generatorService){
        this.generatorService = generatorService;
    }

    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response) throws DocumentException, IOException{
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
    
        this.generatorService.export(response);
    
    }
    
}
