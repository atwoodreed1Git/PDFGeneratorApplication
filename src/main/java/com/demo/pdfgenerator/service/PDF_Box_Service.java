package com.demo.pdfgenerator.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PDF_Box_Service {
    public String getPDFRequest() {

        return "Hi from the pdf Service";
    }

}
