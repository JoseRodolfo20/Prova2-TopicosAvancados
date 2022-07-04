package br.edu.univas.si7.LeonardoHenrique.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
                     //extends Auditing<String>
public class Customer implements Serializable{
	
	@Id
    private long cpf;

    private String name;
    private String birth_date;
    private String gender;
    private String email;
    private String loyalty_rate;

    public Customer() {
	}

	public Customer(String name2) {
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoyalty_rate() {
		return loyalty_rate;
	}

	public void setLoyalty_rate(String loyalty_rate) {
		this.loyalty_rate = loyalty_rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cpf ^ (cpf >>> 32));
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
		Customer other = (Customer) obj;
		if (cpf != other.cpf)
			return false;
		return true;
	}
    
	
    
   

}
