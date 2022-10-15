package model.priorityQueueImplementation;

public interface IPriorityQueue<T> {
    void insertElement(int priorityValue, T element);
    T extractMax();
    void increaseKey(T element, int newPriorityValue);
    String showElements();
    T showMaximum();
}
