package model;

import model.dataStructures.hashTableImplementation.HashTable;

public class ClinicalLaboratoryManager {
    private HashTable<String, Pacient> patients;

    private Unity hematologySection;
    private Unity generalPurposeSection;

    public ClinicalLaboratoryManager() {
        patients = new HashTable<>(5);
        hematologySection = new Unity();
        generalPurposeSection = new Unity();
    }

    public boolean isPatientInSystem(String id) {
        return patients.search(id) != null;
    }
    public Gender assingGender(int g){
        Gender gender = null;
        switch (g){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NON_BINARY;
                break;
        }
        return gender;
    }
    public void addPatient(String id, String name, int g, int age, boolean isPrioritized){
        Pacient patient = new Pacient(id,name,assingGender(g),age,isPrioritized);
        patients.insert(id,patient);
    }
    public void addPatient(String id, String name, int g, int age, boolean isPrioritized, int priorityValue) {
        Pacient patient = new Pacient(id,name,assingGender(g),age,isPrioritized, priorityValue);
        patients.insert(id,patient);
    }
}
