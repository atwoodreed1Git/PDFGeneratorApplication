package com.demo.pdfgenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PDF_Box_Service {

    public String getPDFRequest(int numberOfImagesToProcess) {

        for (int i = 0; i < numberOfImagesToProcess; i++) {
            System.out.println("Page " + (i + 1) + " of " + numberOfImagesToProcess + " created.");
        }
        System.out.println("------------------------------------");
        return numberOfImagesToProcess + " PDF Pages Created";
    }

}
