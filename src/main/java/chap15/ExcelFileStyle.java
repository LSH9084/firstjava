package chap15;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileStyle {

	
	public static void main(String[] args) {
		
		String path1 = "c:"+File.separator+"javaStudyLsh"+File.separator+"java"+File.separator+
				"java"+File.separator+"firstjava"+File.separator;
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("1학년 2반 성적");
		
		//sheet 눈금선 없애기
		
		sheet.setDisplayGridlines(false);
		
		// 표 헤더 cell style 정의
		
		CellStyle tableHeadStyle = workbook.createCellStyle();
		
		//배경색
		
		tableHeadStyle.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		tableHeadStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		//정렬
		
		tableHeadStyle.setAlignment(HorizontalAlignment.CENTER); // 수평 가운데정렬
		tableHeadStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 수직 가운데 정렬
		
		//폰트
		Font HeadFont = workbook.createFont();
		HeadFont.setFontHeightInPoints((short)12);
		HeadFont.setBold(true);
		tableHeadStyle.setFont(HeadFont);
		
		//테두리 선
		
		tableHeadStyle.setBorderLeft(BorderStyle.THIN);
		tableHeadStyle.setBorderRight(BorderStyle.THICK);
		tableHeadStyle.setBottomBorderColor(IndexedColors.LIGHT_ORANGE.getIndex());
		
		// row 생성
		
		Row row = sheet.createRow(0);
		
		//cell 생성
		
		Cell cell = row.createCell(0);
		cell.setCellStyle(tableHeadStyle);
		cell.setCellValue("ddd");
		
		try (FileOutputStream fos1 = new FileOutputStream(new File(path1 + "ggg.xls") )){
			workbook.write(fos1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
	}
}
