package com.shize.algo;

/**
 * 单链表实现的LRU算法
 */
public class SingleLinkedLRU<T> {

    public static void main(String[] args) {
        SingleLinkedLRU<Integer> objectSingleLinkedLRU = new SingleLinkedLRU<>();
        objectSingleLinkedLRU.put(1);
        objectSingleLinkedLRU.put(3);
        objectSingleLinkedLRU.put(5);
        objectSingleLinkedLRU.put(4);
        objectSingleLinkedLRU.display();

        objectSingleLinkedLRU.put(3);
        System.out.println("after put 3:");
        objectSingleLinkedLRU.display();
    }

    private final SNode<T> guard = new SNode<>();

    public void display() {
        SNode<T> cur = guard.getNext();
        while (cur != null) {
            System.out.println(cur.getElement());
            cur = cur.getNext();
        }
    }


    public void put(T ele) {
        // 遍历链表，如果存在，删除原来的，插入到头部，如果不存在，插入到头部
        SNode<T> targetPreNode = findPreNode(ele);
        if (targetPreNode != null) {
            SNode<T> target = targetPreNode.getNext();
            targetPreNode.setNext(target.getNext());
            target.setNext(guard.getNext());
            guard.setNext(target);
        } else {
            SNode<T> target = new SNode<>(ele);
            target.setNext(guard.getNext());
            guard.setNext(target);
        }
    }

    private SNode<T> findPreNode(T ele) {
        SNode<T> res = null;
        SNode<T> cur = guard;
        while (true) {
            SNode<T> next = cur.getNext();
            if (next == null) {
                break;
            }
            if (next.getElement().equals(ele)) {
                res = cur;
                break;
            }
            cur = next;
        }
        return res;
    }


}
