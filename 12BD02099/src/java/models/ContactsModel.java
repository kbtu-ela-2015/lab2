package models;

import java.util.ArrayList;

public class ContactsModel {

public ArrayList<String> username, surname, phone, home_phone, address;

    public ContactsModel()
    {
        username = new ArrayList<String>();
        username.add("Akzhol");
        username.add("Erasyl");

        surname = new ArrayList<String>();
        surname.add("Ibraimov");
        surname.add("Erlanov");

        phone = new ArrayList<String>();
        phone.add("87078753095");
        phone.add("87083643742");

        home_phone = new ArrayList<String>();
        home_phone.add("87273364363");
        home_phone.add("87273646333");

        address = new ArrayList<String>();
        address.add("Tole bi, 80");
        address.add("Kazybek bi, 34");
}
}
