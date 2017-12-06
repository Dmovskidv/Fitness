package view;

import Interface.ViewInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main implements ViewInterface{

    private static JMenuBar menuBar;
    private static JMenu sales, services, clients, staff, reports, lock, help, addSale, groupLessons, admin;
    private static JMenuItem addClient, findClient, gim, pool, timeTable, addStaff, findStaff, reportDay, reportMonth,
            lockOn, changeUser, exitApp, helpInfo;
    private static JMenuItem adminItem;
    private static JFrame frame;
    private static JPanel panel;
    // ClientModelTable model = new ClientModelTable();
    private JButton buttonAddClient, buttonAddSale, buttonServices, buttonLock;
    private JLayeredPane panelButtons;

    public Main() {

        frame = new JFrame();

        frame.setTitle("Фитнеc-центр");
        frame.setSize(1200, 750);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        try {
            panel = new JPanel() {
                private Image backgroundImage = ImageIO.read(new File("src/main/resources/images/fitness2.jpg"));

                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

        panel.setLayout(null);
        panel.setBounds(10, 11, 1164, 668);
        frame.getContentPane().add(panel);
        setMenuBar();
        frame.setVisible(true);
        MyDialog.control_password();
        setButtons();

    }

    public void setButtons() {

        panelButtons = new JLayeredPane();
        panelButtons.setBounds(10, 11, 1144, 646);
        panel.add(panelButtons);

        buttonAddSale = new JButton("Добавить продажу");
        buttonAddSale.setBounds(372, 196, 400, 70);
        panelButtons.add(buttonAddSale);

        buttonServices = new JButton("Добавить нового клиента");
        buttonServices.setBounds(372, 277, 400, 70);
        panelButtons.add(buttonServices);
        buttonAddClient = new JButton("Учёт посещений клиентов");
        buttonAddClient.setBounds(372, 358, 400, 70);
        panelButtons.add(buttonAddClient);

        buttonLock = new JButton("Блокировка");
        buttonLock.setBounds(960, 24, 153, 59);
        panelButtons.add(buttonLock);
         buttonLock.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
         MyDialog.control_password();

         }
         });


    }

    public void setMenuBar() {
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        admin = new JMenu("Администратор");
        menuBar.add(admin);

        adminItem = new JMenuItem("");
        admin.add(adminItem);

        sales = new JMenu("Продажи");
        menuBar.add(sales);

        addSale = new JMenu("Добавить продажу");
        sales.add(addSale);
        addSale.add("Абонемент");
        addSale.add("Разовое посещение");

        clients = new JMenu("Клиенты");
        menuBar.add(clients);

        addClient = new JMenuItem("Добавить клиента");
        clients.add(addClient);

        findClient = new JMenuItem("Найти клиента");
        clients.add(findClient);

        services = new JMenu("Услуги");
        menuBar.add(services);

        gim = new JMenuItem("Тренажёрный зал");
        services.add(gim);

        pool = new JMenuItem("Бассеин");
        services.add(pool);

        groupLessons = new JMenu("Групповые занятия");
        services.add(groupLessons);
        groupLessons.add("Йога");
        groupLessons.add("Пилатес");
        groupLessons.add("Стрипплаcтика");
        groupLessons.add("Аэробмикc");

        timeTable = new JMenuItem("Расписание");
        services.add(timeTable);

        staff = new JMenu("Персонал");
        menuBar.add(staff);

        addStaff = new JMenuItem("Добавить сотрудника");
        staff.add(addStaff);

        findStaff = new JMenuItem("Найти сотрудника");
        staff.add(findStaff);

        reports = new JMenu("Отчёты");
        menuBar.add(reports);

        reportDay = new JMenuItem("Отчёт за день");
        reports.add(reportDay);

        reportMonth = new JMenuItem("Отчёт за месяц");
        reports.add(reportMonth);

        lock = new JMenu("Блокировка");
        menuBar.add(lock);

        lockOn = new JMenuItem("Заблокировать");
        lock.add(lockOn);
         lockOn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
         MyDialog.control_password();

         }
         });

        changeUser = new JMenuItem("Сменить пользователь");
        lock.add(changeUser);

        exitApp = new JMenuItem("Выход из программы");
        lock.add(exitApp);

        help = new JMenu("Справка");
        menuBar.add(help);

        helpInfo = new JMenuItem("О программе");
        help.add(helpInfo);

    }

    public static JFrame getFrame() {
        return frame;
    }

    public static JMenuItem setadminItem() {
        return adminItem;
    }


    @Override
    public ViewInterface showView() {
        return this;
    }
}
