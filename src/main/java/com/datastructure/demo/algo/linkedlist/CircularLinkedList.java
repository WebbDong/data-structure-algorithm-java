package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.NormalNode;

/**
 * @Description: 循环链表
 * @Author: Webb Dong
 * @CreateDate: 2018/12/28 10:28
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2018/12/28 10:28
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class CircularLinkedList<T extends Comparable<T>> {

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
        if (currentNode != null) {
            do {
                if (index == i) {
                    return currentNode;
                }
                i++;
                currentNode = currentNode.getNext();
            } while (currentNode != head);
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
        if (currentNode != null) {
            do {
                if (currentNode.getData() == data
                        || (data != null && data.equals(currentNode.getData()))) {
                    return currentNode;
                }
                currentNode = currentNode.getNext();
            } while (currentNode.getData() != head);
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
            newNode.setNext(newNode);
            head = newNode;
            last = newNode;
        } else {
            newNode.setNext(head);
            last.setNext(newNode);
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
            newNode.setNext(newNode);
            head = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setNext(head);
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

        NormalNode<T> current = head;
        NormalNode<T> pre = null;
        boolean isFinded = false;

        while (true) {
            if (current == node || current.getData().equals(node.getData())) {
                isFinded = true;
                break;
            }
            pre = current;
            current = current.getNext();
            if (current == head) {
                break;
            }
        }

        if (!isFinded) {
            return;
        }

        if (pre == null) {
            newNode.setNext(head);
            head = newNode;
            last.setNext(newNode);
        } else {
            newNode.setNext(current);
            pre.setNext(newNode);
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
        if (node == null || newNode == null || head == null) {
            return;
        }

        NormalNode<T> current = head;
        do {
            current = current.getNext();
        } while (current != head && current != node && !current.getData().equals(node.getData()));

        if (current == null) {
            return;
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        if (current == last || current.getData().equals(last.getData())) {
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

        NormalNode<T> current = head;
        NormalNode<T> pre = null;
        int i = 0;
        do {
            if (i == index) {
                deleteNode(current, pre);
                break;
            }
            pre = current;
            current = current.getNext();
            i++;
        } while (current != head);
    }

    /**
     * 根据指定的值删除节点
     * @param value
     */
    public void deleteByValue(T value) {
        if (head == null) {
            return;
        }

        NormalNode<T> current = head;
        NormalNode<T> pre = null;
        do {
            if (current.getData().equals(value)) {
                deleteNode(current, pre);
                break;
            }
            pre = current;
            current = current.getNext();
        } while (current != head);
    }

    /**
     * 删除节点
     * @param current
     * @param pre
     */
    private void deleteNode(NormalNode<T> current, NormalNode<T> pre) {
        if (pre == null) {
            head = current.getNext();
            current.setNext(null);
            last.setNext(head);
        } else {
            pre.setNext(current.getNext());
            current.setNext(null);
        }
    }

    /**
     * 反转链表，直接修改原链表
     * @return
     */
    public NormalNode<T> inverse() {
        if (head == null) {
            return null;
        }

        NormalNode<T> current = head;
        NormalNode<T> next;
        NormalNode<T> newHead = last;
        do {
            next = current.getNext();
            current.setNext(newHead);
            newHead = current;
            current = next;
        } while (current != head);
        last = head;
        head = newHead;
        return newHead;
    }

    /**
     * 反转链表，返回反转后的新头节点，不修改原链表
     * @return
     */
    public NormalNode<T> inverseLinkedList() {
        if (head == null) {
            return null;
        }

        NormalNode<T> current = head;
        NormalNode<T> next;
        NormalNode<T> newHead = null;
        NormalNode<T> newCurrent;
        NormalNode<T> newLast = null;
        do {
            next = current.getNext();
            newCurrent = new NormalNode<>(current.getData());
            if (newLast == null) {
                newLast = newCurrent;
            }
            newCurrent.setNext(newHead);
            newHead = newCurrent;
            current = next;
        } while (current != head);
        newLast.setNext(newHead);
        return newHead;
    }

    public void printAll() {
        printAllElement(head);
    }

    /**
     * 遍历指定头节点的链表，打印所有元素
     * @param head
     */
    public static void printAllElement(NormalNode<?> head) {
        if (head == null) {
            return;
        }

        NormalNode<?> current = head;
        do {
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        } while (current != head);
        System.out.println();
    }

    public void printHeadAndLast() {
        System.out.println("head.getData()=" + head.getData());
        System.out.println("last.getData()=" + last.getData());
    }

    public static void main(String[] args) {
        System.out.println("--------------- insertToTail -----------------");
        CircularLinkedList<Integer> list1 = new CircularLinkedList<>();
        list1.insertToTail(100);
        list1.insertToTail(200);
        list1.insertToTail(300);
        list1.insertToTail(400);
        list1.insertToTail(500);
        list1.printAll();

        System.out.println("--------------- insertToHead -----------------");
        CircularLinkedList<Integer> list2 = new CircularLinkedList<>();
        list2.insertToHead(1000);
        list2.insertToHead(2000);
        list2.insertToHead(3000);
        list2.insertToHead(4000);
        list2.insertToHead(5000);
        list2.printAll();

        System.out.println("--------------- insertAfter -----------------");
        NormalNode<Integer> node1 = list2.findByIndex(4);
        list2.insertAfter(node1, 6000);
        list2.printAll();
        NormalNode<Integer> node5 = list2.findByIndex(0);
        list2.insertAfter(node5, 6666);
        list2.printAll();
        list2.printHeadAndLast();
        NormalNode<Integer> node6 = list2.findByValue(6000);
        list2.insertAfter(node6, 4444);
        list2.printAll();
        list2.printHeadAndLast();

        System.out.println("--------------- insertBefore -----------------");
        NormalNode<Integer> node2 = list2.findByIndex(0);
        list2.insertBefore(node2, 9999);
        list2.printAll();
        NormalNode<Integer> node3 = list2.findByValue(4444);
        list2.insertBefore(node3, 8888);
        list2.printAll();
        NormalNode<Integer> node4 = list2.findByValue(8888);
        list2.insertBefore(node4, 7777);
        list2.printAll();

        System.out.println("--------------- deleteByIndex -----------------");
        list2.deleteByIndex(0);
        list2.printAll();

        System.out.println("--------------- deleteByValue -----------------");
        list2.deleteByValue(4000);
        list2.printAll();

        System.out.println("--------------- inverse -----------------");
        list2.printAll();
        list2.printHeadAndLast();
        list2.inverse();
        list2.printAll();
        list2.printHeadAndLast();

        System.out.println("--------------- inverseLinkedList -----------------");
        list2.printAll();
        NormalNode<Integer> head = list2.inverseLinkedList();
        printAllElement(head);
        list2.printAll();
    }

}
