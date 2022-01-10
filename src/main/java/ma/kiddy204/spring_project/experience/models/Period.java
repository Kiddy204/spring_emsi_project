package ma.kiddy204.spring_project.experience.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Period {
	
	@Id @GeneratedValue
	private Long id ;
	
	@Column( nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate earliestDate;
	
	
	@Column( nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate latestDate;
	
	@Column( nullable = false)
	private int min_period;
	
	@Column( nullable = false)
	private int flexibility;




	public LocalDate getEarliestDate() {
		return earliestDate;
	}

	public void setEarliestDate(LocalDate earliestDate) {
		this.earliestDate = earliestDate;
	}

	public LocalDate getLatestDate() {
		return latestDate;
	}

	public void setLatestDate(LocalDate latestDate) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
