package com.demo.pdfgenerator.service;

import org.springframework.stereotype.Service;

/**
 PDF rendering

 I'm getting an OutOfMemoryError. What can I do?
 The memory footprint depends on the PDF itself and on the resolution you use for rendering. Some possible options:

 increase the -Xmx value when starting java
 use a scratch file by loading files with this code PDDocument.load(file, MemoryUsageSetting.setupTempFileOnly())
 be careful not to hold your images after rendering them, e.g. avoid putting all images of a PDF into a List
 don't forgot to close your PDDocument objects
 decrease the scale when calling PDFRenderer.renderImage(), or the dpi value when calling PDFRenderer.renderImageWithDPI()
 disable the cache for PDImageXObject objects by calling PDDocument.setResourceCache() with a cache object that is derived from DefaultResourceCache and whose call public void put(COSObject indirect, PDXObject xobject) does nothing. Be aware that this will slow down rendering for PDF files that have an identical image in several pages (e.g. a company logo or a background). More about this can be read in PDFBOX-3700.
 ***/
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
