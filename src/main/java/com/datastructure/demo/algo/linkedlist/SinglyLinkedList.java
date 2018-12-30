package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.NormalNode;

/**
 * @Description:    单链表
 * @Author:         Webb Dong
 * @CreateDate:     2018/12/24 16:35
 * @UpdateUser:     Webb Dong
 * @UpdateDate:     2018/12/24 16:35
 * @UpdateRemark:
 * @Version:        1.0.0
 */
public class SinglyLinkedList<T> {

    /**
     * 头节点
     */
    private NormalNode<T> head;

    /**
     * 尾结点
     */
    private NormalNode<T> last;

    /**
     * 根据索引查找
     * @param index
     * @return
     */
    public NormalNode<T> findByIndex(int index) {
        int i = 0;
        NormalNode<T> currentNode = head;
        while (currentNode != null) {
            if (index == i) {
                return currentNode;
            }
            i++;
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /**
     * 根据值查找
     * @param data
     * @return
     */
    public NormalNode<T> findByValue(T data) {
        NormalNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == data
                    || (data != null && data.equals(currentNode.getData()))) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /**
     * 插入到头部
     * @param data
     */
    public void insertToHead(T data) {
        NormalNode<T> newNode = new NormalNode<>(data);
        insertToHead(newNode);
    }

    /**
     * 插入到头部
     * @param newNode
     */
    public void insertToHead(NormalNode<T> newNode) {
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    /**
     * 插入到尾部
     * @param data
     */
    public void insertToTail(T data) {
        NormalNode<T> newNode = new NormalNode<>(data);
        insertToTail(newNode);
    }

    /**
     * 插入到尾部
     * @param newNode
     */
    public void insertToTail(NormalNode<T> newNode) {
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    /**
     * 插入到指定元素之前
     * @param node
     * @param data
     */
    public void insertBefore(NormalNode<T> node, T data) {
        NormalNode<T> newNode = new NormalNode<>(data);
        insertBefore(node, newNode);
    }

    /**
     * 插入到指定元素之前
     * @param node
     * @param newNode
     */
    public void insertBefore(NormalNode<T> node, NormalNode<T> newNode) {
        if (node == null || newNode == null || head == null) {
            return;
        }

        NormalNode<T> currentNode = head;
        NormalNode<T> preNode = null;
        while (currentNode != null && !node.getData().equals(currentNode.getData())) {
            preNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            return;
        }

        if (preNode == null) {
            newNode.setNext(currentNode);
            head = newNode;
        } else {
            newNode.setNext(preNode.getNext());
            preNode.setNext(newNode);
        }
    }

    /**
     * 插入到指定元素之后
     * @param node
     * @param data
     */
    public void insertAfter(NormalNode<T> node, T data) {
        NormalNode<T> newNode = new NormalNode<>(data);
        insertAfter(node, newNode);
    }

    /**
     * 插入到指定元素之后
     * @param node
     * @param newNode
     */
    public void insertAfter(NormalNode<T> node, NormalNode<T> newNode) {
        if (node == null || newNode == null) {
            return;
        }
        newNode.setNext(node.getNext());
        node.setNext(newNode);
        if (node == last || node.getData().equals(last.getData())) {
            last = newNode;
        }
    }

    /**
     * 删除指定索引的节点
     * @param index
     */
    public void deleteByIndex(int index) {
        if (head == null) {
            return;
        }

        NormalNode<T> currentNode = head;
        NormalNode<T> preNode = null;

        for (int i = 0; currentNode != null && i != index; i++) {
            preNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            return;
        }

        deleteNode(currentNode, preNode);
    }

    /**
     * 根据指定的值删除节点
     * @param value
     */
    public void deleteByValue(T value) {
        if (head == null) {
            return;
        }

        NormalNode<T> currentNode = head;
        NormalNode<T> preNode = null;
        while (currentNode != null && !currentNode.getData().equals(value)) {
            preNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            return;
        }

        deleteNode(currentNode, preNode);
    }

    /**
     * 删除指定的节点
     * @param node
     */
    public void deleteByNode(NormalNode<T> node) {
        if (head == null) {
            return;
        }

        deleteByValue(node.getData());
    }

    /**
     * 反转链表，直接修改原链表
     */
    public NormalNode<T> inverse() {
        // 遍历的当前节点
        NormalNode<T> current = head;
        // 遍历的下一个节点
        NormalNode<T> next;
        // 新头节点
        NormalNode<T> newHead = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(newHead);
            newHead = current;
            current = next;
        }
        last = head;
        head = newHead;
        return newHead;
    }

    /**
     * 反转链表，返回反转后的新头节点，不修改原链表
     * @return
     */
    public NormalNode<T> inverseLinkedList() {
        // 遍历的当前节点
        NormalNode<T> current = head;
        // 遍历的下一个节点
        NormalNode<T> next;
        // 新头节点
        NormalNode<T> newHead = null;
        // 新当前节点
        NormalNode<T> newCurrent;
        while (current != null) {
            next = current.getNext();
            newCurrent = new NormalNode<>(current.getData());
            newCurrent.setNext(newHead);
            newHead = newCurrent;
            current = next;
        }
        return newHead;
    }

    /**
     * 打印所有元素
     */
    public void printAll() {
        printAllElement(head);
    }

    public void printHeadAndLast() {
        System.out.println("head.getData()=" + head.getData());
        System.out.println("last.getData()=" + last.getData());
    }

    /**
     * 遍历指定头节点的链表，打印所有元素
     * @param head
     */
    public static void printAllElement(NormalNode<?> head) {
        NormalNode<?> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + ", ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    /**
     * 删除节点
     * @param currentNode
     * @param preNode
     */
    private void deleteNode(NormalNode<T> currentNode, NormalNode<T> preNode) {
        if (preNode == null) {
            head = currentNode.getNext();
            currentNode.setNext(null);
        } else {
            preNode.setNext(currentNode.getNext());
            currentNode.setNext(null);
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------- insertToHead -----------------");
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.insertToHead(100);
        list1.insertToHead(200);
        list1.insertToHead(300);
        list1.printAll();

        System.out.println("-------------- insertToTail -----------------");
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.insertToTail(700);
        list2.insertToTail(800);
        list2.insertToTail(900);
        list2.insertToTail(2000);
        list2.insertToTail(4000);
        list2.insertToTail(6000);
        list2.printAll();

        System.out.println("-------------- find -----------------");
        NormalNode<Integer> node1 = list2.findByIndex(1);
        System.out.println("list2.findByIndex(1) = " + node1);

        NormalNode<Integer> node2 = list2.findByValue(900);
        System.out.println("list2.findByValue(900) = " + node2);

        System.out.println("-------------- insertAfter -----------------");
        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();
        list3.insertToHead(2000);
        list3.insertToHead(3000);
        list3.insertToHead(4000);
        NormalNode<Integer> node3 = list3.findByIndex(0);
        list3.insertAfter(node3, 7000);
        list3.printAll();
        list3.printHeadAndLast();
        NormalNode<Integer> node10 = list3.findByValue(2000);
        list3.insertAfter(node10, 5678);
        list3.printAll();
        list3.printHeadAndLast();

        System.out.println("-------------- insertBefore -----------------");
        NormalNode<Integer> node4 =  list3.findByIndex(1);
        list3.insertBefore(node4, 50000);
        list3.printAll();
        NormalNode<Integer> node11 = list3.findByIndex(0);
        list3.insertBefore(node11, 60000);
        list3.printAll();
        list3.printHeadAndLast();
        NormalNode<Integer> node12 = list3.findByValue(5678);
        list3.insertBefore(node12, 70000);
        list3.printAll();
        list3.printHeadAndLast();

        System.out.println("-------------- deleteByIndex -----------------");
        list3.deleteByIndex(1);
        list3.printAll();

        System.out.println("-------------- deleteByValue -----------------");
        list3.deleteByValue(2000);
        list3.printAll();

        System.out.println("-------------- deleteByNode -----------------");
        NormalNode<Integer> deleteNode = new NormalNode<>(50000);
        list3.deleteByNode(deleteNode);
        list3.printAll();

        System.out.println("-------------- inverse -----------------");
        list2.printAll();
        list2.printHeadAndLast();
        list2.inverse();
        list2.printAll();
        list2.printHeadAndLast();

        System.out.println("-------------- inverseLinkList -----------------");
        NormalNode<Integer> newHead = list2.inverseLinkedList();
        list2.printAll();
        printAllElement(newHead);
        list2.printAll();
    }

}
