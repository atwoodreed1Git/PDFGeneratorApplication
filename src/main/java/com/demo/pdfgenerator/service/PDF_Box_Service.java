package com.demo.pdfgenerator.service;

import org.springframework.stereotype.Service;

@Service
public class PDF_Box_Service {

    public boolean getPDFRequest(int numberOfImagesToProcess) {

        try {
            for (int i = 0; i < numberOfImagesToProcess; i++) {
                System.out.println("Page " + (i + 1) + " of " + numberOfImagesToProcess + " created.");
            }

            System.out.println("------------------------------------");
            return true;

        } catch (Exception error) {
            System.err.println(error);
            return false;
        }
    }
}
