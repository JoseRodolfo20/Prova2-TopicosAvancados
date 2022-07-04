package br.edu.univas.si7.leonardohenrique.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.edu.univas.si7.leonardohenrique.model.Employee;

public class EmployeeDTO {
	
	@NotNull(message = "O CPF não pode ser null.")
	@NotEmpty(message = "O CPF não pode ser vazio.")
	@Size(max = 11, message = "O CPF deve ter 11 caracteres.")
	private String cpf;
	
	@NotNull(message = "O nome não pode ser null.")
	@NotEmpty(message = "O nome não pode ser vazio.")
    private String name;
	
	@NotNull(message = "As horas extras trabalhadas não pode ser null.")
	@NotEmpty(message = "As horas extras trabalhadas não pode ser vazia.")
    private String extraWorkedHours;
	
	@NotNull(message = "A ultima data de treinamento não pode ser null.")
	@NotEmpty(message = "A ultima data de treinamento não pode ser vazia.")
    private String lastTrainingDate;
	
	@NotNull(message = "O valor total da folha de pagamento não pode ser null.")
	@NotEmpty(message = "O valor total da folha de pagamento não pode ser vazio.")
    private String payrollTotalValue;
	
	public EmployeeDTO() {
	}
	
	public EmployeeDTO(Employee emp) {
		this.cpf = emp.getCpf();
		this.name = emp.getName();
		this.extraWorkedHours = emp.getExtraWorkedHours();
		this.lastTrainingDate = emp.getLastTrainingDate();
		this.payrollTotalValue = emp.getPayrollTotalValue();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtraWorkedHours() {
		return extraWorkedHours;
	}

	public void setExtraWorkedHours(String extraWorkedHours) {
		this.extraWorkedHours = extraWorkedHours;
	}

	public String getLastTrainingDate() {
		return lastTrainingDate;
	}

	public void setLastTrainingDate(String lastTrainingDate) {
		this.lastTrainingDate = lastTrainingDate;
	}

	public String getPayrollTotalValue() {
		return payrollTotalValue;
	}

	public void setPayrollTotalValue(String payrollTotalValue) {
		this.payrollTotalValue = payrollTotalValue;
	}
	
	

}
