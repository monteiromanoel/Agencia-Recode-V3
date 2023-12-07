package com.recode.agencia.service.imp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.recode.agencia.dto.UserDto;
import com.recode.agencia.entity.Cliente;
import com.recode.agencia.entity.Role;
import com.recode.agencia.repository.ClienteRepository;
import com.recode.agencia.repository.RoleRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public void saveUser(UserDto userDto) {
		Cliente cliente = new Cliente();
		cliente.setNome(userDto.getNome());
		cliente.setEmail(userDto.getEmail());
		cliente.setSenha(passwordEncoder.encode(userDto.getSenha()));
		
		Role role = roleRepository.findByName("ROLE_USER");
		if(role == null) {
            role = checkRoleExist();
        }
		cliente.setRoles(Arrays.asList(role));
		clienteRepository.save(cliente);
	}
	
	@Override
	public void saveUserAdmin(Cliente cliente) {
		Cliente newCliente = new Cliente();
		newCliente.setNome(cliente.getNome());
		newCliente.setEmail(cliente.getEmail());
		newCliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
		newCliente.setDocumento(cliente.getDocumento());
		newCliente.setData_nasc(cliente.getData_nasc());
		newCliente.setCep(cliente.getCep());
		newCliente.setLogradouro(cliente.getLogradouro());
		newCliente.setTelefone(cliente.getTelefone());
		newCliente.setUf(cliente.getUf());
		
		Role role = roleRepository.findByName("ROLE_USER");
		if(role == null) {
            role = checkRoleExist();
        }
		cliente.setRoles(Arrays.asList(role));
		clienteRepository.save(newCliente);
	}
	
	@Override
	public Cliente findUserByEmail(String email) {
		return clienteRepository.findByEmail(email);
	}
	
	@Override
	public List<UserDto> findAllUsers(){
		List<Cliente> clientes = clienteRepository.findAll();	
		return clientes.stream()
				.map((cliente) -> mapToUserDto(cliente))
				.collect(Collectors.toList());
	}

	private UserDto mapToUserDto(Cliente cliente) {
		UserDto userDto = new UserDto();
		userDto.setNome(cliente.getNome());
		userDto.setEmail(cliente.getEmail());
		return userDto;
	}
	
	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_USER");
		return roleRepository.save(role);
	}

	@Override
	public void saveUserAdmin(UserDto userDto, Cliente cliente) {
		// TODO Auto-generated method stub
		
	}
	
}
