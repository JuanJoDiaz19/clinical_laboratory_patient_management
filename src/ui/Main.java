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
                "\n==============================="+RESET);
        int option = 0;
        do {
            System.out.println("\nSelect one of the following options:\n\n"+
                    "(1). Register a patient\n" +
                    "(2). Register entry to the clinic\n" +
                    "(3). Mark queue entry\n" +
                    "(4). Mark queue exit\n" +
                    "(5). Undo option\n"+
                    "(6). Show order in the list\n" +
                    "(7). Show people in the laboratory\n" +
                    "(0). Exit\n");
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
                addPatientToDataBase();
                break;
            case 2:
                addPatientToLaboratory();
                break;
            case 3:
                putInTheQueue();
                break;
            case 4:
                removeFromTheQueue();
                break;
            case 5:
                undoOption();
                break;
            case 6:
                showPeopleInQueue();
                break;
            case 7:
                showPatientsInLaboratory();
                break;
            default:
                System.out.println("Byeeee :)");
                break;
        }
    }
    public void addPatientToDataBase() {
        System.out.println("Enter the id of the patient: ");
        String id = sc.nextLine();
        if(clinic.isPatientInDataBase(id)) {
            System.out.println("The patient is already in the dataBase :)");
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

    public void putInTheQueue() {
        System.out.println("Enter the id of the patient:");
        String id = sc.nextLine();
        if(!clinic.isPatientInLaboratory(id)) {
            System.out.println("The patient isn't in the laboratory please mark his entry");
        } else {
            System.out.println("Enter the unity that you want to enqueue the patient:\n1. Hematology\n2. General purpose");
            int option = Integer.parseInt(sc.nextLine());
            clinic.enqueueInSection(id, option);
        }
    }
    public void removeFromTheQueue() {
        System.out.println("Enter the unity that you want to call the patient:\n1. Hematology\n2. General purpose");
        int option = Integer.parseInt(sc.nextLine());
        System.out.println(clinic.removeFromQueue(option));
    }
    public void showPeopleInQueue() {
        System.out.println("Enter the unity that you see the Queue:\n1. Hematology\n2. General purpose");
        int option = Integer.parseInt(sc.nextLine());
        System.out.println("***** Order of the people in the Queue *****");
        System.out.println(clinic.showPatientsInQueue(option));
    }

    public void undoOption() {
        System.out.println("Enter the unity where you want to undo the option: \n1. Hematology\n2. General purpose");
        int option = Integer.parseInt(sc.nextLine());
        clinic.undoOption(option);
    }

    public void addPatientToLaboratory() {
        System.out.println("Enter the id of the patient you want to add: ");
        String id = sc.nextLine();
        System.out.println(clinic.addPatientsInLaboratory(id));;
    }

    public void showPatientsInLaboratory() {
        System.out.print(clinic.showPatientsInLaboratory());
    }
}
