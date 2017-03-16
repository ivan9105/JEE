package com.jee.structures.tree.tree234;

/**
 * Created by Иван on 15.03.2017.
 */
public class Node {
    private static final int MAX_SIZE = 4;
    private int number;
    private Node parent;
    private Node childArray[] = new Node[MAX_SIZE];
    private Item items[] = new Item[MAX_SIZE - 1];

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node[] getChildArray() {
        return childArray;
    }

    public void setChildArray(Node[] childArray) {
        this.childArray = childArray;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public void connectChild(int index, Node child) {
        childArray[index] = child;
        if (child != null) {
            child.setParent(this);
        }
    }

    public Node disconnectChild(int index) {
        Node temp = childArray[index];
        childArray[index] = null;
        return temp;
    }

    public Node getChild(int index) {
        return childArray[index];
    }

    public boolean isLeaf() {
        return childArray[0] == null;
    }

    public Item getItem(int index) {
        return items[index];
    }

    public boolean isFull() {
        return number == MAX_SIZE - 1;
    }

    public int findItem(long key) {
        for (int i = 0; i < MAX_SIZE - 1; i++) {
            if (items[i] == null) {
                break;
            } else if (items[i].getKey() == key) {
                return i;
            }
        }
        return -1;
    }

    public int insertItem(Item item) {
        number++;
        long key = item.getKey();

        for (int i = MAX_SIZE - 2; i >= 0; i--) {
            if (items[i] != null) {
                long itemKey = items[i].getKey();
                if (key < itemKey) {
                    items[i + 1] = items[i];
                } else {
                    items[i + 1] = item;
                    return i + 1;
                }
            }
        }

        items[0] = item;
        return 0;
    }

    public Item removeLastItem() {
        Item temp = items[number - 1];
        items[number - 1] = null;
        number--;
        return temp;
    }

    public void displayNode() {
        for (int i = 0; i < number; i++) {
            items[i].display();
        }
        System.out.println("/");
    }

    public void removeChild(Node child) {
        int index = 0;
        for (int i = 0; i < childArray.length; i++) {
            if (childArray[i] == child) {
                childArray[i] = null;
                index = i;
                break;
            }
        }

        System.arraycopy(childArray, index + 1, childArray, index, childArray.length - 1 - index);
    }
}
