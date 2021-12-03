package com.demo.pdfgenerator.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PDF_ControllerTest {

    @Test
    void getPDFRequest() {
        PDF_Controller pdf_controller = new PDF_Controller();
        String response = pdf_controller.getPDFRequest(0);
        assertEquals("Number must be greater than 0", response);
    }

    @Test
    void millisToShortDHMS() {
    }
}