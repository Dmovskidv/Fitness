package view;

import Interface.ViewInterface;
import controller.Controller;
import model.DB;
import model.Model;
import javax.swing.*;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class AddSale implements ViewInterface {

    private JDialog dialog;
    private JPanel panel;
    private static JTextField textFieldNumCard;
    private static JLabel labelSum;
    private static JComboBox comboBoxServices;
    private static JComboBox comboBoxTypeVisit;
    private static JComboBox comboBoxTypeClient;
    private JLabel labelTitle;
    private JLabel labelService;
    private JLabel labelTypeVisit;
    private JLabel labelTypeClient;
    private JLabel labelNumCard;
    private static JLabel labelPay;
    private static JLabel labelStatusPay;
    private static JLabel labelStatus;
    private JButton buttonCancel, buttonPay;
    private String[] itemServices = Model.getDateForAddSale("services");
    private String[] itemTypeVisit = Model.getDateForAddSale("visit");
    private String[] itemTypeClient = Model.getDateForAddSale("client");


    //constructor
    public AddSale() {
        dialog = new JDialog();
        dialog.setSize(600, 570);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.getContentPane().setLayout(null);
        panel = new JPanel();
        panel.setBounds(0, 0, 584, 532);
        dialog.getContentPane().add(panel);
        panel.setLayout(null);
        dialog.setModal(true);
        setInterface();
    }

    //set Interfase
    private void setInterface() {
        labelTitle = new JLabel("Оплата");
        labelTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        labelTitle.setBounds(242, 33, 100, 25);
        panel.add(labelTitle);

        comboBoxServices = new JComboBox(itemServices);
        comboBoxServices.setBounds(143, 100, 416, 40);
        panel.add(comboBoxServices);
        Controller.showSumBeforePay(comboBoxServices);


        comboBoxTypeVisit = new JComboBox(itemTypeVisit);
        comboBoxTypeVisit.setBounds(143, 154, 416, 40);
        panel.add(comboBoxTypeVisit);
        Controller.showSumBeforePay(comboBoxTypeVisit);

        comboBoxTypeClient = new JComboBox(itemTypeClient);
        comboBoxTypeClient.setBounds(143, 205, 416, 40);
        panel.add(comboBoxTypeClient);
        //Controller.showSumBeforePay(comboBoxTypeClient);

        buttonCancel = new JButton("Закрыть");
        buttonCancel.setBounds(435, 463, 124, 40);
        panel.add(buttonCancel);
        Controller.closeAddSale(buttonCancel, getDialog());

        buttonPay = new JButton("Оплатить");
        buttonPay.setBounds(301, 463, 124, 40);
        panel.add(buttonPay);
        DB.addPayDB(buttonPay);

        labelService = new JLabel("Услуга");
        labelService.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelService.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelService.setBounds(25, 100, 108, 40);
        panel.add(labelService);


        labelTypeVisit = new JLabel("Тип посещения");
        labelTypeVisit.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelTypeVisit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelTypeVisit.setBounds(25, 154, 108, 40);
        panel.add(labelTypeVisit);

        labelTypeClient = new JLabel("Тип клиента");
        labelTypeClient.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelTypeClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelTypeClient.setBounds(25, 205, 108, 40);
        panel.add(labelTypeClient);

        textFieldNumCard = new JTextField();
        textFieldNumCard.setBounds(143, 256, 116, 40);
        panel.add(textFieldNumCard);
        textFieldNumCard.setColumns(10);

        Controller.clickComboBoxClientClub(textFieldNumCard);

        labelNumCard = new JLabel("№ карты");
        labelNumCard.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelNumCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelNumCard.setBounds(25, 256, 108, 40);
        panel.add(labelNumCard);

        labelPay = new JLabel("Сумма к оплате:");
        labelPay.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelPay.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelPay.setBounds(25, 357, 149, 25);
        panel.add(labelPay);

        labelStatusPay = new JLabel("Статус оплаты:");
        labelStatusPay.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelStatusPay.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelStatusPay.setBounds(25, 393, 149, 25);
        panel.add(labelStatusPay);

        labelSum = new JLabel("0");
        labelSum.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelSum.setBounds(198, 354, 85, 31);
        panel.add(labelSum);

        labelStatus = new JLabel("не оплачено");
        labelStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelStatus.setBounds(198, 389, 120, 32);
        panel.add(labelStatus);

    }

    //show View
    @Override
    public void showView() {
        dialog.setVisible(true);
    }

    //getters
    public JDialog getDialog() {
        return dialog;
    }

    public static JTextField getTextFieldNumCard() {
        return textFieldNumCard;
    }

    public static JComboBox getComboBoxTypeVisit() {
        return comboBoxTypeVisit;
    }

    public static  JComboBox getComboBoxTypeClient() {
        return comboBoxTypeClient;
    }

    public static  JComboBox getComboBoxServices() {
        return comboBoxServices;
    }

    public static  JLabel getLabelSum() {
        return labelSum;
    }

    public static  JLabel getLabelStatus() {
        return labelStatus;
    }


}
