package model;

import Interface.DateInterface;

import java.util.ArrayList;

public class Model implements DateInterface {

    ArrayList<Client> clients = new ArrayList<Client>();
   // ArrayList<Staff> staff = new ArrayList<Staff>();



    @Override
    public DateInterface getDate() {
        return null;
    }
}
