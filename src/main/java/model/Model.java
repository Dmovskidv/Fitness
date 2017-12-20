package model;

import Interface.DateInterface;

import javax.swing.*;
import java.util.ArrayList;

public class Model implements DateInterface {

    //for ComboBox  class AddSale
    private static String[] itemServices = new String[]{"Не выбрано", "Бассеин", "Тренажёрный зал", "Аэробика", "Йога"};;
    private static String[] itemTypeVisit = new String[]{"Не выбрано", "Разовое посещение", "Абонемент"};
    private static String[] itemTypeClient = new String[]{"Не выбрано", "Клиент клуба", "Гость"};

    //for ComboBox class AddClient
    private static String[] whereKnow = { "Не выбрано","Рассказали знакомые", "Реклама в интернете", "Реклама в метро",
            "Интернет-поисковик", "Находится рядом", "Рекламные листовки", "Другое" };
    private static String[] getNews = {"Не выбрано", "Получать всё", "Не получать", "Только SMS", "Только email" };
    private String[] sexPerson = {"Не выбрано", "Мужской", "Женский" };




    private   ArrayList<Client> clients = new ArrayList<Client>();

    @Override
    public ArrayList<Client> getDate() {
        return clients;
    }

    public int getCountClients(){
        return clients.size()+1;
    }



    public static String[] getDateForAddSale(String name){
        switch(name){
            case "services" : return itemServices;

            case "visit": return  itemTypeVisit;

            case "client": return itemTypeClient;

            default: return new String[]{""};
               }

    }

    public static String[] getDateForAddClient(String name){
        switch(name){
            case "whereKnow" : return itemServices;

            case "getNews": return  itemTypeVisit;

            case "sexPerson": return itemTypeClient;

            default: return new String[]{""};
        }

    }





    public String[] getItemServices() {
        return itemServices;
    }

    public String[] getItemTypeVisit() {
        return itemTypeVisit;
    }

    public String[] getItemTypeClient() {
        return itemTypeClient;
    }







}


