package com.demo.pdfgenerator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PDF_ControllerTest {

    @Test
    void testCreatePDFofImagesByZeroImages() {
        PDF_Controller pdf_controller = new PDF_Controller();
        String response = pdf_controller.createPDFofImagesBySpecifiedNumberOfImages(0);
        assertEquals("Number must be greater than 0", response);
    }

//    @Test
//    void testCreatePDFofImagesBy1000Images() {
//        PDF_Controller pdf_controller = new PDF_Controller();
//        String response = pdf_controller.createPDFofImagesBySpecifiedNumberOfImages(1000);
////        assertTrue("1000 PDF Pages Created in".contains(response));
//    }
}