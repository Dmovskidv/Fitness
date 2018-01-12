package model;

import controller.Controller;
import view.AddClient;
import view.AddSale;
import view.FindClient;
import view.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DB {

    private static Model model = new Model();

    private static Connection connection;

    public static boolean openDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(
                    "jdbc:sqlite:src\\sqlite\\myDB.db");
            //System.out.println("DB open");
            return true;

        } catch (Exception e) {
            System.out.println("DB isn't open");
            return false;
        }
    }

    public static void insertDB() {
        final String names = AddClient.getField_name().getText();
        final String sirname = AddClient.getField_sirname().getText();
        final String lastname = AddClient.getField_nameFather().getText();
        final String sex = ((String) AddClient.getComboBox_sex().getSelectedItem());
        final String age = (AddClient.getDatePicker().getJFormattedTextField().getText().trim().length() > 0) ? AddClient.getDatePicker().getJFormattedTextField().getText() : "Не указано";
        final String mobilePhone = AddClient.getField_mobilePhone().getText();
        final String homePhone = (AddClient.getField_homePhone().getText().trim().length() > 0) ? AddClient.getField_homePhone().getText() : "Не указано";
        final String workPhone = (AddClient.getField_workPhone().getText().trim().length() > 0) ? AddClient.getField_workPhone().getText() : "Не указано";
        final String numberPassport = (AddClient.getField_passport().getText().trim().length() > 0) ? AddClient.getField_passport().getText() : "Не указано";
        final String mailAddress = (AddClient.getField_email().getText().trim().length() > 0) ? AddClient.getField_email().getText() : "Не указано";
        final String infoPassport = (AddClient.getField_infoPassport().getText().trim().length() > 0) ? AddClient.getField_infoPassport().getText() : "Не указано";
        final String moreInformation = (AddClient.getTextArea_aboutClient().getText().trim().length() > 0) ? AddClient.getTextArea_aboutClient().getText() : "Не указано";
        final String whereKnow = (String) AddClient.getComboBox_whyKnow().getSelectedItem();
        final String getReklama = (String) AddClient.getComboBox_getPublic().getSelectedItem();
        final String getPathFoto = AddClient.getLabel_foto().getIcon().toString();
        final String clientStatus = "не активный";


        //command INSERT in DB
        String query = "INSERT INTO clients (sirName, name, lastName, sex, mobilePhone, homePhone, workPhone, email, age, whereKnow, getReklama, numberPassport, infoPassport, moreInfo, pathFoto, status) " +
                "VALUES ('" + sirname + "', '" + names + "', '" + lastname + "', '" + sex + "', '" + mobilePhone + "', '" + homePhone
                + "', '" + workPhone + "', '" + mailAddress + "', '" + age + "', '" + whereKnow + "', '" + getReklama
                + "', '" + numberPassport + "', '" + infoPassport + "', '" + moreInformation + "', '" + getPathFoto + "', '" + clientStatus + "')";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Client added");
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void selectDB() {


        try {
            Statement statement = connection.createStatement();

            String query = "SELECT card, sirname, name, lastName, sex, mobilePhone, homePhone, workPhone, email, age, " +
                    "whereKnow, getReklama, numberPassport, infoPassport, moreInfo, pathFoto, status " +
                    " FROM clients" +
                    " ORDER BY sirName";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
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
                String pathFoto = result.getString("pathFoto");
                String clientStatus = result.getString("status");

                model.getDate().add(new Client(name, sirName, lastName, sex, age, card,
                        pathFoto, mobilePhone, homePhone, workPhone, email, numberPassport, infoPassport, moreInfo, whereKnow, getReklama, clientStatus));
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
            //System.out.println("DB close");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String selectCostDB(String nameservice, String timeservice) {
        String resultTransaction = "";
        if (openDB()) {


            String query = "SELECT cost " +
                    " FROM cost WHERE time = ?  AND name = ?";

            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, timeservice);
                ps.setString(2, nameservice);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    resultTransaction = rs.getString("cost");
                }
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return resultTransaction;
    }

    public static String getPasswordDB(String adminname) {
        String getPassword = "";
        if (openDB()) {


            String query = "SELECT pass " +
                    " FROM password WHERE admin = ?";

            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, adminname);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    getPassword = rs.getString("pass");
                }
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return getPassword;
    }

    public static String[] getAdminDB() {
        String getAdmin[] = new String[3];
        if (openDB()) {


            String query = "SELECT admin " +
                    " FROM password";

            try {
                PreparedStatement ps = connection.prepareStatement(query);

                ResultSet rs = ps.executeQuery();
                int i = 0;
                while (rs.next()) {

                    getAdmin[i] = rs.getString("admin");
                    i++;
                }

                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return getAdmin;
    }

    public static void addPayDB(JButton actionPay) {

        actionPay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {



try {

    String service = (String) AddSale.getComboBoxServices().getSelectedItem();
    String timeService = (String) AddSale.getComboBoxTypeVisit().getSelectedItem();
    Calendar c = new GregorianCalendar();
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    String date = format.format(c.getTime());
    String time = new SimpleDateFormat ( "HH:mm:ss" ).format ( new Date() );
    String admin = Main.getAdminItem().getText();
    String rusNameService = service;
    String rusNameTimeService = timeService;
    service = Controller.convertationService(service);
    timeService = Controller.convertationTimeService(timeService);
    double payment = Double.parseDouble(DB.selectCostDB(service, timeService));
    String numberCard = (((String) AddSale.getComboBoxTypeClient().getSelectedItem()).equals("Гость")) ? "Гость" : AddSale.getTextFieldNumCard().getText();

    //check valide input in WindowPay
   if(numberCard.length()==0 || (AddSale.getComboBoxTypeVisit().getSelectedItem().equals("Разовое посещение") && AddSale.getComboBoxTypeClient().getSelectedItem().equals("Клиент клуба")) ||
    (AddSale.getComboBoxTypeClient().getSelectedItem().equals("Гость") && !AddSale.getComboBoxTypeVisit().getSelectedItem().equals("Разовое посещение"))  ){
       throw new NullPointerException("exception");
   }

   if(Controller.validateNumberCard(numberCard) || numberCard.equals("Гость") ){

    int lastID = DB.selectLastID();
    CashBox cashBox = new CashBox(DB.incLastSum(lastID), payment, lastID);
    double cashSum = cashBox.count();
    if(numberCard.equals("Гость")){insertVisitGostDB(rusNameService);}


                //command INSERT in DB
                String query = "INSERT INTO cashBox (date, time , admin, service, period, payment, sum, numberCard) " +
                        "VALUES ('" + date + "', '" + time + "', '" + admin + "', '" + service + "', '" + timeService + "', '" + payment + "', '" + cashSum
                       + "', '" + numberCard + "')";

                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);
                    System.out.println("Данные об оплате сохранены в базу данных");
                    AddSale.getLabelStatus().setText("оплачено");


                    JOptionPane.showMessageDialog(null, "Операция прошла успешно");
                    if(!numberCard.equals("Гость")){

                        DB.setStatusClient(numberCard, rusNameService, rusNameTimeService);

                       for (int i=0;i<model.getDate().size();i++){
                           if(model.getDate().get(i).getNumberCard()==Integer.parseInt(numberCard)){
                               model.getDate().get(i).setStatus(rusNameService+" "+rusNameTimeService);
                           }
                       }

                    }
                    statement.close();
                } catch (Exception exc) {
                    System.out.println(exc);
                }
   }      else {  JOptionPane.showMessageDialog(null, "Такой номер карты клиента не существует");}

            }catch(Exception exception){JOptionPane.showMessageDialog(null,"Не корректно заполнена форма оплаты");}
            }
        });

    }

    private static void setStatusClient(String numberCard, String service, String time) {

        int idcard = Integer.parseInt(numberCard);
        String nameAndTimeService = service+" "+time;

        if (openDB()) {

           //command INSERT in DB
            String query = "UPDATE clients SET status = ? WHERE card = ?";

            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, nameAndTimeService);
                ps.setInt(2, idcard);
                ps.executeUpdate();

                ps.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double incLastSum(int i) {

        int resultTransaction = 0;

        if (openDB()) {

            String query = "SELECT sum FROM cashBox WHERE id = ?";

            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, i);


                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    resultTransaction =rs.getInt("sum");
                }
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultTransaction;
    }

    private static int selectLastID() {

        int resultTransaction = 0;

        if (openDB()) {

            String query = "SELECT id FROM cashBox ORDER BY id DESC LIMIT 1";

            try {
                PreparedStatement ps = connection.prepareStatement(query);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    resultTransaction =rs.getInt("id");
                }
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return resultTransaction;
    }

    public static void updateClient(String id, String textForChange, String nameColumn) {

        Controller.updateJTable(id, textForChange, nameColumn);

        String[] mass = new String[3];
        int idcard = Integer.parseInt(id);
        if(nameColumn.equals("fio")) {
            mass = textForChange.split(" ");
                   }


            String query = null;
            if (openDB()) {

               switch(nameColumn){

                   case "fio" : query = "UPDATE clients SET sirName = ?, name = ?, lastName = ? WHERE card = ?";
                       break;
                   case "sex" : query = "UPDATE clients SET sex = ? WHERE card = ?";
                       break;
                   case "mobilePhone" : query = "UPDATE clients SET mobilePhone = ? WHERE card = ?";
                       break;
                   case "homePhone" : query = "UPDATE clients SET homePhone = ? WHERE card = ?";
                       break;
                   case "workPhone" : query = "UPDATE clients SET workPhone = ? WHERE card = ?";
                       break;
                   case "email" : query = "UPDATE clients SET email = ? WHERE card = ?";
                       break;
                   case "age" : query = "UPDATE clients SET age = ? WHERE card = ?";
                       break;
                   case "whereKnow" : query = "UPDATE clients SET whereKnow = ? WHERE card = ?";
                       break;
                   case "moreInfo" : query = "UPDATE clients SET moreInfo = ? WHERE card = ?";
                       break;
                   case "getReklama" : query = "UPDATE clients SET getReklama = ? WHERE card = ?";
                       break;
                   case "numberPassport" : query = "UPDATE clients SET numberPassport = ? WHERE card = ?";
                       break;
                   case "pathFoto" : query = "UPDATE clients SET pathFoto = ? WHERE card = ?";
                       break;
               }

                try {

                    PreparedStatement ps = connection.prepareStatement(query);

                    if(!nameColumn.equals("fio")){
                    ps.setString(1, textForChange);
                    ps.setInt(2, idcard);
                }
                if(nameColumn.equals("fio")){
                    ps.setString(1, mass[0]);
                    ps.setString(2, mass[1]);
                    ps.setString(3, mass[2]);
                    ps.setInt(4, idcard);
                }
                    ps.executeUpdate();

                    ps.close();
                } catch (Exception e) {
                    System.out.println(e);
                }


            }
        }

    public static void insertEnterVisitClientDB() {
        Calendar c = new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String date = format.format(c.getTime());
        String timeEnter = calendar.getTime().getHours()+":"+calendar.getTime().getMinutes();
        String fio = FindClient.getLabelInfoClientFio().getText();
        String idClient = FindClient.getLabelInfoClientCard().getText();
        String serviceClient = FindClient.getLabelInfoClientStatus().getText();//Controller.findClientId(idClient);
        String serviceName[] = serviceClient.split(" ");
        String serviceRez = (serviceName[0].equals("Тренажёрный") || serviceName[0].equals("Тренажерный") )? serviceName[0]+" "+serviceName[1]  : serviceName[0];



        //command INSERT in DB
        String query = "INSERT INTO visits (client, date, timeEntrance, service) " +
                "VALUES ('" + fio + "','"  + date + "','"  + timeEnter + "','"  + serviceRez + "')";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
           JOptionPane.showMessageDialog(null,"Вход клиента №"+idClient+" добавлен");
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void insertExitVisitClientDB() {
        Calendar calendar = Calendar.getInstance();
        String timeEdit = calendar.getTime().getHours()+":"+calendar.getTime().getMinutes();
        String idClient = FindClient.getLabelInfoClientCard().getText();
        String fio = FindClient.getLabelInfoClientFio().getText();

        //command INSERT in DB
        String query = "UPDATE visits SET timeExit = ? WHERE client = ?";


        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(2, fio);
            ps.setString(1, timeEdit);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"Выход клиента №"+idClient+" добавлен");
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void insertVisitGostDB(String service) {
        Calendar c = new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String date = format.format(c.getTime());
        String timeEnter = calendar.getTime().getHours()+":"+calendar.getTime().getMinutes();

        //command INSERT in DB
        String query = "INSERT INTO visits (client, date, timeEntrance, service) " +
                "VALUES ('" + "Гость" + "','"  + date + "','"  + timeEnter + "','"  + service + "')";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            //JOptionPane.showMessageDialog(null,"Вход на разовое посещение добавлен");
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static int selectForReportService( String service) {

        String date = new SimpleDateFormat ( "dd.MM.yyyy" ).format ( new Date() );
        int result = 0;
        if (openDB()) {


            String query = "SELECT COUNT (client) AS total FROM visits WHERE date= ? AND service = ? ";

            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, date);
                ps.setString(2, service);
                ResultSet rs = ps.executeQuery();


                while (rs.next()) {
                    result = rs.getInt("total");

                }
                ps.close();
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public static double sumOfDay() {
        String date = new SimpleDateFormat ( "dd.MM.yyyy" ).format ( new Date() );

        double result = 0;

        if (openDB()) {


            String query = "SELECT SUM (payment) AS total FROM cashBox WHERE date = ? ";

            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, date);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    result = rs.getDouble("total");
                                   }
                ps.close();
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public static double sumAll() {

        String date = new SimpleDateFormat ( "dd.MM.yyyy" ).format ( new Date() );

        double result = 0;

        if (openDB()) {


            String query = "SELECT MAX (sum) AS total FROM cashBox ";

            try {
                PreparedStatement ps = connection.prepareStatement(query);
                //ps.setString(1, date);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    result = rs.getDouble("total");

                }
                ps.close();
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
}

