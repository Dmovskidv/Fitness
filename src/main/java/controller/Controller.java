package controller;

import Interface.ViewInterface;
import model.Client;
import model.DB;
import model.Model;
import view.*;
import view.services.*;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;



public class Controller {

    static ViewInterface main = new Main();
    private static AddClient addClient = new AddClient();
    private static Model model = new Model();
   // private static boolean resultoperation = false;


    //----------------------------start program-----------------------------------
public void showApp() {
        main.showView();
    }


//----------------------------autorisation program----------------------------
public static void controlPassword(){

    new Thread(new Runnable() {
        @Override
        public void run() {
            final JPasswordField passwordField = new JPasswordField(10);
            JLabel label_login = new JLabel("Администратор");
            JLabel label_password = new JLabel("Пароль");
            String[] user = DB.getAdminDB();
            JComboBox combo_users = new JComboBox(user);
            Object[] array = { label_login, combo_users, label_password, passwordField };
            String login = "";

            passwordField.addAncestorListener(new AncestorListener() {
                @Override
                public void ancestorAdded(AncestorEvent event) {
                    passwordField.requestFocusInWindow();
                }
                @Override
                public void ancestorRemoved(AncestorEvent event) {

                }

                @Override
                public void ancestorMoved(AncestorEvent event) {

                }
            });//Установить фокус полю ввода пароля

            int res = JOptionPane.showConfirmDialog(null, array, "Авторизация", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);//Вызов диалогового окна

            if (res == JOptionPane.OK_OPTION) {

                login = (String) combo_users.getSelectedItem();
                char[] password = passwordField.getPassword();
                String inputPass = "";
                for (char c : password) {
                    inputPass += c;
                }

                if (inputPass.equals(DB.getPasswordDB(login))) {
                    JOptionPane.showMessageDialog(null, "Добро пожаловать, " + login);
                    passwordField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                    passwordField.setText("");
                    Main.setadminItem().setText(login);

                } else {
                    passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
                    passwordField.setToolTipText("Неверный пароль");
                    passwordField.setText("");
                    controlPassword();
                }

            } else if (res == JOptionPane.CANCEL_OPTION || res == JOptionPane.CLOSED_OPTION) {
                int res2 = JOptionPane.showConfirmDialog(null, "Выйти из приложения?", "Exit", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (res2 == 0) {
                    System.exit(0);
                } else
                    controlPassword();

            }
        }
    }).start();



}


//----------------------------lock program---exit program---------------------
public static void clickLockProgram(JButton buttonLock) {
    buttonLock.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            controlPassword();
        }
    });

}
    public static void exitProgram(JMenuItem lock) {
        lock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

//----------------------------open views program------------------------------
    public static void openAddClient(JButton button, final JFrame frame) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddClient().showView();
                frame.setVisible(false);
            }
        });
    }

    public static void openAddClientClickItem(JMenuItem action, final JFrame frame) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddClient().showView();
                frame.setVisible(false);
            }
        });
    }

    public static void openFindClient(JButton button2) {
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindClient().showView();
                Main.getFrame().setVisible(false);
            }
        });

    }

    public static void openFindClientClickItem(JMenuItem findClient, final JFrame frame) {
        findClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindClient().showView();
                frame.setVisible(false);

            }
        });
    }

    public static void openAddSale(JButton buttonAddSale, final JFrame frame) {
        buttonAddSale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AddSale().showView();
            }
        });
    }

    public static void openAboutApp(JMenuItem helpInfo, final JFrame frame) {
        helpInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutApp().showView();
            }
        });
    }

    public static void clickServicesIoga(JMenuItem action, final JFrame frame) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new IogaInfo().showView();
            }
        });
    }

    public static void clickServicesPool(final JMenuItem pool, final JFrame frame) {
        pool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new PoolInfo().showView();
            }
        });
    }

    public static void clickServicesGim(JMenuItem gim, final JFrame frame) {
        gim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GimInfo().showView();
            }
        });

    }

    public static void clickServicesAerobic(JMenuItem action, final JFrame frame) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new FitnessInfo().showView();
            }
        });

    }

    public static void clickItemTrener(JMenuItem thirdAdmin) {
        thirdAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Trener().showView();
            }
        });
    }

    public static void clickaddSaleRaz(JMenuItem action) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSale saleRaz = new AddSale();
                saleRaz.getComboBoxTypeVisit().setSelectedItem("Разовое посещение");
                saleRaz.getComboBoxTypeClient().setSelectedItem("Гость");
                showSumBeforePay2(AddSale.getComboBoxServices(), "1 раз");
                saleRaz.showView();
            }
        });
    }

    public static void clickAbonement1m(JMenuItem action) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSale saleRaz = new AddSale();
                saleRaz.getComboBoxTypeVisit().setSelectedItem("Абонемент 1 месяц");
                saleRaz.getComboBoxTypeClient().setSelectedItem("Клиент клуба");
                showSumBeforePay2(AddSale.getComboBoxServices(), "1 мес");


                saleRaz.showView();
            }
        });
    }

    public static void clickAbonement3m(JMenuItem action) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSale saleRaz = new AddSale();
                saleRaz.getComboBoxTypeVisit().setSelectedItem("Абонемент 3 месяца");
                saleRaz.getComboBoxTypeClient().setSelectedItem("Клиент клуба");
                showSumBeforePay2(AddSale.getComboBoxServices(), "3 мес");
                saleRaz.showView();
            }
        });
    }

    public static void clickAbonement6m(JMenuItem action) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSale saleRaz = new AddSale();
                saleRaz.getComboBoxTypeVisit().setSelectedItem("Абонемент 6 месяцев");
                saleRaz.getComboBoxTypeClient().setSelectedItem("Клиент клуба");
                showSumBeforePay2(AddSale.getComboBoxServices(), "6 мес");
                saleRaz.showView();
            }
        });
    }

    public static void clickAbonement1y(JMenuItem action) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSale saleRaz = new AddSale();
                saleRaz.getComboBoxTypeVisit().setSelectedItem("Абонемент 1 год");
                saleRaz.getComboBoxTypeClient().setSelectedItem("Клиент клуба");
                showSumBeforePay2(AddSale.getComboBoxServices(), "1 год");
                saleRaz.showView();
            }
        });
    }
//-----------------------------------------------------------------------------------------

    public static void returnMainMenu(final JButton button3, final JFrame frame) {
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                Main.getFrame().setVisible(true);
            }
        });
    }

    public static void cancelClientButton(JButton action, final JFrame frame) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Main.getFrame().setVisible(true);
            }
        });
    }

     public static void clickComboBoxClientClub(final JTextField field) {
        field.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(((String)AddSale.getComboBoxTypeClient().getSelectedItem()).equals("Гость")){
                    field.setEditable(false);
                                   }
                else if(!((String)AddSale.getComboBoxTypeClient().getSelectedItem()).equals("Гость")){
                    field.setEditable(true);
                }
            }
        });
    }

    public static void closeAddSale(JButton buttonCancel, final JDialog frame) {
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public static void clickOpenFoto(final JButton fileopen) {
        fileopen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
               int ret = fileopen.showDialog(null, "Добавить фото");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    String fileLocation = fileopen.getSelectedFile().getPath();
                    AddClient.getLabel_foto().setIcon(new ImageIcon(fileLocation));
                }
            }
        });
    }

    public static void cleanFormButton(JButton button_clean) {
        button_clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddClient.getField_name().setText("");
                AddClient.getField_sirname().setText("");
                AddClient.getField_nameFather().setText("");
                AddClient.getField_mobilePhone().setText("");
                AddClient.getField_homePhone().setText("");
                AddClient.getField_workPhone().setText("");
                AddClient.getField_email().setText("");
                AddClient.getField_passport().setText("");
                AddClient.getField_infoPassport().setText("");
                AddClient.getTextArea_aboutClient().setText("");
                AddClient.getComboBox_getPublic().setSelectedItem("Не выбрано");
                AddClient.getComboBox_whyKnow().setSelectedItem("Не выбрано");
                AddClient.getComboBox_sex().setSelectedItem("Не выбрано");
            }
        });
    }

    public static void writeDB(JButton button_create) {
        button_create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(DB.openDB() && dateClientValide()) {

                    if(isSameClient(AddClient.getField_name().getText(), AddClient.getField_sirname().getText(), AddClient.getField_nameFather().getText())){



                   try {
                       writeClientInTableAddNow();
                   }catch(Exception ex){
                       System.out.println("Новый клиент в jtable не добавлен");
                   }
                    DB.insertDB();
                    showMessageDialog("OK");
                    DB.closeDB();
                    } else showMessageDialog("isSameClient");


                }else showMessageDialog("NO");

            }
        });
    }

    private static boolean isSameClient(String name, String sirname, String fathername) {
        boolean result = true;

        for (Client m: model.getDate()
             ) {
            if(m.getName().equals(name) && m.getLastName().equals(sirname) && m.getFatherName().equals(fathername)) {
                result = false;
            }
        }

        return result;
    }

    private static void showMessageDialog(String str) {
        switch (str){
            case "OK": JOptionPane.showMessageDialog(null, "Добавлен клиент: " + AddClient.getField_sirname().getText() + " " + AddClient.getField_name().getText().charAt(0) + "." + AddClient.getField_nameFather().getText().charAt(0)+".");
                break;
            case "NO": JOptionPane.showMessageDialog(null, "Заполните обязательные поля формы и повторите ввод");
                break;
            case "isSameClient": JOptionPane.showMessageDialog(null, "Клиент с такими данными уже существует");
            break;
        }
    }

    private static boolean dateClientValide() {

        if (AddClient.getField_name().getText().length() == 0) {
            AddClient.getField_name().setBorder(BorderFactory.createLineBorder(Color.red));
        }
        if (AddClient.getField_sirname().getText().length() == 0) {
            AddClient.getField_sirname().setBorder(BorderFactory.createLineBorder(Color.red));
        }
        if (AddClient.getField_nameFather().getText().length() == 0) {
            AddClient.getField_nameFather().setBorder(BorderFactory.createLineBorder(Color.red));
        }
        if (AddClient.getComboBox_sex().getSelectedIndex()==0) {
            AddClient.getComboBox_sex().setForeground(Color.red);

        }
        if ( AddClient.getField_mobilePhone().getText().length()==0) {
            AddClient.getField_mobilePhone().setBorder(BorderFactory.createLineBorder(Color.red));
        }



        boolean date = (AddClient.getField_sirname().getText().length()>0 && AddClient.getField_name().getText().length()>0 &&
                AddClient.getField_nameFather().getText().length()>0 && !AddClient.getComboBox_sex().getSelectedItem().equals("Не выбрано")
                && AddClient.getField_mobilePhone().getText().length()>0 )? true : false;


        return date;
    }

    public final static void setColumnsWidth(JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(370);
        table.getColumnModel().getColumn(1).setPreferredWidth(110);
        table.setRowHeight(25);
        }

    public static void initDB() {

                if(DB.openDB()){
                    DB.selectDB();
                    System.out.println("БД чтение...");
                    DB.closeDB();
                   System.out.println("БД закрыта");
                }


    }

    public static void writeClientInTableAddNow(){
         String name = AddClient.getField_name().getText();
         String sirname = AddClient.getField_sirname().getText();
         String lastname = AddClient.getField_nameFather().getText();
         String sex = ((String) AddClient.getComboBox_sex().getSelectedItem());
         String age = (AddClient.getDatePicker().getJFormattedTextField().getText().trim().length() > 0) ? AddClient.getDatePicker().getJFormattedTextField().getText() : "Не указано";
         String mobilePhone = AddClient.getField_mobilePhone().getText();
         String homePhone = (AddClient.getField_homePhone().getText().trim().length() > 0) ? AddClient.getField_homePhone().getText() : "Не указано";
         String workPhone = (AddClient.getField_workPhone().getText().trim().length() > 0) ? AddClient.getField_workPhone().getText() : "Не указано";
         String numberPassport = (AddClient.getField_passport().getText().trim().length() > 0) ? AddClient.getField_passport().getText() : "Не указано";
         String mailAddress = (AddClient.getField_email().getText().trim().length() > 0) ? AddClient.getField_email().getText() : "Не указано";
         String infoPassport = (AddClient.getField_infoPassport().getText().trim().length() > 0) ? AddClient.getField_infoPassport().getText() : "Не указано";
         String moreInformation = (AddClient.getTextArea_aboutClient().getText().trim().length() > 0) ? AddClient.getTextArea_aboutClient().getText() : "Не указано";
         String whereKnow = (String)AddClient.getComboBox_whyKnow().getSelectedItem();
         String getReklama = (String)AddClient.getComboBox_getPublic().getSelectedItem();
         String getPathFoto = AddClient.getLabel_foto().getIcon().toString();
         String getClientStatus = "Не активный";
         model.getDate().add(new Client(name,sirname,lastname,sex,age,model.getDate().size()+1,getPathFoto,mobilePhone,homePhone,workPhone,mailAddress,numberPassport,infoPassport,moreInformation, whereKnow, getReklama,getClientStatus));
          }

    public static void clickClientJTable(final JTable tableClients) {

        ListSelectionModel selModel = tableClients.getSelectionModel();
        selModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false)
                {
                   int row = tableClients.getSelectedRow();
                   int col = tableClients.getSelectedColumn();
                   if(col==0){col++;}
                   int  idCard = (int) tableClients.getModel().getValueAt(row, col);

                    for (Client m : model.getDate()
                         ) {
                        if(m.getNumberCard()==idCard){
                            FindClient.getLabelInfoClientFio().setText(m.getLastName()+" "+m.getName()+" "+
                                    m.getFatherName());
                            FindClient.getLabelInfoClientPol().setText(m.getSex());
                            FindClient.getLabelInfoClientCard().setText(String.valueOf(idCard));
                            FindClient.getLabelInfoClientEmail().setText(m.getEmail());
                            FindClient.getLabelInfoClientGetR().setText(m.getReklama());
                            FindClient.getLabelInfoClientMore().setText(m.getAboutClient());
                            FindClient.getLabelInfoClientPass().setText(m.getNumPassport());
                            FindClient.getLabelInfoClientKnow().setText(m.getWhereKnow());
                            FindClient.getLabelInfoClientFoto().setIcon(new ImageIcon(m.getPathFoto()));
                            FindClient.getLabelInfoClientBirthday().setText(m.getDateBirthday());
                            FindClient.getLabelInfoClientMobileNumber().setText(m.getPhoneMobile());
                            FindClient.getLabelInfoClientHomeNumber().setText(m.getPhoneHome());
                            FindClient.getLabelInfoClientWorkNumber().setText(m.getPhoneWork());
                            FindClient.getLabelInfoClientStatus().setText(m.getStatus());
                        }
                    }


                }
            }
        });


    }

    public static void inputTextFindClient(final JTextField textfieldInputClient) {
        textfieldInputClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                textfieldInputClient.setText("");
                textfieldInputClient.setForeground(Color.black);
                FindClient.getTextfieldInputClient().setBorder(BorderFactory.createLineBorder(Color.gray));
            }
        });
    }

    public static void clickButtonFindClient(JButton buttonFindClient) {
        buttonFindClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String date = (FindClient.getTextfieldInputClient().getText().length()>0)? FindClient.getTextfieldInputClient().getText() : "";
                boolean resultFind = true;

                for (Client m: model.getDate()
                     ) {
                    String id = m.getNumberCard()+"";
                    String str = m.getLastName()+" "+ m.getName();
                    if(str.equals(date) || id.equals(date)){

                        FindClient.getLabelInfoClientFio().setText(m.getLastName()+" "+m.getName()+" "+
                                m.getFatherName());
                        FindClient.getLabelInfoClientPol().setText(m.getSex());
                        FindClient.getLabelInfoClientCard().setText(String.valueOf(m.getNumberCard()));
                        FindClient.getLabelInfoClientEmail().setText(m.getEmail());
                        FindClient.getLabelInfoClientGetR().setText(m.getReklama());
                        FindClient.getLabelInfoClientMore().setText(m.getAboutClient());
                        FindClient.getLabelInfoClientPass().setText(m.getNumPassport());
                        FindClient.getLabelInfoClientKnow().setText(m.getWhereKnow());
                        FindClient.getLabelInfoClientFoto().setIcon(new ImageIcon(m.getPathFoto()));
                        FindClient.getLabelInfoClientBirthday().setText(m.getDateBirthday());
                        FindClient.getLabelInfoClientMobileNumber().setText(m.getPhoneMobile());
                        FindClient.getLabelInfoClientHomeNumber().setText(m.getPhoneHome());
                        FindClient.getLabelInfoClientWorkNumber().setText(m.getPhoneWork());
                        FindClient.getLabelInfoClientStatus().setText(m.getStatus());
                        resultFind = false;
                        break;
                    }
                }
                if(resultFind && date.length()>0 && !FindClient.getTextfieldInputClient().getText().equals("Введите ФИО клиента или номер карты")){
                    JOptionPane.showMessageDialog(null,"Клиент с такими данными не найден" );
                }else if(resultFind && date.length()==0 || FindClient.getTextfieldInputClient().getText().equals("Введите ФИО клиента или номер карты")){
                    FindClient.getTextfieldInputClient().setBorder((BorderFactory.createLineBorder(Color.red)));
                    JOptionPane.showMessageDialog(null, "Введите данные в поле поиска");}




            }
        });
    }

    public static void showSumBeforePay(final JComboBox comboBoxTypeVisit) {

            comboBoxTypeVisit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

            String timeService = (String) AddSale.getComboBoxTypeVisit().getSelectedItem();
            String service = (String)AddSale.getComboBoxServices().getSelectedItem();

            if(timeService.equals("Разовое посещение") && !service.equals("Не выбрано")){
             AddSale.getComboBoxTypeClient().setSelectedItem("Гость");
            }
            else if(!timeService.equals("Разовое посещение") && !service.equals("Не выбрано")){
                AddSale.getComboBoxTypeClient().setSelectedItem("Клиент клуба");
            }

            service = convertationService(service);
            timeService = convertationTimeService(timeService);

            String s = DB.selectCostDB(service, timeService);
             AddSale.getLabelSum().setText(s+"$");
        }

});

    }

    public static String convertationTimeService(String timeService) {
        switch (timeService){
            case "Разовое посещение" : timeService = "1 раз";
                break;
            case "Абонемент 1 месяц" : timeService = "1 мес";
                break;
            case "Абонемент 3 месяца" : timeService = "3 мес";
                break;
            case "Абонемент 6 месяцев" : timeService = "6 мес";
                break;
            case "Абонемент 1 год" : timeService = "1 год";
                break;
        }
        return timeService;
    }

    public static String convertationService(String service) {
        switch (service){
            case "Тренажёрный зал" : service = "gim";
                break;
            case "Бассеин" : service = "pool";
                break;
            case "Аэробика" : service = "aerobic";
                break;
            case "Йога" : service = "ioga";
                break;
        }
        return service;
    }

    public static void showSumBeforePay2(final JComboBox comboBoxServices, final String time) {
        comboBoxServices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String service = (String)comboBoxServices.getSelectedItem();
                service = convertationService(service);
                String s = DB.selectCostDB(service, time);
                AddSale.getLabelSum().setText(s+"$");


            }
        });
    }

    public static void clickCloseAboutApp(JButton close, final JDialog dialog) {
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
              //  Main.getFrame().setVisible(true);
            }
        });
    }

    public static boolean validateNumberCard(String numberCard) {

        boolean result = false;
        for (Client m: model.getDate()
             ) {
            if(numberCard.equals(m.getNumberCard()+"")){
                result = true;

                break;
            }
        }
        return result;
    }

     //------------------------------------------------------------
    //change info for clients
    public static void clickChangeText(final JButton button) {

        button.addMouseListener(new MouseAdapter() {

          @Override
          public void mouseClicked(MouseEvent e) {

              int y = button.getY();

              switch (y){
                  case 83 : changeDateBD("fio");
                      break;
                  case 119 : changeDateBD("sex");
                      break;
                  case 155 : changeDateBD("age");
                      break;
                  case 185 : changeDateBD("pathFoto");
                      break;
                  case 191 : changeDateBD("email");
                      break;
                  case 227 : changeDateBD("numberPassport");
                      break;
                  case 263 : changeDateBD("getReklama");
                      break;
                  case 299 : changeDateBD("whereKnow");
                      break;
                  case 335 : changeDateBD("moreInfo");
                      break;
                  case 371 : changeDateBD("mobilePhone");
                      break;
                  case 407 : changeDateBD("homePhone");
                      break;
                  case 443 : changeDateBD("workPhone");
                      break;
              }
          }
      });
    }

    private static void changeDateBD(String nameColumnTable) {
if(FindClient.getLabelInfoClientCard().getText().length()>0) {
    String id = FindClient.getLabelInfoClientCard().getText();

    String str = (nameColumnTable.equals("pathFoto"))? JOptionPane.showInputDialog(null, "Введите путь к новой фотографии", "src\\main\\resources\\fotoClients\\margo.jpg") : JOptionPane.showInputDialog(null, "Введите новую информацию");
        if (str != null) {
        DB.updateClient(id, str, nameColumnTable);
    }
}



    }

    public static void updateJTable(String id, String textForChange, String nameColumn) {
        String[] mass = new String[3];
      if(nameColumn.equals("fio")) {
           mass = textForChange.split(" ");
      }

        for (Client m : model.getDate()
             ) {
            if(Integer.parseInt(id) == m.getNumberCard()){





                switch(nameColumn){
                    case "fio" : m.setLastName(mass[0]);
                                 m.setName(mass[1]);
                                 m.setFatherName(mass[2]);
                        FindClient.getTableClients().updateUI();
                       FindClient.getLabelInfoClientFio().setText(mass[0]+" "+ mass[1]+" "+mass[2]);
                     //   resultoperation = true;
                        break;
                    case "sex" : FindClient.getLabelInfoClientPol().setText(textForChange);
                                 m.setSex(textForChange);
                           //      resultoperation = true;
                                 break;

                    case "email" :
                        FindClient.getLabelInfoClientEmail().setText(textForChange);
                        m.setEmail(textForChange);
                     //   resultoperation = true;
                        break;
                    case "age" :
                        FindClient.getLabelInfoClientBirthday().setText(textForChange);
                        m.setDateBirthday(textForChange);
                     //   resultoperation = true;
                        break;
                    case "numberPassport" :
                        FindClient.getLabelInfoClientPass().setText(textForChange);
                        m.setNumPassport(textForChange);
                     //   resultoperation = true;
                        break;
                    case "getReklama" :
                        FindClient.getLabelInfoClientGetR().setText(textForChange);
                        m.setGetReklama(textForChange);
                      //  resultoperation = true;
                        break;
                    case "whereKnow" :
                        FindClient.getLabelInfoClientKnow().setText(textForChange);
                        m.setWhereKnow(textForChange);
                    //    resultoperation = true;
                        break;
                    case "moreInfo" :
                        FindClient.getLabelInfoClientMore().setText(textForChange);
                        m.setAboutClient(textForChange);
                      //  resultoperation = true;
                        break;
                    case "mobilePhone" :
                        FindClient.getLabelInfoClientMobileNumber().setText(textForChange);
                        m.setPhoneMobile(textForChange);
                     //   resultoperation = true;
                        break;
                    case "homePhone" :
                        FindClient.getLabelInfoClientHomeNumber().setText(textForChange);
                        m.setPhoneHome(textForChange);
                      //  resultoperation = true;
                        break;
                    case "workPhone" :
                        FindClient.getLabelInfoClientWorkNumber().setText(textForChange);
                        m.setPhoneWork(textForChange);
                      //  resultoperation = true;
                        break;
                    case "pathFoto" :
                        m.setPathFoto(textForChange);
                        FindClient.getLabelInfoClientFoto().setIcon(new ImageIcon(textForChange));
                        //  resultoperation = true;
                        break;

                }

            }
          // if(resultoperation){break;}
        }

    }

    public static void clickExitClient(JButton buttonClientExit) {
        buttonClientExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void clickEnterClient(JButton buttonClientEnter) {
        buttonClientEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fio = FindClient.getLabelInfoClientFio().getText();
                String date = FindClient.getLabelInfoClientBirthday().getText();
                String idClient = FindClient.getLabelInfoClientCard().getText();
                String serviceClient = Controller.findClientId(idClient);
            }
        });
    }

    private static String findClientId(String idClient) {
        String result = null;
        for (Client m: model.getDate()
             ) {
            if(m.getNumberCard() == Integer.parseInt(idClient)){
               result = m.getStatus();
            }
        }
        return result;
    }







    //-------------------------------------------------------------
}


