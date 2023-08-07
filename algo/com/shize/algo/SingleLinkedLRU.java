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
            // 删除元素的原来的位置
            SNode<T> target = targetPreNode.getNext();
            targetPreNode.setNext(target.getNext());

            setTargetToHead(target);
        } else {
            setTargetToHead(new SNode<>(ele));
        }
    }

    private void setTargetToHead(SNode<T> target) {
        target.setNext(guard.getNext());
        guard.setNext(target);
    }

    private SNode<T> findPreNode(T ele) {
        SNode<T> cur = guard;
        while (cur.getNext() != null) {
            if (cur.getNext().getElement().equals(ele)) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }


}
