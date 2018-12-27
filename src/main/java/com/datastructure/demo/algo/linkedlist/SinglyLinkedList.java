package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.SinglyNode;

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
    private SinglyNode<T> head;

    /**
     * 尾结点
     */
    private SinglyNode<T> last;

    /**
     * 根据索引查找
     * @param index
     * @return
     */
    public SinglyNode<T> findByIndex(int index) {
        int i = 0;
        SinglyNode<T> currentNode = head;
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
    public SinglyNode<T> findByValue(T data) {
        SinglyNode<T> currentNode = head;
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
        SinglyNode<T> newNode = new SinglyNode<>(data);
        insertToHead(newNode);
    }

    /**
     * 插入到头部
     * @param newNode
     */
    public void insertToHead(SinglyNode<T> newNode) {
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
        SinglyNode<T> newNode = new SinglyNode<>(data);
        insertToTail(newNode);
    }

    /**
     * 插入到尾部
     * @param newNode
     */
    public void insertToTail(SinglyNode<T> newNode) {
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
    public void insertBefore(SinglyNode<T> node, T data) {
        SinglyNode<T> newNode = new SinglyNode<>(data);
        insertBefore(node, newNode);
    }

    /**
     * 插入到指定元素之前
     * @param node
     * @param newNode
     */
    public void insertBefore(SinglyNode<T> node, SinglyNode<T> newNode) {
        if (node == null || newNode == null || head == null) {
            return;
        }

        SinglyNode<T> currentNode = head;
        SinglyNode<T> preNode = null;
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
    public void insertAfter(SinglyNode<T> node, T data) {
        SinglyNode<T> newNode = new SinglyNode<>(data);
        insertAfter(node, newNode);
    }

    /**
     * 插入到指定元素之后
     * @param node
     * @param newNode
     */
    public void insertAfter(SinglyNode<T> node, SinglyNode<T> newNode) {
        if (node == null || newNode == null) {
            return;
        }
        newNode.setNext(node.getNext());
        node.setNext(newNode);
    }

    /**
     * 删除指定索引的节点
     * @param index
     */
    public void deleteByIndex(int index) {
        if (head == null) {
            return;
        }

        SinglyNode<T> currentNode = head;
        SinglyNode<T> preNode = null;

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

        SinglyNode<T> currentNode = head;
        SinglyNode<T> preNode = null;
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
    public void deleteByNode(SinglyNode<T> node) {
        if (head == null) {
            return;
        }

        deleteByValue(node.getData());
    }

    /**
     * 反转链表，直接修改原链表
     */
    public SinglyNode<T> inverse() {
        // 遍历的当前节点
        SinglyNode<T> current = head;
        // 遍历的下一个节点
        SinglyNode<T> next;
        // 新头节点
        SinglyNode<T> newHead = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(newHead);
            newHead = current;
            current = next;
        }
        head = newHead;
        return newHead;
    }

    /**
     * 反转链表，返回反转后的新头节点，不修改原链表
     * @return
     */
    public SinglyNode<T> inverseLinkedList() {
        // 遍历的当前节点
        SinglyNode<T> current = head;
        // 遍历的下一个节点
        SinglyNode<T> next;
        // 新头节点
        SinglyNode<T> newHead = null;
        // 新当前节点
        SinglyNode<T> newCurrent;
        while (current != null) {
            next = current.getNext();
            newCurrent = new SinglyNode<>(current.getData());
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

    /**
     * 遍历指定头节点的链表，打印所有元素
     * @param head
     */
    public static void printAllElement(SinglyNode<?> head) {
        SinglyNode<?> currentNode = head;
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
    private void deleteNode(SinglyNode<T> currentNode, SinglyNode<T> preNode) {
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
        SinglyNode<Integer> node1 = list2.findByIndex(1);
        System.out.println("list2.findByIndex(1) = " + node1);

        SinglyNode<Integer> node2 = list2.findByValue(900);
        System.out.println("list2.findByValue(900) = " + node2);

        System.out.println("-------------- insertAfter -----------------");
        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();
        list3.insertToHead(2000);
        list3.insertToHead(3000);
        list3.insertToHead(4000);
        SinglyNode<Integer> node3 = list3.findByIndex(0);
        list3.insertAfter(node3, 7000);
        list3.printAll();

        System.out.println("-------------- insertBefore -----------------");
        SinglyNode<Integer> node4 =  list3.findByIndex(0);
        list3.insertBefore(node4, 50000);
        list3.printAll();

        System.out.println("-------------- deleteByIndex -----------------");
        list3.deleteByIndex(1);
        list3.printAll();

        System.out.println("-------------- deleteByValue -----------------");
        list3.deleteByValue(2000);
        list3.printAll();

        System.out.println("-------------- deleteByNode -----------------");
        SinglyNode<Integer> deleteNode = new SinglyNode<>(50000);
        list3.deleteByNode(deleteNode);
        list3.printAll();

        System.out.println("-------------- inverse -----------------");
        list2.printAll();
        list2.inverse();
        list2.printAll();

        System.out.println("-------------- inverseLinkList -----------------");
        SinglyNode<Integer> newHead = list2.inverseLinkedList();
        list2.printAll();
        printAllElement(newHead);
        list2.printAll();
    }

}
