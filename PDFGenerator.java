package org.example.firstapplication;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PDFGenerator {

    public static void generatePDF() {

        try {

            Document document = new Document();

            PdfWriter.getInstance(document,
                    new FileOutputStream("StudentReport.pdf"));

            document.open();

            Font titleFont =
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);

            Paragraph title =
                    new Paragraph("Student Report",titleFont);

            title.setAlignment(Element.ALIGN_CENTER);

            document.add(title);

            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);

            table.addCell("ID");
            table.addCell("Name");
            table.addCell("Department");
            table.addCell("Email");

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM student";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                table.addCell(String.valueOf(rs.getInt("id")));
                table.addCell(rs.getString("name"));
                table.addCell(rs.getString("dept"));
                table.addCell(rs.getString("email"));

            }

            document.add(table);

            document.close();

            rs.close();
            ps.close();
            con.close();

            System.out.println("PDF Generated Successfully.");

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}