package model.dataStructures.hashTableImplementation;

public interface IHashTable<K,V> {
    public void insert(K key, V value) throws Exception;
    public V search(K key);
    public void deleteKey(K key);

}
