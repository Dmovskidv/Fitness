package model;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Client {

    //main information
    private  String name;
    private String lastName;
    private String fatherName;
    private String dateBirthday;
    private String sex;
    //more
    private int numberCard;
    private String pathFoto;
    private String phoneMobile;
    private String phoneHome;
    private String phoneWork;
    private String email;
    private String numPassport;
    private String infoPassport;
    private String aboutClient;
    private String whereKnow;
    private String getReklama;



    private String status;



    public Client(String name, String lastName, String fatherName, String sex , String dateBirthday , int numberCard,
                  String pathFoto, String phoneMobile, String phoneHome, String phoneWork, String email, String numPassport, String infoPassport, String aboutClient, String whereKnow, String getReklama, String status) {
        this.name = name;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dateBirthday = dateBirthday;
        this.sex = sex;
        this.numberCard = numberCard;
        this.pathFoto = pathFoto;
        this.phoneMobile = phoneMobile;
        this.phoneHome = phoneHome;
        this.phoneWork = phoneWork;
        this.email = email;
        this.numPassport = numPassport;
        this.infoPassport = infoPassport;
        this.aboutClient = aboutClient;
        this.getReklama = getReklama;
        this.whereKnow = whereKnow;
        this.status = status;
    }


    public  String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getDateBirthday() {
        return dateBirthday;
    }

    public String getSex() {
        return sex;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public String getPathFoto() {
        return pathFoto;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public String getEmail() {
        return email;
    }

    public String getNumPassport() {
        return numPassport;
    }

    public String getInfoPassport() {
        return infoPassport;
    }

    public String getAboutClient() {
        return aboutClient;
    }

    public String getWhereKnow() {
        return whereKnow;
    }

    public String getReklama() {
        return getReklama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
