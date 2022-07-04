package br.edu.univas.si7.leonardohenrique.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.leonardohenrique.dto.EmployeeDTO;
import br.edu.univas.si7.leonardohenrique.model.Employee;
import br.edu.univas.si7.leonardohenrique.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping()
	public List<EmployeeDTO> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable String id) {
		Employee emp = service.getEmployeeById(id);
		return new EmployeeDTO(emp);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createEmployee(@RequestBody @Valid EmployeeDTO dto) {
		service.createEmployee(dto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateEmployee(@RequestBody @Valid EmployeeDTO dto, @PathVariable String id) {
		service.updateEmployee(dto, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable String id) {
		service.deleteEmployee(id);
	}

}
