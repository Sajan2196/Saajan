package com.bankingApp.Banking_app.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Banking_data")
@Entity

public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Account_Holder_name")
	private String accountHolerName;

	private double balance;

//	public Account() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Account(long id, String accountHolerName, double balance) {
//		super();
//		this.id = id;
//		this.accountHolerName = accountHolerName;
//		this.balance = balance;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

}
