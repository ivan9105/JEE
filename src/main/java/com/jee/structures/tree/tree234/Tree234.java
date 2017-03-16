package com.jee.structures.tree.tree234;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 16.03.2017.
 */
public class Tree234 {
    private Node root = new Node();

    public int find(long key) {
        Node currentNode = root;
        int index;
        while (true) {
            if (currentNode == null) {
                return -1;
            } else if ((index = currentNode.findItem(key)) != -1) {
                return index;
            } else if (currentNode.isLeaf()) {
                return -1;
            } else {
                currentNode = getNextChild(currentNode, key);
            }
        }
    }

    public void insert(long value) {
        Node currentNode = root;
        Item temp = new Item(value);

        while (true) {
            if (currentNode == null) {
                break;
            } else if (currentNode.isFull()) {
                split(currentNode);
                currentNode = getNextChild(currentNode.getParent(), value);
            } else if (currentNode.isLeaf()) {
                break;
            } else {
                currentNode = getNextChild(currentNode, value);
            }
        }

        if (currentNode != null) {
            currentNode.insertItem(temp);
        }
    }

    public boolean remove(long key) {
        Node target = findNode(key, root);
        if (target != null) {
            List<Long> keys = new ArrayList<>();
            collectKeys(target, keys, key);
            if (target != root) {
                Node parent = target.getParent();
                parent.removeChild(target);
                for (Long key_ : keys) {
                    insert(key_);
                }
            } else {
                root = new Node();
                for (Long key_ : keys) {
                    insert(key_);
                }
            }
        }
        return false;
    }

    private void collectKeys(Node node, List<Long> keys, long removed) {
        Item[] items = node.getItems();
        for (Item item : items) {
            if (item != null && item.getKey() != removed) {
                keys.add(item.getKey());
            }
        }

        for (Node child : node.getChildArray()) {
            if (child != null) {
                collectKeys(child, keys, removed);
            }
        }
    }

    @Nullable
    private Node findNode(long key, Node node) {
        if (node.findItem(key) != -1) {
            return node;
        } else {
            for (Node child : node.getChildArray()) {
                if (child != null) {
                    return findNode(key, child);
                }
            }
        }
        return null;
    }

    public void displayTree() {
        System.out.println("......................................................");
        recDisplayTree(root, 0, 0);
        System.out.println("......................................................");
    }

    private void recDisplayTree(Node node, int level, int index) {
        System.out.print("level=" + level + " child=" + index + " ");
        node.displayNode();
        int numItems = node.getNumber();
        for (int j = 0; j < numItems + 1; j++) {
            Node nextNode = node.getChild(j);
            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, j);
            } else {
                return;
            }
        }
    }

    private void split(Node node) {
        Item thirdItem = node.removeLastItem();
        Item secondItem = node.removeLastItem();
        Node secondChild = node.disconnectChild(2);
        Node thirdChild = node.disconnectChild(3);
        Node parent;

        Node newRightNode = new Node();
        if (node == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, node);
        } else {
            parent = node.getParent();
        }

        int index = parent.insertItem(secondItem);
        int number = parent.getNumber();

        for (int i = number - 1; i > index; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i + 1, temp);
        }
        parent.connectChild(index + 1, newRightNode);

        newRightNode.insertItem(thirdItem);
        newRightNode.connectChild(0, secondChild);
        newRightNode.connectChild(1, thirdChild);
    }

    @Nullable
    private Node getNextChild(Node node, long value) {
        for (int i = 0; i < node.getNumber(); i++) {
            if (value < node.getItem(i).getKey()) {
                return node.getChild(i);
            }
        }
        return node.getChild(node.getNumber() - 1);
    }
}
