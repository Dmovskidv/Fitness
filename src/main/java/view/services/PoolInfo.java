package view.services;

import Interface.ViewInterface;
import controller.Controller;
import model.DB;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class PoolInfo implements ViewInterface {



    private JFrame frame;
    private JPanel mainPanel, panelDop;
    private JLabel labelPhoto, labelTitleUsluga, labelRaz, labelTitleCena, labelAbonent1m, labelAbonent3m,
            labelAbonent6m, labelAbonentYear, labelCenaRaz, labelCenaAbonent1m, labelCenaAbonent3m, labelCenaAbonent6m,
            labelCenaAbonent1y, labelDopPanelTitle, labelInfoPool1, labelInfoPool2, labelInfoPool3, labelInfoPool4,
            labelInfoPool5;
    private JButton buttonReturnMain;

    public PoolInfo() {
        frame = new JFrame();
        frame.setTitle("Услуга");
        frame.setSize(1200, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 1184, 712);
        frame.getContentPane().add(mainPanel);
        mainPanel.setLayout(null);
        setInterface();

    }

    public void setInterface() {
        labelPhoto = new JLabel("");
        labelPhoto.setIcon(new ImageIcon("src\\main\\resources\\images\\pool.jpg"));
        labelPhoto.setBorder(new LineBorder(Color.LIGHT_GRAY));
        labelPhoto.setBounds(557, 57, 600, 600);
        mainPanel.add(labelPhoto);

        labelTitleUsluga = new JLabel("Бассеин");
        labelTitleUsluga.setFont(new Font("Verdana", Font.BOLD, 24));
        labelTitleUsluga.setBounds(218, 57, 134, 35);
        mainPanel.add(labelTitleUsluga);

        labelRaz = new JLabel(" Разовое посещение:");
        labelRaz.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelRaz.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelRaz.setBounds(10, 140, 198, 35);
        mainPanel.add(labelRaz);

        labelTitleCena = new JLabel("Цены:");
        labelTitleCena.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelTitleCena.setBounds(10, 109, 77, 20);
        mainPanel.add(labelTitleCena);

        labelAbonent1m = new JLabel(" Абонемент 1 месяц:");
        labelAbonent1m.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelAbonent1m.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelAbonent1m.setBounds(10, 186, 198, 35);
        mainPanel.add(labelAbonent1m);

        labelAbonent3m = new JLabel(" Абонемент 3 месяца:");
        labelAbonent3m.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelAbonent3m.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelAbonent3m.setBounds(10, 232, 198, 35);
        mainPanel.add(labelAbonent3m);

        labelAbonent6m = new JLabel(" Абонемент 6 месяцев:");
        labelAbonent6m.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelAbonent6m.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelAbonent6m.setBounds(10, 278, 198, 35);
        mainPanel.add(labelAbonent6m);

        labelAbonentYear = new JLabel(" Абонемент 1 год:");
        labelAbonentYear.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelAbonentYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelAbonentYear.setBounds(10, 324, 198, 35);
        mainPanel.add(labelAbonentYear);

        labelCenaRaz = new JLabel(DB.selectCostDB("pool", "1 раз")+"$");
        labelCenaRaz.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaRaz.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaRaz.setBounds(218, 139, 59, 35);
        mainPanel.add(labelCenaRaz);

        labelCenaAbonent1m = new JLabel(DB.selectCostDB("pool", "1 мес")+"$");
        labelCenaAbonent1m.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaAbonent1m.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaAbonent1m.setBounds(218, 185, 59, 35);
        mainPanel.add(labelCenaAbonent1m);

        labelCenaAbonent3m = new JLabel(DB.selectCostDB("pool", "3 мес")+"$");
        labelCenaAbonent3m.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaAbonent3m.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaAbonent3m.setBounds(218, 231, 59, 35);
        mainPanel.add(labelCenaAbonent3m);

        labelCenaAbonent6m = new JLabel(DB.selectCostDB("pool", "6 мес")+"$");
        labelCenaAbonent6m.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaAbonent6m.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaAbonent6m.setBounds(218, 277, 59, 35);
        mainPanel.add(labelCenaAbonent6m);

        labelCenaAbonent1y = new JLabel(DB.selectCostDB("pool", "1 год")+"$");
        labelCenaAbonent1y.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaAbonent1y.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaAbonent1y.setBounds(218, 323, 59, 35);
        mainPanel.add(labelCenaAbonent1y);

        panelDop = new JPanel();
        panelDop.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        panelDop.setBounds(10, 370, 510, 196);
        mainPanel.add(panelDop);
        panelDop.setLayout(null);

        labelDopPanelTitle = new JLabel(" Дополнительная информация:");
        labelDopPanelTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelDopPanelTitle.setBounds(0, 11, 270, 20);
        panelDop.add(labelDopPanelTitle);

        labelInfoPool1 = new JLabel("- 6 дорожек по 25 метров");
        labelInfoPool1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoPool1.setBounds(10, 42, 174, 20);
        panelDop.add(labelInfoPool1);

        labelInfoPool2 = new JLabel("- ширина 18 метров");
        labelInfoPool2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoPool2.setBounds(10, 73, 174, 20);
        panelDop.add(labelInfoPool2);

        labelInfoPool3 = new JLabel("- глубокая часть – 200см");
        labelInfoPool3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoPool3.setBounds(10, 104, 174, 20);
        panelDop.add(labelInfoPool3);

        labelInfoPool4 = new JLabel("- мелкая часть – 140см");
        labelInfoPool4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoPool4.setBounds(10, 135, 174, 20);
        panelDop.add(labelInfoPool4);

        labelInfoPool5 = new JLabel("- температура воды от +27° до +28°С");
        labelInfoPool5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoPool5.setBounds(10, 166, 300, 20);
        panelDop.add(labelInfoPool5);

        buttonReturnMain = new JButton("");
        buttonReturnMain.setBorder(null);
        buttonReturnMain.setIcon(new ImageIcon("src\\main\\resources\\images\\return.jpg"));
        buttonReturnMain.setBounds(10, 10, 47, 53);
        mainPanel.add(buttonReturnMain);
        Controller.returnMainMenu(buttonReturnMain, getFrame());



    }

    public JFrame getFrame() {
        return frame;
    }

    @Override
    public void showView() {
        frame.setVisible(true);
    }
}
