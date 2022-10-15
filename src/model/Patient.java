package model;

public class Patient {
    private String id;
    private String name;
    private Gender gender;
    private int age;
    private boolean isPrioritized;
    private int priorityValue;

    public Patient(String id, String name, Gender gender, int age, boolean isPrioritized, int priorityValue) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.isPrioritized = isPrioritized;
        this.priorityValue = priorityValue;
    }
    public Patient(String id, String name, Gender gender, int age, boolean isPrioritized) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.isPrioritized = isPrioritized;
    }

    public String print() {
        String ans = "" +
                "******* PACIENT *******\n" +
                "*   Id: " + id + "\n"+
                "*   Name: " + name + "\n"+
                "*   Gender: " + (gender == Gender.MALE? "Male": (gender == Gender.FEMALE? "Female": "Non binary")) + "\n"+
                "*   Age: " + age + "\n" +
                "*   Prioritized: " + (isPrioritized? "YES": "NO") + "\n" +
                "*   Priority value: " + priorityValue + "\n";
        return ans;
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
        return age;
    }

    public void setEdad(int edad) {
        this.age = edad;
    }

    public boolean isPrioritized() {
        return isPrioritized;
    }

    public void setPrioritized(boolean prioritized) {
        isPrioritized = prioritized;
    }

    public int getPriorityValue() {
        return priorityValue;
    }

    public void setPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
    }
}
