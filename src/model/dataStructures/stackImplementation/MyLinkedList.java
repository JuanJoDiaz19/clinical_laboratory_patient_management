package model.dataStructures.stackImplementation;

public class MyLinkedList<T> implements IStack<T> {

    private NodeLinkedList<T> head;
    private NodeLinkedList<T> tail;


    @Override
    public void pop(){
        if(tail!=null && head!=null) {
            if (!tail.equals(head)) {
                NodeLinkedList<T> newTail = tail.getPrevious();
                tail.setPrevious(null);
                tail = newTail;
                tail.setNext(null);
            } else {
                tail = null;
                head = null;
            }
        }
    }
    @Override
    public T top(){
       return tail == null ? null: tail.getValue();
    }
    @Override
    public void push(T element){
        NodeLinkedList<T> insertNode = new NodeLinkedList<T>(element);
        if(head == null) {
            head = insertNode;
            tail = insertNode;
        } else {
            NodeLinkedList<T> prevTail = tail;
            tail.setNext(insertNode);
            tail = insertNode;
            tail.setPrevious(prevTail);
        }
    }
    @Override
    public boolean isEmpty(){
        return tail == null && head == null;
    }
    private String print(NodeLinkedList<T> current, String ans){
        if(current ==null){
            return ans;
        }
        ans+= " " + current.getValue();
        return print(current.getPrevious(),ans);
    }
    @Override
    public String print(){
        //Discord qlo ya no me deja abrirlo jajajaj

        return print(tail, "");
    }








}
