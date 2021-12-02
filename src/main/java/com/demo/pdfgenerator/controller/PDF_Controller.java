package com.demo.pdfgenerator.controller;

import com.demo.pdfgenerator.service.PDF_Box_Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PDF_Controller {

    private final PDF_Box_Service pdf_box_service;

    public PDF_Controller(PDF_Box_Service pdf_box_service) {
        this.pdf_box_service = pdf_box_service;
    }

    @RequestMapping("/pdf")
    public String getPDFRequest() {

        return this.pdf_box_service.getPDFRequest();
    }
}
