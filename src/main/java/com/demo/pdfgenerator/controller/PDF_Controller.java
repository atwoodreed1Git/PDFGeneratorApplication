package com.demo.pdfgenerator.controller;

import com.demo.pdfgenerator.service.PDF_Box_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RequestMapping("/pdf")
@RestController
public class PDF_Controller {

    @Autowired
    private PDF_Box_Service pdf_box_service;
    private long startTime;
    private long endTime;

    @GetMapping("/pdfBox/{numberOfImagesToProcess}")
    public String getPDFRequest(@PathVariable int numberOfImagesToProcess) {

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
            results = numberOfImagesToProcess + " PDF Pages Created in " + millisToShortDHMS(duration/1000000);

        } else {
            results = "Failed to complete";
        }

        return results;
    }

    public static String millisToShortDHMS(long duration) {
        String res = "";    // java.util.concurrent.TimeUnit;
        long days = TimeUnit.MILLISECONDS.toDays(duration);
        long hours = TimeUnit.MILLISECONDS.toHours(duration) -
                TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration) -
                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
        long millis = TimeUnit.MILLISECONDS.toMillis(duration) -
                TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(duration));

        if (days == 0) {
            res = String.format("%02d hours %02d min %02d sec .%04d", hours, minutes, seconds, millis);
        } else {
            res = String.format("%dd %02d hours %02d min %02d sec .%04d", days, hours, minutes, seconds, millis);
        }
        
        return res;
    }
}
