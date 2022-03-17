package com.feichai.test.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    //1.构造一个Node节点，作为数据载体
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    //2.构建一个虚拟的双向链表，里面放的就是我们的Node
    class DoubleLinkedList<K,V>{
        Node<K,V> head;
        Node<K,V> tail;

        public DoubleLinkedList(){
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        public void addHead(Node<K,V> node){
            node.next = tail;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node<K,V> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = null;
            node.prev = null;
        }

        public Node getLast(){
            return tail.prev;
        }


    }


    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList <Integer,Integer> doubleLinkedList;

    LRUCache(int cacheSize){
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        Node<Integer,Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    public void put(int key,int value){
        if (map.containsKey(key)){
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else{
            if (map.size() == cacheSize){
                Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode);
                doubleLinkedList.removeNode(lastNode);
            }
            Node<Integer, Integer> newNode = new Node<>(key,value);
            map.put(key,newNode);
            doubleLinkedList.addHead(newNode);
        }
    }
}
