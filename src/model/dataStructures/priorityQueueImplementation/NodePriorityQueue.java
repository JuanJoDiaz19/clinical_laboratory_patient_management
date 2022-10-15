package model.dataStructures.priorityQueueImplementation;

public class NodePriorityQueue<T> {
    private int priorityValue;
    private T element;

    public NodePriorityQueue(int priorityValue, T element) {
        this.priorityValue = priorityValue;
        this.element = element;
    }

    public int getPriorityValue() {
        return priorityValue;
    }

    public void setPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
