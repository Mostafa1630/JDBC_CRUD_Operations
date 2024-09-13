import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        // Testing CRUD Operations
        InsertEmployee insertEmployee = new InsertEmployee();
        SelectEmployees selectEmployees = new SelectEmployees();
        UpdateEmployee updateEmployee = new UpdateEmployee();
        DeleteEmployee deleteEmployee = new DeleteEmployee();

        try {
            // Insert records
            insertEmployee.insertRecord("Mostafa Maher", "MostafaMaher@example.com", "egypt", 90000);
            insertEmployee.insertRecord("Ahmed Maher", "AhmedMaher@example.com", "egypt", 90000);
            insertEmployee.insertRecord("Mohmed Maher", "MohmedMaher@example.com", "egypt", 90000);

            // Select records
//            System.out.println("After inserting records:");
//            selectEmployees.selectAllRecords();

            // Update record
          //  updateEmployee.updateRecord(1, "Ravi Kumar Singh", "ravi.kumar@example.com", "India", 55000);

            // Select records
            //System.out.println("After updating record with ID 1:");
           // selectEmployees.selectAllRecords();

            // Delete record
//            deleteEmployee.deleteRecord(6);

            // Select records
           // System.out.println("After deleting record with ID 3:");
            selectEmployees.selectAllRecords();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}