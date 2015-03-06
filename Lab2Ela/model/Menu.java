package model;

import java.util.ArrayList;

public class Menu {

    private ArrayList<MenuItem> list;

    public Menu() {
        this.list = new ArrayList<MenuItem>();

        this.list.add(new MenuItem("Main", "/main"));
        this.list.add(new MenuItem("Photos", "/gallery"));
        this.list.add(new MenuItem("Contact", "/contact"));
    }

    public ArrayList<MenuItem> getList() {
        return list;
    }
}
