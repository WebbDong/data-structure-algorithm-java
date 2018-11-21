package com.datastructure.demo.tree.binarytree;

import com.datastructure.demo.model.Person;
import com.datastructure.demo.tree.Tree;
import com.datastructure.demo.tree.TreeNode;
import lombok.Data;

/**
 * 二叉树
 * @param <T>
 */
@Data
public class BinaryTree<T extends Comparable> implements Tree<T> {

    private TreeNode<T> root;

    public TreeNode find(T data) {
        return null;
    }

    public boolean insert(T data) {
        TreeNode<T> newNode = new TreeNode<T>(data);
        // 如果是空树，直接赋值给root
        if (root == null) {
            root = newNode;
            return true;
        }
        TreeNode<T> currentNode = root;
        TreeNode<T> parentNode;
        boolean isLeft;
        while (currentNode != null) {
            parentNode = currentNode;
            // 插入的数据小于当前值，取左子树
            if (currentNode.getData().compareTo(newNode.getData()) > 0) {
                currentNode = currentNode.getLeftChild();
                isLeft = true;
            } else {
                // 插入的数据大于当前值，取右子树
                currentNode = currentNode.getRightChild();
                isLeft = false;
            }

            if (currentNode == null) {
                if (isLeft) {
                    parentNode.setLeftChild(newNode);
                } else {
                    parentNode.setRightChild(newNode);
                }
                return true;
            }
        }
        return false;
    }

    public boolean delete(T data) {
        return false;
    }

    public void traversePrint() {

    }

    // ------------------------------------- test --------------------------------------

    public static void main(String[] args) {
        testInsert();
    }

    public static void testInsert() {
        Tree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(25);
        tree.insert(23);
        tree.insert(18);
        tree.insert(30);
        tree.insert(28);
        tree.insert(7);
        tree.insert(43);
        tree.insert(9);
        System.out.println(tree);

        Tree<Person> tree2 = new BinaryTree<Person>();
        tree2.insert(new Person(25, "person1"));
        tree2.insert(new Person(23, "person2"));
        tree2.insert(new Person(18, "person3"));
        tree2.insert(new Person(30, "person4"));
        tree2.insert(new Person(28, "person5"));
        tree2.insert(new Person(7, "person6"));
        tree2.insert(new Person(43, "person7"));
        tree2.insert(new Person(9, "person8"));
        System.out.println(tree2);
    }

}