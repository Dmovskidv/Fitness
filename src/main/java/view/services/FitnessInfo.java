package view.services;

import Interface.ViewInterface;
import controller.Controller;
import model.DB;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class FitnessInfo implements ViewInterface {

    private JPanel mainPanel, panelDop;
    private JLabel labelPhoto, labelTitleUsluga, labelRaz, labelTitleCena, labelAbonent1m, labelAbonent3m,labelAbonent6m,labelAbonentYear,labelCenaRaz,labelCenaAbonent1m,
            labelCenaAbonent3m, labelCenaAbonent6m, labelCenaAbonent1y, labelDopPanelTitle,labelInfoAerobic1, labelInfoAerobic2, labelInfoAerobic3, labelInfoAerobic4,labelInfoAerobic5, labelInfoAerobic6;
    private JButton buttonReturnMain;
    private final JFrame frame;

    final String IMAGE_PATH = "src\\main\\resources\\images\\fitness.jpg";
    final String IMAGE_PATH_RETURN = "src\\main\\resources\\images\\return.jpg";

    public FitnessInfo() {
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
        labelPhoto.setIcon(new ImageIcon(IMAGE_PATH));
        labelPhoto.setBorder(new LineBorder(Color.LIGHT_GRAY));
        labelPhoto.setBounds(780, 57, 750, 750);
        mainPanel.add(labelPhoto);

        labelTitleUsluga = new JLabel("Аэробика");
        labelTitleUsluga.setFont(new Font("Tahoma", Font.BOLD, 28));
        labelTitleUsluga.setBounds(300, 57, 250, 35);
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

        labelCenaRaz = new JLabel(DB.selectCostDB("aerobic", "1 раз")+"$");
        formatCena(labelCenaRaz);
        labelCenaRaz.setBounds(420, 139, 59, 35);
        mainPanel.add(labelCenaRaz);

        labelCenaAbonent1m = new JLabel(DB.selectCostDB("aerobic", "1 мес")+"$");
        formatCena(labelCenaAbonent1m);
        labelCenaAbonent1m.setBounds(420, 185, 59, 35);
        mainPanel.add(labelCenaAbonent1m);

        labelCenaAbonent3m = new JLabel(DB.selectCostDB("aerobic", "3 мес")+"$");
        formatCena(labelCenaAbonent3m);
        labelCenaAbonent3m.setBounds(420, 231, 59, 35);
        mainPanel.add(labelCenaAbonent3m);

        labelCenaAbonent6m = new JLabel(DB.selectCostDB("aerobic", "6 мес")+"$");
        formatCena(labelCenaAbonent6m);
        labelCenaAbonent6m.setBounds(420, 277, 59, 35);
        mainPanel.add(labelCenaAbonent6m);

        labelCenaAbonent1y = new JLabel(DB.selectCostDB("aerobic", "1 год")+"$");
        formatCena(labelCenaAbonent1y);
        labelCenaAbonent1y.setBounds(420, 323, 59, 35);
        mainPanel.add(labelCenaAbonent1y);

        panelDop = new JPanel();
        panelDop.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        panelDop.setBounds(10, 370, 700, 210);
        mainPanel.add(panelDop);
        panelDop.setLayout(null);

        labelDopPanelTitle = new JLabel(" Дополнительная информация:");
        labelDopPanelTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelDopPanelTitle.setBounds(0, 11, 650, 25);
        panelDop.add(labelDopPanelTitle);

        labelInfoAerobic1 = new JLabel("- одна из самых популярных разновидностей фитнеса");
        formatText(labelInfoAerobic1);
        labelInfoAerobic1.setBounds(10, 42, 650, 25);
        panelDop.add(labelInfoAerobic1);

        labelInfoAerobic2 = new JLabel("- упражнения проводятся под музыку");
        formatText(labelInfoAerobic2);
        labelInfoAerobic2.setBounds(10, 72, 650, 25);
        panelDop.add(labelInfoAerobic2);

        labelInfoAerobic3 = new JLabel("- основное преимущество упражнений аэробики – это не только");
        formatText(labelInfoAerobic3);
        labelInfoAerobic3.setBounds(10, 102, 650, 25);
        panelDop.add(labelInfoAerobic3);

        labelInfoAerobic4 = new JLabel("похудение, но и укрепление дыхательной и сердечно-сосудистой ");
        formatText(labelInfoAerobic4);
        labelInfoAerobic4.setBounds(20, 124, 650, 25);
        panelDop.add(labelInfoAerobic4);

        labelInfoAerobic5 = new JLabel("системы");
        formatText(labelInfoAerobic5);
        labelInfoAerobic5.setBounds(20, 146, 650, 25);
        panelDop.add(labelInfoAerobic5);

        labelInfoAerobic6 = new JLabel("- занятия проводятся в группах");
        labelInfoAerobic6.setBounds(10, 172, 600, 25);
        formatText(labelInfoAerobic6);
        panelDop.add(labelInfoAerobic6);

        buttonReturnMain = new JButton("");
        buttonReturnMain.setBorder(null);
        buttonReturnMain.setIcon(new ImageIcon(IMAGE_PATH_RETURN));
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
