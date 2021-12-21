package com.demo.pdfgenerator.controller;

import com.demo.pdfgenerator.service.PDF_Box_Service;
import com.demo.pdfgenerator.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;

@RequestMapping("/pdf")
@RestController
public class PDF_Controller {

    @Autowired
    private PDF_Box_Service pdf_box_service;
    private long startTime;
    private long endTime;

    @GetMapping("/pdfBox/{numberOfImagesToProcess}")
    public String createPDFofImagesBySpecifiedNumberOfImages(@PathVariable int numberOfImagesToProcess) {

        String results = "";
        boolean isComplete = false;

        if (numberOfImagesToProcess <= 0) {
            return "Number must be greater than 0";
        }

        startTime = System.nanoTime();
        isComplete = pdf_box_service.getPDFRequest(numberOfImagesToProcess);
        endTime = System.nanoTime();

        long duration = (endTime - startTime);

        if (isComplete) {
            results = numberOfImagesToProcess + " PDF Pages Created in " + TimeUtils.millisToShortDHMS(duration/1000000);

        } else {
            results = "Failed to complete";
        }

        return results;
    }

    // TODO: 12/20/2021 example get service call
//    @RequestMapping("/pdf/generate")
//    public void generatePDF(HttpServletResponse response) throws IOException {
//        response.setContentType("application/pdf");
//        String fileName = "Testing.pdf";
//
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=pdf_" + fileName + ".pdf";
//
//        response.setHeader(headerKey, headerValue);
//
//        this.pdf_box_service.createPDF(response);
//    }
}
