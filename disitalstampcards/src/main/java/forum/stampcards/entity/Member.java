package forum.stampcards.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="mst_member")
@Entity
@Setter
@Getter
@ToString
public class Member {

	@Id
	private String id;
	
	private String name;
	
	private String depertment;
	
	private Date attendance;
	
	@Column(name="is_online", columnDefinition = "boolean default false")
	private Boolean isOnline = false;
	
	@Column(name="has_attended", columnDefinition = "boolean default true")
	private Boolean hasAttended = true;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date createdAt;

}
