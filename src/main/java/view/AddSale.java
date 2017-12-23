package view;

import Interface.ViewInterface;
import controller.Controller;
import model.Model;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class AddSale implements ViewInterface {

    private JFrame frame;
    private static JTextField textFieldNumCard;
    private JPanel panel;
    private JComboBox comboBoxServices;



    private JComboBox comboBoxTypeVisit;
    private JComboBox comboBoxTypeClient;
    private JLabel labelTitle, labelService, labelTypeVisit, labelTypeClient, labelNumCard, labelPay, labelStatusPay, labelSum,
            labelStatus;
    private JButton buttonCancel, buttonPay;



    private String[] itemServices = Model.getDateForAddSale("services");
    private String[] itemTypeVisit = Model.getDateForAddSale("visit");
    private String[] itemTypeClient = Model.getDateForAddSale("client");



    //constructor
    public AddSale() {
        frame = new JFrame();
        frame.setSize(600, 570);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        panel = new JPanel();
        panel.setBounds(0, 0, 584, 532);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
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


        comboBoxTypeVisit = new JComboBox(itemTypeVisit);
        comboBoxTypeVisit.setBounds(143, 154, 416, 40);
        panel.add(comboBoxTypeVisit);

        comboBoxTypeClient = new JComboBox(itemTypeClient);
        comboBoxTypeClient.setBounds(143, 205, 416, 40);
        panel.add(comboBoxTypeClient);

        buttonCancel = new JButton("Отмена");
        buttonCancel.setBounds(435, 463, 124, 40);
        panel.add(buttonCancel);
        Controller.closeAddSale(buttonCancel, getFrame());

        buttonPay = new JButton("Оплатить");
        buttonPay.setBounds(301, 463, 124, 40);
        panel.add(buttonPay);

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
        textFieldNumCard.setEditable(false);
        Controller.clickComboBoxClientClub(comboBoxTypeClient);

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

        labelStatus = new JLabel("нет");
        labelStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelStatus.setBounds(198, 389, 75, 32);
        panel.add(labelStatus);

    }

    //show View
    @Override
    public void showView() {
        frame.setVisible(true);
    }

    //getters
    public JFrame getFrame() {
        return frame;
    }
    public static JTextField getTextFieldNumCard() {
        return textFieldNumCard;
    }

    public JComboBox getComboBoxTypeVisit() {
        return comboBoxTypeVisit;
    }

    public JComboBox getComboBoxTypeClient() {
        return comboBoxTypeClient;
    }


}
