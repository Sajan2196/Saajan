package com.bankingApp.Banking_app.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingApp.Banking_app.Service.AccountService;
import com.bankingApp.Banking_app.dto.AccountDto;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	// add account rest api
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accouontDto) {
		return new ResponseEntity<>(accountService.createAccount(accouontDto), HttpStatus.CREATED);
	}
	// get account rest

	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}

	// deposit
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {

		Double amount = request.get("amount");
		AccountDto accountDto = accountService.deposit(id, amount);
		return ResponseEntity.ok(accountDto);
	}

	// widraw
	@PutMapping("/{id}/widraw")
	public ResponseEntity<AccountDto> widrow(@PathVariable Long id, @RequestBody Map<String, Double> request) {

		double amount = request.get("amount");
		AccountDto accountDto = accountService.widrow(id, amount);
		return ResponseEntity.ok(accountDto);
	}

	// get all accounts REST API
	@GetMapping()
	public ResponseEntity<List<AccountDto>> getAllAccounts() {
		List<AccountDto> data = accountService.getAllAccounts();
		return ResponseEntity.ok(data);

	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account is deleted successfully");

	}
}
