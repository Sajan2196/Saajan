package com.bankingApp.Banking_app.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AccountDto {

	private Long id;
	private String accountHolerName;
	private double balance;
	
	public Long getId() {
		return id;
	}
	
	
	public AccountDto(Long id, String accountHolerName, double balance) {
		super();
		this.id = id;
		this.accountHolerName = accountHolerName;
		this.balance = balance;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountHolerName() {
		return accountHolerName;
	}
	public void setAccountHolerName(String accountHolerName) {
		this.accountHolerName = accountHolerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}


	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", accountHolerName=" + accountHolerName + ", balance=" + balance + "]";
	}
	
	
	
	
}

