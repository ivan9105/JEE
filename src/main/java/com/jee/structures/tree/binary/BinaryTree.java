package com.jee.structures.tree.binary;

import org.apache.commons.lang.BooleanUtils;

import javax.annotation.Nullable;
import java.util.Stack;

/**
 * Created by Иван on 15.03.2017.
 */
public class BinaryTree<V> {
    private static final Integer BLANK_SIZE = 32;

    private Node<V> root;

    @Nullable
    public Node find(long key) {
        Node<V> current = root;
        while (current.getKey() != key) {
            if (key < current.getKey()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(long key, V value) {
        Node<V> node = new Node<>();
        node.setKey(key);
        node.setValue(value);

        if (root == null) {
            this.root = node;
        } else {
            Node<V> current = root;
            Node<V> parent;
            while (true) {
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(node);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(node);
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(long key) {
        if (root == null) {
            return false;
        }

        Node<V> current = root;
        Node<V> parent = root;
        boolean isLeftChild = true;
        while (current.getKey() != key) {
            parent = current;
            if (key < current.getKey()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) {
                return false;
            }
        }

        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {
                this.root = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (current.getRightChild() == null) {
            if (current == root) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            Node<V> successor = getSuccessor(current);

            if (current == root) {
                this.root = successor;
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }

            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    private Node<V> getSuccessor(Node<V> deleteNode) {
        Node<V> successorParent = deleteNode;
        Node<V> successor = deleteNode;
        Node<V> current = deleteNode.getRightChild();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != deleteNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(deleteNode.getRightChild());
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPre order traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nIn order traversal:  ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPost order traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    public void displayTree() {
        if (root == null) {
            return;
        }

        Stack<Node<V>> mainStack = new Stack<>();
        mainStack.push(root);
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        int nBlanks = BLANK_SIZE;
        while (BooleanUtils.isFalse(isRowEmpty)) {
            Stack<Node<V>> localStack = new Stack<>();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }

            while (!mainStack.isEmpty()) {
                Node<V> temp = mainStack.pop();
                if (temp != null) {
                    System.out.print(temp.getKey());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());

                    if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty()) {
                mainStack.push(localStack.pop());
            }
        }
        System.out.println("......................................................");
    }

    private void preOrder(Node<V> node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    private void inOrder(Node<V> node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            System.out.print(node.getKey() + " ");
            inOrder(node.getRightChild());
        }
    }

    private void postOrder(Node<V> node) {
        if (node != null) {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.print(node.getKey() + " ");
        }
    }
}
