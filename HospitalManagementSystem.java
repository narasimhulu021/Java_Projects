package Hospital_Project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String ailment;

    public Patient(int id, String name, int age, String ailment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age + ", Ailment: " + ailment;
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id + ", Name: " + name + ", Specialization: " + specialization;
    }
}

class Appointment {
    int patientId;
    int doctorId;
    String date;

    public Appointment(int patientId, int doctorId, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment: Patient ID: " + patientId + ", Doctor ID: " + doctorId + ", Date: " + date;
    }
}

public class HospitalManagementSystem {
    private static final List<Patient> patients = new ArrayList<>();
    private static final List<Doctor> doctors = new ArrayList<>();
    private static final List<Appointment> appointments = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Generate Bill");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 : managePatients();
                case 2 : manageDoctors();
                case 3 : scheduleAppointment();
                case 4 : viewAppointments();
                case 5 : generateBill();
                case 6 : {
                    System.out.println("Exiting system. Goodbye!");
                    return;
                }
                default : System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void managePatients() {
        System.out.println("\n--- Manage Patients ---");
        System.out.println("1. Add Patient");
        System.out.println("2. View Patients");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 : addPatient();
            case 2 : viewPatients();
            default : System.out.println("Invalid choice.");
        }
    }

    private static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Patient Ailment: ");
        String ailment = scanner.nextLine();

        patients.add(new Patient(id, name, age, ailment));
        System.out.println("Patient added successfully!");
    }

    private static void viewPatients() {
        System.out.println("\n--- Patient List ---");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void manageDoctors() {
        System.out.println("\n--- Manage Doctors ---");
        System.out.println("1. Add Doctor");
        System.out.println("2. View Doctors");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 : addDoctor();
            case 2 : viewDoctors();
            default : System.out.println("Invalid choice.");
        }
    }

    private static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Doctor Specialization: ");
        String specialization = scanner.nextLine();

        doctors.add(new Doctor(id, name, specialization));
        System.out.println("Doctor added successfully!");
    }

    private static void viewDoctors() {
        System.out.println("\n--- Doctor List ---");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private static void scheduleAppointment() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        appointments.add(new Appointment(patientId, doctorId, date));
        System.out.println("Appointment scheduled successfully!");
    }

    private static void viewAppointments() {
        System.out.println("\n--- Appointment List ---");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private static void generateBill() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor Fee: ");
        double doctorFee = scanner.nextDouble();
        System.out.print("Enter Medicine Charges: ");
        double medicineCharges = scanner.nextDouble();
        System.out.print("Enter Other Charges: ");
        double otherCharges = scanner.nextDouble();

        double total = doctorFee + medicineCharges + otherCharges;
        System.out.printf("Total Bill for Patient ID %d: $%.2f%n", patientId, total);
    }
}
