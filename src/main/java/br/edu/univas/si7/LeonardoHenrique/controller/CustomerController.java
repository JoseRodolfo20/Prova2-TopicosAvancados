package br.edu.univas.si7.LeonardoHenrique.controller;

import java.net.URI;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.univas.si7.LeonardoHenrique.dto.CustomerDTO;
import br.edu.univas.si7.LeonardoHenrique.model.Customer;
import br.edu.univas.si7.LeonardoHenrique.service.CustomerService;

@RestController
@RequestMapping("/customers")
@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("")
	public ResponseEntity<List<CustomerDTO>> findAll() {
		List<CustomerDTO> list = service.findAll().stream().map(c -> new CustomerDTO(c)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> find(@PathVariable long id) {
		Customer customer = service.findById(id);
		return ResponseEntity.ok().body(new CustomerDTO(customer));
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> createCustomer(@Valid @RequestBody CustomerDTO customer) {
		long newCustomerId = service.createCustomer(service.toCustomer(customer));

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCustomerId).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@Valid @RequestBody CustomerDTO customer, @PathVariable long id) {
		service.updateCustomer(service.toCustomer(customer), id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable long id) {
		service.deleteCustomer(id);
	}

}
