package com.pf_programacionVII.service;


import java.util.ArrayList;

import com.pf_programacionVII.model.User;
import com.pf_programacionVII.repository.UserRepository;

public class UserServiceImpl implements UserService {

	UserRepository userRepository =new UserRepository();
	
	@Override
	public ArrayList<User> getAllUsuarios() {
			return userRepository.getAll("CALL GetUsuarios()");
	}

	@Override
	public User getUsuarioByUsuario(String usuario) {
		return userRepository.getUserByUsuario("CALL GetUsuarioByUsuario(?)", usuario);
	}

	@Override
	public void insertUser( User usuario) {
		userRepository.insertUser("CALL SetUsuario(?,?,?,?,?)", usuario);
	}

	@Override
	public void updateUser(User usuario) {
		userRepository.updatetUser("CALL UpdateUsuario(?,?,?,?,?,?)","CALL GetUsuarioById(?)", usuario);
	}

	@Override
	public void deleteUser(int idUsuario) {
		userRepository.deleteUser("Call DeleteUsuario(?)", idUsuario);
	}

	@Override
	public User getUsuarioById(int idUsuario) {
		return userRepository.getUserById("Call GetUsuarioById(?)", idUsuario);
	}

	

}
