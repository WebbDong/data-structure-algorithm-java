package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.DuLinkedNode;

/**
 * @Description: 带头双向循环链表
 * @Author: Webb Dong
 * @CreateDate: 2019/01/08 13:43
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/01/08 13:43
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class HeadCircularDuLinkedList<T> {

    /**
     * 头节点
     */
    private DuLinkedNode<T> head = new DuLinkedNode<>();

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
        DuLinkedNode<T> current = head.getNext();
        int i = 0;
        while (current != head) {
            if (index == i) {
                return current;
            }
            current = current.getNext();
            i++;
        }
        return null;
    }

    /**
     * 根据值查找
     * @param data
     * @return
     */
    public DuLinkedNode<T> findByValue(T data) {
        DuLinkedNode<T> current = head.getNext();
        while (current != head) {
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
        if (last == null) {
            head.setNext(newNode);
            newNode.setPrevious(head);
            newNode.setNext(head);
            last = newNode;
        } else {
            head.getNext().setPrevious(newNode);
            newNode.setNext(head.getNext());
            newNode.setPrevious(head);
            head.setNext(newNode);
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
        if (last == null) {
            head.setNext(newNode);
            head.setPrevious(newNode);
            newNode.setPrevious(head);
            newNode.setNext(head);
        } else {
            last.setNext(newNode);
            newNode.setNext(head);
            newNode.setPrevious(last);
        }
        last = newNode;
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
        if (node == null || newNode == null) {
            return;
        }

        newNode.setNext(node);
        newNode.setPrevious(node.getPrevious());
        node.getPrevious().setNext(newNode);
        node.setPrevious(newNode);
        size++;
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
        if (node == null || newNode == null) {
            return;
        }

        newNode.setPrevious(node);
        newNode.setNext(node.getNext());
        node.getNext().setPrevious(newNode);
        node.setNext(newNode);
        if (node == last) {
            last = newNode;
        }
        size++;
    }

    /**
     * 删除指定索引的节点
     * @param index
     */
    public void deleteByIndex(int index) {
        DuLinkedNode<T> current = head.getNext();
        int i = 0;
        while (current != head) {
            if (i == index) {
                deleteNode(current);
                break;
            }
            current = current.getNext();
            i++;
        }
    }

    /**
     * 根据指定的值删除节点
     * @param value
     */
    public void deleteByValue(T value) {
        DuLinkedNode<T> current = head.getNext();
        while (current != head) {
            if (current.getData().equals(value)) {
                deleteNode(current);
                break;
            }
            current = current.getNext();
        }
    }

    /**
     * 反转链表，直接修改原链表
     * @return
     */
    public DuLinkedNode<T> inverse() {
        DuLinkedNode<T> current = head.getNext();
        DuLinkedNode<T> next;
        DuLinkedNode<T> temp;
        while (current != head) {
            next = current.getNext();
            temp = current.getPrevious();
            current.setPrevious(next);
            current.setNext(temp);
            current = next;
        }
        temp = head.getNext();
        head.setNext(last);
        last = temp;
        return head;
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
        DuLinkedNode<?> current = head.getNext();
        System.out.print("printAllElementStartHead：");
        while (current != head) {
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
        if (last == null) {
            return;
        }
        DuLinkedNode<?> current = last;
        System.out.print("printAllElementStartLast：");
        while (current != head) {
            System.out.print(current.getData() + ", ");
            current = current.getPrevious();
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    /**
     * 删除指定节点
     * @param node
     */
    private void deleteNode(DuLinkedNode<T> node) {
        if (node == null) {
            return;
        }

        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
        if (node == last) {
            last = node.getPrevious();
        }
        node.setPrevious(null);
        node.setNext(null);
        node.setData(null);
        size--;
    }

    public static void main(String[] args) {
        System.out.println("------------------ insertToHead -------------------");
        HeadCircularDuLinkedList<Integer> list1 = new HeadCircularDuLinkedList<>();
        list1.insertToHead(100);
        list1.insertToHead(200);
        list1.insertToHead(300);
        list1.insertToHead(400);
        list1.printAllStartHead();
        list1.printAllStartLast();

        System.out.println("------------------ findByIndex -------------------");
        DuLinkedNode<Integer> node1 = list1.findByIndex(2);
        System.out.println(node1);

        System.out.println("------------------ findByValue -------------------");
        DuLinkedNode<Integer> node2 = list1.findByValue(300);
        System.out.println(node2);

        System.out.println("------------------ insertToTail -------------------");
        HeadCircularDuLinkedList<Integer> list2 = new HeadCircularDuLinkedList<>();
        list2.insertToTail(1000);
        list2.insertToTail(2000);
        list2.insertToTail(3000);
        list2.insertToTail(4000);
        list2.printAllStartHead();
        list2.printAllStartLast();

        System.out.println("------------------ insertBefore -------------------");
        DuLinkedNode<Integer> node3 = list2.findByIndex(0);
        list2.insertBefore(node3, 5000);
        list2.printAllStartHead();
        list2.printAllStartLast();
        DuLinkedNode<Integer> node4 = list2.findByIndex(list2.getSize() - 1);
        list2.insertBefore(node4, 6000);
        list2.printAllStartHead();
        list2.printAllStartLast();

        System.out.println("------------------ insertAfter -------------------");
        DuLinkedNode<Integer> node5 = list2.findByIndex(0);
        list2.insertAfter(node5, 7000);
        list2.printAllStartHead();
        list2.printAllStartLast();
        DuLinkedNode<Integer> node6 = list2.findByIndex(list2.getSize() - 1);
        list2.insertAfter(node6, 8000);
        list2.printAllStartHead();
        list2.printAllStartLast();

        System.out.println("------------------ deleteByIndex -------------------");
        list2.deleteByIndex(0);
        list2.printAllStartHead();
        list2.printAllStartLast();
        list2.deleteByIndex(list2.getSize() - 1);
        list2.printAllStartHead();
        list2.printAllStartLast();

        System.out.println("------------------ deleteByValue -------------------");
        list2.deleteByValue(1000);
        list2.printAllStartHead();
        list2.printAllStartLast();

        System.out.println("------------------ inverse -------------------");
        list2.inverse();
        list2.printAllStartHead();
        list2.printAllStartLast();
    }

}
