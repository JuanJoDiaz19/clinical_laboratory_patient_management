package ui;

import model.ClinicalLaboratoryManager;

import java.util.Scanner;

public class Main {

    private ClinicalLaboratoryManager clinic;
    private final Scanner sc;
    private final String YELLOW;
    private final String RESET;

    public static void main(String[] args) {
        Main main = new Main();
        main.execute();
    }
    public Main(){
        clinic = new ClinicalLaboratoryManager();
        sc = new Scanner(System.in);
        YELLOW="\u001B[33m";
        RESET="\u001B[0m";
    }

    public void execute() {
        System.out.println(YELLOW+"==============================="+
                "\n    WELCOME TO THE CLINIC    "+
                "\n===============================\n"+RESET);
        int option = 0;
        do {
            System.out.println("Select one of the following options:\n"+
                    "1. Register a patient\n" +
                    "2. Mark queue entry\n" +
                    "3. Mark queue exit\n" +
                    "4. Undo option\n"+
                    "5. Show people in the queue\n" +
                    "0. Exit\n");
            try {
                option = Integer.parseInt(sc.nextLine());
                executeOption(option);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        } while (option != 0);
    }
    public void executeOption(int option) {
        switch (option){
            case 1:
                addPatient();
                break;
            case 2:
                putInThequeue();
                break;
            case 3:
                removeFromTheQueue();
                break;
            case 4:

                break;
            default:
                System.out.println("Please choose an available option :)");
                break;
        }
    }
    public void addPatient() {
        System.out.println("Enter the id of the patient: ");
        String id = sc.nextLine();
        if(clinic.isPatientInSystem(id)) {
            System.out.println("The patient is already in the system :)");
        } else {
            System.out.println("Enter the name of the patient: ");
            String name = sc.nextLine();
            System.out.println("Enter the gender of the patient:\n1. Male\n2. Female\n3. Non-Binary");
            int gender = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the age of the patient:");
            int age = Integer.parseInt(sc.nextLine());
            System.out.println("The patient is prioritized?\n1. YES\n2. NO");
            int prioritized = Integer.parseInt(sc.nextLine());
            int priorityValue;
            if(prioritized == 1) {
                System.out.println("From 1 to 5 how urgent is your atention");
                priorityValue = Integer.parseInt(sc.nextLine());
                while(priorityValue<1 || priorityValue>5){
                    System.out.println("Enter a valid option:\nFrom 1 to 5 how urgent is your attention");
                    priorityValue = Integer.parseInt(sc.nextLine());
                }
                clinic.addPatient(id, name, gender, age, true, priorityValue);
            } else {
                priorityValue = 0;
                clinic.addPatient(id, name, gender, age, false, priorityValue);
            }
        }
    }

    public void putInThequeue() {
        System.out.println("Enter the id of the patient:");
        String id = sc.nextLine();
        if(!clinic.isPatientInSystem(id)) {
            System.out.println("The patient isn't in the system please register him");
        } else {
            System.out.println("Enter the unity that you want to enqueue the patient:\n1. Hematology\n2. General purpose");
            int option = Integer.parseInt(sc.nextLine());
            clinic.enqueueInSection(id, option);
        }
    }

    public void removeFromTheQueue() {
        System.out.println("Enter the unity that you want to enqueue the patient:\n1. Hematology\n2. General purpose");
        int option = Integer.parseInt(sc.nextLine());
        System.out.println(clinic.removeFromQueue(option));
    }
}
