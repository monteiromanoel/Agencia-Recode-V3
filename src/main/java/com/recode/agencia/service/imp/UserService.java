package com.recode.agencia.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.recode.agencia.dto.UserDto;
import com.recode.agencia.entity.Cliente;

@Service
public interface UserService {
    void saveUser(UserDto userDto);

    Cliente findUserByEmail(String email);

    List<UserDto> findAllUsers();

	void saveUserAdmin(UserDto userDto, Cliente cliente);

	void saveUserAdmin(Cliente cliente);

}
