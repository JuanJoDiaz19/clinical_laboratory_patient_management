package model;

import model.dataStructures.hashTableImplementation.HashTable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ClinicalLaboratoryManager {
    private HashTable<String, Patient> dataBase;

    private HashTable<String, Patient> patientsInLaboratory;
    private Unity hematologySection;
    private Unity generalPurposeSection;

    public ClinicalLaboratoryManager() {
        dataBase = new HashTable<>(10);
        hematologySection = new Unity();
        generalPurposeSection = new Unity();
        patientsInLaboratory = new HashTable<>(5);
        loadData();
    }

    public boolean isPatientInLaboratory(String id) {
        return patientsInLaboratory.search(id) != null;
    }
    public boolean isPatientInDataBase(String id) {
        return dataBase.search(id) != null;
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
        dataBase.insert(id,patient);
        saveData(patient);
    }
    public void loadPatient(String id, String name, int g, int age, boolean isPrioritized, int priorityValue) {
        Patient patient = new Patient(id,name,assingGender(g),age,isPrioritized, priorityValue);
        dataBase.insert(id,patient);
    }

    public void enqueueInSection(String id,  int option){
        Patient patient = dataBase.search(id);
        if(option == 1) {
            hematologySection.enqueue(patient.getPriorityValue(), patient);
        } else {
            generalPurposeSection.enqueue( patient.getPriorityValue(), patient);
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

    public String showPatientsInQueue(int option) {
        if(option == 1) {
            return hematologySection.showPatientsQueue();
        } else {
            return generalPurposeSection.showPatientsQueue();
        }
    }

    public void undoOption(int option) {
        if(option == 1) {
            hematologySection.unDoOption();
        } else {
            generalPurposeSection.unDoOption();
        }
    }

    public String addPatientsInLaboratory(String id) {
        String out;
        Patient p = dataBase.search(id);
        if(p == null) {
            out = "Sorry, the patient isn't in the data base, please register him in the data base";
        } else {
            if(patientsInLaboratory.search(p.getId()) == null) {
                patientsInLaboratory.insert(p.getId(), p);
                out = "Correct entry to the laboratory :)";
            } else {
                out = "The patient is already ub the laboratory";
            }

        }
        return out;
    }

    public String showPatientsInLaboratory() {
        String out = "********** People in the laboratory **********\n\n";
        ArrayList<Patient> patients = patientsInLaboratory.showContent();
        for (Patient p: patients) {
            out+= " * " + p.getName() + "\n";
        }
        return out;
    }


}
