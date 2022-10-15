package model;

import model.dataStructures.priorityQueueImplementation.Heap;
import model.dataStructures.priorityQueueImplementation.IPriorityQueue;
import model.dataStructures.stackImplementation.IStack;
import model.dataStructures.stackImplementation.MyLinkedList;

public class Unity {

    private IPriorityQueue<Patient> priorityQueue;
    private IStack<Patient> lastAdded;
    private IStack<Patient> lastDeleted;

    public Unity() {
        priorityQueue = new Heap<>();
        lastAdded = new MyLinkedList<>();
        lastDeleted = new MyLinkedList<>();
    }

    public void enqueue(int priorityValue, Patient pacient) {
        priorityQueue.insertElement(priorityValue, pacient);
    }

    public Patient removeFromQueue() {
        return priorityQueue.extractMax();
    }

}
