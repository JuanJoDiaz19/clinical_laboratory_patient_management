package model.dataStructures.stackImplementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    MyLinkedList<Integer> myLinkedList;
    public void setUp1(){
        myLinkedList = new MyLinkedList<>();
    }
    @Test
    public void setUp2() {
        myLinkedList = new MyLinkedList<>();
        myLinkedList.push(12);
        myLinkedList.push(4);
        myLinkedList.push(5);
        myLinkedList.push(9);
        myLinkedList.push(5);
        myLinkedList.push(69);
    }
    @Test
    public void pushTest1(){
        setUp1();
        myLinkedList.push(1);
        myLinkedList.push(2);
        myLinkedList.push(3);
        assertEquals( " 3 2 1", myLinkedList.print());
    }
    @Test
    public void pushTest2(){
        setUp1();
        assertEquals( "", myLinkedList.print());
    }
    @Test
    public void pushTest3(){
        setUp1();
        myLinkedList.push(12);
        myLinkedList.push(4);
        myLinkedList.push(5);
        myLinkedList.push(9);
        myLinkedList.push(5);
        myLinkedList.push(69);
        assertEquals( " 69 5 9 5 4 12", myLinkedList.print());
    }
    @Test
    public void topTest1() {
        setUp2();
        assertEquals(myLinkedList.top(), 69);
    }
    @Test
    public void topTest2() {
        setUp1();
        assertEquals(myLinkedList.top(), null);
    }
    @Test
    public void topTest3() {
        setUp1();
        myLinkedList.push(13);
        assertEquals(myLinkedList.top(), 13);
    }
    @Test
    public void popTest1() {
        setUp2();
        myLinkedList.pop();
        assertEquals(myLinkedList.top(), 5);
    }
    @Test
    public void popTest2() {
        setUp1();
        myLinkedList.pop();
        assertEquals(myLinkedList.top(), null);
    }
    @Test
    public void popTest3() {
        setUp1();
        myLinkedList.push(69);
        myLinkedList.pop();
        assertEquals(myLinkedList.top(), null);
    }
    @Test
    public void isEmptyTest1(){
        setUp1();
        assertEquals(myLinkedList.isEmpty(),true);
    }
    @Test
    public void isEmptyTest2(){
        setUp1();
        myLinkedList.push(420);
        assertEquals(myLinkedList.isEmpty(),false);
    }

    @Test
    public void isEmptyTest3(){
        setUp1();
        myLinkedList.push(777);
        myLinkedList.pop();
        assertEquals(myLinkedList.isEmpty(),true);
    }


}