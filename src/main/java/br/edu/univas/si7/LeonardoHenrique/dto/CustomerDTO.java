package br.edu.univas.si7.LeonardoHenrique.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.edu.univas.si7.LeonardoHenrique.model.Customer;

public class CustomerDTO {
	
	@NotNull(message = "CPF can not be null.")
	@NotEmpty(message = "CPF can not be empty.")
    private long cpf;
    
    @NotNull(message = "Name can not be null.")
	@NotEmpty(message = "Name can not be empty.")
    private String name;

    @NotNull(message = "Date can not be null.")
    @NotEmpty(message = "Date can not be empty.")
    private String birth_date;

    private String gender;

    @NotNull(message = "Email can not be null.")
	@NotEmpty(message = "Email can not be empty.")
    private String email;
    private String loyalty_rate;

    public CustomerDTO() {
	}
    public CustomerDTO(Customer customer) {
        this.cpf = customer.getCpf();
        this.name = customer.getName();
        this.birth_date = customer.getBirth_date();
        this.gender = customer.getGender();
        this.email = customer.getEmail();
        this.loyalty_rate = customer.getLoyalty_rate();
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
	public String toString() {
		return "CustomerDTO [cpf=" + cpf + ", name=" + name + ", birth_date=" + birth_date + ", gender=" + gender
				+ ", email=" + email + ", loyalty_rate=" + loyalty_rate + "]";
	}
    
	
    
    

}
