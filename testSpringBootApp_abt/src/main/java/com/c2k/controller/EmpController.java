package com.c2k.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import com.c2k.model.Employee;
import com.c2k.service.serviceimpl.EmpServiceImpl;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RouterOperation(path = "save employee" )
@ApiResponses(value = { 
  @ApiResponse(responseCode = "201", description = "emp created", 
    content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Employee.class)) }),
  @ApiResponse(responseCode = "400", description = "Invalid emp object", 
    content = @Content), 
  @ApiResponse(responseCode = "404", description = "Emp not found", 
    content = @Content) })
@RestController
public class EmpController {
	@Autowired
	EmpServiceImpl empServiceImpl;

	@PostMapping("/saveemp")
	public ResponseEntity<String> saveemp(@RequestBody Employee e) {
		String s = "Employee saved with id: " + empServiceImpl.saveemp(e).getId();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "employee_abt");
		return new ResponseEntity<String>(s, responseHeaders, HttpStatus.CREATED);

	}

}
