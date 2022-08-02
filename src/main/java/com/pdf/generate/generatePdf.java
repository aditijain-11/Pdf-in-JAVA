package com.pdf.generate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class generatePdf {

	public static void main(String[] args) {

		try {
			String fileName = "C:\\pdf\\xyz.pdf";
			Document document = new Document(PageSize.A4, 40f, 40f, 40f, 40f);
			PdfWriter.getInstance(document, new FileOutputStream(fileName));

			document.open();

//			font types
			Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
			Font italicFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);
			Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 18);
			Font avgFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
//			Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN,12);
//			logo
			Image image;
			try {
				image = Image.getInstance("C:\\pdf\\logo.png");
				image.scaleAbsolute(100, 80);
				image.setAlignment(Element.ALIGN_CENTER);
				document.add(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			heading
			Paragraph heading = new Paragraph("INDRAPRASTHA GAS LIMITED", bigFont);
			heading.setAlignment(Element.ALIGN_CENTER);

			document.add(heading);

			Paragraph para1 = new Paragraph("A Joint Venture of GAIL (India) Ltd. BPCL & Govt. of NCT of Delhi\r\n"
					+ "IGL Bhawan, Plot No. 4, Community Centre, Sector – 9, R.K. Puram, New Delhi – 110022\r\n" + "",
					avgFont);
			para1.setAlignment(Element.ALIGN_CENTER);

			document.add(para1);

			document.add(new Paragraph("\n"));

//			heading 2
			Chunk underline = new Chunk("MATERIAL GATEPASS");
			underline.setUnderline(0.8f, -1f);
			Paragraph heading2 = new Paragraph();
			heading2.add(underline);
			heading2.setAlignment(Element.ALIGN_CENTER);
			document.add(heading2);

//			para2
			Paragraph para2 = new Paragraph(
					"Overwriting must be signed by the authorized signatory. Material Gate Pass may be issued on this format only in triplicate for keeping first copy with Security. Second with receiver and the last copy with custodian. Receiver may be advised to preserve the copy of Gate Pass of returnable material which will be required at the time of material coming back to IGL",
					italicFont);
			para2.setAlignment(Element.ALIGN_CENTER);
			document.add(para2);

//			para3
			document.add(new Paragraph("\n"));
			Paragraph para3 = new Paragraph(
					"Please allow item(s) mentioned below to be taken out from IGL premises on ", boldFont);
			para3.setAlignment(Element.ALIGN_CENTER);
			document.add(para3);

			document.add(new Paragraph("\n"));
//			table
			float[] ColumnWidths = { 5f, 5f, 5f, 5f, 5f };
			PdfPTable table = new PdfPTable(ColumnWidths);

			PdfPCell c1 = new PdfPCell(new Phrase("Sl. No."));
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Description of Item(s)"));
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Model & Sr. No., if any"));
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Quantity  (In Number or Weight, whichever is applicable)"));
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Purpose of taking out the material"));
			table.addCell(c1);

			table.addCell("1.1");
			table.addCell("1.2");
			table.addCell("1.3");
			table.addCell("1.4");
			table.addCell("1.5");
			table.addCell("2.1");
			table.addCell("2.2");
			table.addCell("2.3");
			table.addCell("2.4");
			table.addCell("2.5");
			table.addCell("3.1");
			table.addCell("3.2");
			table.addCell("3.3");
			table.addCell("3.4");
			table.addCell("3.5");

			document.add(table);

//			Person Information

//			custodian name
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("Custodian Details :  ", boldFont));

//			destination of material
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("Destination Of Material : ", boldFont));

//			carrier name
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("Name of person carrying the above material : ", boldFont));

//			Signature of carrier
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("Signature of the person carrying the material : ", boldFont));

//			IT Approver details
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("IT Approver Details : ", boldFont));

//			Signature IT and HR department
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("\n"));
			document.add(new Paragraph(
					"(Signature IT Department)                                                                                    (Counter Signature Of Executive - HR) ",
					boldFont));

//			PdfContentByte cb = pdf.getDirectContent();
//		      try {
//				cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 24);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		      cb.moveTo(30, 150);
//		      cb.lineTo(570, 150);
//		      cb.stroke();

			Paragraph line = new Paragraph(
					"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			document.add(line);

			document.add(new Paragraph("\n"));
//			security gaurd slip
			Paragraph paraA = new Paragraph("Material Entered at Sl. No.: ", boldFont);
			document.add(paraA);

			Paragraph paraB = new Paragraph("Dated : ", boldFont);
			document.add(paraB);

			Paragraph paraC = new Paragraph("Timed : ", boldFont);
			document.add(paraC);

			document.add(new Paragraph("Type : ", boldFont));

			Paragraph signSecurity = new Paragraph("Signature Of Security Gaurd(above)", avgFont);
			signSecurity.setAlignment(Element.ALIGN_RIGHT);
			document.add(signSecurity);

			document.close();

			System.out.println("finished");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
