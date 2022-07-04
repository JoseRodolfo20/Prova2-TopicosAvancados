package br.edu.univas.si7.LeonardoHenrique.dto;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinTable;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import br.edu.univas.si7.LeonardoHenrique.model.Auditing;

public class AuditingDTO {
	
protected long identifier;
	
    @NotNull
	@Column(name = "created_date")
	@CreatedDate
	@Temporal(TIMESTAMP)
	protected Date creationDate;
	
	@NotNull
	@Column(name = "lastMod_date")
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	protected Date lastModifiedDate;
	
	@NotNull
	@Size(max = 20)
	@JoinTable(name = "CUSTOMER_FK")
	protected long register_code;
	
	public AuditingDTO() {
		
	}

	public AuditingDTO(Auditing auditing) {
		super();
		this.identifier = auditing.getIdentifier();
		this.creationDate = auditing.getCreationDate();
		this.lastModifiedDate = auditing.getLastModifiedDate();
		this.register_code = auditing.getRegister_code();
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
	public String toString() {
		return "AuditingDTO [identifier=" + identifier + ", creationDate=" + creationDate + ", lastModifiedDate="
				+ lastModifiedDate + ", register_code=" + register_code + "]";
	}
	
	
	
	

}
