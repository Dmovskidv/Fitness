package view;

import Interface.ViewInterface;
import controller.Controller;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class AboutApp implements ViewInterface{



    JDialog dialog;
        JPanel mainPanel, infoPanel;
        JButton close;
        JLabel titleFitness, licenzia, contacs, maker, admin, title;


    public AboutApp() {
        dialog = new JDialog();
        dialog.setSize(600, 570);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.getContentPane().setLayout(null);
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 584, 532);
        dialog.getContentPane().add(mainPanel);
        mainPanel.setLayout(null);
        setInterface();
    }

    private void setInterface() {
        JLabel labelWindow = new JLabel("");
        labelWindow.setIcon(new ImageIcon("src\\main\\resources\\images\\AboutApp.jpg"));
        labelWindow.setBackground(Color.BLACK);
        labelWindow.setBounds(10, 11, 220, 220);
        mainPanel.add(labelWindow);

         titleFitness = new JLabel("Фитнес-центр");
        titleFitness.setForeground(Color.BLACK);
        titleFitness.setFont(new Font("Tahoma", Font.BOLD, 45));
        titleFitness.setBounds(238, 85, 336, 74);
        mainPanel.add(titleFitness);

         infoPanel = new JPanel();
        infoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        infoPanel.setBounds(10, 235, 564, 286);
        mainPanel.add(infoPanel);
        infoPanel.setLayout(null);

         licenzia = new JLabel("Лицензия: демо версия");
        licenzia.setFont(new Font("Tahoma", Font.BOLD, 12));
        licenzia.setBounds(10, 101, 301, 20);
        infoPanel.add(licenzia);

         contacs = new JLabel("Контакты: моб. телефон +375 (44) 796-20-65, email dmovskidv@gmail.com ");
        contacs.setFont(new Font("Tahoma", Font.BOLD, 12));
        contacs.setBounds(10, 163, 496, 20);
        infoPanel.add(contacs);

        close = new JButton("Закрыть");
        close.setBounds(432, 241, 122, 34);
        infoPanel.add(close);
        Controller.clickCloseAboutApp(close, getDialog() );

         maker = new JLabel("Разработчик: Дмовский Дмитрий Витальевич");
        maker.setFont(new Font("Tahoma", Font.BOLD, 12));
        maker.setBounds(10, 76, 301, 14);
        infoPanel.add(maker);

         admin = new JLabel("Пользователь: администратор фитнес-центра");
        admin.setFont(new Font("Tahoma", Font.BOLD, 12));
        admin.setBounds(10, 132, 408, 20);
        infoPanel.add(admin);

         title = new JLabel("Автоматизация работы фитнес-центра 2018 год");
        title.setFont(new Font("Verdana", Font.BOLD, 14));
        title.setBounds(88, 11, 408, 26);
        infoPanel.add(title);
        dialog.setModal(true);
           }

    public JDialog getDialog() {
        return dialog;
    }

    @Override
    public void showView() {
        dialog.setVisible(true);
    }
}
