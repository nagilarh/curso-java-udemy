package enumerate.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class HourContract {
	private Date date;
	private double valuePerHour;
	private int hours;

	public double totalValue() {
		return valuePerHour * hours;
	}
}


