package controller;

import Interface.DateInterface;
import Interface.ViewInterface;
import model.Client;
import model.Model;
import view.AddClient;
import view.FindClient;
import view.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.*;

public class Controller  {

         static ViewInterface main  = new Main();
         static AddClient addClient = new AddClient();
         static Model model = new Model();



    public void showApp(){
       main.showView();
    }

    public static  void openAddClient(JButton button){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new AddClient().showView();
                 Main.getFrame().setVisible(false);
            }
        });
    }

    public static void openFindClient(JButton button2){
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindClient().showView();
                Main.getFrame().setVisible(false);

            }
        });

    }

    public static void returnMainMenu(final JButton button3, final JFrame frame){
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                Main.getFrame().setVisible(true);
                          }
        });
    }

    public static void addClientButton(JButton action){

        action.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                final String name = AddClient.getField_name().getText();
                final String sirname = AddClient.getField_sirname().getText();

                final String lastname =  AddClient.getField_nameFather().getText();
                if(name.trim().length()==0){AddClient.getField_sirname().setBorder(BorderFactory.createLineBorder(Color.red));}
                if(sirname.trim().length()==0){AddClient.getField_name().setBorder(BorderFactory.createLineBorder(Color.red));}
                if(lastname.trim().length()==0){AddClient.getField_nameFather().setBorder(BorderFactory.createLineBorder(Color.red));}
                final String sex = ((String) AddClient.getComboBox_sex().getSelectedItem().toString());
        final String age = (AddClient.getDatePicker().getJFormattedTextField().getText().trim().length()>0)? AddClient.getDatePicker().getJFormattedTextField().getText() : "Не указано";
        final int numberCard = model.getDate().size()+1;
        //Image foto = AddClient.getField_photo();
        final String mobilePhone =  AddClient.getField_mobilePhone().getText();
        final String homePhone =  (AddClient.getField_homePhone().getText().trim().length()>0) ? AddClient.getField_homePhone().getText() : "Не указано";
        final String workPhone =  (AddClient.getField_workPhone().getText().trim().length()>0) ? AddClient.getField_workPhone().getText() : "Не указано";
        final String numberPassport = (AddClient.getField_passport().getText().trim().length()>0) ? AddClient.getField_passport().getText() : "Не указано";
        final String mailAddress = (AddClient.getField_email().getText().trim().length()>0) ? AddClient.getField_email().getText() : "Не указано";
        final String infoPassport = (AddClient.getField_infoPassport().getText().trim().length()>0) ? AddClient.getField_infoPassport().getText() : "Не указано";
        final String moreInformation = (AddClient.getTextArea_aboutClient().getText().trim().length()>0) ? AddClient.getTextArea_aboutClient().getText() : "Не указано";

         if(mobilePhone.trim().length()>0 && name.trim().length()>0 && sirname.trim().length()>0 && lastname.trim().length()>0) {
             model.getDate().add(new Client(name, sirname, lastname, sex, age, numberCard /*foto*/,
                     mobilePhone, homePhone, workPhone, mailAddress, numberPassport, infoPassport, moreInformation));
             JOptionPane.showMessageDialog(null,"Добавлен клиент "+sirname+" "+name.charAt(0)+"."+lastname.charAt(0)+". №"+model.getCountClients());
         }else {
             System.out.println("Incorrect input, repeat please");

         }
            }
        });
    }

    public static void cancelClientButton(JButton action, final JFrame frame){
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ) {
                frame.dispose();
                Main.getFrame().setVisible(true);
            }
        });
    }



 }
