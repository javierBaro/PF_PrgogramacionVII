package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.UsuariosMaterias;

public interface UsuariosMateriasService {
	public ArrayList<UsuariosMaterias> getAll();
	public ArrayList<UsuariosMaterias> getAllByIdUsuario(int idUsuario);
	public UsuariosMaterias getUsuariosMateriasByJoinIdAndIdUsuario(int idJoin,int idUsuario);
	public UsuariosMaterias getUsuariosMateriasById( int idUsuariosMaterias);
	public UsuariosMaterias getUsuariosMateriasByIdUsuarioAndIdMateria( int idUsuario,int idMateria);
	public void insertUsuariosMaterias(UsuariosMaterias usuariosMaterias);
	public void updatetUsuariosMaterias(UsuariosMaterias usuariosMaterias);
	public void deleteUsuariosMaterias(int idUsuariosMaterias);
	public void deleteUsuariosMateriasByIdUsuario(int idUsuario);
}
