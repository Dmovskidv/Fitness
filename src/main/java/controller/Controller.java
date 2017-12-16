package controller;

import Interface.ViewInterface;
import view.AddClient;
import view.FindClient;
import view.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class Controller {

      static ViewInterface main  = new Main();
     // ViewInterface addClient = new AddClient();

    public void showApp(){
       main.showView();
    }

    public static  void openAddClient(JButton button){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new AddClient().showView();
                 //main.getFrame().dispose();
                main.getFrame().setVisible(false);
            }
        });
    }

    public static void openFindClient(JButton button2){
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindClient().showView();
                main.getFrame().setVisible(false);

            }
        });

    }

    public static void returnMainMenu(final JButton button3, final JFrame frame){
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                main.getFrame().setVisible(true);
                          }
        });
    }






}
