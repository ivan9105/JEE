package com.jee.structures.tree.binary;

/**
 * Created by Иван on 15.03.2017.
 */
public class Node<V> {
    private long key;
    private V value;
    private Node<V> leftChild;
    private Node<V> rightChild;

    public String getNodeInfo() {
        return "{" + key + ", " + value + "} ";
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<V> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<V> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<V> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<V> rightChild) {
        this.rightChild = rightChild;
    }
}
