package br.edu.univas.si7.leonardohenrique.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.univas.si7.leonardohenrique.controller.exception.InvalidDataException;
import br.edu.univas.si7.leonardohenrique.controller.exception.ObjectNotFoundException;
import br.edu.univas.si7.leonardohenrique.dto.EmployeeDTO;
import br.edu.univas.si7.leonardohenrique.model.Auditing;
import br.edu.univas.si7.leonardohenrique.model.Employee;
import br.edu.univas.si7.leonardohenrique.repository.AuditingMongoRepository;
import br.edu.univas.si7.leonardohenrique.repository.EmployeeMongoRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMongoRepository empRepo;
	
	@Autowired
	private AuditingMongoRepository audRepo;
	
	public List<EmployeeDTO> getAllEmployees(){
		List<Employee> listEMP = empRepo.findAll();
		
		return listEMP.stream()
				.map(emp -> new EmployeeDTO(emp))
				.collect(Collectors.toList());
	}
	
	public Employee getEmployeeById(@PathVariable String id){
		if(id == null) {
			throw new InvalidDataException("id não pode ser null.");
		}
		Optional<Employee> obj = empRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Mensagem não encontrada: " + id));
	}
	
	public void createEmployee(EmployeeDTO dto) {
		Employee emp = toEmployee(dto);
		Auditing aud = new Auditing();
		aud.setOperation("CREATE");
		aud.setDate(LocalDateTime.now());
		audRepo.save(aud);
		emp.setAuditing(aud);
		empRepo.save(emp);
	}
	
	public void updateEmployee(EmployeeDTO dto, String id) {
		if(dto == null) {
			throw new InvalidDataException("Mensagem não pode ser null.");
		}
		Employee emp = getEmployeeById(id);
		updateData(dto, emp);
		Auditing aud = new Auditing();
		aud.setOperation("UPDATE");
		aud.setDate(LocalDateTime.now());
		audRepo.save(aud);
		emp.setAuditing(aud);
		empRepo.save(emp);
	}
	
	public void deleteEmployee(String id) {
		Employee emp = getEmployeeById(id);
		Auditing aud = new Auditing();
		aud.setOperation("DELETE");
		aud.setDate(LocalDateTime.now());
		audRepo.save(aud);
		emp.setAuditing(aud);
		empRepo.delete(emp);
	}
	
	private void updateData(EmployeeDTO dto, Employee emp) {
		emp.setCpf(dto.getCpf());
		emp.setName(dto.getName());
		emp.setExtraWorkedHours(dto.getExtraWorkedHours());
		emp.setLastTrainingDate(dto.getLastTrainingDate());
		emp.setPayrollTotalValue(dto.getPayrollTotalValue());
	}
	
	private Employee toEmployee(EmployeeDTO dto) {
		Employee emp = new Employee();
		emp.setCpf(dto.getCpf());
		emp.setName(dto.getName());
		emp.setExtraWorkedHours(dto.getExtraWorkedHours());
		emp.setLastTrainingDate(dto.getLastTrainingDate());
		emp.setPayrollTotalValue(dto.getPayrollTotalValue());
		
		return emp;
	}

}
