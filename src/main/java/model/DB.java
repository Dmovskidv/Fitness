package model;

import view.AddClient;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DB {

    static Connection connection;

   public static  boolean openDB() {
       try {
           Class.forName("org.sqlite.JDBC");
           connection = DriverManager.getConnection(
                   "jdbc:sqlite:c:\\sqlite\\myDB.db");
           System.out.println("Connected");
           System.out.println(AddClient.getLabel_foto().getIcon().toString());
           return true;
           } catch (Exception e) {
               System.out.println("not connection");
               return false;
           }
   }

    public static  void insertDB() {
        final String names = AddClient.getField_name().getText();
        final String sirname = AddClient.getField_sirname().getText();

        final String lastname = AddClient.getField_nameFather().getText();
        if (names.trim().length() == 0) {
            AddClient.getField_sirname().setBorder(BorderFactory.createLineBorder(Color.red));
        }
        if (sirname.trim().length() == 0) {
            AddClient.getField_name().setBorder(BorderFactory.createLineBorder(Color.red));
        }
        if (lastname.trim().length() == 0) {
            AddClient.getField_nameFather().setBorder(BorderFactory.createLineBorder(Color.red));
        }
        final String sex = ((String) AddClient.getComboBox_sex().getSelectedItem());
        final String age = (AddClient.getDatePicker().getJFormattedTextField().getText().trim().length() > 0) ? AddClient.getDatePicker().getJFormattedTextField().getText() : "Не указано";
        final String mobilePhone = AddClient.getField_mobilePhone().getText();
        final String homePhone = (AddClient.getField_homePhone().getText().trim().length() > 0) ? AddClient.getField_homePhone().getText() : "Не указано";
        final String workPhone = (AddClient.getField_workPhone().getText().trim().length() > 0) ? AddClient.getField_workPhone().getText() : "Не указано";
        final String numberPassport = (AddClient.getField_passport().getText().trim().length() > 0) ? AddClient.getField_passport().getText() : "Не указано";
        final String mailAddress = (AddClient.getField_email().getText().trim().length() > 0) ? AddClient.getField_email().getText() : "Не указано";
        final String infoPassport = (AddClient.getField_infoPassport().getText().trim().length() > 0) ? AddClient.getField_infoPassport().getText() : "Не указано";
        final String moreInformation = (AddClient.getTextArea_aboutClient().getText().trim().length() > 0) ? AddClient.getTextArea_aboutClient().getText() : "Не указано";
        final String whereKnow = (String)AddClient.getComboBox_whyKnow().getSelectedItem();
        final String getReklama = (String)AddClient.getComboBox_getPublic().getSelectedItem();
        final String getPathFoto = AddClient.getLabel_foto().getIcon().toString();

        //command INSERT in DB
       String query = "INSERT INTO clients (sirName, name, lastName, sex, mobilePhone, homePhone, workPhone, email, age, whereKnow, getReklama, numberPassport, infoPassport, moreInfo, pathFoto) " +
                      "VALUES ('" + sirname + "', '" + names + "', '" + lastname + "', '" + sex + "', '" + mobilePhone + "', '" + homePhone
               + "', '" + workPhone + "', '"+ mailAddress + "', '" + age + "', '" + whereKnow + "', '" + getReklama
        + "', '"  + numberPassport + "', '" + infoPassport + "', '" + moreInformation + "', '" + getPathFoto + "')";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Rows added");
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static  void selectDB() {
        try {
            Statement statement = connection.createStatement();

            String query = "SELECT card, sirname, name, lastName, sex, mobilePhone, homePhone, workPhone, email, age, " +
                    "whereKnow, getReklama, numberPassport, infoPassport, moreInfo" +
                    " FROM clients" +
                    " ORDER BY sirName";
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                int card = result.getInt("card");
                String sirName = result.getString("sirname");
                String name = result.getString("name");
                String lastName = result.getString("lastName");
                String sex = result.getString("sex");
                String mobilePhone = result.getString("mobilePhone");
                String homePhone = result.getString("homePhone");
                String workPhone = result.getString("workPhone");
                String email = result.getString("email");
                String age = result.getString("age");
                String whereKnow = result.getString("whereKnow");
                String getReklama = result.getString("getReklama");
                String numberPassport = result.getString("numberPassport");
                String infoPassport = result.getString("infoPassport");
                String moreInfo = result.getString("moreInfo");
                System.out.println(card);
                System.out.println(sirName);
                System.out.println(name);
                System.out.println(lastName);
                System.out.println(sex);

            }
                result.close();
                statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeDB() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
