package com.cg.controller;

import com.cg.bo.ClientBO;
import com.cg.service.ClientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee-client")
public class ClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/feign")
    public List<ClientBO> getEmployeesUsingFeign() {
    	logger.info("Fetching all employees");
        return clientService.getAllClients();
    }

    @GetMapping("/rest-template")
    public List<ClientBO> getEmployeesUsingRestTemplate() {
    	logger.info("Fetching all employees");
        return clientService.getAllClients();
    }
}
