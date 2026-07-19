package org.example.firstapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class HelloController {

    public Button submitButton;
    public Button pdfButton;
    @FXML
    private TextField nameField;

    @FXML
    private TextField deptField;

    @FXML
    private TextField emailField;

    @FXML
    public void submitData() {

        String name = nameField.getText();
        String dept = deptField.getText();
        String email = emailField.getText();

        String sql =
                "INSERT INTO student(name, dept, email) VALUES(?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setString(3, email);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data Inserted Successfully");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void generatePDF(){

        PDFGenerator.generatePDF();

    }

}