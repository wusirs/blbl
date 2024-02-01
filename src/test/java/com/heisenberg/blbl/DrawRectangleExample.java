package com.heisenberg.blbl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DrawRectangleExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(DrawRectangleExample.class);

    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("rectangle.pdf"));
            document.open();
            PdfContentByte contentByte = writer.getDirectContent();
            // Set rectangle dimensions
            float x = 100; // X-coordinate of the lower-left corner
            float y = 100; // Y-coordinate of the lower-left corner
            float width = 200; // Width of the rectangle
            float height = 100; // Height of the rectangle
            // Draw the rectangle
            contentByte.rectangle(x, y, width, height);
            contentByte.stroke();
            document.close();
            System.out.println("Rectangle drawn successfully!");
        } catch (DocumentException | FileNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static void drawPdf() throws IOException, DocumentException {
        Document document = new Document();
        String fileFullPath = "D:\\output\\javaout\\simpleTable.pdf";
        PdfWriter writer = PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileFullPath)));
        document.open();

    }
}
