package view.services;

import Interface.ViewInterface;
import controller.Controller;
import model.DB;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GimInfo implements ViewInterface {

    private JFrame frame;
    private JPanel mainPanel, panelDop;
    private JLabel labelPhoto, labelTitleUsluga, labelRaz, labelTitleCena, labelAbonent1m, labelAbonent3m,
            labelAbonent6m, labelAbonentYear, labelCenaRaz, labelCenaAbonent1m, labelCenaAbonent3m, labelCenaAbonent6m,
            labelCenaAbonent1y, labelDopPanelTitle, labelInfoPool1, labelInfoPool2, labelInfoPool3, labelInfoPool4,
            labelInfoPool5, labelInfoPool6;
    private JButton buttonReturnMain;

    final String IMAGEPATH = "src\\main\\resources\\images\\gim.jpg";
    final String IMAGEPATHRETURN = "src\\main\\resources\\images\\return.jpg";

    public GimInfo() {
        frame = new JFrame();
        frame.setTitle("Услуга");
        frame.setSize(1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 1600, 900);
        frame.getContentPane().add(mainPanel);
        mainPanel.setLayout(null);
        setInterface();

    }

    public void setInterface() {
        labelPhoto = new JLabel("");
        labelPhoto.setIcon(new ImageIcon(IMAGEPATH));
        labelPhoto.setBorder(new LineBorder(Color.LIGHT_GRAY));
        labelPhoto.setBounds(780, 57, 750, 750);
        mainPanel.add(labelPhoto);

        labelTitleUsluga = new JLabel("Тренажёрный зал");
        labelTitleUsluga.setFont(new Font("Tahoma", Font.BOLD, 28));
        labelTitleUsluga.setBounds(300, 57, 350, 35);
        mainPanel.add(labelTitleUsluga);

        labelRaz = new JLabel(" Разовое посещение:");
        formatTextCena(labelRaz);
        labelRaz.setBounds(10, 140, 400, 35);
        mainPanel.add(labelRaz);

        labelTitleCena = new JLabel("Цены:");
        labelTitleCena.setFont(new Font("Tahoma", Font.BOLD, 24));
        labelTitleCena.setBounds(10, 100, 90, 35);
        mainPanel.add(labelTitleCena);

        labelAbonent1m = new JLabel(" Абонемент 1 месяц:");
        formatTextCena(labelAbonent1m);
        labelAbonent1m.setBounds(10, 186, 400, 35);
        mainPanel.add(labelAbonent1m);

        labelAbonent3m = new JLabel(" Абонемент 3 месяца:");
        formatTextCena(labelAbonent3m);
        labelAbonent3m.setBounds(10, 232, 400, 35);
        mainPanel.add(labelAbonent3m);

        labelAbonent6m = new JLabel(" Абонемент 6 месяцев:");
        formatTextCena(labelAbonent6m);
        labelAbonent6m.setBounds(10, 278, 400, 35);
        mainPanel.add(labelAbonent6m);

        labelAbonentYear = new JLabel(" Абонемент 1 год:");
        formatTextCena(labelAbonentYear);
        labelAbonentYear.setBounds(10, 324, 400, 35);
        mainPanel.add(labelAbonentYear);

        labelCenaRaz = new JLabel(DB.selectCostDB("gim", "1 раз")+"$");
        formatCena(labelCenaRaz);
        labelCenaRaz.setBounds(420, 139, 59, 35);
        mainPanel.add(labelCenaRaz);

        labelCenaAbonent1m = new JLabel(DB.selectCostDB("gim", "1 мес")+"$");
        formatCena(labelCenaAbonent1m);
        labelCenaAbonent1m.setBounds(420, 185, 59, 35);
        mainPanel.add(labelCenaAbonent1m);

        labelCenaAbonent3m = new JLabel(DB.selectCostDB("gim", "3 мес")+"$");
        formatCena(labelCenaAbonent3m);
        labelCenaAbonent3m.setBounds(420, 231, 59, 35);
        mainPanel.add(labelCenaAbonent3m);

        labelCenaAbonent6m = new JLabel(DB.selectCostDB("gim", "6 мес")+"$");
        formatCena(labelCenaAbonent6m);
        labelCenaAbonent6m.setBounds(420, 277, 59, 35);
        mainPanel.add(labelCenaAbonent6m);

        labelCenaAbonent1y = new JLabel(DB.selectCostDB("gim", "1 год")+"$");
        formatCena(labelCenaAbonent1y);
        labelCenaAbonent1y.setBounds(420, 323, 59, 35);
        mainPanel.add(labelCenaAbonent1y);

        panelDop = new JPanel();
        panelDop.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        panelDop.setBounds(10, 370, 700, 210);
        mainPanel.add(panelDop);
        panelDop.setLayout(null);

        labelDopPanelTitle = new JLabel(" Дополнительная информация:");
        formatText(labelDopPanelTitle);
        labelDopPanelTitle.setBounds(0, 11, 650, 25);
        panelDop.add(labelDopPanelTitle);

        labelInfoPool1 = new JLabel("- современный спортивный зал с тренажерами (более 30) для");
        formatText(labelInfoPool1);
        labelInfoPool1.setBounds(10, 42, 650, 25);
        panelDop.add(labelInfoPool1);

        labelInfoPool2 = new JLabel("различных групп мышц");
        formatText(labelInfoPool2);
        labelInfoPool2.setBounds(20, 64, 650, 25);
        panelDop.add(labelInfoPool2);

        labelInfoPool3 = new JLabel("- различные спортивные снаряды, которые рассчитаны на");
        formatText(labelInfoPool3);
        labelInfoPool3.setBounds(10, 94, 650, 25);
        panelDop.add(labelInfoPool3);

        labelInfoPool4 = new JLabel("посетителей разного уровня физической подготовки");
        formatText(labelInfoPool4);
        labelInfoPool4.setBounds(20, 116, 650, 25);
        panelDop.add(labelInfoPool4);

        labelInfoPool5 = new JLabel("- широкий гантельный ряд");
        formatText(labelInfoPool5);
        labelInfoPool5.setBounds(10, 146, 650, 25);
        panelDop.add(labelInfoPool5);

        labelInfoPool6 = new JLabel("- в тренажерном зале постоянно находятся квалифицированные тренера");
        formatText(labelInfoPool6);
        labelInfoPool6.setBounds(10, 176, 720, 25);
        panelDop.add(labelInfoPool6);

        buttonReturnMain = new JButton("");
        buttonReturnMain.setBorder(null);
        buttonReturnMain.setIcon(new ImageIcon(IMAGEPATHRETURN));
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

    public void  formatText(JLabel label){
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
    }

    public void  formatCena(JLabel label){
        label.setFont(new Font("Tahoma", Font.BOLD, 26));
        label.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
    }

    public void  formatTextCena(JLabel label){
        label.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        label.setFont(new Font("Tahoma", Font.PLAIN, 26));
    }
}
