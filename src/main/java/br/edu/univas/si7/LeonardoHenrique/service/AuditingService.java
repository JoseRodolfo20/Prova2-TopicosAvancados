package br.edu.univas.si7.leonardohenrique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.si7.leonardohenrique.model.Auditing;
import br.edu.univas.si7.leonardohenrique.repository.AuditingMongoRepository;

@Service
public class AuditingService {
	
	@Autowired
	private AuditingMongoRepository audRepo;
	
	public List<Auditing> getAllAuditing(){
		return audRepo.findAll();	
	}

}
