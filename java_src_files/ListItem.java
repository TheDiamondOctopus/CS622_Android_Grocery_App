package com.example.tech.cs622_hw4_t8;

public class ListItem {
    private String head;
    private String desc;
    private int photo;

    public ListItem() {
    }

    public ListItem(String head, String desc, int photo) {
        this.head = head;
        this.desc = desc;
        this.photo = photo;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public int getPhoto() { return photo; }
}
