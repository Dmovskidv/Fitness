package view.services;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GimInfo {

    private JFrame frame;
    private JPanel mainPanel, panelDop;
    private JLabel labelPhoto, labelTitleUsluga, labelRaz, labelTitleCena, labelAbonent1m, labelAbonent3m,
            labelAbonent6m, labelAbonentYear, labelCenaRaz, labelCenaAbonent1m, labelCenaAbonent3m, labelCenaAbonent6m,
            labelCenaAbonent1y, labelDopPanelTitle, labelInfoPool1, labelInfoPool2, labelInfoPool3, labelInfoPool4,
            labelInfoPool5, labelInfoPool6;
    private JButton buttonReturnMain;

    public GimInfo() {
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
        frame.setVisible(true);
    }

    public void setInterface() {
        labelPhoto = new JLabel("");
        labelPhoto.setIcon(new ImageIcon("src\\main\\resources\\images\\gim.jpg"));
        labelPhoto.setBorder(new LineBorder(Color.LIGHT_GRAY));
        labelPhoto.setBounds(557, 57, 600, 600);
        mainPanel.add(labelPhoto);

        labelTitleUsluga = new JLabel("Тренажёрный зал");
        labelTitleUsluga.setFont(new Font("Verdana", Font.BOLD, 24));
        labelTitleUsluga.setBounds(123, 57, 292, 35);
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

        labelCenaRaz = new JLabel(" 2$");
        labelCenaRaz.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaRaz.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaRaz.setBounds(218, 139, 59, 35);
        mainPanel.add(labelCenaRaz);

        labelCenaAbonent1m = new JLabel(" 15$");
        labelCenaAbonent1m.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaAbonent1m.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaAbonent1m.setBounds(218, 185, 59, 35);
        mainPanel.add(labelCenaAbonent1m);

        labelCenaAbonent3m = new JLabel(" 25$");
        labelCenaAbonent3m.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaAbonent3m.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaAbonent3m.setBounds(218, 231, 59, 35);
        mainPanel.add(labelCenaAbonent3m);

        labelCenaAbonent6m = new JLabel(" 40$");
        labelCenaAbonent6m.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaAbonent6m.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaAbonent6m.setBounds(218, 277, 59, 35);
        mainPanel.add(labelCenaAbonent6m);

        labelCenaAbonent1y = new JLabel(" 70$");
        labelCenaAbonent1y.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaAbonent1y.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaAbonent1y.setBounds(218, 323, 59, 35);
        mainPanel.add(labelCenaAbonent1y);

        panelDop = new JPanel();
        panelDop.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        panelDop.setBounds(10, 370, 524, 252);
        mainPanel.add(panelDop);
        panelDop.setLayout(null);

        labelDopPanelTitle = new JLabel(" Дополнительная информация:");
        labelDopPanelTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelDopPanelTitle.setBounds(0, 11, 270, 20);
        panelDop.add(labelDopPanelTitle);

        labelInfoPool1 = new JLabel("- современный спортивный зал с тренажерами (более 30) для");
        labelInfoPool1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoPool1.setBounds(10, 42, 490, 20);
        panelDop.add(labelInfoPool1);

        labelInfoPool2 = new JLabel("различных групп мышц");
        labelInfoPool2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoPool2.setBounds(20, 63, 517, 20);
        panelDop.add(labelInfoPool2);

        labelInfoPool3 = new JLabel("- различные спортивные снаряды, которые рассчитаны на");
        labelInfoPool3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoPool3.setBounds(10, 94, 490, 20);
        panelDop.add(labelInfoPool3);

        labelInfoPool4 = new JLabel("посетителей разного уровня физической подготовки");
        labelInfoPool4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoPool4.setBounds(20, 113, 480, 20);
        panelDop.add(labelInfoPool4);

        labelInfoPool5 = new JLabel("- широкий гантельный ряд");
        labelInfoPool5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoPool5.setBounds(10, 141, 517, 20);
        panelDop.add(labelInfoPool5);

        labelInfoPool6 = new JLabel("- в тренажерном зале постоянно находятся отзывчивые тренеры");
        labelInfoPool6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoPool6.setBounds(10, 169, 480, 20);
        panelDop.add(labelInfoPool6);

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
}
