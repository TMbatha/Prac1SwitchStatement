package za.ac.cput;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * RunEmployee.java 06/02/2024
 *
 * @author Thabiso Mbatha
 */
public class RunEmployee {

    private static String name, surname, number;
    private static double salary;

    public static Employee createEmployeeDefault() {
        Employee empDef = new Employee();

        name = JOptionPane.showInputDialog("Enter Name: ");
        surname = JOptionPane.showInputDialog("Enter Surname: ");
        number = JOptionPane.showInputDialog("Enter Number: ");
        String tempSalary = JOptionPane.showInputDialog("Enter Salary: ");
        salary = Double.parseDouble(tempSalary);

        empDef.setEmpName(name);
        empDef.setEmpSurname(surname);
        empDef.setEmpNumber(number);
        empDef.setEmpSalary(salary);

        return empDef;
    }

    public static Employee createEmployeeOverloaded() {
        name = JOptionPane.showInputDialog("Enter Name: ");
        surname = JOptionPane.showInputDialog("Enter Surname: ");
        number = JOptionPane.showInputDialog("Enter Number: ");
        String tempSalary = JOptionPane.showInputDialog("Enter Salary: ");
        salary = Double.parseDouble(tempSalary);

        Employee empOvl;
        return empOvl = new Employee(name, surname, number, salary);
    }

    public static void main(String[] args) {
        /*here, in order to give the user options to choose from, like 
        adding new employees or increasing their salaries, you need to 
        have a way to store a list of existing employees in order to manipulate 
        their data.*/

        ArrayList<Employee> employeeList = new ArrayList<>();

        int counter = 1;
        while (counter == 1) {
            String input = JOptionPane.showInputDialog(null, "What would you like to do? \n"
                    + "1. Add an employee using the default constructor \n"
                    + "2. Add an employee using the overloaded constructor \n"
                    + "3. Increase employees salary \n"
                    + "4. View employees\n" 
                    + "5. Exit");

            switch (input) {
                case ("1"):
                    employeeList.add(RunEmployee.createEmployeeDefault());
                    JOptionPane.showMessageDialog(null, "Employee Created\nUsing Default\nConstructor");
                    break;
                case ("2"):
                    employeeList.add(RunEmployee.createEmployeeOverloaded());
                    JOptionPane.showMessageDialog(null, "Employee Created\nUsing Overloaded\nConstructor");
                    break;
                case ("3"):
                    String tempPercentageIncrease = JOptionPane.showInputDialog("Enter salary percentage increase: ");
                    double percentageIncrease = Double.parseDouble(tempPercentageIncrease);

                    for (Employee emp : employeeList) {
                        emp.increaseSalary(percentageIncrease);
                    }
                    break;
                case ("4"):
                    for (Employee emp : employeeList) {
                        JOptionPane.showMessageDialog(null, emp.toString() + "\n");
                    }
                    break;
                case ("5"):
                    counter -= 1;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input.");
                    break;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Thank you!");
        
    }
}
