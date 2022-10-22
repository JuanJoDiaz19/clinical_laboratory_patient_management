package hashTableImplementation;

import model.dataStructures.hashTableImplementation.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    HashTable<String, String> table;
    public void setUp1(){
        table=new HashTable<>(13);
    }
    public void setUp2(){
        table=new HashTable<>(1);
    }
    public void setUp3() {
        table=new HashTable<>(1);
        table.insert("123", "Juan Jose");
        table.insert("456", "Patricia");
    }
    public void     setUp4() {
        table=new HashTable<>(1);
        table.insert("124", "Pepe");
        table.insert("124", "Papa");
    }
    @Test
    public void hashTest1(){
        setUp1();
        assertEquals(4,table.hash("Juan"));
    }
    @Test
    public void hashTest2(){
        setUp1();
        assertEquals(0,table.hash(""));
    }
    @Test
    public void hashTest3(){
        setUp2();
        assertEquals(0,table.hash("SapoPerro"));
    }
    @Test
    public void insertTest1() throws Exception {
        setUp2();
        table.insert("123", "Juan Jose");
        assertEquals("Juan Jose",table.search("123"));
    }
    @Test
    public void insertTest2() throws Exception {
        setUp2();
        table.insert("123", "Juan Jose");
        table.insert("456", "Patricia");
        assertEquals("Patricia",table.search("456"));
    }
    @Test
    public void insertTest3() {
        setUp1();
        table.insert("4", "Diaz");
        table.insert("2", "Londoño");
        assertEquals("Londoño",table.search("2"));
        assertEquals("Diaz",table.search("4"));
    }
    @Test
    public void searchTest1() throws Exception {
        setUp3();
        assertEquals("Patricia",table.search("456"));
    }
    @Test
    public void searchTest2() throws Exception {
        setUp3();
        assertNull(table.search("789"));
    }

    @Test
    public void searchTest3() throws Exception {
        setUp4();
        assertEquals("Pepe",table.search("124"));
    }

    @Test
    public void deleteTest1() throws Exception {
        setUp3();
        //Sin colisiones
        table.deleteKey("456");
        assertNull(table.search("456"));
        assertEquals("Juan Jose", table.search("123"));
    }
    @Test
    public void deleteTest2() throws Exception {
        setUp1();
        //Con colisiones
        table.insert("123", "Juan Jose");
        table.insert("456", "Patricia");
        table.deleteKey("123");
        assertNull(table.search("123"));
        assertEquals("Patricia", table.search("456"));
    }
    @Test
    public void deleteTest3() throws Exception {
        setUp1();
        //Con colisiones
        table.deleteKey("123");
        assertNull(table.search("123"));
    }
}