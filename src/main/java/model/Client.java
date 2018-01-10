package model;



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
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setDateBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumPassport(String numPassport) {
        this.numPassport = numPassport;
    }

    public void setInfoPassport(String infoPassport) {
        this.infoPassport = infoPassport;
    }

    public void setAboutClient(String aboutClient) {
        this.aboutClient = aboutClient;
    }

    public void setWhereKnow(String whereKnow) {
        this.whereKnow = whereKnow;
    }

    public void setGetReklama(String getReklama) {
        this.getReklama = getReklama;
    }


}
