package com.pf_programacionVII.service;


import java.util.ArrayList;

import com.pf_programacionVII.model.User;

public interface UserService {
	
	public ArrayList<User> getAllUsuarios() ;
	public User getUsuarioByUsuario(String usuario);
	public User getUsuarioByUsuarioAndContrasena(String usuario,String contrasena);
	public User getUsuarioById(int idUsuario);
	public void insertUser(User usuario);
	public boolean insertAndReplicate(User usuario);
	public void updateUser(User usuario);
    public void deleteUser(int idUsuario);
}
