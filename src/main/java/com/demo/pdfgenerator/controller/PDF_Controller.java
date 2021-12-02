package com.demo.pdfgenerator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PDF_Controller {

    @RequestMapping("/pdf")
    public String getPDFRequest() {
        return "Hi from the pdf Controller";
    }
}
