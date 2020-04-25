package com.nelioalves.cursomc.services;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random random = new Random();
	
	public void sendNewPassword(String email) {
		Optional<Cliente> obj = clienteService.findByEmail(email);
		
		if(!obj.isPresent()) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = nesPassword();
		obj.get().setSenha(pe.encode(newPass));
		clienteService.insert(obj.get());
		emailService.sendNewPasswordEmail(obj.get(), newPass);
	}

	private String nesPassword() {
		char[] vet = new char[10];
		
		for(int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
		
		return new String(vet);
	}

	private char randomChar() {
		int opt = random.nextInt(3);
		
		if(opt == 0) { //gera um digito
			return (char) (random.nextInt(10) + 48);
		}else if(opt == 1) {
			return (char) (random.nextInt(26) + 65);
		}else {
			return (char) (random.nextInt(26) + 97);
		}
	}
}
