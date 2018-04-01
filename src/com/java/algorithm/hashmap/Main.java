package com.java.algorithm.hashmap;

public class Main {

    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.add("Al",  1);
        map.add("bbb", 2);
        map.clearAll();
        map.add("Al",  1);
        map.add("bbb", 2);
        System.out.println(map.toString());
        System.out.println(map.getValue("Al"));
        System.out.println(map.getValue("bbb"));
        map.delete("Al");
        System.out.println(map.getValue("Al"));
    }
}

