package model.dataStructures.stackImplementation;

public class NodeLinkedList<T> {
    private T value;
    private NodeLinkedList<T> next;
    private NodeLinkedList<T> previous;

    public NodeLinkedList(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeLinkedList getNext() {
        return next;
    }

    public void setNext(NodeLinkedList next) {
        this.next = next;
    }

    public NodeLinkedList getPrevious() {
        return previous;
    }

    public void setPrevious(NodeLinkedList previous) {
        this.previous = previous;
    }
}
