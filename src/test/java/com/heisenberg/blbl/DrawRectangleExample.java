package com.heisenberg.blbl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class DrawRectangleExample {
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
            e.printStackTrace();
        }
    }
}
