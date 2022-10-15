package model;

import model.dataStructures.priorityQueueImplementation.Heap;
import model.dataStructures.priorityQueueImplementation.IPriorityQueue;
import model.dataStructures.stackImplementation.IStack;
import model.dataStructures.stackImplementation.MyLinkedList;

public class Unity {

    private IPriorityQueue<Pacient> priorityQueue;
    private IStack<Pacient> lastAdded;
    private IStack<Pacient> lastDeleted;

    public Unity() {
        priorityQueue = new Heap<>();
        lastAdded = new MyLinkedList<>();
        lastDeleted = new MyLinkedList<>();
    }

}
