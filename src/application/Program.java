package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		List<Employee> employees = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i);
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			while (hasId(employees, id) != null) {
				System.out.print("This id already exists, type again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			employees.add(new Employee(id, name, salary));
		}
		
		System.out.print("Enter the employee id that will have the salary increase: ");
		int id = sc.nextInt();
		
		Employee emp = hasId(employees, id);
		
		while (emp == null) {
			System.out.println("This id does not exist, try again: ");
			id = sc.nextInt();
			emp = hasId(employees, id);
		}
		
		System.out.print("Enter the percentage: ");
		double percentage = sc.nextDouble();
		
		emp.increaseSalary(percentage);
		
		for (Employee employee : employees) {
			System.out.println("List of employees: " + employee);
		}
		
		sc.close();
	}
	
	public static Employee hasId(List<Employee> employee, int id) {
		Employee emp = employee.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp;
	}
}
