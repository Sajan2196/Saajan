package com.bankingApp.Banking_app.Service;

import java.util.List;

import com.bankingApp.Banking_app.dto.AccountDto;

public interface AccountService {
		
	AccountDto createAccount(AccountDto accountDto);
	AccountDto deposit(Long id, Double amount);
	AccountDto getAccountById(Long id);
	AccountDto widrow(Long id, Double amount);
	List<AccountDto> getAllAccounts();
	void deleteAccount(Long id);
}
