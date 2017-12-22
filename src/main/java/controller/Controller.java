package controller;

import Interface.ViewInterface;
import model.Client;
import model.Model;
import view.*;
import view.services.FitnessInfo;
import view.services.GimInfo;
import view.services.PoolInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Controller {

    static ViewInterface main = new Main();
    static AddClient addClient = new AddClient();
    static Model model = new Model();
    private static Scanner scanner;


    public void showApp() {
        main.showView();
    }

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

    public static void returnMainMenu(final JButton button3, final JFrame frame) {
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                Main.getFrame().setVisible(true);
            }
        });
    }

    public static void addClientButton(JButton action) {

        action.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                final String name = AddClient.getField_name().getText();
                final String sirname = AddClient.getField_sirname().getText();

                final String lastname = AddClient.getField_nameFather().getText();
                if (name.trim().length() == 0) {
                    AddClient.getField_sirname().setBorder(BorderFactory.createLineBorder(Color.red));
                }
                if (sirname.trim().length() == 0) {
                    AddClient.getField_name().setBorder(BorderFactory.createLineBorder(Color.red));
                }
                if (lastname.trim().length() == 0) {
                    AddClient.getField_nameFather().setBorder(BorderFactory.createLineBorder(Color.red));
                }
                final String sex = ((String) AddClient.getComboBox_sex().getSelectedItem());
                final String age = (AddClient.getDatePicker().getJFormattedTextField().getText().trim().length() > 0) ? AddClient.getDatePicker().getJFormattedTextField().getText() : "Не указано";
                final int numberCard = model.getDate().size() + 1;
                final ImageIcon foto =  (ImageIcon) AddClient.getLabel_foto().getIcon();
                final String mobilePhone = AddClient.getField_mobilePhone().getText();
                final String homePhone = (AddClient.getField_homePhone().getText().trim().length() > 0) ? AddClient.getField_homePhone().getText() : "Не указано";
                final String workPhone = (AddClient.getField_workPhone().getText().trim().length() > 0) ? AddClient.getField_workPhone().getText() : "Не указано";
                final String numberPassport = (AddClient.getField_passport().getText().trim().length() > 0) ? AddClient.getField_passport().getText() : "Не указано";
                final String mailAddress = (AddClient.getField_email().getText().trim().length() > 0) ? AddClient.getField_email().getText() : "Не указано";
                final String infoPassport = (AddClient.getField_infoPassport().getText().trim().length() > 0) ? AddClient.getField_infoPassport().getText() : "Не указано";
                final String moreInformation = (AddClient.getTextArea_aboutClient().getText().trim().length() > 0) ? AddClient.getTextArea_aboutClient().getText() : "Не указано";

                if (mobilePhone.trim().length() > 0 && name.trim().length() > 0 && sirname.trim().length() > 0 && lastname.trim().length() > 0) {
                    model.getDate().add(new Client(name, sirname, lastname, sex, age, numberCard, foto,
                            mobilePhone, homePhone, workPhone, mailAddress, numberPassport, infoPassport, moreInformation));
                    JOptionPane.showMessageDialog(null, "Добавлен клиент " + sirname + " " + name.charAt(0) + "." + lastname.charAt(0) + ". №" + model.getCountClients());
                } else {
                    System.out.println("Incorrect input, repeat please");

                }
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

    public static void clickServicesPool(final JMenuItem pool, final JFrame frame) {
        pool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new PoolInfo();
            }
        });
    }

    public static void clickServicesGim(JMenuItem gim, final JFrame frame) {
        gim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GimInfo();
            }
        });

    }

    public static void clickServicesClickAerobic(JMenuItem action, final JFrame frame) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new FitnessInfo();
            }
        });

    }

    public static void clickLockProgram(JButton buttonLock) {
        buttonLock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialog.control_password();
            }
        });

    }

    public static void exitProgram(JMenuItem lock) {
        lock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void openAddSale(JButton buttonAddSale, JFrame frame) {
        buttonAddSale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddSale().showView();
            }
        });
    }

    public static void clickComboBoxClientClub(final JComboBox comboBoxTypeClient) {
        comboBoxTypeClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxTypeClient.getSelectedItem().equals("Клиент клуба")) {
                    AddSale.getTextFieldNumCard().setEditable(true);
                }
            }
        });
    }

    public static void closeAddSale(JButton buttonCancel, final JFrame frame) {
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

    public static void clickAddSaleAbonement(JMenuItem action) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSale saleAbonement = new AddSale();
                saleAbonement.getComboBoxTypeVisit().setSelectedItem("Абонемент");
                saleAbonement.showView();

            }
        });
    }

    public static void clickaddSaleRaz(JMenuItem action) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSale saleRaz = new AddSale();
                saleRaz.getComboBoxTypeVisit().setSelectedItem("Разовое посещение");
                saleRaz.showView();
            }
        });
    }

    public static void writeClientFile(JButton action) {
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //---------------------------------------------------------------
                final String name = AddClient.getField_name().getText();
                final String sirname = AddClient.getField_sirname().getText();

                final String lastname = AddClient.getField_nameFather().getText();
                if (name.trim().length() == 0) {
                    AddClient.getField_sirname().setBorder(BorderFactory.createLineBorder(Color.red));
                }
                if (sirname.trim().length() == 0) {
                    AddClient.getField_name().setBorder(BorderFactory.createLineBorder(Color.red));
                }
                if (lastname.trim().length() == 0) {
                    AddClient.getField_nameFather().setBorder(BorderFactory.createLineBorder(Color.red));
                }
                final String sex = ((String) AddClient.getComboBox_sex().getSelectedItem());
                final String age = (AddClient.getDatePicker().getJFormattedTextField().getText().trim().length() > 0) ? AddClient.getDatePicker().getJFormattedTextField().getText() : "Не указано";
                final int numberCard = model.getDate().size() + 1;
                final ImageIcon foto =  (ImageIcon) AddClient.getLabel_foto().getIcon();
                final String mobilePhone = AddClient.getField_mobilePhone().getText();
                final String homePhone = (AddClient.getField_homePhone().getText().trim().length() > 0) ? AddClient.getField_homePhone().getText() : "Не указано";
                final String workPhone = (AddClient.getField_workPhone().getText().trim().length() > 0) ? AddClient.getField_workPhone().getText() : "Не указано";
                final String numberPassport = (AddClient.getField_passport().getText().trim().length() > 0) ? AddClient.getField_passport().getText() : "Не указано";
                final String mailAddress = (AddClient.getField_email().getText().trim().length() > 0) ? AddClient.getField_email().getText() : "Не указано";
                final String infoPassport = (AddClient.getField_infoPassport().getText().trim().length() > 0) ? AddClient.getField_infoPassport().getText() : "Не указано";
                final String moreInformation = (AddClient.getTextArea_aboutClient().getText().trim().length() > 0) ? AddClient.getTextArea_aboutClient().getText() : "Не указано";
                //-----------------------------------------------------------------------------------------------------------


                File file = new File("src//main//resources//clients.txt");

                FileWriter writerFile = null;
                try {
                    writerFile = new FileWriter(file, true);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {

                    if (mobilePhone.trim().length() > 0 && name.trim().length() > 0 && sirname.trim().length() > 0 && lastname.trim().length() > 0) {
                        writerFile.write( "|" + sirname + "|" + name + "|" + lastname + "|" + sex + "|" + age +  "|" + mobilePhone + "|" +
                                homePhone + "|" + workPhone + "|" + numberPassport + "|" + mailAddress + "|" + infoPassport + "|" + moreInformation + "|"+ foto+"\n");
                    }else {
                        System.out.println("Incorrect input");
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    writerFile.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    writerFile.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void readFileClient(String path){




    }
}
