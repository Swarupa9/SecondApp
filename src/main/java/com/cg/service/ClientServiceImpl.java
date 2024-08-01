package com.cg.service;

import com.cg.bo.ClientBO;
import com.cg.client.EmployeeClient;
import com.cg.client.EmployeeFeignClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final EmployeeClient employeeClient;
    private final EmployeeFeignClient employeeFeignClient;

    @Autowired
    public ClientServiceImpl(EmployeeClient employeeClient, EmployeeFeignClient employeeFeignClient) {
        this.employeeClient = employeeClient;
        this.employeeFeignClient = employeeFeignClient;
    }

    @Override
    public List<ClientBO> getAllClients() {
    	logger.debug("Fetching all employees");
        // Using RestTemplate
        List<ClientBO> clientsFromRest = employeeClient.getAllEmployees();

        // Using Feign Client
        List<ClientBO> clientsFromFeign = employeeFeignClient.getAllEmployees();

        // Combine both lists
        clientsFromRest.addAll(clientsFromFeign);
        return clientsFromRest;
    }
}
