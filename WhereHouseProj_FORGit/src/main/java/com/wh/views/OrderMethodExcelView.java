package com.wh.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.wh.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		//extract data from model

		@SuppressWarnings("unchecked")
		List<OrderMethod> oml=(List<OrderMethod>) model.get("OrderMethodList");

		//set name 
		res.addHeader("Content-Disposition","attachment;filename=OrderMethods.xlsx");
		//create sheet
		Sheet sheet=workbook.createSheet("orderMethodsList");
		//create 1st row as headings
		Row r1=sheet.createRow(0);
		r1.createCell(0).setCellValue("ID");
		r1.createCell(1).setCellValue("O M MODE");
		r1.createCell(2).setCellValue("O M CODE");
		r1.createCell(3).setCellValue("O M TYPE");
		r1.createCell(4).setCellValue("O M ACCEPT");
		r1.createCell(5).setCellValue("O M DESCRIPTION");
		//CREATE data rows
		int rowVal=1;
		for(OrderMethod om : oml) {
			Row r=sheet.createRow(rowVal++);
			r.createCell(0).setCellValue(om.getOrderMId());
			r.createCell(1).setCellValue(om.getOrderMMode());
			r.createCell(2).setCellValue(om.getOrderMCode());
			r.createCell(3).setCellValue(om.getOrderMType());

			List<String> omAcc=om.getOrderMAccept();// 	ACCEPT   RETURN
			String omAccAsString="";//   ""  "-ACCEPT"  "-ACCEPT-RETURN"
			for(String a : omAcc) {
				omAccAsString=omAccAsString+ "-"+ a;
			}//for
			r.createCell(4).setCellValue(omAccAsString);
			r.createCell(5).setCellValue(om.getOrderMDesc());
		}//for
	}//metod
}//class
