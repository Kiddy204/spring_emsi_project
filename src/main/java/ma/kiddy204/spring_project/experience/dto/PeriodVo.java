package ma.kiddy204.spring_project.experience.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeriodVo {
	private Long id ;
	private String earliestDate;	
	private String latestDate;
	private int min_period;
	private int flexibility;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEarliestDate() {
		return earliestDate;
	}
	public void setEarliestDate(String earliestDate) {
		this.earliestDate = earliestDate;
	}
	public String getLatestDate() {
		return latestDate;
	}
	public void setLatestDate(String latestDate) {
		this.latestDate = latestDate;
	}
	public int getMin_period() {
		return min_period;
	}
	public void setMin_period(int min_period) {
		this.min_period = min_period;
	}
	public int getFlexibility() {
		return flexibility;
	}
	public void setFlexibility(int flexibility) {
		this.flexibility = flexibility;
	}
	
	
}
