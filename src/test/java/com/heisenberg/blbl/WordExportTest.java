package com.heisenberg.blbl;


import cn.afterturn.easypoi.entity.ImageEntity;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heisenberg
 * @version 1.0
 * @date 2024-06-28 14:47:47
 */
public class WordExportTest {
    public static void main(String[] args) throws IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("startTime","2023");
        map.put("endTime","2024");
        map.put("name","tom");
        map.put("age","23");
        map.put("sex","男");

        List<String> list = new ArrayList<>();
        list.add("2019就读A学校");
        list.add("2022就读B学校");
        list.add("2023上岸研究生");
        map.put("list",list);

        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setUrl(new File("D://A.png").getAbsolutePath());
        imageEntity.setWidth(80);
        imageEntity.setHeight(100);
        map.put("photo",imageEntity);

        FileUtil.exportWordByModel(new FileOutputStream(new File("D://A.docx")),map,"D://A.docx","员工统计");
    }

    // poi api 生成导出word的代码
    public static void exportWord() throws IOException {
        try {
            // 创建一个空的Word文档
            XWPFDocument document = new XWPFDocument();

            // 创建一个段落
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Hello, World!");

            // 将文档保存到硬盘
            FileOutputStream out = new FileOutputStream(new File("HelloWorld.docx"));
            document.write(out);
            out.close();

            System.out.println("Word文档已导出成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
