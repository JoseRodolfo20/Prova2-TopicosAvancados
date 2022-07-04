package br.edu.univas.si7.leonardohenrique.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.leonardohenrique.model.Auditing;
import br.edu.univas.si7.leonardohenrique.service.AuditingService;

@RestController
@RequestMapping("/auditings")
public class AuditingController {
	
	@Autowired
	private AuditingService service;
	
	@GetMapping()
	public List<Auditing> getAllAuditings(){
		return service.getAllAuditing();
	}

}
