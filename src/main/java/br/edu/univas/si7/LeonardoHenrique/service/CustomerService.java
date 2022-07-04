package br.edu.univas.si7.LeonardoHenrique.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.univas.si7.LeonardoHenrique.dto.CustomerDTO;
import br.edu.univas.si7.LeonardoHenrique.exception.InvalidDataException;
import br.edu.univas.si7.LeonardoHenrique.exception.ObjectNotFoundException;
import br.edu.univas.si7.LeonardoHenrique.model.Customer;
import br.edu.univas.si7.LeonardoHenrique.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public List<Customer> findAll() {
		return repo.findAll();
	}

	public Customer findById(long id) {
		Optional<Customer> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Customer " + id + " not found."));
	}

	public long createCustomer(Customer customer) {
		Optional<Customer> existingCustomer = repo.findById(customer.getCpf());
		if (existingCustomer.isPresent()) {
			throw new InvalidDataException("Customer already exist with this id: " + customer.getCpf());
		}
		repo.save(customer);
		return customer.getCpf();
	}

	public Customer toCustomer(CustomerDTO customer) {
		return new Customer(customer.getName());
	}

	public void updateCustomer(Customer customer, long id) {
		if (customer == null) {
			throw new InvalidDataException("Invalid customer id.");
		}
		Customer existingObj = findById(id);
		updateData(existingObj, customer);
		repo.save(customer);
	}

	private void updateData(Customer existingObj, Customer customer) {
		existingObj.setName(customer.getName());
	}

	public void deleteCustomer(long id) {
		if (Objects.isNull(id)) {
			throw new InvalidDataException("Category id can not be null.");
		}
		Customer cust = findById(id);
		try {
			repo.delete(cust);
		} catch (DataIntegrityViolationException e) {
			throw new InvalidDataException("Can not delete a customer");
		}
	}
}
