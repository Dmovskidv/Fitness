package view;

import Interface.ViewInterface;
import controller.Controller;
import model.ModelTable;

import javax.swing.*;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class FindClient implements ViewInterface {

    final String IMAGE_PATH_REDUCT = "src\\main\\resources\\images\\icon2redact.png";
    final String IMAGE_PATH_FOTO = "src\\main\\resources\\images\\fotoForAddClient.jpg";
    final String IMAGE_PATH_RETURN = "src\\main\\resources\\images\\return.jpg";

    private JFrame frame;
    private static JTable tableClients;
    private static JTextField textfieldInputClient;
    private JLabel labelNumberCard,labelFio,labelPol,labelBirthday,labelStatus,labelEmail,labelPass,labelReklama,labelWhereKnow,labelDopInfo, labelTitle;
    private static JLabel labelInfoClientCard,labelInfoClientFio,labelInfoClientBirthday,labelInfoClientStatus,labelInfoClientEmail,labelInfoClientPass,labelInfoClientGetR,
    labelInfoClientKnow,labelInfoClientMore,labelInfoClientPol,labelInfoClientMobileNumber,labelInfoClientHomeNumber,labelInfoClientWorkNumber,labelPhonesMobile,labelPhonesHome,labelPhonesWork, labelInfoClientFoto;
    private JPanel mainpanel, panelInfo, panelClient, topPanel;
    private JScrollPane scrollPaneTable;
    private JButton buttonFindClient, buttonClientEnter, buttonReturnMain, buttonClientExit;
    ModelTable modelTable = new ModelTable();

    public FindClient() {
        frame = new JFrame();
        frame.setTitle("Новый клиент");
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // frame.getContentPane().setLayout(null);
        mainpanel = new JPanel();
        frame.getContentPane().add(mainpanel);
        mainpanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
        mainpanel.setBounds(0, 0, 1600, 900);
        mainpanel.setLayout(null);
        setTableClient();
        setPanelInfo();
        setClient();

        // input FIO or ID Client
        textfieldInputClient = new JTextField();
        textfieldInputClient.setText("Введите ФИО клиента или номер карты");
        textfieldInputClient.setForeground(Color.LIGHT_GRAY);

        textfieldInputClient.setBounds(51, 72, 370, 36);
        mainpanel.add(textfieldInputClient);
        textfieldInputClient.setColumns(10);
        Controller.inputTextFindClient(textfieldInputClient);

        // Buttons control visit clients
        buttonFindClient = new JButton("Поиск");
        buttonFindClient.setBounds(430, 72, 120, 36);
        mainpanel.add(buttonFindClient);
        Controller.clickButtonFindClient(buttonFindClient);



        // -------------------------------


    }

    public void setPanelInfo() {
        panelInfo = new JPanel();
        panelInfo.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelInfo.setBounds(580, 220, 410, 482);
        mainpanel.add(panelInfo);
        panelInfo.setLayout(null);

        labelNumberCard = new JLabel(" Номер карты клиента:");
        labelNumberCard.setBounds(10, 11, 390, 30);
        panelInfo.add(labelNumberCard);
        formatText(labelNumberCard);

        labelFio = new JLabel(" Статус:");
        labelFio.setBounds(10, 47, 390, 30);
        panelInfo.add(labelFio);
        formatText(labelFio);

        labelPol = new JLabel(" Клиент:");
        labelPol.setBounds(10, 83, 390, 30);
        panelInfo.add(labelPol);
        formatText(labelPol);

        labelBirthday = new JLabel(" Пол:");
        labelBirthday.setBounds(10, 119, 390, 30);
        panelInfo.add(labelBirthday);
        formatText(labelBirthday);

        labelStatus = new JLabel(" Дата рождения:");
        labelStatus.setBounds(10, 155, 390, 30);
        panelInfo.add(labelStatus);
        formatText(labelStatus);

        labelEmail = new JLabel(" Email:");
        labelEmail.setBounds(10, 191, 390, 30);
        panelInfo.add(labelEmail);
        formatText(labelEmail);

        labelPass = new JLabel(" Паспортные данные:");
        labelPass.setBounds(10, 227, 390, 30);
        panelInfo.add(labelPass);
        formatText(labelPass);

        labelReklama = new JLabel(" Получать рекламу:");
        labelReklama.setBounds(10, 263, 390, 30);
        panelInfo.add(labelReklama);
        formatText(labelReklama);

        labelWhereKnow = new JLabel(" Откуда узнал:");
        labelWhereKnow.setBounds(10, 299, 390, 30);
        panelInfo.add(labelWhereKnow);
        formatText(labelWhereKnow);

        labelDopInfo = new JLabel(" Дополнительная информация:");
        labelDopInfo.setBounds(10, 335, 390, 30);
        panelInfo.add(labelDopInfo);
        formatText(labelDopInfo);

        labelPhonesMobile = new JLabel(" Мобильный телефон:");
        labelPhonesMobile.setBounds(10, 371, 390, 30);
        panelInfo.add(labelPhonesMobile);
        formatText(labelPhonesMobile);

        labelPhonesHome = new JLabel(" Домашний телефон:");
        labelPhonesHome.setBounds(10, 405, 390, 30);
        panelInfo.add(labelPhonesHome);
        formatText(labelPhonesHome);

        labelPhonesWork = new JLabel(" Рабочий телефон:");
        labelPhonesWork.setBounds(10, 441, 390, 30);
        panelInfo.add(labelPhonesWork);
        formatText(labelPhonesWork);
    }

    public void setClient() {
        panelClient = new JPanel();
        panelClient.setLayout(null);
        panelClient.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelClient.setBounds(1006, 220, 522, 481);
        mainpanel.add(panelClient);

        labelInfoClientCard = new JLabel("");
        labelInfoClientCard.setBounds(10, 11, 467, 30);
        panelClient.add(labelInfoClientCard);
        formatText(labelInfoClientCard);

        labelInfoClientStatus = new JLabel("");
        labelInfoClientStatus.setBounds(10, 47, 467, 30);
        panelClient.add(labelInfoClientStatus);
        formatText(labelInfoClientStatus);

        labelInfoClientFio = new JLabel("");
        labelInfoClientFio.setBounds(10, 83, 467, 30);
        panelClient.add(labelInfoClientFio);
        formatText(labelInfoClientFio);

        labelInfoClientPol = new JLabel("");
        labelInfoClientPol.setBounds(10, 119, 467, 30);
        panelClient.add(labelInfoClientPol);
        formatText(labelInfoClientPol);

        labelInfoClientBirthday = new JLabel("");
        labelInfoClientBirthday.setBounds(10, 155, 467, 30);
        panelClient.add(labelInfoClientBirthday);
        formatText(labelInfoClientBirthday);

        labelInfoClientEmail = new JLabel("");
        labelInfoClientEmail.setBounds(10, 191, 467, 30);
        panelClient.add(labelInfoClientEmail);
        formatText(labelInfoClientEmail);

        labelInfoClientPass = new JLabel("");
        labelInfoClientPass.setBounds(10, 227, 467, 30);
        panelClient.add(labelInfoClientPass);
        formatText(labelInfoClientPass);

        labelInfoClientGetR = new JLabel("");
        labelInfoClientGetR.setBounds(10, 263, 467, 30);
        panelClient.add(labelInfoClientGetR);
        formatText(labelInfoClientGetR);

        labelInfoClientKnow = new JLabel("");
        labelInfoClientKnow.setBounds(10, 299, 467, 30);
        panelClient.add(labelInfoClientKnow);
        formatText(labelInfoClientKnow);

        labelInfoClientMore = new JLabel("");
        labelInfoClientMore.setBounds(10, 335, 467, 30);
        panelClient.add(labelInfoClientMore);
        formatText(labelInfoClientMore);

        labelInfoClientMobileNumber = new JLabel("");
        labelInfoClientMobileNumber.setBounds(10, 371, 467, 30);
        panelClient.add(labelInfoClientMobileNumber);
        formatText(labelInfoClientMobileNumber);

        labelInfoClientHomeNumber = new JLabel("");
        labelInfoClientHomeNumber.setBounds(10, 405, 467, 30);
        panelClient.add(labelInfoClientHomeNumber);
        formatText(labelInfoClientHomeNumber);

        labelInfoClientWorkNumber = new JLabel("");
        labelInfoClientWorkNumber.setBounds(10, 441, 467, 30);
        panelClient.add(labelInfoClientWorkNumber);
        formatText(labelInfoClientWorkNumber);

        JButton buttonRedactFio = new JButton("");
        buttonRedactFio.setBounds(487, 83, 25, 25);
        panelClient.add(buttonRedactFio);
        buttonRedactFio.setIcon(new ImageIcon(IMAGE_PATH_REDUCT));
        Controller.clickChangeText(buttonRedactFio);

        JButton buttonRedactPol = new JButton("", new ImageIcon(IMAGE_PATH_REDUCT) );
        buttonRedactPol.setBounds(487, 119, 25, 25);
        panelClient.add(buttonRedactPol);
        Controller.clickChangeText(buttonRedactPol);

        JButton buttonRedactBirthday = new JButton("");
        buttonRedactBirthday.setBounds(487, 155, 25, 25);
        panelClient.add(buttonRedactBirthday);
        buttonRedactBirthday.setIcon(new ImageIcon(IMAGE_PATH_REDUCT));
        Controller.clickChangeText(buttonRedactBirthday);

        JButton buttonRedactEmail = new JButton("", new ImageIcon(IMAGE_PATH_REDUCT) );
        buttonRedactEmail.setBounds(487, 191, 26, 25);
        panelClient.add(buttonRedactEmail);
        Controller.clickChangeText(buttonRedactEmail);


        JButton buttonRedactPassport = new JButton("");
        buttonRedactPassport.setBounds(487, 227, 25, 25);
        panelClient.add(buttonRedactPassport);
        buttonRedactPassport.setIcon(new ImageIcon(IMAGE_PATH_REDUCT));
        Controller.clickChangeText(buttonRedactPassport);

        JButton buttonRedactGetReklama = new JButton("");
        buttonRedactGetReklama.setBounds(487, 263, 25, 25);
        panelClient.add(buttonRedactGetReklama);
        buttonRedactGetReklama.setIcon(new ImageIcon(IMAGE_PATH_REDUCT));
        Controller.clickChangeText(buttonRedactGetReklama);

        JButton buttonRedactWhereKnow = new JButton("");
        buttonRedactWhereKnow.setBounds(487, 299, 25, 25);
        panelClient.add(buttonRedactWhereKnow);
        buttonRedactWhereKnow.setIcon(new ImageIcon(IMAGE_PATH_REDUCT));
        Controller.clickChangeText(buttonRedactWhereKnow);

        JButton buttonDopInfo = new JButton("");
        buttonDopInfo.setBounds(487, 335, 25, 25);
        panelClient.add(buttonDopInfo);
        buttonDopInfo.setIcon(new ImageIcon(IMAGE_PATH_REDUCT));
        Controller.clickChangeText(buttonDopInfo);

        JButton buttonRedactMobileClient = new JButton("");
        buttonRedactMobileClient.setBounds(487, 371, 25, 25);
        panelClient.add(buttonRedactMobileClient);
        buttonRedactMobileClient.setIcon(new ImageIcon(IMAGE_PATH_REDUCT));
        Controller.clickChangeText(buttonRedactMobileClient);

        JButton buttonRedactHomeClient = new JButton("");
        buttonRedactHomeClient.setBounds(487, 407, 25, 25);
        panelClient.add(buttonRedactHomeClient);
        buttonRedactHomeClient.setIcon(new ImageIcon(IMAGE_PATH_REDUCT));
        Controller.clickChangeText(buttonRedactHomeClient);

        JButton buttonRedactWorkClient = new JButton("");
        buttonRedactWorkClient.setBounds(487, 443, 25, 25);
        panelClient.add(buttonRedactWorkClient);
        buttonRedactWorkClient.setIcon(new ImageIcon(IMAGE_PATH_REDUCT));
        Controller.clickChangeText(buttonRedactWorkClient);

        topPanel = new JPanel();
        topPanel.setBounds(550, 0, 1000, 300);
        mainpanel.add(topPanel);
        topPanel.setLayout(null);

        labelTitle = new JLabel(" Информация о клиенте");
        topPanel.add(labelTitle);
        labelTitle.setBounds(20, 64, 500, 67);
        labelTitle.setFont(new Font("Tahoma", Font.BOLD, 36));

        labelInfoClientFoto = new JLabel("");
        labelInfoClientFoto.setIcon(new ImageIcon(IMAGE_PATH_FOTO));
        labelInfoClientFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        labelInfoClientFoto.setBounds(600, 10, 200, 200);
        topPanel.add(labelInfoClientFoto);

        JButton buttonRedactFotoClient = new JButton("");
        buttonRedactFotoClient.setBounds(810, 185, 25, 25);
        topPanel.add(buttonRedactFotoClient);
        buttonRedactFotoClient.setIcon(new ImageIcon(IMAGE_PATH_REDUCT));
        Controller.clickChangeText(buttonRedactFotoClient);


         buttonClientExit = new JButton("Выход  клиента");
        buttonClientExit.setBounds(1285, 758, 240, 60);
        mainpanel.add(buttonClientExit);
        Controller.clickExitClient(buttonClientExit);

        buttonClientEnter = new JButton("Вход  клиента");
        buttonClientEnter.setBounds(1015, 758, 240, 60);
        mainpanel.add(buttonClientEnter);
        Controller.clickEnterClient(buttonClientEnter);



        buttonReturnMain = new JButton("");
         buttonReturnMain.setBorder(null);
        buttonReturnMain.setIcon(new ImageIcon(IMAGE_PATH_RETURN));
        buttonReturnMain.setBounds(10, 10, 47, 53);
        mainpanel.add(buttonReturnMain);
        Controller.returnMainMenu(buttonReturnMain, getFrame());
    }

    public void setTableClient() {
        scrollPaneTable = new JScrollPane();
        scrollPaneTable.setBounds(50, 114, 500, 590);
        mainpanel.add(scrollPaneTable);
        tableClients = new JTable(modelTable);
        tableClients.setBorder(new LineBorder(Color.LIGHT_GRAY));
        tableClients.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tableClients.setBounds(10, 114, 500, 590);
        Controller.clickClientJTable(tableClients);
        scrollPaneTable.setViewportView(tableClients);
        Controller.setColumnsWidth(tableClients);
            }

    @Override
    public void showView() {
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public static  JTable getTableClients() {
        return tableClients;
    }

    public static JLabel getLabelInfoClientBirthday() {
        return labelInfoClientBirthday;
    }

    public static JLabel getLabelInfoClientStatus() {
        return labelInfoClientStatus;
    }

    public static JLabel getLabelInfoClientEmail() {
        return labelInfoClientEmail;
    }

    public static JLabel getLabelInfoClientPass() {
        return labelInfoClientPass;
    }

    public static JLabel getLabelInfoClientGetR() {
        return labelInfoClientGetR;
    }

    public static JLabel getLabelInfoClientKnow() {
        return labelInfoClientKnow;
    }

    public static JLabel getLabelInfoClientMore() {
        return labelInfoClientMore;
    }

    public static JLabel getLabelInfoClientPol() {
        return labelInfoClientPol;
    }

    public static  JLabel getLabelInfoClientFio() {
        return labelInfoClientFio;
    }

    public  static  JLabel getLabelInfoClientCard() {
        return labelInfoClientCard;
    }

    public static JLabel getLabelInfoClientFoto() {
        return labelInfoClientFoto;
    }

    public static  JTextField getTextfieldInputClient() {
        return textfieldInputClient;
    }

    public static JLabel getLabelInfoClientMobileNumber() {
        return labelInfoClientMobileNumber;
    }

    public static JLabel getLabelInfoClientHomeNumber() {
        return labelInfoClientHomeNumber;
    }

    public static JLabel getLabelInfoClientWorkNumber() {
        return labelInfoClientWorkNumber;
    }

    public static void formatText(JLabel label){
        label.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), null, null, null));
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
    }

}
