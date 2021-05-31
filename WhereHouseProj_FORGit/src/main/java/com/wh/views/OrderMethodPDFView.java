package com.wh.views;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.wh.model.OrderMethod;

public class OrderMethodPDFView extends AbstractPdfView {
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//read data
		@SuppressWarnings("unchecked")
		List<OrderMethod> oml=(List<OrderMethod>) model.get("OrderMethodList");
		
		res.addHeader("Content-Disposition","attachment;filename=OrderMethods.pdf");
		
		Font font=new Font(Font.TIMES_ROMAN, 22 , Font.BOLD, Color.CYAN);
		
		Paragraph p = new Paragraph("ALL YOUR ORDER METHODS",font);
		p.setSpacingBefore(10f);
		p.setSpacingAfter(10f);
		p.setAlignment(Element.ALIGN_CENTER);
		
		doc.add(p);
		//table creation
		PdfPTable tab=new PdfPTable(6);
		//add headings
		tab.addCell("ID");
		tab.addCell("O M CODE");
		tab.addCell("O M MODE");
		tab.addCell("O M TYPE");
		tab.addCell("O M ACCECPT");
		tab.addCell("O M DESC");
		
		//ADD DATA
		for(OrderMethod om : oml ) {
			tab.addCell(String.valueOf(om.getOrderMId()));
			tab.addCell(om.getOrderMCode());
			tab.addCell(om.getOrderMMode());
			tab.addCell(om.getOrderMType());
			tab.addCell(om.getOrderMAccept().toString());
			tab.addCell(om.getOrderMDesc());
		}//for
		doc.add(tab);
	}//method
}//class