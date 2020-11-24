package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.DuLinkedNode;

/**
 * @Description:    双向链表
 * @Author:         Webb Dong
 * @CreateDate:     2018/12/24 16:35
 * @UpdateUser:     Webb Dong
 * @UpdateDate:     2018/12/24 16:35
 * @UpdateRemark:
 * @Version:        1.0.0
 */
public class DuLinkedList<T> {

    /**
     * 头节点
     */
    private DuLinkedNode<T> head;

    /**
     * 尾结点
     */
    private DuLinkedNode<T> last;

    public DuLinkedNode<T> getHead() {
        return head;
    }

    public DuLinkedNode<T> getLast() {
        return last;
    }

    /**
     * 根据索引查找
     * @param index
     * @return
     */
    public DuLinkedNode<T> findByIndex(int index) {
        int i = 0;
        DuLinkedNode<T> current = head;
        while (current != null) {
            if (i == index) {
                return current;
            }
            i++;
            current = current.getNext();
        }
        return null;
    }

    /**
     * 根据值查找
     * @param data
     * @return
     */
    public DuLinkedNode<T> findByValue(T data) {
        DuLinkedNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        }
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
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
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
        } else {
            newNode.setPrevious(last);
            last.setNext(newNode);
            last = newNode;
        }
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
        DuLinkedNode<T> pre = null;
        while (current != null && current != node && !current.getData().equals(newNode.getData())) {
            pre = current;
            current = current.getNext();
        }

        if (current == null) {
            return;
        }

        newNode.setNext(current);
        current.setPrevious(newNode);
        if (pre == null) {
            head = newNode;
        } else {
            pre.setNext(newNode);
            newNode.setPrevious(pre);
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
        while (current != null && current != node && !current.getData().equals(node.getData())) {
            current = current.getNext();
        }

        if (current == null) {
            return;
        }

        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        if (current == last || current.getData().equals(last.getData())) {
            last = newNode;
        } else {
            current.getNext().setPrevious(newNode);
        }
        current.setNext(newNode);
    }

    /**
     * 删除指定索引的节点
     * @param index
     */
    public void deleteByIndex(int index) {
        DuLinkedNode<T> current = head;
        for (int i = 0; current != null; i++, current = current.getNext()) {
            if (i == index) {
                deleteNode(current);
                break;
            }
        }
    }

    /**
     * 根据指定的值删除节点
     * @param value
     */
    public void deleteByValue(T value) {
        DuLinkedNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(value)) {
                deleteNode(current);
                break;
            }
            current = current.getNext();
        }
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
        while (current != null) {
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * 遍历指定尾节点的链表，打印所有元素
     * @param last
     */
    public void printAllElementStartLast(DuLinkedNode<T> last) {
        DuLinkedNode<?> current = last;
        System.out.print("printAllElementStartLast：");
        while (current != null) {
            System.out.print(current.getData() + ", ");
            current = current.getPrevious();
        }
        System.out.println();
    }

    /**
     * 反转链表，直接修改原链表
     * @return
     */
    public DuLinkedNode<T> inverse() {
        DuLinkedNode<T> current = head;
        DuLinkedNode<T> temp;
        DuLinkedNode<T> next;
        while (current != null) {
            next = current.getNext();
            temp = current.getPrevious();
            current.setPrevious(next);
            current.setNext(temp);
            current = next;
        }
        temp = head;
        head = last;
        last = temp;
        return head;
    }

    /**
     * 删除指定的节点
     * @param current
     */
    public void deleteNode(DuLinkedNode<T> current) {
        if (current == head || current.getData().equals(head.getData())) {
            // 删除头节点
            head = current.getNext();
            head.setPrevious(null);
        } else if (current == last || current.getData().equals(last.getData())) {
            // 删除尾节点
            last = current.getPrevious();
            last.setNext(null);
        } else {
            current.getPrevious().setNext(current.getNext());
        }
        current.setPrevious(null);
        current.setNext(null);
    }

    public static void main(String[] args) {
        System.out.println("----------------- insertToHead -------------------");
        DuLinkedList<Integer> list1 = new DuLinkedList<>();
        list1.insertToHead(10000);
        list1.insertToHead(20000);
        list1.insertToHead(30000);
        list1.insertToHead(40000);
        list1.insertToHead(50000);
        list1.insertToHead(60000);
        list1.printAllStartHead();
        list1.printAllStartLast();

        System.out.println("----------------- insertToTail -------------------");
        DuLinkedList<Integer> list2 = new DuLinkedList<>();
        list2.insertToTail(1111);
        list2.insertToTail(2222);
        list2.insertToTail(3333);
        list2.insertToTail(4444);
        list2.insertToTail(5555);
        list2.printAllStartHead();
        list2.printAllStartLast();

        System.out.println("----------------- insertBefore -------------------");
        DuLinkedNode<Integer> node1 = list2.findByIndex(0);
        list2.insertBefore(node1, 9999);
        list2.printAllStartHead();
        list2.printAllStartLast();

        DuLinkedNode<Integer> node2 = list2.findByValue(5555);
        list2.insertBefore(node2, 6666);
        list2.printAllStartHead();
        list2.printAllStartLast();

        System.out.println("----------------- insertAfter -------------------");
        DuLinkedNode<Integer> node3 = list2.findByValue(4444);
        list2.insertAfter(node3, 3399);
        list2.printAllStartHead();
        list2.printAllStartLast();

        DuLinkedNode<Integer> node4 = list2.findByIndex(0);
        list2.insertAfter(node4, 1188);
        list2.printAllStartHead();
        list2.printAllStartLast();

        DuLinkedNode<Integer> node5 = list2.findByValue(5555);
        list2.insertAfter(node5, 2277);
        list2.printAllStartHead();
        list2.printAllStartLast();

        System.out.println("----------------- deleteByIndex -------------------");
        list2.deleteByIndex(0);
        list2.printAllStartHead();
        list2.printAllStartLast();

        System.out.println("----------------- deleteByValue -------------------");
        list2.deleteByValue(2277);
        list2.printAllStartHead();
        list2.printAllStartLast();

        System.out.println("----------------- inverse -------------------");
        list2.inverse();
        list2.printAllStartHead();
        list2.printAllStartLast();
    }

}
