package priorityQueueImplementation;

import model.dataStructures.priorityQueueImplementation.Heap;
import model.dataStructures.priorityQueueImplementation.NodePriorityQueue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    private Heap<String> heap;

    private void setUp1(){
        heap=new Heap<>();
    }
    private void setUp2(){
        heap=new Heap<>();
        heap.insertElement(5, "Juan");
        heap.insertElement(1, "Francisco");
        heap.insertElement(4, "Alberto");
        heap.insertElement(6, "Javier");
        heap.insertElement(9, "Nelson");
        heap.insertElement(11, "Patricia");
    }
    private void setUp3(){
        heap =  new Heap<>();
        heap.getArr().add(new NodePriorityQueue<>(16, "Juan"));
        heap.getArr().add(new NodePriorityQueue<>(4, "Francisco"));
        heap.getArr().add(new NodePriorityQueue<>(10, "Alberto"));
        heap.getArr().add(new NodePriorityQueue<>(14, "Javier"));
        heap.getArr().add(new NodePriorityQueue<>(7, "Nelson"));
        heap.getArr().add(new NodePriorityQueue<>(9, "Patricia"));
        heap.getArr().add(new NodePriorityQueue<>(3, "Nelly"));
        heap.getArr().add(new NodePriorityQueue<>(2, "Esteban"));
        heap.getArr().add(new NodePriorityQueue<>(8, "Julio"));
        heap.getArr().add(new NodePriorityQueue<>(1, "Andrew"));
    }
    private void setUp4(){
        heap =  new Heap<>();
        heap.getArr().add(new NodePriorityQueue<>(4, "Juan"));
        heap.getArr().add(new NodePriorityQueue<>(14, "Francisco"));
        heap.getArr().add(new NodePriorityQueue<>(7, "Alberto"));
        heap.getArr().add(new NodePriorityQueue<>(2, "Javier"));
        heap.getArr().add(new NodePriorityQueue<>(8, "Nelson"));
        heap.getArr().add(new NodePriorityQueue<>(1, "Patricia"));
    }
    private void setUp5() {
        heap = new Heap<>();
        heap.insertElement(5, "Juan");
    }
    private void setUp6() {
        heap = new Heap<>();
        heap.insertElement(3, "Ricardo1");
        heap.insertElement(3, "Ricardo2");
        heap.insertElement(3, "Ricardo3");
        heap.insertElement(3, "Ricardo4");
        heap.insertElement(3, "Ricardo5");
    }

    private void setUp7(){
        heap = new Heap<>();
        heap.insertElement(16, "Juan");
        heap.insertElement(3, "Alfa");
        heap.insertElement(4, "Beta");
        heap.insertElement(1, "Gamma");
        heap.insertElement(3, "Omega");
    }


    @Test
    public void addElementTest1(){
        setUp1();
        heap.insertElement(13,"Hola");
        assertTrue(heap.getArr().get(1).getPriorityValue()==13 &&heap.getArr().get(1).getElement().equals("Hola"));
    }

    @Test
    public void addElementTest2(){
        setUp2();
        heap.insertElement(13,"Hola");
        assertEquals("Hola",heap.extractMax());
    }
    @Test
    public void addElementTest3(){
        setUp2();
        heap.insertElement(13,"Hola");
        assertEquals("13 6 11 1 5 4 9 ",heap.print());
    }

    @Test
    public void maxHeapifyTest1(){
        setUp3();
        heap.maxHeapify(2);
        assertEquals("16 14 10 8 7 9 3 2 4 1 ",heap.print());
    }
    @Test
    public void maxHeapifyTest2(){
        setUp4();
        heap.maxHeapify(1);
        assertEquals("14 8 7 2 4 1 ",heap.print());
    }
    @Test
    public void maxHeapifyTest3(){
        setUp3();
        heap.maxHeapify(1);
        assertEquals("16 4 10 14 7 9 3 2 8 1 ",heap.print());
    }
    @Test
    public void buildMaxHeapifyTest1(){
        setUp3();
        heap.buildMaxHeapify();
        assertEquals("16 14 10 8 7 9 3 2 4 1 ",heap.print());
    }
    @Test
    public void buildMaxHeapifyTest2(){
        setUp1();
        heap.buildMaxHeapify();
        assertEquals("",heap.print());
    }
    @Test
    public void buildMaxHeapifyTest3(){
        setUp4();
        heap.buildMaxHeapify();
        assertEquals("14 8 7 2 4 1 ",heap.print());
    }
    @Test
    public void extractMaxElementTest1(){
        setUp4();
        assertEquals("Juan",heap.extractMax());
    }
    @Test
    public void extractMaxTest2(){
        setUp1();
        assertEquals(null,heap.extractMax());
    }
    @Test
    public void extractMaxTest3(){
        setUp5();
        heap.extractMax();
        assertEquals("",heap.print());
    }
    @Test
    public void increaseKeyTest1(){
        setUp5();
        heap.increaseKey("Juan",10);
        assertEquals("15 ",heap.print());
    }
    @Test
    public void  increaseKeyTest2(){
        setUp4();
        heap.increaseKey("Juan",5);
        assertEquals("14 9 7 2 8 1 ",heap.print());
    }
    @Test
    public void showMaxTest1(){
        setUp3();
        assertEquals("Juan",heap.showMaximum());
    }
    @Test
    public void showMaxTest2(){
        setUp1();
        assertEquals(null,heap.showMaximum());
    }
    @Test
    public void showMaxTest3(){
        setUp6();
        assertEquals("Ricardo1",heap.showMaximum());
    }

    @Test
    public void heapSortTest1() throws CloneNotSupportedException {
        setUp7();
        ArrayList<String> arrayList = heap.heapSort();
        for (String s: arrayList) {
            System.out.println(s);
        }
    }
    @Test
    public void heapSortTest2() throws CloneNotSupportedException {
        setUp7();
        ArrayList<String> arrayList = heap.heapSort();
        assertEquals("Juan", heap.showMaximum() );
    }
    @Test
    public void heapSortTest3() throws CloneNotSupportedException {
        setUp7();
        ArrayList<String> arrayList = heap.heapSort();
        assertEquals("Juan", heap.showMaximum());
        heap.extractMax();
        assertEquals("Beta", heap.showMaximum());
    }
}