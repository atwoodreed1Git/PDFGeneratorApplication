package com.demo.pdfgenerator.controller;

import com.demo.pdfgenerator.service.PDF_Box_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pdf")
@RestController
public class PDF_Controller {

    @Autowired
    private PDF_Box_Service pdf_box_service;

    @GetMapping("/pdfBox/{numberOfImagesToProcess}")
    public int getPDFRequest(@PathVariable int numberOfImagesToProcess) {

        return pdf_box_service.getPDFRequest(numberOfImagesToProcess);
    }
}
