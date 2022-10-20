package model;

import model.dataStructures.priorityQueueImplementation.Heap;
import model.dataStructures.priorityQueueImplementation.IPriorityQueue;
import model.dataStructures.priorityQueueImplementation.NodePriorityQueue;
import model.dataStructures.stackImplementation.IStack;
import model.dataStructures.stackImplementation.MyLinkedList;

import java.util.ArrayList;

public class Unity {

    private IPriorityQueue<Patient> priorityQueue;
    private IStack<IPriorityQueue<Patient>> lastModifications;

    public Unity() {
        priorityQueue = new Heap<>();
        lastModifications = new MyLinkedList<>();
    }

    public void enqueue(int priorityValue, Patient patient) {
        priorityQueue.insertElement(priorityValue, patient);
        Heap<Patient> newPatients = new Heap<>();
        newPatients.setArr((ArrayList<NodePriorityQueue<Patient>>) priorityQueue.getArr().clone());
        lastModifications.push(newPatients);
    }

    public Patient removeFromQueue() {
        Patient patientOut = priorityQueue.extractMax();
        Heap<Patient> newPatients = new Heap<>();
        newPatients.setArr((ArrayList<NodePriorityQueue<Patient>>) priorityQueue.getArr().clone());
        lastModifications.push(newPatients);
        return patientOut;
    }

    public String showPatientsQueue() {
        String out = "";
        ArrayList<Patient> orderPatients = priorityQueue.heapSort();
        int counter = 0;
        for (Patient p: orderPatients) {
            counter++;
            out += counter + ". " + p.getName() + "\n";
        }
        return out;
    }

    public void unDoOption() {
        lastModifications.pop();
        Heap<Patient> newUndo = new Heap<>();
        newUndo.setArr((ArrayList<NodePriorityQueue<Patient>>) lastModifications.top().getArr().clone());
        priorityQueue = newUndo;
    }

}
