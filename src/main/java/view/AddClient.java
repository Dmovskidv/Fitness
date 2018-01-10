package view;

import Interface.ViewInterface;
import controller.Controller;

import model.Model;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import static java.awt.Color.LIGHT_GRAY;

public class AddClient implements ViewInterface {

    private static JFrame frame;
    private static JPanel panel,panelDate;
    private JLabel label_sirname;
    private JLabel label_name;
    private JLabel label_nameFather;
    private JLabel label_getPublic;
    private JLabel label_whyKnow;
    private JLabel label_birthday;
    private JLabel label_mobile;
    private JLabel label_homePhone;
    private JLabel label_workPhone;
    private JLabel label_email;
    private JLabel label_passportNum;
    private JLabel label_infoPassport;
    private JLabel label_aboutClient;
    private JLabel label_Sex;
    private static JLabel label_foto;
    private static  JTextField field_sirname, field_name, field_nameFather, field_mobile, field_homePhone,
            field_workPhone, field_email, field_passport, field_infoPassport ;
    private static JTextArea textArea_aboutClient;
    private JButton button_create, button_cancel, button_clean, buttonReturnMain;
    private static  JComboBox comboBox_getPublic, comboBox_whyKnow, comboBox_sex;
    private static String[] combo_items = Model.getDateForAddClient("whereKnow");
    private static String[] combo_items2 = Model.getDateForAddClient("getNews");
    private String[] sexPerson = Model.getDateForAddClient("sexPerson");
    private static JDatePickerImpl datePicker;



   //methods
    public AddClient() {
        frame = new JFrame();
        frame.setTitle("Новый клиент");
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        getForm();
        getDate();

    }

    public void getForm() {
        label_sirname = new JLabel("Фамилия");
        label_sirname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_sirname.setBounds(20, 71, 94, 26);
        panel.add(label_sirname);

        label_name = new JLabel("Имя");
        label_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_name.setBounds(288, 71, 94, 26);
        panel.add(label_name);

        label_nameFather = new JLabel("Отчество");
        label_nameFather.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_nameFather.setBounds(556, 71, 94, 26);
        panel.add(label_nameFather);

        field_sirname = new JTextField();
        field_sirname.setBounds(20, 97, 258, 45);
        panel.add(field_sirname);
        field_sirname.setColumns(10);

        label_birthday = new JLabel("Дата рождения");
        label_birthday.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_birthday.setBounds(20, 165, 150, 30);
        panel.add(label_birthday);

        label_mobile = new JLabel("Мобильный");
        label_mobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_mobile.setBounds(20, 254, 82, 26);
        panel.add(label_mobile);

        label_homePhone = new JLabel("Домашний");
        label_homePhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_homePhone.setBounds(288, 254, 82, 26);
        panel.add(label_homePhone);

        label_workPhone = new JLabel("Рабочий");
        label_workPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_workPhone.setBounds(556, 254, 82, 26);
        panel.add(label_workPhone);

        label_email = new JLabel("Email");
        label_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_email.setBounds(20, 364, 82, 26);
        panel.add(label_email);

        label_passportNum = new JLabel("Номер паспорта");
        label_passportNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_passportNum.setBounds(20, 469, 133, 26);
        panel.add(label_passportNum);

        label_infoPassport = new JLabel("Кем и когда выдан");
        label_infoPassport.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_infoPassport.setBounds(311, 469, 122, 26);
        panel.add(label_infoPassport);

        field_name = new JTextField();
        field_name.setColumns(10);
        field_name.setBounds(288, 97, 258, 45);
        panel.add(field_name);


        field_nameFather = new JTextField();
        field_nameFather.setColumns(10);
        field_nameFather.setBounds(556, 97, 258, 45);
        panel.add(field_nameFather);

        field_workPhone = new JTextField();
        field_workPhone.setColumns(10);
        field_workPhone.setBounds(556, 280, 258, 45);
        panel.add(field_workPhone);

        field_homePhone = new JTextField();
        field_homePhone.setColumns(10);
        field_homePhone.setBounds(288, 280, 258, 45);
        panel.add(field_homePhone);

        field_mobile = new JTextField();
        field_mobile.setColumns(10);
        field_mobile.setBounds(20, 280, 258, 45);
        panel.add(field_mobile);

        field_email = new JTextField();
        field_email.setColumns(10);
        field_email.setBounds(20, 393, 794, 45);
        panel.add(field_email);

        field_passport = new JTextField();
        field_passport.setColumns(10);
        field_passport.setBounds(23, 496, 272, 45);
        panel.add(field_passport);

        field_infoPassport = new JTextField();
        field_infoPassport.setColumns(10);
        field_infoPassport.setBounds(311, 496, 503, 45);
        panel.add(field_infoPassport);

        button_clean = new JButton("Очистить");
        button_clean.setBounds(862, 768, 225, 54);
        panel.add(button_clean);
        Controller.cleanFormButton(button_clean);

        button_create = new JButton("Создать");
        button_create.setBounds(1097, 768, 225, 54);
        panel.add(button_create);
        Controller.writeDB(button_create);

        button_cancel = new JButton("Закрыть");
        button_cancel.setBounds(1332, 768, 225, 54);
        panel.add(button_cancel);
        Controller.cancelClientButton(button_cancel, getFrame());

        buttonReturnMain = new JButton("");
        buttonReturnMain.setBorder(null);
        buttonReturnMain.setIcon(new ImageIcon("src\\main\\resources\\images\\return.jpg"));
        buttonReturnMain.setBounds(20, 10, 47, 53);
        panel.add(buttonReturnMain);
        Controller.returnMainMenu(buttonReturnMain, getFrame());

        textArea_aboutClient = new JTextArea();
        textArea_aboutClient.setBorder(BorderFactory.createLineBorder(LIGHT_GRAY));
        textArea_aboutClient.setBounds(863, 393, 697, 328);
        panel.add(textArea_aboutClient);


        label_aboutClient = new JLabel("Дополнительно:");
        label_aboutClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_aboutClient.setBounds(870, 357, 122, 41);
        panel.add(label_aboutClient);

        label_foto = new JLabel();
        label_foto.setBounds(1311, 112, 200, 200);
        label_foto.setIcon(new ImageIcon("src\\main\\resources\\images\\fotoForAddClient.jpg"));
        label_foto.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel.add(label_foto);


        label_getPublic = new JLabel("Получать рекламу:");
        label_getPublic.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_getPublic.setBounds(863, 159, 133, 32);
        panel.add(label_getPublic);

        label_whyKnow = new JLabel("Откуда узнал:");
        label_whyKnow.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_whyKnow.setBounds(863, 257, 133, 20);
        panel.add(label_whyKnow);

        comboBox_getPublic = new JComboBox(combo_items2);
        comboBox_getPublic.setBounds(863, 189, 361, 45);
        panel.add(comboBox_getPublic);

        comboBox_whyKnow = new JComboBox(combo_items);
        comboBox_whyKnow.setBounds(863, 280, 361, 45);
        panel.add(comboBox_whyKnow);

//addFoto
        JButton fileopen = new JButton("Добавить");
        fileopen.setBounds(1326, 323, 171, 32);
        panel.add(fileopen);
        Controller.clickOpenFoto(fileopen);


        comboBox_sex = new JComboBox(sexPerson);
        comboBox_sex.setBounds(863, 97, 361, 45);
        panel.add(comboBox_sex);

         label_Sex = new JLabel("Пол:");
        label_Sex.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_Sex.setBounds(863, 71, 74, 26);
        panel.add(label_Sex);

    }

    void getDate() {
        panelDate = new JPanel();
        panelDate.setBounds(0, 185, 250, 73);
        panel.add(panelDate);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        panelDate.add(datePicker);

    }

//show frame Addclient()
    @Override
    public void showView() {
        frame.setVisible(true);

    }


//format show date
    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "dd.MM.yyyy";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {

                return dateFormatter.parseObject(text);

        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }

//getters and setters
    public static JFrame getFrame() {
        return frame;
    }

    public static  JComboBox getComboBox_getPublic() {
        return comboBox_getPublic;
    }

    public static JComboBox getComboBox_whyKnow() {
        return comboBox_whyKnow;
    }

    public static JComboBox getComboBox_sex() {
        return comboBox_sex;
    }

    public static JPanel getPanel() {
        return panel;
    }

    public static  JTextField getField_sirname() {
        return field_sirname;
    }

    public static JTextField getField_name() {
        return field_name;
    }

    public static JTextField getField_nameFather() {
        return field_nameFather;
    }

    public static JTextField getField_workPhone() {
        return field_workPhone;
    }

    public static JTextField getField_homePhone() {
        return field_homePhone;
    }

    public static JTextField getField_mobilePhone() {
        return field_mobile;
    }

    public static JTextField getField_email() {
        return field_email;
    }

    public static JTextField getField_passport() {
        return field_passport;
    }

    public static JTextField getField_infoPassport() {
        return field_infoPassport;
    }

    public static JLabel getLabel_foto() {
        return label_foto;
    }

    public static JTextArea getTextArea_aboutClient() {
        return textArea_aboutClient;
    }

    public static JDatePickerImpl getDatePicker(){
        return datePicker;
    }


}