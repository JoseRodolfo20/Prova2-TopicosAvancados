package com.univas.JoseRodolfo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univas.JoseRodolfo.Service.SalesmanService;

@RestController
@RequestMapping("/auditings")
public class AuditingController {

    @Autowired
	private SalesmanService service;
	
	@GetMapping()
	public List<Auditing> getAllAuditings(){
		return service.getAllAuditing();
	}

    
}
