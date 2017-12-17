package view;

import Interface.ViewInterface;
import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ViewInterface {

    private static JMenuBar menuBar;
    private static JMenu sales, services, clients, staff, reports, lock, help, addSale, groupLessons, admin;
    private static JMenuItem addClient, findClient, gim, pool, timeTable, addStaff, findStaff, reportDay, reportMonth,
            lockOn, changeUser, exitApp, helpInfo;
    private static JMenuItem adminItem;
    private static JFrame frame;
    private static JPanel panel;
    private JButton buttonAddClient,buttonAddSale,buttonServices, buttonLock;
    private static JLayeredPane panelButtons;


    public Main() {
        frame = new JFrame();
        frame.setTitle("Фитнеc-центр");
        frame.setSize(1200, 750);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1180, 690);
        frame.getContentPane().add(panel);
        setMenuBar();
        setButtons();
        setImage();
        frame.setVisible(true);
        //MyDialog.control_password();



    }

    private void setImage() {
        JLabel images = new JLabel();
        images.setIcon(new ImageIcon("src\\main\\resources\\images\\mainBackground11.jpg"));
        images.setBounds(0, 0, 1180, 690);
        panel.add(images);
    }

    public void setButtons() {

        panelButtons = new JLayeredPane();
        panelButtons.setBounds(10, 11, 1144, 646);
        panel.add(panelButtons);

        buttonAddSale = new JButton("Добавить продажу");
        buttonAddSale.setBounds(372, 196, 400, 70);
        panelButtons.add(buttonAddSale);

        buttonAddClient = new JButton("Добавить нового клиента");
        buttonAddClient.setBounds(372, 277, 400, 70);
        panelButtons.add(buttonAddClient);
        Controller.openAddClient(buttonAddClient);

        buttonServices = new JButton("Учёт посещений клиентов");
        buttonServices.setBounds(372, 358, 400, 70);
        panelButtons.add(buttonServices);
        Controller.openFindClient(buttonServices);

        buttonLock = new JButton("Блокировка");
        buttonLock.setBounds(1050, 24, 100, 100);
        buttonLock.setBorder(null);
        panelButtons.add(buttonLock);
        buttonLock.setIcon(new ImageIcon("src\\main\\resources\\images\\lock3.jpg"));
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

    public static JFrame  getFrame() {
        return frame;
    }



    public static JMenuItem setadminItem() {
        return adminItem;
    }


    @Override
    public void showView() {
        return;
    }


}
