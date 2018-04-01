package com.java.algorithm.hashmap;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.LinkedList;

class HashMap<K, V>{

    private int bucketSize;
    private LinkedList<KeyValue>[] elements;
    private int size;


    public HashMap(){
        this.bucketSize = 16;
        this.elements = new LinkedList[bucketSize];
        this.size = 0;
    }


    public void add(K key, V value){
        int position = getHash(key);
        LinkedList<KeyValue> list = new LinkedList<>();


        if(elements[position] != null){

            for(KeyValue element : elements[position]){
                if(element.getKey().equals(key)){
                    throw new IllegalStateException("This key already used");
                }
            }

        } else{
            list.add(new KeyValue(key, value));
            elements[position] = list;
            size++;
        }


        //resizeIfNeeded();
    }

    private int getHash(K key){
        return key.hashCode() % this.bucketSize;
    }

    public V getValue(K key){
        int position = getHash(key);
        if(elements[position] == null){
            throw new InvalidParameterException("There is no such an item");
        } else{
            for(KeyValue element : elements[position]){
                if(element.getKey().equals(key)){
                    return (V) element.getValue();

                }
            }

        }
        return null;
    }

    private void resizeIfNeeded(){
        // If it holds more elements than bucketSize * 2, destroy and recreate it
        // with the double size of the elements array.
        // if it holds less elements than bucketSize / 2, destroy and recreate it
        // with half size of the elements array.
    }


    public void clearAll(){
        this.elements = new LinkedList[bucketSize];
    }

    public void delete(K key){
        int hash = getHash(key);
        if(elements[hash] == null){
            throw new InvalidParameterException("Nothing to delete");
        } else{
            for(KeyValue element : elements[hash]){
                if(element.getKey().equals(key)){
                    elements[hash].remove(element);
                }
            }

        }
    }

    @Override
    public String toString(){
        return "HashMap{" +
                "bucketSize=" + bucketSize +
                ", elements=" + Arrays.toString(elements) +
                ", size=" + this.size +
                '}';
    }
}