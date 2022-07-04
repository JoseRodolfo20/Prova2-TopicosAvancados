package br.edu.univas.si7.LeonardoHenrique.model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditing<U> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long identifier;
	
	@Column(name = "created_date")
	@CreatedDate
	@Temporal(TIMESTAMP)
	protected Date creationDate;
	
	@Column(name = "lastMod_date")
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	protected Date lastModifiedDate;
	
	@JoinTable(name = "CUSTOMER_FK")
	protected long register_code;
	
	public Auditing() {
		
	}

	public long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public long getRegister_code() {
		return register_code;
	}

	public void setRegister_code(long register_code) {
		this.register_code = register_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (identifier ^ (identifier >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auditing other = (Auditing) obj;
		if (identifier != other.identifier)
			return false;
		return true;
	}
	
	

}
