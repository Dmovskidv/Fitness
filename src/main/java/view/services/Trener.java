package view.services;

import Interface.ViewInterface;
import controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Trener implements ViewInterface {

    private JFrame frame;


    public Trener() {
        frame = new JFrame();
        frame.setSize(600, 570);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        setInterface();



    }

    private void setInterface() {
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\images\\scala.jpg"));
        lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        lblNewLabel.setBounds(262, 11, 312, 335);
        frame.getContentPane().add(lblNewLabel);

        JLabel fio = new JLabel("Дуэйн «Скала»");
        fio.setFont(new Font("Tahoma", Font.BOLD, 22));
        fio.setBounds(36, 83, 197, 41);
        frame.getContentPane().add(fio);

        JLabel titleInstructor = new JLabel("Инструктор");
        titleInstructor.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleInstructor.setBounds(74, 11, 110, 29);
        frame.getContentPane().add(titleInstructor);

        JLabel fitnescentr = new JLabel("фитнес-центра");
        fitnescentr.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fitnescentr.setBounds(59, 43, 148, 29);
        frame.getContentPane().add(fitnescentr);


        JButton buttonexit = new JButton("Закрыть");
        buttonexit.setBounds(464, 492, 110, 29);
        frame.getContentPane().add(buttonexit);
        Controller.returnMainMenu(buttonexit, frame);

        JLabel fitnesspec = new JLabel("Фитнеc-спецификация:");
        fitnesspec.setFont(new Font("Tahoma", Font.BOLD, 16));
        fitnesspec.setBounds(10, 148, 242, 29);
        frame.getContentPane().add(fitnesspec);

        JLabel desc1 = new JLabel("- силовые тренировки");
        desc1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        desc1.setBounds(10, 184, 223, 29);
        frame.getContentPane().add(desc1);

        JLabel desc2 = new JLabel("- коррекция фигуры");
        desc2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        desc2.setBounds(10, 224, 223, 19);
        frame.getContentPane().add(desc2);

        JLabel desc3 = new JLabel("- снижение веса");
        desc3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        desc3.setBounds(10, 254, 223, 19);
        frame.getContentPane().add(desc3);

        JLabel desc4 = new JLabel("- составление индивидуальных");
        desc4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        desc4.setBounds(10, 284, 249, 19);
        frame.getContentPane().add(desc4);

        JLabel desc5 = new JLabel("тренировочных программ");
        desc5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        desc5.setBounds(20, 301, 197, 19);
        frame.getContentPane().add(desc5);

        JLabel desc6 = new JLabel("- консультации по ");
        desc6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        desc6.setBounds(10, 331, 249, 14);
        frame.getContentPane().add(desc6);

        JLabel desc7 = new JLabel("спортивному питанию");
        desc7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        desc7.setBounds(20, 347, 232, 19);
        frame.getContentPane().add(desc7);

        JLabel desc8 = new JLabel("Контакты:");
        desc8.setFont(new Font("Tahoma", Font.BOLD, 16));
        desc8.setBounds(262, 369, 110, 14);
        frame.getContentPane().add(desc8);

        JLabel desc9 = new JLabel("011-7-495-123-45-67");
        desc9.setFont(new Font("Tahoma", Font.PLAIN, 16));
        desc9.setBounds(262, 404, 213, 14);
        frame.getContentPane().add(desc9);

        JLabel desc10 = new JLabel("skala_johnson@gmail.com");
        desc10.setFont(new Font("Tahoma", Font.PLAIN, 16));
        desc10.setBounds(262, 419, 213, 27);
        frame.getContentPane().add(desc10);

    }

    @Override
    public void showView() {
        frame.setVisible(true);
    }
}
