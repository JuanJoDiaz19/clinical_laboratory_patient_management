package model.priorityQueueImplementation;

import java.util.ArrayList;

public class Heap<T> implements IPriorityQueue<T>{
    private ArrayList<NodePriorityQueue<T>> arr;
    public Heap() {
        arr = new ArrayList<>();
        arr.add(null);
    }
    @Override
    public void insertElement(int priorityValue, T element) {
        arr.add(new NodePriorityQueue(priorityValue,element));
        buildMaxHeapify();
    }
    public void maxHeapify(int index) {
        int l = 2*index;
        int r = 2*index + 1;
        int largest;
        if(l <= arr.size()-1 && arr.get(l).getPriorityValue() > arr.get(index).getPriorityValue()) {
            largest = l;
        } else {
            largest = index;
        }
        if(r<= arr.size()-1 && arr.get(r).getPriorityValue()  > arr.get(largest).getPriorityValue() ) {
            largest = r;
        }
        if(largest != index) {
            NodePriorityQueue<T> temp1= arr.get(index);
            NodePriorityQueue<T> temp2= arr.get(largest);
            arr.set(index,temp2);
            arr.set(largest,temp1);
            maxHeapify(largest);
        }
    }
    public void buildMaxHeapify() {
        for(int i= arr.size()-1; i >=1;i--){
            maxHeapify(i);
        }
    }
    public ArrayList heapSort(ArrayList arr) {
        return null;
    }

    public String print() {
        String ans = "";
        for (int i = 1; i <arr.size(); i++) {
            ans += arr.get(i).getPriorityValue() + " ";
        }
        return ans;
    }
    public ArrayList<NodePriorityQueue<T>> getArr() {
        return arr;
    }
    public void setArr(ArrayList<NodePriorityQueue<T>> arr) {
        this.arr = arr;
    }

    @Override
    public T extractMax() {
        T max=null;
        if(arr.size() >=2) {
            max = arr.get(1).getElement();
            arr.set(1,arr.get(arr.size()-1));
            arr.remove(arr.size()-1);
            maxHeapify(1);
        }
        return max;
    }

    @Override
    public void increaseKey(T element, int newPriortyValue) {
        int index = -1;
        for (int i = 1; i < arr.size(); i++) {
            if(arr.get(i).getElement().equals(element)){
                index = i;
            }
        }
        if(newPriortyValue > arr.get(index).getPriorityValue()) {
            arr.get(index).setPriorityValue(arr.get(index).getPriorityValue()+newPriortyValue);
            buildMaxHeapify();
        }
    }
    @Override
    public String showElements() {
        String ans = "";
        for (int i = 1; i < arr.size() ; i++) {
            ans+= arr.get(i).getPriorityValue() + " "+ arr.get(i).getElement() + "\n";
        }
        return ans;
    }

    @Override
    public T showMaximum() {
        if(arr.size()>1) {
            return arr.get(1).getElement();
        }else {
            return null;
        }
    }
}
