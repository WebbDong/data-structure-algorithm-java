package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.DuLinkedNode;

/**
 * @Description: 双向循环链表
 * @Author: Webb Dong
 * @CreateDate: 2019/01/02 10:50
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/01/02 10:50
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class CircularDuLinkedList<T> {

    /**
     * 头节点
     */
    private DuLinkedNode<T> head;

    /**
     * 尾结点
     */
    private DuLinkedNode<T> last;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 根据索引查找
     * @param index
     * @return
     */
    public DuLinkedNode<T> findByIndex(int index) {
        DuLinkedNode<T> current = head;
        int i = 0;
        do {
            if (i == index) {
                return current;
            }
            current = current.getNext();
            i++;
        } while (current != head);
        return null;
    }

    /**
     * 根据值查找
     * @param data
     * @return
     */
    public DuLinkedNode<T> findByValue(T data) {
        DuLinkedNode<T> current = head;
        do {
            if (data.equals(current.getData())) {
                return current;
            }
            current = current.getNext();
        } while (current != head);
        return null;
    }

    /**
     * 插入到头部
     * @param data
     */
    public void insertToHead(T data) {
        DuLinkedNode<T> newNode = new DuLinkedNode<>(data);
        insertToHead(newNode);
    }

    /**
     * 插入到头部
     * @param newNode
     */
    public void insertToHead(DuLinkedNode<T> newNode) {
        if (head == null) {
            head = newNode;
            last = newNode;
            head.setNext(newNode);
            head.setPrevious(newNode);
        } else {
            newNode.setNext(head);
            newNode.setPrevious(last);
            head.setPrevious(newNode);
            head = newNode;
            last.setNext(head);
        }
        size++;
    }

    /**
     * 插入到尾部
     * @param data
     */
    public void insertToTail(T data) {
        DuLinkedNode<T> newNode = new DuLinkedNode<>(data);
        insertToTail(newNode);
    }

    /**
     * 插入到尾部
     * @param newNode
     */
    public void insertToTail(DuLinkedNode<T> newNode) {
        if (head == null) {
            head = newNode;
            last = newNode;
            head.setNext(newNode);
            head.setPrevious(newNode);
        } else {
            last.setNext(newNode);
            newNode.setPrevious(last);
            newNode.setNext(head);
            head.setPrevious(newNode);
            last = newNode;
        }
        size++;
    }

    /**
     * 插入到指定元素之前
     * @param node
     * @param data
     */
    public void insertBefore(DuLinkedNode<T> node, T data) {
        DuLinkedNode<T> newNode = new DuLinkedNode<>(data);
        insertBefore(node, newNode);
    }

    /**
     * 插入到指定元素之前
     * @param node
     * @param newNode
     */
    public void insertBefore(DuLinkedNode<T> node, DuLinkedNode<T> newNode) {
        if (node == null || newNode == null || head == null) {
            return;
        }

        DuLinkedNode<T> current = head;
        DuLinkedNode<T> pre;
        do {
            pre = current;
            current = current.getNext();
        } while (current != head && current != node && !current.getData().equals(node.getData()));

        if (current == head) {
            return;
        }


    }

    /**
     * 插入到指定元素之后
     * @param node
     * @param data
     */
    public void insertAfter(DuLinkedNode<T> node, T data) {
        DuLinkedNode<T> newNode = new DuLinkedNode<>(data);
        insertAfter(node, newNode);
    }

    /**
     * 插入到指定元素之后
     * @param node
     * @param newNode
     */
    public void insertAfter(DuLinkedNode<T> node, DuLinkedNode<T> newNode) {
        if (node == null || newNode == null || head == null) {
            return;
        }

        DuLinkedNode<T> current = head;

    }

    /**
     * 删除指定索引的节点
     * @param index
     */
    public void deleteByIndex(int index) {
        DuLinkedNode<T> current = head;
        int i = 0;
        do {
            if (i == index) {
                deleteNode(current);
                break;
            }
            current = current.getNext();
            i++;
        } while (current != head);
    }

    /**
     * 根据指定的值删除节点
     * @param value
     */
    public void deleteByValue(T value) {
        DuLinkedNode<T> current = head;
        do {
            if (current.getData().equals(value)) {
                deleteNode(current);
                break;
            }
            current = current.getNext();
        } while (current != head);
    }

    public void printAllStartHead() {
        printAllElementStartHead(head);
    }

    public void printAllStartLast() {
        printAllElementStartLast(last);
    }

    /**
     * 遍历指定头节点的链表，打印所有元素
     * @param head
     */
    public static void printAllElementStartHead(DuLinkedNode<?> head) {
        DuLinkedNode<?> current = head;
        System.out.print("printAllElementStartHead：");
        do {
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        } while (current != head);
        System.out.println();
    }

    /**
     * 遍历指定尾节点的链表，打印所有元素
     * @param last
     */
    public void printAllElementStartLast(DuLinkedNode<T> last) {
        DuLinkedNode<?> current = last;
        System.out.print("printAllElementStartLast：");
        do {
            System.out.print(current.getData() + ", ");
            current = current.getPrevious();
        } while (current != last);
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    /**
     * 删除节点
     * @param current
     */
    private void deleteNode(DuLinkedNode<T> current) {
        if (current == head) {
            head = current.getNext();
            head.setPrevious(last);
            last.setNext(head);
        } else if (current == last) {
            last = current.getPrevious();
            head.setPrevious(last);
            last.setNext(head);
        } else {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        }
        current.setNext(null);
        current.setPrevious(null);
    }

    public static void main(String[] args) {
        System.out.println("------------------ insertToHead -------------------");
        CircularDuLinkedList<Integer> list1 = new CircularDuLinkedList<>();
        list1.insertToHead(100000);
        list1.insertToHead(200000);
        list1.insertToHead(300000);
        list1.insertToHead(400000);
        list1.insertToHead(500000);
        list1.insertToHead(600000);
        list1.printAllStartHead();
        list1.printAllStartLast();
        System.out.println("size=" + list1.getSize());

        System.out.println("------------------ insertToTail -------------------");
        CircularDuLinkedList<String> list2 = new CircularDuLinkedList<>();
        list2.insertToTail("Ferrari");
        list2.insertToTail("Lamborghini");
        list2.insertToTail("Pagani");
        list2.insertToTail("BMW");
        list2.insertToTail("BENZ");
        list2.printAllStartHead();
        list2.printAllStartLast();
        System.out.println("size=" + list2.getSize());

        System.out.println("------------------ findByIndex -------------------");
        DuLinkedNode<String> node1 = list2.findByIndex(0);
        System.out.println("findByIndex(0)=" + node1.getData());

        System.out.println("------------------ findByValue -------------------");
        DuLinkedNode<String> node2 = list2.findByValue("BMW");
        System.out.println("findByValue(\"BMW\")=" + node2.getData());

        System.out.println("------------------ deleteByIndex -------------------");
//        list1.deleteByIndex(1);
        list1.deleteByIndex(5);
        list1.printAllStartHead();
        list1.printAllStartLast();

        System.out.println("------------------ deleteByValue -------------------");
        list1.deleteByValue(400000);
        list1.printAllStartHead();
        list1.printAllStartLast();
    }

}
