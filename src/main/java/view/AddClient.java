package view;

import Interface.ViewInterface;
import controller.Controller;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class AddClient implements ViewInterface {

    private JPanel panel;
    private JLabel label_sirname, label_name, label_nameFather, label_getPublic, label_whyKnow, label_birthday,
            label_mobile, label_homePhone, label_workPhone, label_email, label_passportNum, label_infoPassport,
            label_aboutClient;
    private JTextField field_sirname, field_name, field_nameFather, field_birthday, field_mobile, field_homePhone,
            field_workHome, field_email, field_passport, field_infoPassport, field_photo;
    private JTextArea textArea_aboutClient;
    private JButton button_create, button_cancel, button_addPhoto, buttonReturnMain;
    private JComboBox comboBox_getPublic, comboBox_whyKnow, comboBox_pol;
    private String[] combo_items = { "Рассказали знакомые", "Реклама в интернете", "Реклама в метро",
            "Интернет-поисковик", "Находится рядом", "Рекламные листовки", "Другое" };
    private String[] combo_items2 = { "Получать всё", "Не получать", "Только SMS", "Только email" };
    private String[] sexPerson = { "Мужской", "Женский" };
    private JPanel panelDate;
    private JFrame frame;

    public AddClient() {
        frame = new JFrame();
        frame.setTitle("Новый клиент");
        frame.setSize(1200, 750);
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
        label_sirname.setBounds(23, 30, 94, 26);
        panel.add(label_sirname);

        label_name = new JLabel("Имя");
        label_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_name.setBounds(213, 30, 94, 26);
        panel.add(label_name);

        label_nameFather = new JLabel("Отчество");
        label_nameFather.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_nameFather.setBounds(403, 30, 94, 26);
        panel.add(label_nameFather);

        field_sirname = new JTextField();
        field_sirname.setBounds(23, 55, 180, 45);
        panel.add(field_sirname);
        field_sirname.setColumns(10);

        label_birthday = new JLabel("Дата рождения");
        label_birthday.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_birthday.setBounds(23, 125, 122, 20);
        panel.add(label_birthday);

        label_mobile = new JLabel("Мобильный");
        label_mobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_mobile.setBounds(23, 234, 82, 26);
        panel.add(label_mobile);

        label_homePhone = new JLabel("Домашний");
        label_homePhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_homePhone.setBounds(213, 234, 82, 26);
        panel.add(label_homePhone);

        label_workPhone = new JLabel("Рабочий");
        label_workPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_workPhone.setBounds(403, 234, 82, 26);
        panel.add(label_workPhone);

        label_email = new JLabel("Email");
        label_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_email.setBounds(23, 344, 82, 26);
        panel.add(label_email);

        label_passportNum = new JLabel("Номер паспорта");
        label_passportNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_passportNum.setBounds(23, 449, 133, 26);
        panel.add(label_passportNum);

        label_infoPassport = new JLabel("Кем и когда выдан");
        label_infoPassport.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_infoPassport.setBounds(311, 449, 122, 26);
        panel.add(label_infoPassport);

        field_name = new JTextField();
        field_name.setColumns(10);
        field_name.setBounds(213, 55, 180, 45);
        panel.add(field_name);
        // System.out.println(field_name.getBorder().);

        field_nameFather = new JTextField();
        field_nameFather.setColumns(10);
        field_nameFather.setBounds(403, 55, 180, 45);
        panel.add(field_nameFather);

        field_mobile = new JTextField();
        field_mobile.setColumns(10);
        field_mobile.setBounds(403, 260, 180, 45);
        panel.add(field_mobile);

        field_homePhone = new JTextField();
        field_homePhone.setColumns(10);
        field_homePhone.setBounds(213, 260, 180, 45);
        panel.add(field_homePhone);

        field_workHome = new JTextField();
        field_workHome.setColumns(10);
        field_workHome.setBounds(23, 260, 180, 45);
        panel.add(field_workHome);

        field_email = new JTextField();
        field_email.setColumns(10);
        field_email.setBounds(23, 369, 560, 45);
        panel.add(field_email);

        field_passport = new JTextField();
        field_passport.setColumns(10);
        field_passport.setBounds(23, 476, 272, 45);
        panel.add(field_passport);

        field_infoPassport = new JTextField();
        field_infoPassport.setColumns(10);
        field_infoPassport.setBounds(311, 476, 272, 45);
        panel.add(field_infoPassport);

        button_create = new JButton("Создать");
        button_create.setBounds(782, 631, 180, 54);
        panel.add(button_create);

        button_cancel = new JButton("Отмена");
        button_cancel.setBounds(983, 631, 177, 54);
        panel.add(button_cancel);

        buttonReturnMain = new JButton("");
        buttonReturnMain.setBorder(null);
        buttonReturnMain.setIcon(new ImageIcon("src\\main\\resources\\images\\return.jpg"));
        buttonReturnMain.setBounds(20, 633, 47, 53);
        panel.add(buttonReturnMain);
        Controller.returnMainMenu(buttonReturnMain, getFrame());

        textArea_aboutClient = new JTextArea();
        textArea_aboutClient.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        textArea_aboutClient.setBounds(612, 369, 548, 234);
        panel.add(textArea_aboutClient);

        label_aboutClient = new JLabel("Дополнительно:");
        label_aboutClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_aboutClient.setBounds(610, 329, 122, 41);
        panel.add(label_aboutClient);

        field_photo = new JTextField();
        field_photo.setBounds(917, 55, 243, 250);
        panel.add(field_photo);
        field_photo.setColumns(10);

        label_getPublic = new JLabel("Получать рекламу:");
        label_getPublic.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_getPublic.setBounds(612, 128, 133, 32);
        panel.add(label_getPublic);

        label_whyKnow = new JLabel("Откуда узнал:");
        label_whyKnow.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_whyKnow.setBounds(612, 237, 133, 20);
        panel.add(label_whyKnow);

        comboBox_getPublic = new JComboBox(combo_items2);
        comboBox_getPublic.setBounds(612, 156, 287, 45);
        panel.add(comboBox_getPublic);

        comboBox_whyKnow = new JComboBox(combo_items);
        comboBox_whyKnow.setBounds(612, 260, 287, 45);
        panel.add(comboBox_whyKnow);

        button_addPhoto = new JButton("Добавить фото");
        button_addPhoto.setBounds(969, 316, 145, 32);
        panel.add(button_addPhoto);

        comboBox_pol = new JComboBox(sexPerson);
        comboBox_pol.setBounds(612, 55, 287, 45);
        panel.add(comboBox_pol);

        JLabel label = new JLabel("Пол:");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setBounds(612, 30, 74, 26);
        panel.add(label);

    }

    void getDate() {
        panelDate = new JPanel();
        panelDate.setBounds(0, 145, 250, 73);
        panel.add(panelDate);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        // datePicker.setBorder(BorderFactory.createLineBorder(Color.gray,0 ));
        panelDate.add(datePicker);
    }

    @Override
    public void showView() {
        frame.setVisible(true);

    }

    @Override
    public JFrame getFrame() {
        return frame;
    }

    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "yyyy-MM-dd";
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
}
