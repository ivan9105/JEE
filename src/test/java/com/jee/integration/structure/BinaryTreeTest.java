package com.jee.integration.structure;

import com.jee.structures.tree.binary.BinaryTree;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Иван on 15.03.2017.
 */
public class BinaryTreeTest {
    @Test
    public void doWork() {
        BinaryTree<Double> tree = new BinaryTree<>();
        tree.insert(50, 1.5);
        tree.insert(25, 1.2);
        tree.insert(75, 1.7);
        tree.insert(12, 1.5);
        tree.insert(37, 1.2);
        tree.insert(43, 1.7);
        tree.insert(30, 1.5);
        tree.insert(33, 1.2);
        tree.insert(87, 1.7);
        tree.insert(93, 1.5);
        tree.insert(97, 1.5);

        tree.displayTree();

        Assert.assertEquals(tree.find(50).getValue(), 1.5);

        tree.delete(37);

        tree.displayTree();

        Assert.assertEquals(tree.find(25).getRightChild().getValue(), 1.7);
    }
}
