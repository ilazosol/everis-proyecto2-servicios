package com.everis.springboot.credits.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.springboot.credits.document.CreditDocument;
import com.everis.springboot.credits.service.CreditService;

import reactor.core.publisher.Mono;

@RestController
public class CreditController {
	
	@Autowired
	private CreditService creditService;
	
	@PostMapping("/saveCredit/{idClient}")
	public Mono<ResponseEntity<Map<String,Object>>> saveCredit(@PathVariable String idClient,@Valid @RequestBody CreditDocument document){
		return creditService.saveCredit(idClient,document);
	}
	
	@PostMapping("/pay/{id}/{amount}")
	public Mono<ResponseEntity<Map<String,Object>>> payCredit(@PathVariable String id, @PathVariable Double amount){
		return creditService.payCredit(id, amount);
	}
	
	@PostMapping("/spend/{id}/{amount}")
	public Mono<ResponseEntity<Map<String,Object>>> spendCredit(@PathVariable String id, @PathVariable Double amount){
		return creditService.spendCredit(id, amount);
	}
	
	@GetMapping("/getBalance/{idCredit}")
	public Mono<ResponseEntity<Map<String,Object>>> getBalance(@PathVariable("idCredit") String idCredit) {
		return creditService.consultCredit(idCredit);
	}

}
