/**  
 * @Title:  ExcelTest.java   
 * @Package com.wpc.test   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangpengcheng     
 * @date:   2016年12月13日 下午6:39:54   
 * @version V1.0 
 */
package com.wpc.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

/**   
 * @ClassName:  ExcelTest   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: wangpengcheng 
 * @date:   2016年12月13日 下午6:39:54   
 *     
 */
public class ExcelTest {

	public static void main(String[] args) throws Exception {
		
//		ExcelExportHelper eeh = new ExcelExportHelper();
		
		List<Map<String, Object>> users = new ArrayList<>();
		/*User user = null;
		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setId(i+1);
			user.setAccount("wpc"+i);
			user.setUsername(i+"wpc");
			user.setPassword("wpc123");
			user.setAge(i+3);
			user.setUpdateTime(new Date());
			users.add(user);
		}*/
		Map<String, Object> user = null;
		for (int i = 0; i < 10; i++) {
			user = new HashMap<>();
			user.put("ID", i+1);
			user.put("account", "wpc"+i);
			user.put("username", i+"wpc");
			user.put("password", "wpc123");
			user.put("age", i+3);
			user.put("updateTime", new Date());
			users.add(user);
		}
//		String[] header = {"ID", "账户", "昵称", "密码", "年龄", "生日"};
//		String[] properties = {"id", "account", "username", "password", "age", "updateTime"};
		
//		eeh.exportExcelAndSave(header, properties, users, "用户列表", "e:\\", "用户列表");
		
		
		/*Map<Integer, String> headNames = new HashMap<>();
		headNames.put(0, "ID");
		headNames.put(1, "账户");
		headNames.put(2, "昵称");
		headNames.put(3, "密码");
		headNames.put(4, "年龄");
		headNames.put(5, "生日");
		
		SheetBean sb = new SheetBean();
		sb.setSheetName("用户列表");
		sb.setTitle("用户列表");
		sb.setRownum(3);
		sb.setMergeColCount(2);
		sb.setHeadNames(headNames);
		sb.setTableContents(users);
		
		List<SheetBean> sheets = new ArrayList<>();
		sheets.add(sb);
//		sb.setSheetName("用户列表2");
//		sb.setTitle("用户列表2");
//		sheets.add(sb);
		
		ExcelBean eb = new ExcelBean();
		eb.setPath("e:\\excel\\123.xlsx");
		eb.setSheets(sheets);
		
		WriteExcel we = new WriteExcel();
		we.write(eb);*/
		
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
	    HSSFWorkbook wb = new HSSFWorkbook();

	    // 创建Excel的工作sheet,对应到一个excel文档的tab
	    HSSFSheet sheet = wb.createSheet("sheet1");

	    // 设置excel每列宽度
	    sheet.setColumnWidth(0, 8000);
	    sheet.setColumnWidth(1, 8000);
	    sheet.setColumnWidth(2, 8000);
	    sheet.setColumnWidth(3, 8000);
	    
	    // 创建字体样式
	    HSSFFont font = wb.createFont();
	    font.setFontName("Verdana");
	    font.setBoldweight((short) 100);
	    font.setFontHeight((short) 300);
	    font.setColor(HSSFColor.BLACK.index);

	    // 创建单元格样式
	    HSSFCellStyle style = wb.createCellStyle();
	    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	    style.setFillForegroundColor(HSSFColor.WHITE.index);
	    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

	    // 设置边框
	    style.setBottomBorderColor(HSSFColor.BLACK.index);
	    style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    style.setBorderTop(HSSFCellStyle.BORDER_THIN);

	    style.setFont(font);// 设置字体

	    // 创建Excel的sheet的弟一行
	    HSSFRow row = sheet.createRow(0);
	    row.setHeight((short) 1000);// 设定行的高度
	    
	    // 创建一个Excel的第一行第一格单元格
	    HSSFCell cell = row.createCell(0);

	    // 给Excel的单元格设置样式和赋值
	    cell.setCellStyle(style);
	    cell.setCellValue("XXXXXXXXX");
	    
	    // 创建一个Excel的第一行第二格单元格
	    cell = row.createCell(1);

	    // 给Excel的单元格设置样式和赋值
	    cell.setCellStyle(style);
	    cell.setCellValue("XXXXXXXXX");

	    //设置弟三第四格 row.createCell(1); .......
	    cell = row.createCell(2);
	    cell.setCellStyle(style);
	    cell.setCellValue("XXXXXXXXX");
	    cell = row.createCell(3);
	    cell.setCellStyle(style);
	    cell.setCellValue("XXXXXXXXX");
	    
	    //创建弟二行
	    row = sheet.createRow(1);
	    row.setHeight((short) 1000);// 设定行的高度

	    // 创建一个Excel的第二行第一格单元格
	    cell = row.createCell(0);

	    // 给Excel的单元格设置样式和赋值
	    cell.setCellStyle(style);
	    cell.setCellValue("XXXXXXXXX");
	    
	    // 创建超链接
	    HSSFHyperlink link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);
	    link.setAddress("http://www.baidu.com");
	    
	    // 创建一个Excel的第二行第二格单元格
	    cell = row.createCell(1);

	    // 给Excel的单元格设置样式和赋值
	    cell.setCellStyle(style);
	    cell.setCellValue("百度");
	    cell.setHyperlink(link);// 设定单元格的链接

	    //设置弟三第四格 row.createCell(1); .......
	    
	    //设置弟三行第四行类似......
	    
	    FileOutputStream os = new FileOutputStream("e://workbook.xls");
	    wb.write(os);
	    os.close();
		
	}
	
}
