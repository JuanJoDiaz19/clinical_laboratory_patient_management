package model;

import model.dataStructures.hashTableImplementation.HashTable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ClinicalLaboratoryManager {
    private HashTable<String, Patient> patients;

    private Unity hematologySection;
    private Unity generalPurposeSection;

    public ClinicalLaboratoryManager() {
        patients = new HashTable<>(5);
        hematologySection = new Unity();
        generalPurposeSection = new Unity();
        loadData();
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
    public void addPatient(String id, String name, int g, int age, boolean isPrioritized, int priorityValue) {
        Patient patient = new Patient(id,name,assingGender(g),age,isPrioritized, priorityValue);
        patients.insert(id,patient);
        saveData(patient);
    }
    public void loadPatient(String id, String name, int g, int age, boolean isPrioritized, int priorityValue) {
        Patient patient = new Patient(id,name,assingGender(g),age,isPrioritized, priorityValue);
        patients.insert(id,patient);
    }

    public void enqueueInSection(String id,  int option){
        Patient patient = patients.search(id);
        if(option == 1) {
            hematologySection.enqueue(patient.getPriorityValue(), patient);
        } else {
            generalPurposeSection.enqueue(patient.getPriorityValue(), patient);
        }
    }

    public String removeFromQueue(int option) {
        Patient patient;
        if(option == 1) {
            patient = hematologySection.removeFromQueue();
        } else {
            patient = generalPurposeSection.removeFromQueue();
        }
        return patient != null? patient.print(): "The queue is empty :(\n";
    }

    public void loadData() {
        try {
            File file = new File("DataBase.csv");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parameters = line.split(",");
                loadPatient(parameters[0], parameters[1], (parameters[2].equals("MALE"))? 1 : (parameters[2].equals("FEMALE") ? 2: 3), Integer.parseInt(parameters[3]) , Boolean.parseBoolean(parameters[4]), Integer.parseInt(parameters[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveData(Patient patient) {
        String out = patient.getId() + "," + patient.getName() + "," + patient.getGender() + "," +patient.getAge() + "," +patient.isPrioritized() + "," + patient.getPriorityValue() + "\n";
        try {
            File file = new File("DataBase.csv");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                out += line + "\n";
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(out.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
