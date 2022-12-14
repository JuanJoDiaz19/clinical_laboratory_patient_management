package model.dataStructures.hashTableImplementation;

import java.util.ArrayList;

public class HashTable<K,V>  implements IHashTable<K,V>{
    private int m;
    private HashNode<K,V>[] table;

    public HashTable(int m) {
        this.m = m;
        table = new HashNode[m];
    }
    public int hash(K key) {
        return (Math.abs(key.hashCode())) % m;
    }

    @Override
    public void insert(K key, V value) {
        int insertKey = hash(key);
        HashNode<K,V> nodeList = table[insertKey];

        if(nodeList == null) {
            table[insertKey] = new HashNode<>(key, value);
        } else {
            while (nodeList != null) {
                if(nodeList.getKey().equals(key)) {
                    return;
                }
                nodeList = nodeList.getNext();
            }
            HashNode<K,V> finalNode = new HashNode<>(key, value);
            table[insertKey].setPrevious(finalNode);
            finalNode.setNext(table[insertKey]);
            table[insertKey] = finalNode;

        }
    }

    @Override
    public V search(K key) {
        V value = null;
        int searchKey = hash(key);
        HashNode<K,V> searchNode = table[searchKey];
        while (searchNode != null) {
            if(key.equals(searchNode.getKey())){
                value = searchNode.getValue();
            }
            searchNode = searchNode.getNext();
        }
        return value;
    }

    @Override
    public void deleteKey(K key) {
        int deleteKey = hash(key);
        HashNode<K,V> deleteNode = table[deleteKey];
        while (deleteNode != null){
            if(deleteNode.getKey().equals(key)){
                HashNode<K,V> prev = deleteNode.getPrevious();
                HashNode<K,V> next = deleteNode.getNext();
                if(deleteNode.equals(table[deleteKey])){
                    table[deleteKey]=next;
                }else {
                    if(prev != null) prev.setNext(next);
                    if(next != null)next.setPrevious(prev);
                }
            }
            deleteNode = deleteNode.getNext();
        }
    }

    public ArrayList<V> showContent() {
        ArrayList<V> nodesInTheTable = new ArrayList<>();
        for(int i = 0; i< table.length; i++) {
            if(table[i] != null){
                HashNode<K, V> temporalNode = table[i];
                while (temporalNode != null) {
                    nodesInTheTable.add(temporalNode.getValue());
                    temporalNode = temporalNode.getNext();
                }
            }
        }
        return nodesInTheTable;
    }
}
