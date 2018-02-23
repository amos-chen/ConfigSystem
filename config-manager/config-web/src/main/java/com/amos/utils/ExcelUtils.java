package com.amos.utils;

import com.amos.dto.ExcelElement;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlunwei on 2018/2/18.
 */
public class ExcelUtils {

	public static void export(String language, String filename, Map<String, List<ExcelElement>> excelData,
							  HttpServletResponse response, HttpServletRequest request) {
		//map排序
		List<Map.Entry<String, List<ExcelElement>>> list = new ArrayList<>(excelData.entrySet());

		int rowCount = 1;
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Sheet1"); // 新建名为 Sheet1 的表

		//第一行单元格的样式
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 10); // 大小
		font.setFontName("Arial");
		cellStyle.setFont(font);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(253, 251, 135)));
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中

		Row row = sheet.createRow(rowCount);
		sheet.setColumnWidth(0, 22 * 256);
		sheet.setColumnWidth(1, 29 * 256);
		sheet.setColumnWidth(2, 16 * 256);
		sheet.setColumnWidth(3, 9 * 256);
		sheet.setColumnWidth(4, 29 * 256);
		XSSFCell firstRowCell1 = (XSSFCell) row.createCell(0);
		XSSFCell firstRowCell2 = (XSSFCell) row.createCell(1);
		XSSFCell firstRowCell3 = (XSSFCell) row.createCell(2);
		XSSFCell firstRowCell4 = (XSSFCell) row.createCell(3);
		XSSFCell firstRowCell5 = (XSSFCell) row.createCell(4);
		firstRowCell1.setCellStyle(cellStyle);
		firstRowCell2.setCellStyle(cellStyle);
		firstRowCell3.setCellStyle(cellStyle);
		firstRowCell4.setCellStyle(cellStyle);
		firstRowCell5.setCellStyle(cellStyle);
		if (language.equals("中文")) {
			firstRowCell1.setCellValue("设备名称");
			firstRowCell2.setCellValue("型号");
			firstRowCell3.setCellValue("单位");
			firstRowCell4.setCellValue("数量");
			firstRowCell5.setCellValue("备注");
		} else {
			firstRowCell1.setCellValue("Item");
			firstRowCell2.setCellValue("Model");
			firstRowCell3.setCellValue("Unit");
			firstRowCell4.setCellValue("Qty.");
			firstRowCell5.setCellValue("Remark");
		}
		rowCount++;
		for (Map.Entry<String, List<ExcelElement>> entry : excelData.entrySet()) {
			String title = entry.getKey();
			List<ExcelElement> elements = entry.getValue();
			CellRangeAddress cra = new CellRangeAddress(rowCount, rowCount, 0, 4);
			sheet.addMergedRegion(cra);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra, sheet); // 下边框
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra, sheet); // 左边框
			RegionUtil.setBorderRight(BorderStyle.THIN, cra, sheet); // 右边框
			RegionUtil.setBorderTop(BorderStyle.THIN, cra, sheet); // 上边框

			Row titleRow = sheet.createRow(rowCount);
			//标题单元格样式
			XSSFCellStyle titleStyle = workbook.createCellStyle();
			XSSFFont titleFont = workbook.createFont();
			titleFont.setFontHeightInPoints((short) 10); // 大小
			titleFont.setFontName("Arial");
			titleFont.setBold(true);
			titleStyle.setFont(titleFont);
			XSSFCell titleRowCell1 = (XSSFCell) titleRow.createCell(0);
			XSSFCell titleRowCell5 = (XSSFCell) titleRow.createCell(4);
			titleStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(221, 215, 231)));
			titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			titleStyle.setAlignment(HorizontalAlignment.LEFT);//水平左
			titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
			titleStyle.setBorderLeft(BorderStyle.THIN);
			titleStyle.setBorderRight(BorderStyle.THIN);
			titleRowCell1.setCellStyle(titleStyle);
			titleRowCell5.setCellStyle(titleStyle);
			titleRowCell1.setCellValue(title);
			rowCount++;
			for (int i = 0; i < elements.size(); i++) {
				Row elementRow = sheet.createRow(rowCount);
				XSSFCell elementRowCell1 = (XSSFCell) elementRow.createCell(0);
				XSSFCell elementRowCell2 = (XSSFCell) elementRow.createCell(1);
				XSSFCell elementRowCell3 = (XSSFCell) elementRow.createCell(2);
				XSSFCell elementRowCell4 = (XSSFCell) elementRow.createCell(3);
				XSSFCell elementRowCell5 = (XSSFCell) elementRow.createCell(4);
				XSSFCellStyle style1 = workbook.createCellStyle();
				XSSFCellStyle style2 = workbook.createCellStyle();
				style1.setFont(font);
				style2.setFont(font);
				style1.setAlignment(HorizontalAlignment.LEFT);//水平左
				style1.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
				style2.setAlignment(HorizontalAlignment.CENTER);//水平中
				style2.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
				style1.setWrapText(true);//自动换行
				style2.setWrapText(true);//自动换行
				style1.setBorderRight(BorderStyle.THIN);
				style1.setBorderBottom(BorderStyle.THIN);
				style1.setBorderTop(BorderStyle.THIN);
				style1.setBorderLeft(BorderStyle.THIN);
				style2.setBorderRight(BorderStyle.THIN);
				style2.setBorderBottom(BorderStyle.THIN);
				style2.setBorderTop(BorderStyle.THIN);
				style2.setBorderLeft(BorderStyle.THIN);

				elementRowCell1.setCellStyle(style1);
				elementRowCell2.setCellStyle(style1);
				elementRowCell3.setCellStyle(style2);
				elementRowCell4.setCellStyle(style2);
				elementRowCell5.setCellStyle(style1);
				elementRowCell1.setCellValue(elements.get(i).getTitle());
				elementRowCell2.setCellValue(elements.get(i).getModel());
				elementRowCell3.setCellValue(elements.get(i).getUnit());
				elementRowCell4.setCellValue(elements.get(i).getNumber());
				elementRowCell5.setCellValue(elements.get(i).getRemark());
				rowCount++;
			}
		}
		/*File file = new File(filename);
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.flush();
				outputStream.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}*/

		ServletOutputStream fos = null;
		try {
			response.setHeader("Content-disposition", "attachment;filename=" + getFileName(request, filename));
			response.setContentType("application/msexcel;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");

			fos = response.getOutputStream();
			workbook.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.flush();
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 包含中文和特殊字符的文件名的兼容性
	 *
	 * @param request
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	private static String getFileName(HttpServletRequest request, String fileName) throws Exception {
		fileName = HtmlUtils.htmlUnescape(fileName);
		String head = request.getHeader("User-Agent").toLowerCase();
		if (head.indexOf("firefox") > 0 || head.indexOf("ope") > 0
				|| head.indexOf("chrome") > 0) {
			fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1"); // firefox浏览器
		} else {
			fileName = java.net.URLEncoder.encode(fileName, "UTF-8"); // IE浏览器
		}
		return fileName;
	}


	/*public static Map<String, List<ExcelElement>> sortMapByKey(Map<String, List<ExcelElement>> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}

		Map<String, List<ExcelElement>> sortMap = new TreeMap<String, List<ExcelElement>>(
				new MapKeyComparator());

		sortMap.putAll(map);

		return sortMap;
	}

	//比较器类
	static class MapKeyComparator implements Comparator<String> {

		@Override
		public int compare(String str1, String str2) {

			return str1.compareTo(str2);
		}
	}*/


}
