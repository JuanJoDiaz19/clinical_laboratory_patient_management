package model.dataStructures.stackImplementation;

public interface IStack<T>{
    void pop();
    T top();
    void push(T element);
    boolean isEmpty();
    String print();
}
