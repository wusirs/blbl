package com.heisenberg.blbl.test;

import com.heisenberg.blbl.utils.PDFUtil;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * <a href="https://blog.csdn.net/zhuocailing3390/article/details/124144144">示例一</a><br/>
 * <a href="https://blog.csdn.net/lcczpp/article/details/125424395">示例二</a>
 */
public class DrawPdfTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DrawPdfTest.class);

    private boolean logo = false;
    private String logoImagePath;
    private float logoWidth = 80F;
    private float logoHeight = 40F;

    private static final Properties PROPERTIES;

    static {
        InputStream propertiesStream = DrawPdfTest.class.getResourceAsStream("/config/filePath.properties");
        PROPERTIES = new Properties();
        try {
            PROPERTIES.load(propertiesStream);
        } catch (IOException e) {
            LOGGER.error("配置加载失败", e);
        }
    }

    public void setLogo(float logoWidth, float logoHeight, String filePath) {
        this.logoImagePath = PROPERTIES.getProperty(filePath);
        this.logo = true;
        this.logoWidth = logoWidth;
        this.logoHeight = logoHeight;
    }

    public void printPdf() {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(PROPERTIES.getProperty("pdf.outPath"))));
            document.open();
            PdfContentByte contentByte = writer.getDirectContent();
            float x = 100; // X-coordinate of the lower-left corner
            float y = 100; // Y-coordinate of the lower-left corner
            float width = 200; // Width of the rectangle
            float height = 100; // Height of the rectangle
            PDFUtil.drawRectangle(contentByte, width, height, x, y, BaseColor.BLACK);
            setLogo(80, 40, "pdf.waterImg");
            PDFUtil.addImg(document, logoImagePath, logoWidth, logoHeight);
            document.close();
            LOGGER.info("Rectangle drawn successfully!");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Test
    public void begin(){
        printPdf();
    }
}
