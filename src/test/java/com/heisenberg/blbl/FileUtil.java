package com.heisenberg.blbl;


import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;

/**
 * @author Heisenberg
 * @version 1.0
 * @date 2024-06-28 15:28:28
 */
public class FileUtil {
    /**
     * 根据模板导出Word
     * @param os
     * @param map
     * @param modelFileName
     * @param outFileName
     */
    public static void exportWordByModel(OutputStream os, Map<String, Object> map, String modelFileName, String outFileName) {
        try {
            // 1.获取模板文件路径 - 重点
            //XWPFDocument word = WordExportUtil.exportWord07(modelFileName, map);有时候这种方式可以找到有时候找不到（不太清楚）

            // 打印出模板文件的完整路径 - 校验路径是否存在
            File templateFile = new File(modelFileName);
            if (templateFile.exists()) {
                System.out.println("模板文件存在: " + templateFile.getAbsolutePath());
            } else {
                System.out.println("模板文件不存在: " + templateFile.getAbsolutePath());
            }
            // 2.映射模板，替换数据
            XWPFDocument word = WordExportUtil.exportWord07(templateFile.getAbsolutePath(), map);
//            // 3.设置返回参数的字符集
//            response.reset();
//            response.setHeader("Access-Control-Allow-Origin", "*");
//            response.setContentType("application/msexcel");
//            response.setContentType("text/html; charset=UTF-8");
//            // 4.设置响应类型为Word文档
//            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
//            // 5.中文文件名处理，否则报错
//            String encodedFileName = URLEncoder.encode(outFileName, "UTF-8");
//            response.setHeader("Content-Disposition", "attachment;filename=" + encodedFileName + ".docx");
            // 6.将Word文档发送到浏览器
            word.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据文件名获取文件对象
     * @param modelFileName
     * @return
     */
    public static File filePath(String modelFileName) {
        // 获取类加载器
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        // 尝试从类路径中加载资源
        URL resource = classLoader.getResource(modelFileName);
        return new File(resource.getFile());
    }
}

