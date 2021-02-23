package enumerate.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);

	}

	public Double income(Integer year, Integer mounth) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract contract : contracts) {
			cal.setTime(contract.getDate());
			var cYear = cal.get(Calendar.YEAR);
			var cMounth = 1 + cal.get(Calendar.MONTH);

			if (mounth == cMounth && year == cYear) {
				sum += contract.totalValue();
			}
		}
		return sum;
	}
}
