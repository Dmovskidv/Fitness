package model;

import java.awt.*;
import java.util.Date;

public class Client {

    //main information
    private String name;
    private String lastName;
    private String fatherName;
    private Date dateBirthday;
    private Boolean sex;
    private int numberCard;
    private Image foto;
    //more
    private int phoneMobile;
    private int phoneHome;
    private int phoneWork;
    private String email ="Не указан";
    private int numPassport;
    private int infoPassport;
    private String aboutClient ="Не указана";

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public int getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(int phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public int getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(int phoneHome) {
        this.phoneHome = phoneHome;
    }

    public int getPhoneWork() {
        return phoneWork;
    }

    public void setPhoneWork(int phoneWork) {
        this.phoneWork = phoneWork;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumPassport() {
        return numPassport;
    }

    public void setNumPassport(int numPassport) {
        this.numPassport = numPassport;
    }

    public int getInfoPassport() {
        return infoPassport;
    }

    public void setInfoPassport(int infoPassport) {
        this.infoPassport = infoPassport;
    }

    public String getAboutClient() {
        return aboutClient;
    }

    public void setAboutClient(String aboutClient) {
        this.aboutClient = aboutClient;
    }
}
