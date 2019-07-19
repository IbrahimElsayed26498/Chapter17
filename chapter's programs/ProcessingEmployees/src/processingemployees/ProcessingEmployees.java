/*
In the name of Allah, the Gracious, the Merciful
 */
package processingemployees;

// Processing streams of Employee objects
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author ibrahim
 */
public class ProcessingEmployees {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// initialize array of Employees
		Employee[] employees = {
			new Employee("Jason", "Red", 5000, "IT"),
			new Employee("Ashley", "Green", 7600, "IT"),
			new Employee("Matthew", "Indigo", 3587.5, "Sales"),
			new Employee("James", "Indigo", 4700.77, "Marketing"),
			new Employee("Luke", "Indigo", 6200, "IT"),
			new Employee("Jason", "Blue", 3200, "Sales"),
			new Employee("Wendy", "Brown", 4236.4, "Marketing")};
			
		// get List view of the Employees
		List<Employee> list = Arrays.asList(employees);
		
		//display all employees
		System.out.println("Complete Employee list");
		list.stream().forEach(System.out::println);
		
		// Predicate that returns true for salaries in the range $4000-$6000
		Predicate<Employee> fourToSixThousand = 
			e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);
		
		// Display Employees with salaries in the range $4000-$6000
		// sorted into ascending order by salary
		System.out.printf(
				"%nEmployees earning $4000-$6000 per month sorted by salary:%n");
		list.stream()
				.filter(fourToSixThousand)
				.sorted(Comparator.comparing(Employee::getSalary))
				.forEach(System.out::println);
		
		// display first Employee with salary ing the range $4000-$6000
		System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
			list.stream()
				.filter(fourToSixThousand)
				.findFirst()
				.get());
		
		// Functions to get first and last name from employee
		Function<Employee, String> byFirstName = Employee::getFirstName;
		Function<Employee, String> byLasttName = Employee::getLastName;
		
		// comparator for camparing employee by first name then last name
		Comparator<Employee> lastThenFirst = 
				Comparator.comparing(byLasttName).thenComparing(byFirstName);
		
		System.out.printf("%nEmployees in ascending order by last name then first name:%n");
		list.stream()
			.sorted(lastThenFirst)
			.forEach(System.out::println);
		
		// sort employees in descendnig order by last name then first name
		System.out.printf("%nEmployees in descending order by last name then first name:%n");
		list.stream()
			.sorted(lastThenFirst.reversed())
			.forEach(System.out::println);
		
		// display unique employee last names sorted
		System.out.printf("%nUnique employees last names:%n");
		list.stream()
			.map(Employee::getLastName)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		// display only first and last names
		System.out.printf(
				"%nEmployee names in order by last name then first name:%n");
		list.stream()
				.sorted(lastThenFirst)
				.map(Employee::getName)
				.forEach(System.out::println);
		
		// group Employees by department
		System.out.printf("%nEmployees by department:%n");
		Map<String, List<Employee>> groupByDepartment = 
				list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		groupByDepartment.forEach(
			(department, employeesInDepartment) -> 
			{
				System.out.println(department);
				employeesInDepartment.forEach(
				employee -> System.out.printf("    %s%n", employee));
			});
		
		// count number of employees in each department
		System.out.printf("%nCount of Employees by department:%n");
		Map<String, Long> employeeCountByDepartment = 
				list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.counting()));
		
		employeeCountByDepartment.forEach(
		(department, count) -> System.out.printf(
				"%s has %d employee(s)%n", department, count));
		
		// sum of Employee salaries with DoubleStream sum method
		System.out.printf(
				"%nSum of Employees' salaries (via sum method): %.2f%n",
				list.stream()
					.mapToDouble(Employee::getSalary)
					.sum());
		
		// calculate sum of employee salaries with Stream reduce method
		System.out.printf(
				"Sum of Employees' salaries (via reduce method): %.2f%n",
				list.stream()
					.mapToDouble(Employee::getSalary)
					.reduce(0, (value1, value2) -> value1 + value2));
		
		//average of Employee salaries with DoubleStream average method
		System.out.printf("Average of Employees' salaries: %.2f%n",
				list.stream()
					.mapToDouble(Employee::getSalary)
					.average()
					.getAsDouble());
	}

}
