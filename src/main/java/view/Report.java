package view;

import Interface.ViewInterface;
import controller.Controller;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class Report implements ViewInterface {

    private static JDialog dialog;
    private static JPanel panel;
    private static  JLabel labeltitle_countVisit, label_kassaDay,label_allKassa,labelPool ,labelAerobic, labelIoga,labelAllVisit, labelGim, countGim,
            countPool,countAerobic,countIoga,allCountVisit,sumOfDay,AllSum, label_title, label_allDate, label_admin, fioAdmin;
    private JButton exit;

    public Report(){
        dialog = new JDialog();
        dialog.setSize(600, 570);
        dialog.setTitle("Отчёт");
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setLayout(null);
        setInterface();

    }




    private void setInterface() {
        panel = new JPanel();
        dialog.add(panel);
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(10, 145, 564, 376);
           dialog.getContentPane().add(panel);
        panel.setLayout(null);

        labeltitle_countVisit = new JLabel("Количество посещений за день:");
        labeltitle_countVisit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labeltitle_countVisit.setBounds(161, 11, 246, 32);
        panel.add(labeltitle_countVisit);

        label_kassaDay = new JLabel("Касса за день:");
        label_kassaDay.setBorder(UIManager.getBorder("CheckBox.border"));
        label_kassaDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_kassaDay.setBounds(10, 294, 139, 21);
        panel.add(label_kassaDay);

        label_allKassa = new JLabel("Общая касса:");
        label_allKassa.setBorder(UIManager.getBorder("CheckBox.border"));
        label_allKassa.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_allKassa.setBounds(10, 326, 139, 18);
        panel.add(label_allKassa);

        labelPool = new JLabel("Бассейн");
        labelPool.setBorder(UIManager.getBorder("CheckBox.border"));
        labelPool.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelPool.setBounds(10, 88, 139, 21);
        panel.add(labelPool);

        labelAerobic = new JLabel("Аэробика");
        labelAerobic.setBorder(UIManager.getBorder("CheckBox.border"));
        labelAerobic.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelAerobic.setBounds(10, 120, 139, 21);
        panel.add(labelAerobic);

        labelIoga = new JLabel("Йога");
        labelIoga.setBorder(UIManager.getBorder("CheckBox.border"));
        labelIoga.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelIoga.setBounds(10, 152, 139, 21);
        panel.add(labelIoga);

        labelAllVisit = new JLabel("Всего");
        labelAllVisit.setBorder(UIManager.getBorder("CheckBox.border"));
        labelAllVisit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelAllVisit.setBounds(10, 184, 139, 21);
        panel.add(labelAllVisit);

        labelGim = new JLabel("Тренажёрный зал");
        labelGim.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelGim.setBorder(UIManager.getBorder("CheckBox.border"));
        labelGim.setBounds(10, 56, 139, 21);
        panel.add(labelGim);

        countGim = new JLabel("empty");
        countGim.setFont(new Font("Tahoma", Font.BOLD, 16));
        countGim.setBounds(158, 56, 60, 21);
        panel.add(countGim);

        countPool = new JLabel("empty");
        countPool.setFont(new Font("Tahoma", Font.BOLD, 16));
        countPool.setBounds(158, 88, 60, 21);
        panel.add(countPool);

        countAerobic = new JLabel("empty");
        countAerobic.setFont(new Font("Tahoma", Font.BOLD, 16));
        countAerobic.setBounds(158, 120, 60, 21);
        panel.add(countAerobic);

        countIoga = new JLabel("empty");
        countIoga.setFont(new Font("Tahoma", Font.BOLD, 16));
        countIoga.setBounds(158, 152, 60, 21);
        panel.add(countIoga);

        allCountVisit = new JLabel("empty");
        allCountVisit.setFont(new Font("Tahoma", Font.BOLD, 16));
        allCountVisit.setBounds(158, 184, 60, 21);
        panel.add(allCountVisit);

        sumOfDay = new JLabel("empty");
        sumOfDay.setFont(new Font("Tahoma", Font.BOLD, 16));
        sumOfDay.setBounds(158, 294, 148, 21);
        panel.add(sumOfDay);

        AllSum = new JLabel("empty");
        AllSum.setFont(new Font("Tahoma", Font.BOLD, 16));
        AllSum.setBounds(158, 325, 148, 21);
        panel.add(AllSum);

        label_title = new JLabel("Отчёт");
        label_title.setBounds(254, 11, 79, 31);
        dialog.getContentPane().add(label_title);
        label_title.setFont(new Font("Tahoma", Font.BOLD, 24));

        label_allDate = new JLabel("");
        label_allDate.setBounds(165, 53, 277, 21);
           dialog.getContentPane().add(label_allDate);
        label_allDate.setFont(new Font("Tahoma", Font.PLAIN, 18));

        label_admin = new JLabel("Администратор:");
        label_admin.setBounds(10, 113, 126, 21);
           dialog.getContentPane().add(label_admin);
        label_admin.setFont(new Font("Tahoma", Font.PLAIN, 16));

        fioAdmin = new JLabel("fio admin");
        fioAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        fioAdmin.setBounds(135, 113, 228, 19);
           dialog.getContentPane().add(fioAdmin);

        exit = new JButton("Закрыть");
        exit.setBounds(405, 300, 124, 40);
        panel.add(exit);
        Controller.closeAddSale(exit, getDialog());
    }


    @Override
    public void showView() {
        dialog.setVisible(true);
    }

    public static JDialog getDialog() {
        return dialog;
    }

       public static JPanel getPanel() {
        return panel;
    }

      public static JLabel getCountGim() {
        return countGim;
    }

    public static void setCountGim(JLabel countGim) {
        countGim = countGim;
    }

    public static JLabel getCountPool() {
        return countPool;
    }

    public static void setCountPool(JLabel countPool) {
        countPool = countPool;
    }

    public static JLabel getCountAerobic() {
        return countAerobic;
    }

    public static void setCountAerobic(JLabel countAerobic) {
        countAerobic = countAerobic;
    }

    public static JLabel getCountIoga() {
        return countIoga;
    }

    public static void setCountIoga(JLabel countIoga) {
        countIoga = countIoga;
    }

    public static JLabel getAllCountVisit() {
        return allCountVisit;
    }

    public static void setAllCountVisit(JLabel allCountVisit) {
        allCountVisit = allCountVisit;
    }

    public static JLabel getSumOfDay() {
        return sumOfDay;
    }

    public static void setSumOfDay(JLabel sumOfDay) {
        sumOfDay = sumOfDay;
    }

    public static JLabel getAllSum() {
        return AllSum;
    }

    public static void setAllSum(JLabel allSum) {
        AllSum = allSum;
    }

    public static JLabel getFioAdmin() {
        return fioAdmin;
    }

    public static JLabel getLabel_allDate() {
        return label_allDate;
    }
}
