package forum.stampcards.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="tbl_stampcard")
@Entity
@Setter
@Getter
@ToString
public class Stampcard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="employee_id")
	private String employeeId;
	
	@Column(name="stamp_number")
	private Integer stampNumber;

	@Column(name="stamp_type")
	private Integer stampType;
	
	@CreationTimestamp
	@Column(name="stamp_date", nullable=false, updatable=false)
	private Date stampDate;
	
}
