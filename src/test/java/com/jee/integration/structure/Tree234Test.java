package com.jee.integration.structure;

import com.jee.structures.tree.tree234.Tree234;
import org.junit.Test;

/**
 * Created by Иван on 16.03.2017.
 */
public class Tree234Test {

    @Test
    public void doWork() {
        Tree234 tree = new Tree234();

        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(30);
        tree.insert(70);

        tree.insert(51);
        tree.insert(41);
        tree.insert(61);
        tree.insert(31);
        tree.insert(71);

        tree.displayTree();

        tree.remove(71);

        tree.displayTree();
    }
}
