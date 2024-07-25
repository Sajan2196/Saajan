package com.bankingApp.Banking_app.Mapper;

import com.bankingApp.Banking_app.Entities.Account;
import com.bankingApp.Banking_app.dto.AccountDto;

public class accountMapper {

	
	
	
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account (
			   accountDto.getId(),
			   accountDto.getAccountHolerName(),
			   accountDto.getBalance()
	     );	
		
		return account;
	}
	public static AccountDto mapToAccounDto(Account account) {
		AccountDto AccountDto = new AccountDto (
				   account.getId(),
				   account.getAccountHolerName(),
				   account.getBalance()
				);
		return AccountDto;
	}
	
}
