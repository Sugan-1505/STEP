public class Employee_Company_Information_Management {
    static class Employee {
        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Arun", 45000);
        Employee employee2 = new Employee("Divya", 52000);
        Employee employee3 = new Employee("Karthik", 48000);

        Employee.printCompanyInfo();
    }
}