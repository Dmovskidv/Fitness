package view.services;

import controller.Controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class FitnessInfo {
    private JFrame frame;
    private JPanel mainPanel, panelDop;
    private JLabel labelPhoto;
    private JLabel labelTitleUsluga;
    private JLabel labelRaz;
    private JLabel labelTitleCena;
    private JLabel labelAbonent1m;
    private JLabel labelAbonent3m;
    private JLabel labelAbonent6m;
    private JLabel labelAbonentYear;
    private JLabel labelCenaRaz;
    private JLabel labelCenaAbonent1m;
    private JLabel labelCenaAbonent3m;
    private JLabel labelCenaAbonent6m;
    private JLabel labelCenaAbonent1y;
    private JLabel labelDopPanelTitle;
    private JLabel labelInfoAerobic1;
    private JLabel labelInfoAerobic2;
    private JLabel labelInfoAerobic3;
    private JLabel labelInfoAerobic4;
    private JLabel labelInfoAerobic5;



    private JLabel labelInfoAerobic6;
    private JButton buttonReturnMain;

    public FitnessInfo() {
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
        labelPhoto.setIcon(new ImageIcon("src\\main\\resources\\images\\fitness.jpg"));
        labelPhoto.setBorder(new LineBorder(Color.LIGHT_GRAY));
        labelPhoto.setBounds(557, 57, 600, 600);
        mainPanel.add(labelPhoto);

        labelTitleUsluga = new JLabel("Аэробика");
        labelTitleUsluga.setFont(new Font("Verdana", Font.BOLD, 24));
        labelTitleUsluga.setBounds(198, 57, 154, 35);
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

        labelCenaAbonent6m = new JLabel(" 35$");
        labelCenaAbonent6m.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaAbonent6m.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaAbonent6m.setBounds(218, 277, 59, 35);
        mainPanel.add(labelCenaAbonent6m);

        labelCenaAbonent1y = new JLabel(" 60$");
        labelCenaAbonent1y.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCenaAbonent1y.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelCenaAbonent1y.setBounds(218, 323, 59, 35);
        mainPanel.add(labelCenaAbonent1y);

        panelDop = new JPanel();
        panelDop.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        panelDop.setBounds(10, 370, 516, 196);
        mainPanel.add(panelDop);
        panelDop.setLayout(null);

        labelDopPanelTitle = new JLabel(" Дополнительная информация:");
        labelDopPanelTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelDopPanelTitle.setBounds(0, 11, 270, 20);
        panelDop.add(labelDopPanelTitle);

        labelInfoAerobic1 = new JLabel("- одна из самых популярных разновидностей фитнеса");
        labelInfoAerobic1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoAerobic1.setBounds(10, 42, 496, 20);
        panelDop.add(labelInfoAerobic1);

        labelInfoAerobic2 = new JLabel("- упражнения проводятся под музыку");
        labelInfoAerobic2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoAerobic2.setBounds(10, 72, 496, 20);
        panelDop.add(labelInfoAerobic2);

        labelInfoAerobic3 = new JLabel("- основное преимущество упражнений аэробики – это не только");
        labelInfoAerobic3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoAerobic3.setBounds(10, 102, 496, 20);
        panelDop.add(labelInfoAerobic3);

        labelInfoAerobic4 = new JLabel("похудение, но и укрепление дыхательной и сердечно-сосудистой ");
        labelInfoAerobic4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoAerobic4.setBounds(20, 122, 496, 20);
        panelDop.add(labelInfoAerobic4);

        labelInfoAerobic5 = new JLabel("системы");
        labelInfoAerobic5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoAerobic5.setBounds(20, 142, 486, 20);
        panelDop.add(labelInfoAerobic5);

        labelInfoAerobic6 = new JLabel("- занятия проводятся в группах");
        labelInfoAerobic6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelInfoAerobic6.setBounds(10, 172, 486, 20);
        panelDop.add(labelInfoAerobic6);

        buttonReturnMain = new JButton("");
        buttonReturnMain.setBorder(null);
        buttonReturnMain.setIcon(new ImageIcon("src\\main\\resources\\images\\return.jpg"));
        buttonReturnMain.setBounds(10, 633, 47, 53);
        mainPanel.add(buttonReturnMain);
        Controller.returnMainMenu(buttonReturnMain, getFrame());

    }

    public JFrame getFrame() {
        return frame;
    }
}
