package com.hfmx.utils;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExport {
	public static void export2003(HttpServletResponse response, DataGrid<Map<String, Object>> dg) throws IOException {
		Workbook workBook = new HSSFWorkbook();
		writeWorkBook(response, dg, workBook);
	}

	public static void export2007(HttpServletResponse response, DataGrid<Map<String, Object>> dg) throws IOException {
		Workbook workBook = new XSSFWorkbook();
		writeWorkBook(response, dg, workBook);
	}

	private static void writeWorkBook(HttpServletResponse response, DataGrid<Map<String, Object>> dg, Workbook workBook) throws IOException {
		Sheet sheet = workBook.createSheet("sheet1");
		for (int i = 0; i < dg.getRows().size(); i++) {
			Map<String, Object> map = dg.getRows().get(i);
			Row row = sheet.createRow(i + 1);
			int num = 0;
			for (Entry<String, Object> obj : map.entrySet()) {
				Cell cell = row.createCell(num);
				cell.setCellValue(obj.getValue().toString());
				num++;
			}
		}
		workBook.write(response.getOutputStream());
	}

	public static void export2007S(HttpServletResponse response, DataGrid<Map<String, Object>> dg) throws IOException {
		Workbook workBook = new SXSSFWorkbook();
		writeWorkBook(response, dg, workBook);
	}
}
