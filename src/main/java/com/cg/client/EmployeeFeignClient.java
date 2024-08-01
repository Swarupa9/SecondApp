package com.cg.client;

import com.cg.bo.ClientBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "employeeFeignClient", url = "http://localhost:8080")
public interface EmployeeFeignClient {

    @GetMapping("/emp")
    List<ClientBO> getAllEmployees();
}
