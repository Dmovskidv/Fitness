package model;

import Interface.DateInterface;

import javax.swing.*;
import java.util.ArrayList;

public class Model implements DateInterface {

    //for ComboBox  class AddSale
    private static String[] itemServices = new String[]{"Не выбрано", "Бассеин", "Тренажёрный зал", "Аэробика", "Йога"};
    private static String[] itemTypeVisit = new String[]{"Не выбрано", "Разовое посещение", "Абонемент 1 месяц","Абонемент 3 месяца","Абонемент 6 месяцев",
            "Абонемент 1 год",};
    private static String[] itemTypeClient = new String[]{"Не выбрано", "Клиент клуба", "Гость"};

    //for ComboBox class AddClient
    private static String[] whereKnow = { "Не выбрано","Рассказали знакомые", "Реклама в интернете", "Реклама в метро",
            "Интернет-поисковик", "Находится рядом", "Рекламные листовки", "Другое" };
    private static String[] getNews = {"Не выбрано", "Получать всё", "Не получать", "Только SMS", "Только email" };
    private static String[] sexPerson = {"Не выбрано", "Мужской", "Женский" };




    private static ArrayList<Client> clients = new ArrayList<Client>();

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
            case "whereKnow" : return whereKnow;

            case "getNews": return  getNews;

            case "sexPerson": return sexPerson;

            default: return new String[]{""};
        }

    }













}


