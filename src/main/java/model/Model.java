package model;

import Interface.DateInterface;

import java.util.ArrayList;

public class Model implements DateInterface {


    private   ArrayList<Client> clients = new ArrayList<Client>();
   // ArrayList<Staff> staff = new ArrayList<Staff>();



    @Override
    public ArrayList<Client> getDate() {
        return clients;
    }

    public int getCountClients(){
        return clients.size()+1;
    }
}


