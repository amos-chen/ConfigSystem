package com.amos.utils;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${chenlunwei} on 2018/4/28.
 */
public class PDFUtils {

    public static List<Double> getDimension(InputStream inputStream) throws Exception {
        PDFParser parser = new PDFParser(new RandomAccessBuffer(inputStream));
        parser.parse();
        PDDocument document = parser.getPDDocument();
        int pages = document.getNumberOfPages();
        // 读文本内容
        PDFTextStripper stripper = new PDFTextStripper();
        // 设置按顺序输出
        stripper.setSortByPosition(true);
        stripper.setStartPage(1);
        stripper.setEndPage(pages);
        String content = stripper.getText(document);
        List<Double> dimensionList = new ArrayList<>();
        String[] contentList = content.split("\n");
        for (String string : contentList) {
            if (string.contains("*")) {
                System.out.println(1);
                System.out.println(string);
                string = string.replace("mm", "");
                String[] temp = string.split("\\s+");
                String dimension = temp[temp.length - 1];
                String[] dimensions = dimension.split("\\*");
                for (String str : dimensions) {
                    dimensionList.add(Double.parseDouble(str));
                }
            } else if (string.contains("×")) {
                if (string.contains("mm×")) {
                    System.out.println(2);
                    System.out.println(string);
                    string = string.replace("mm", "");
                    String[] originTemp = string.split("\\s+");
                    String dimensionTemp = originTemp[originTemp.length - 1];
                    String[] temp = dimensionTemp.split("×");
                    if (dimensionTemp.contains("L")) {
                        for (int i = 0; i < temp.length; i++) {
                            dimensionList.add(Double.parseDouble(temp[i].substring(1)));
                        }
                    }else{
                        for (int i = 0; i < temp.length; i++) {
                            dimensionList.add(Double.parseDouble(temp[i]));
                        }
                    }
                } else {
                    System.out.println(3);
                    System.out.println(string);
                    string = string.replace("mm", "");
                    String[] temp = string.split("\\s+");
                    String dimension = temp[temp.length - 1];
                    String[] dimensions = dimension.split("×");
                    for (String str : dimensions) {
                        dimensionList.add(Double.parseDouble(str));
                    }
                }
            } else if (string.contains("Dimension (mm)")) {
                System.out.println(4);
                System.out.println(string);
                string = string.replace("mm", "").replace("x", "");
                String[] temp = string.split("\\s+");
                for (int i = 0; i < temp.length; i++) {
                    if (i > 1) {
                        dimensionList.add(Double.parseDouble(temp[i].substring(1)));
                    }
                }
            }
        }

        for (double d : dimensionList) {
            System.out.println(d);
        }
        return dimensionList;
    }


    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Amos\\Desktop\\规格书\\LSE2-200.pdf");
        getDimension(new FileInputStream(file));
    }
}
