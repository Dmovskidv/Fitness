package view;

import Interface.ViewInterface;
import controller.Controller;
import model.ModelTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FindClient implements ViewInterface {

    private JFrame frame;
    private static JTable tableClients;
    private static JTextField textfieldInputClient;
    private JLabel labelNumberCard,labelFio,labelPol,labelBirthday,labelStatus,labelEmail,labelPass,labelReklama,labelWhereKnow,labelDopInfo, labelTitle, labelPhones;
    private static JLabel labelInfoClientCard;
    private static JLabel labelInfoClientFio;
    private static JLabel labelInfoClientBirthday;
    private static JLabel labelInfoClientStatus;
    private static JLabel labelInfoClientEmail;
    private static JLabel labelInfoClientPass;
    private static JLabel labelInfoClientGetR;
    private static JLabel labelInfoClientKnow;
    private static JLabel labelInfoClientMore;
    private static JLabel labelInfoClientPol;
    private static JLabel labelInfoClientContactNumber;
    private static JLabel labelInfoClientFoto;
    private JPanel mainpanel, panelInfo, panelClient, topPanel;
    private JScrollPane scrollPaneTable;
    private JButton buttonFindClient, buttonClientEnter, buttonReturnMain, buttonClientExit, buttonChangePhoto;
    ModelTable modelTable = new ModelTable();


    public FindClient() {
        frame = new JFrame();
        frame.setTitle("Новый клиент");
        frame.setSize(1200, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // frame.getContentPane().setLayout(null);
        mainpanel = new JPanel();
        frame.getContentPane().add(mainpanel);
        mainpanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
        mainpanel.setBounds(0, 0, 1184, 712);
        mainpanel.setLayout(null);
        setTableClient();
        setPanelInfo();
        setClient();

        // input FIO or ID Client
        textfieldInputClient = new JTextField();
        textfieldInputClient.setText("Введите ФИО клиента или номер карты");
        textfieldInputClient.setForeground(Color.LIGHT_GRAY);
        //textfieldInputClient.setCol
        textfieldInputClient.setBounds(10, 72, 272, 36);
        mainpanel.add(textfieldInputClient);
        textfieldInputClient.setColumns(10);
        Controller.inputTextFindClient(textfieldInputClient);

        // Buttons control visit clients
        buttonFindClient = new JButton("Поиск");
        buttonFindClient.setBounds(292, 72, 99, 36);
        mainpanel.add(buttonFindClient);
        Controller.clickButtonFindClient(buttonFindClient);

        buttonClientEnter = new JButton("Вход  клиента");
        buttonClientEnter.setBounds(746, 638, 203, 53);
        mainpanel.add(buttonClientEnter);

        // -------------------------------


    }

    public void setPanelInfo() {
        panelInfo = new JPanel();
        panelInfo.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelInfo.setBounds(416, 220, 320, 412);
        mainpanel.add(panelInfo);
        panelInfo.setLayout(null);

        labelNumberCard = new JLabel("Номер карты клиента:");
        labelNumberCard.setBounds(10, 11, 300, 25);
        panelInfo.add(labelNumberCard);
        labelNumberCard.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), null, null, null));
        labelNumberCard.setFont(new Font("Tahoma", Font.PLAIN, 18));

        labelFio = new JLabel("Клиент:");
        labelFio.setBounds(10, 47, 300, 25);
        panelInfo.add(labelFio);
        labelFio.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelFio.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));

        labelPol = new JLabel("Пол:");
        labelPol.setBounds(10, 83, 300, 25);
        panelInfo.add(labelPol);
        labelPol.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelPol.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));

        labelBirthday = new JLabel("Дата рождения:");
        labelBirthday.setBounds(10, 119, 300, 25);
        panelInfo.add(labelBirthday);
        labelBirthday.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelBirthday.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));

        labelStatus = new JLabel("Статус:");
        labelStatus.setBounds(10, 155, 300, 25);
        panelInfo.add(labelStatus);
        labelStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelStatus.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));

        labelEmail = new JLabel("Email:");
        labelEmail.setBounds(10, 191, 300, 25);
        panelInfo.add(labelEmail);
        labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));

        labelPass = new JLabel("Паспортные данные:");
        labelPass.setBounds(10, 227, 300, 25);
        panelInfo.add(labelPass);
        labelPass.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelPass.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));

        labelReklama = new JLabel("Получать рекламу:");
        labelReklama.setBounds(10, 263, 300, 25);
        panelInfo.add(labelReklama);
        labelReklama.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelReklama.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));

        labelWhereKnow = new JLabel("Откуда узнал:");
        labelWhereKnow.setBounds(10, 299, 300, 25);
        panelInfo.add(labelWhereKnow);
        labelWhereKnow.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelWhereKnow.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));

        labelDopInfo = new JLabel("Дополнительная информация:");
        labelDopInfo.setBounds(10, 335, 300, 25);
        panelInfo.add(labelDopInfo);
        labelDopInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelDopInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));


        labelPhones = new JLabel("Номера телефонов:");
        labelPhones.setBounds(10, 371, 300, 25);
        panelInfo.add(labelPhones);
        labelPhones.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelPhones.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
    }

    public void setClient() {
        panelClient = new JPanel();
        panelClient.setLayout(null);
        panelClient.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelClient.setBounds(746, 220, 412, 412);
        mainpanel.add(panelClient);

        labelInfoClientCard = new JLabel("");
        labelInfoClientCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelInfoClientCard.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), null, null, null));
        labelInfoClientCard.setBounds(10, 11, 363, 25);
        panelClient.add(labelInfoClientCard);

        labelInfoClientFio = new JLabel("");
        labelInfoClientFio.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelInfoClientFio.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelInfoClientFio.setBounds(10, 47, 363, 25);
        panelClient.add(labelInfoClientFio);

        labelInfoClientPol = new JLabel("");
        labelInfoClientPol.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelInfoClientPol.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelInfoClientPol.setBounds(10, 83, 363, 25);
        panelClient.add(labelInfoClientPol);

        labelInfoClientBirthday = new JLabel("");
        labelInfoClientBirthday.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelInfoClientBirthday.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelInfoClientBirthday.setBounds(10, 119, 363, 25);
        panelClient.add(labelInfoClientBirthday);

        labelInfoClientStatus = new JLabel("");
        labelInfoClientStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelInfoClientStatus.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelInfoClientStatus.setBounds(10, 155, 363, 25);
        panelClient.add(labelInfoClientStatus);

        labelInfoClientEmail = new JLabel("");
        labelInfoClientEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelInfoClientEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelInfoClientEmail.setBounds(10, 191, 363, 25);
        panelClient.add(labelInfoClientEmail);

        labelInfoClientPass = new JLabel("");
        labelInfoClientPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelInfoClientPass.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelInfoClientPass.setBounds(10, 227, 363, 25);
        panelClient.add(labelInfoClientPass);

        labelInfoClientGetR = new JLabel("");
        labelInfoClientGetR.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelInfoClientGetR.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelInfoClientGetR.setBounds(10, 263, 363, 25);
        panelClient.add(labelInfoClientGetR);

        labelInfoClientKnow = new JLabel("");
        labelInfoClientKnow.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelInfoClientKnow.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelInfoClientKnow.setBounds(10, 299, 363, 25);
        panelClient.add(labelInfoClientKnow);

        labelInfoClientMore = new JLabel("");
        labelInfoClientMore.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelInfoClientMore.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelInfoClientMore.setBounds(10, 335, 363, 25);
        panelClient.add(labelInfoClientMore);

        labelInfoClientContactNumber = new JLabel("");
        labelInfoClientContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelInfoClientContactNumber.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
        labelInfoClientContactNumber.setBounds(10, 371, 363, 25);
        panelClient.add(labelInfoClientContactNumber);

        JButton buttonRedactNumberCard = new JButton("");
        buttonRedactNumberCard.setBounds(377, 11, 25, 25);
        panelClient.add(buttonRedactNumberCard);
        buttonRedactNumberCard.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));

        JButton buttonRedactFio = new JButton("");
        buttonRedactFio.setBounds(377, 47, 25, 25);
        panelClient.add(buttonRedactFio);
        buttonRedactFio.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));

        JButton buttonRedactPol = new JButton("");
        buttonRedactPol.setBounds(377, 83, 25, 25);
        panelClient.add(buttonRedactPol);
        buttonRedactPol.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));

        JButton buttonRedactBirthday = new JButton("");
        buttonRedactBirthday.setBounds(377, 119, 25, 25);
        panelClient.add(buttonRedactBirthday);
        buttonRedactBirthday.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));

        JButton buttonRedactStatus = new JButton("");
        buttonRedactStatus.setBounds(377, 155, 25, 25);
        panelClient.add(buttonRedactStatus);
        buttonRedactStatus.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));

        JButton buttonRedactEmail = new JButton("");
        buttonRedactEmail.setBounds(377, 191, 25, 25);
        panelClient.add(buttonRedactEmail);
        buttonRedactEmail.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));

        JButton buttonRedactPassport = new JButton("");
        buttonRedactPassport.setBounds(377, 227, 25, 25);
        panelClient.add(buttonRedactPassport);
        buttonRedactPassport.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));

        JButton buttonRedactGetReklama = new JButton("");
        buttonRedactGetReklama.setBounds(377, 263, 25, 25);
        panelClient.add(buttonRedactGetReklama);
        buttonRedactGetReklama.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));

        JButton buttonRedactWhereKnow = new JButton("");
        buttonRedactWhereKnow.setBounds(377, 299, 25, 25);
        panelClient.add(buttonRedactWhereKnow);
        buttonRedactWhereKnow.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));

        JButton buttonRedactContactClient = new JButton("");
        buttonRedactContactClient.setBounds(377, 371, 25, 25);
        panelClient.add(buttonRedactContactClient);
        buttonRedactContactClient.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));

        JButton buttonDopInfo = new JButton("");
        buttonDopInfo.setBounds(377, 335, 25, 25);
        panelClient.add(buttonDopInfo);
        buttonDopInfo.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));

        topPanel = new JPanel();
        topPanel.setBounds(416, 47, 742, 170);
        mainpanel.add(topPanel);
        topPanel.setLayout(null);

        labelTitle = new JLabel(" Информация о клиенте");
        labelTitle.setBounds(0, 44, 299, 67);
        topPanel.add(labelTitle);
        labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));

        labelInfoClientFoto = new JLabel("");
        labelInfoClientFoto.setIcon(new ImageIcon("src\\main\\resources\\images\\fotoForAddClient.jpg"));
        labelInfoClientFoto.setBorder(new LineBorder(Color.LIGHT_GRAY));
        labelInfoClientFoto.setBounds(445, 20, 172, 172);
        topPanel.add(labelInfoClientFoto);

         buttonChangePhoto = new JButton("");
        buttonChangePhoto.setIcon(new ImageIcon("src\\main\\resources\\images\\icon2redact.png"));
        buttonChangePhoto.setBounds(622, 145, 25, 25);
        topPanel.add(buttonChangePhoto);

         buttonClientExit = new JButton("Выход  клиента");
        buttonClientExit.setBounds(959, 638, 203, 53);
        mainpanel.add(buttonClientExit);

        buttonReturnMain = new JButton("");
         buttonReturnMain.setBorder(null);
        buttonReturnMain.setIcon(new ImageIcon("src\\main\\resources\\images\\return.jpg"));
        buttonReturnMain.setBounds(10, 10, 47, 53);
        mainpanel.add(buttonReturnMain);
        Controller.returnMainMenu(buttonReturnMain, getFrame());
    }

    public void setTableClient() {
        scrollPaneTable = new JScrollPane();
        scrollPaneTable.setBounds(10, 114, 381, 508);
        mainpanel.add(scrollPaneTable);
        tableClients = new JTable(modelTable);
        tableClients.setBorder(new LineBorder(Color.LIGHT_GRAY));
        tableClients.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tableClients.setBounds(10, 114, 381, 508);
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

    public static JLabel getLabelInfoClientContactNumber() {
        return labelInfoClientContactNumber;
    }

    public static  JTextField getTextfieldInputClient() {
        return textfieldInputClient;
    }



}
