package ui;

public class Main {
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
                    "2. Register a pacient\n" +
                    "3. Undo option\n"+
                    "");
            try {
                option = Integer.parseInt(sc.nextLine());
                executeOption(option);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        } while (option != 3);
    }
    public void executeOption(int option) {
        switch (option){
            case 1:
                addPacient();
                break;
            case 2:
                //geograficControler.importSQLFile();
                break;
            case 3:
                System.out.println("Bye :)");
                break;
            default:
                System.out.println("Please choose an available option :)");
                break;
        }
    }
    public void addPacient() {
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
            int isprioritized = Integer.parseInt(sc.nextLine());
            int priorityValue;
            if(isprioritized == 1) {
                System.out.println("From 1 to 5 how urgent is your atention");
                priorityValue = Integer.parseInt(sc.nextLine());
                while(priorityValue<1 || priorityValue>5){
                    System.out.println("Enter a valid option:\nFrom 1 to 5 how urgent is your atention");
                    priorityValue = Integer.parseInt(sc.nextLine());
                }
                clinic.addPatient(id, name, gender, age, true, priorityValue);
            } else {
                clinic.addPatient(id, name, gender, age, false);
            }
        }
    }
}
