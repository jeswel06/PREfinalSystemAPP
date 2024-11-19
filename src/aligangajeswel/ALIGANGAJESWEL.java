
package aligangajeswel;



import java.sql.Date;
import java.util.Scanner;

public class ALIGANGAJESWEL {
    private static final Scanner scanner = new Scanner(System.in);
    private static final config config = new config();

   public static void main(String[] args) {
 
    while (true) {
        System.out.println("JOB APPLICATION SYSTEM");
        System.out.println("===================================================");
        System.out.println("1. Applicants");
        System.out.println("2. Job Applications");
        System.out.println("3. Jobs");
        System.out.println("4. Reports");
        System.out.println("5. Exit");
        System.out.println("===================================================");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                manageApplicants();
                break;
            case 2:
                manageJobApplications();
                break;
            case 3:
                manageJobs(); 
                break;
            case 4:
                generateReports();
                break;
            case 5:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

   
  

    private static void manageApplicants() {
        while (true) {
            System.out.println("=== Manage Applicants ===");
            System.out.println("1. Add Applicant");
            System.out.println("2. View All Applicants");
            System.out.println("3. Update Applicant");
            System.out.println("4. Delete Applicant");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addApplicant();
                    break;
                case 2:
                    viewApplicants();
                    break;
                case 3:
                    viewApplicants();
                    updateApplicant();
                    viewApplicants();
                    break;
                case 4:
                    viewApplicants();
                    
                    deleteApplicant();
                    viewApplicants();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addApplicant() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        String sql = "INSERT INTO Applicants (name, email, phone) VALUES (?, ?, ?)";
        config.addRecord(sql, name, email, phone);
    }

    private static void viewApplicants() {
        String sql = "SELECT * FROM Applicants";
        String[] headers = {"ID", "Name", "Email", "Phone"};
        String[] columnNames = {"id", "name", "email", "phone"};
        config.viewRecords(sql, headers, columnNames);
    }

  private static void updateApplicant() {
    System.out.print("Enter applicant ID to update: ");
    int id = getValidIntegerInput();

    System.out.print("Enter new name: ");
    String name = scanner.nextLine();
    System.out.print("Enter new email: ");
    String email = scanner.nextLine();
    System.out.print("Enter new phone: ");
    String phone = scanner.nextLine();

    String sql = "UPDATE Applicants SET name = ?, email = ?, phone = ? WHERE id = ?";
    config.updateRecord(sql, name, email, phone, id);
}

   private static void deleteApplicant() {
    System.out.print("Enter applicant ID to delete: ");
    int id = getValidIntegerInput(); 
    String sql = "DELETE FROM Applicants WHERE id = ?";
    config.deleteRecord(sql, id);
}

    private static void manageJobApplications() {
    while (true) {
        System.out.println("=== Manage Job Applications ===");
        System.out.println("1. Add Job Application");
        System.out.println("2. View All Job Applications");
        System.out.println("3. Update Job Application");
        System.out.println("4. Delete Job Application");
        System.out.println("5. Back");
        System.out.print("Choose an option: ");
        
        int choice = getValidIntegerInput();

        switch (choice) {
            case 1:
                viewApplicants(); 
                addJobApplication();
                break;
            case 2:
                viewJobApplications();
                break;
            case 3:
                viewJobApplications(); 
                updateJobApplication();
                viewJobApplications(); 
                break;
            case 4:
                viewJobApplications(); 
                deleteJobApplication();
                viewJobApplications(); 
                break;
            case 5:
                return; 
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

    private static void addJobApplication() {
    System.out.print("Enter applicant ID: ");
    int applicantId = getValidIntegerInput();
    System.out.print("Enter job title: ");
    String jobTitle = scanner.nextLine();
    System.out.print("Enter application date (YYYY-MM-DD): ");
    String dateString = scanner.nextLine();
    Date applicationDate = Date.valueOf(dateString);
    System.out.print("Enter status: ");
    String status = scanner.nextLine();

    String sql = "INSERT INTO JobApplications (applicantId, jobTitle, applicationDate, status) VALUES (?, ?, ?, ?)";
    config.addRecord(sql, applicantId, jobTitle, applicationDate, status);
}

    private static void viewJobApplications() {
        String sql = "SELECT j.id, a.name, j.jobTitle, j.applicationDate, j.status " +
                     "FROM JobApplications j INNER JOIN Applicants a ON j.applicantId = a.id";
        String[] headers = {"Application ID", "Applicant Name", "Job Title", "Application Date", "Status"};
        String[] columnNames = {"id", "name", "jobTitle", "applicationDate", "status"};
        config.viewRecords(sql, headers, columnNames);
    }

    private static void updateJobApplication() {
    System.out.print("Enter job application ID to update: ");
    int id = getValidIntegerInput(); 

    System.out.print("Enter new job title: ");
    String jobTitle = scanner.nextLine();
    System.out.print("Enter new application date (YYYY-MM-DD): ");
    String dateString = scanner.nextLine();
    Date applicationDate = Date.valueOf(dateString);
    System.out.print("Enter new status: ");
    String status = scanner.nextLine();

    String sql = "UPDATE JobApplications SET jobTitle = ?, applicationDate = ?, status = ? WHERE id = ?";
    config.updateRecord(sql, jobTitle, applicationDate, status, id);
}

   private static void deleteJobApplication() {
    System.out.print("Enter job application ID to delete: ");
    int id = getValidIntegerInput(); 
    String sql = "DELETE FROM JobApplications WHERE id = ?";
    config.deleteRecord(sql, id);
}
   
   private static void manageJobs() {
    while (true) {
        System.out.println("=== Manage Jobs ===");
        System.out.println("1. Add Job");
        System.out.println("2. View All Jobs");
        System.out.println("3. Update Job");
        System.out.println("4. Delete Job");
        System.out.println("5. Back");
        System.out.print("Choose an option: ");
        int choice = getValidIntegerInput(); 

        switch (choice) {
            case 1:
                addJob();
                break;
            case 2:
                viewJobs();
                break;
            case 3:
                viewJobs();
                updateJob();
                viewJobs();
                break;
            case 4:
                viewJobs();
                deleteJob();
                viewJobs();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

private static void addJob() {
    System.out.print("Enter job title: ");
    String title = scanner.nextLine();
    System.out.print("Enter job description: ");
    String description = scanner.nextLine();

    String sql = "INSERT INTO Jobs (title, description) VALUES (?, ?)";
    config.addRecord(sql, title, description);
}

private static void viewJobs() {
    String sql = "SELECT * FROM Jobs";
    String[] headers = {"ID", "Title", "Description"};
    String[] columnNames = {"id", "title", "description"};
    config.viewRecords(sql, headers, columnNames);
}

private static void updateJob() {
    System.out.print("Enter job ID to update: ");
    int id = getValidIntegerInput(); 

    System.out.print("Enter new job title: ");
    String title = scanner.nextLine();
    System.out.print("Enter new job description: ");
    String description = scanner.nextLine();

    String sql = "UPDATE Jobs SET title = ?, description = ? WHERE id = ?";
    config.updateRecord(sql, title, description, id);
}

private static void deleteJob() {
    System.out.print("Enter job ID to delete: ");
    int id = getValidIntegerInput(); 
    String sql = "DELETE FROM Jobs WHERE id = ?";
    config.deleteRecord(sql, id);
}

    private static void generateReports() {
    System.out.println("=== Generate Reports ===");
    System.out.println("1. View All Application History");
    System.out.println("2. Individual Report of Application");
    System.out.println("3. Individual Report of Applicant");
    System.out.print("Choose an option: ");
    
    int choice = getValidIntegerInput(); 

    switch (choice) {
        case 1:
            viewAllApplications();
            break;
        case 2:
            individualApplicationReport();
            break;
        case 3:
            viewApplicants();
            individualApplicantReport();
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
    }
}

    private static void viewAllApplications() {
        String sql = "SELECT a.name, a.email, j.jobTitle, j.applicationDate, j.status " +
                     "FROM Applicants a INNER JOIN JobApplications j ON a.id = j.applicantId";
        String[] headers = {"Applicant Name", "Email", "Job Title", "Application Date", "Status"};
        String[] columnNames = {"name", "email", "jobTitle", "applicationDate", "status"};
        config.viewRecords(sql, headers, columnNames);
    }

    private static void individualApplicationReport() {
    System.out.print("Enter application ID: ");
    int applicationId = scanner.nextInt();
    String sql = "SELECT a.name, a.email, j.jobTitle, j.applicationDate, j.status " +
                 "FROM JobApplications j INNER JOIN Applicants a ON j.applicantId = a.id WHERE j.id = ?";
    String[] headers = {"Applicant Name", "Email", "Job Title", "Application Date", "Status"};
    String[] columnNames = {"name", "email", "jobTitle", "applicationDate", "status"};
    config.viewRecords(sql, headers, columnNames, applicationId);
}

   private static void individualApplicantReport() {
    System.out.print("Enter applicant ID: ");
    int applicantId = scanner.nextInt();
    String sql = "SELECT j.jobTitle, j.applicationDate, j.status " +
                 "FROM JobApplications j WHERE j.applicantId = ?";
    String[] headers = {"Job Title", "Application Date", "Status"};
    String[] columnNames = {"jobTitle", "applicationDate", "status"};
    config.viewRecords(sql, headers, columnNames, applicantId);
    
}
   private static int getValidIntegerInput() {
    while (true) {
        try {
            System.out.print("Enter an integer: ");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}
}