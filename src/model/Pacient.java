package model;

public class Pacient {
    private String id;
    private String name;
    private Gender gender;
    private int edad;
    private boolean isPrioritized;
    private int priorityValue;

    public Pacient(String id, String name, Gender gender, int edad, boolean isPrioritized, int priorityValue) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.edad = edad;
        this.isPrioritized = isPrioritized;
        this.priorityValue = priorityValue;
    }
    public Pacient(String id, String name, Gender gender, int edad, boolean isPrioritized) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.edad = edad;
        this.isPrioritized = isPrioritized;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isPrioritized() {
        return isPrioritized;
    }

    public void setPrioritized(boolean prioritized) {
        isPrioritized = prioritized;
    }

    public int isPriorityValue() {
        return priorityValue;
    }

    public void setPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
    }
}
