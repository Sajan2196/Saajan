package com.bankingApp.Banking_app.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingApp.Banking_app.Entities.Account;
import com.bankingApp.Banking_app.Mapper.accountMapper;
import com.bankingApp.Banking_app.Repository.AccountRepositry;
import com.bankingApp.Banking_app.dto.AccountDto;


@SuppressWarnings("unused")
@Service
public class AccountServiceimpl implements AccountService {
	
	//private static final List<Account> AccountRepositry.findAll(); 

	@Autowired
	private AccountRepositry accountRepository;
	
	@Autowired
	private AccountDto accountDto;
	
	public AccountServiceimpl(AccountRepositry accountRepository) {
		this.accountRepository=accountRepository;
	}
	
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		Account account = accountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return accountMapper.mapToAccounDto(savedAccount);

	}


	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		
		return accountMapper.mapToAccounDto(account);
	}


	
	public AccountDto deposit(Long id, Double amount) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		
		return  accountMapper.mapToAccounDto(savedAccount);
	}


	@Override
	public AccountDto widrow(Long id, Double amount) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		
		if(account.getBalance()<amount) {
			throw new RuntimeException("unsufficient amount");
		}
		
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		
		return accountMapper.mapToAccounDto(savedAccount);
	}


	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> accountMapper.mapToAccounDto(account)).collect(Collectors.toList());
		
	}


	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		accountRepository.deleteById(id);
		
	}


	

	
}
