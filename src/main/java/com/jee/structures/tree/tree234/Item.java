package com.jee.structures.tree.tree234;

/**
 * Created by Иван on 15.03.2017.
 */
public class Item {
    public Item(long key) {
        this.key = key;
    }

    private long key;

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public void display() {
        System.out.print("/" + key);
    }
}
