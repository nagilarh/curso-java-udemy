package enumerate;

import enumerate.entities.Department;
import enumerate.entities.HourContract;
import enumerate.entities.Worker;
import enumerate.entities.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Course {
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.print("Enter worker data: ");
		System.out.print("Name: ");
		String workName = sc.nextLine();
		System.out.print("Level: ");
		String workLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();

		Worker worker = new Worker(workName, WorkerLevel.valueOf(workLevel), baseSalary, new Department(departmentName));

		System.out.print("How many contracts to this worker?");
		var n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.print("Enter mounth and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		var month = Integer.parseInt(monthAndYear.substring(0,2));
		var year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Depertament: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + " : " + String.format("%.2f", worker.income(year, month)));

		sc.close();
	}
}
