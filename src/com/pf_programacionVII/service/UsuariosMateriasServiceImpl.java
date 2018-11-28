package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.UsuariosMaterias;
import com.pf_programacionVII.repository.UsuariosMateriasRepository;

public class UsuariosMateriasServiceImpl implements UsuariosMateriasService {

	UsuariosMateriasRepository usuariosMateriasRepository = new UsuariosMateriasRepository();
	
	@Override
	public ArrayList<UsuariosMaterias> getAll() {
		return usuariosMateriasRepository.getAll("Call UsuariosMaterias()");
	}
	
	@Override
	public ArrayList<UsuariosMaterias> getAllByIdUsuario(int idUsuario) {
		return usuariosMateriasRepository.getAllByIdUsuario("Call GetUsuariosMaterias()",idUsuario);
	}

	@Override
	public UsuariosMaterias getUsuariosMateriasByJoinIdAndIdUsuario(int idJoin, int idUsuario) {
		return usuariosMateriasRepository.getUsuariosMateriasByJoinIdAndIdUsuario("Call GetUsuariosMateriasByIdPlanEstudioMateriasAndIdUsuario(?,?)", idJoin, idUsuario);
	}

	@Override
	public UsuariosMaterias getUsuariosMateriasById(int idUsuariosMaterias) {
		return usuariosMateriasRepository.getUsuariosMateriasById("Call GetUsuariosMateriasById(?)", idUsuariosMaterias);
	}

	@Override
	public void insertUsuariosMaterias(UsuariosMaterias usuariosMaterias) {
		usuariosMateriasRepository.insertUsuariosMaterias("Call SetUsuariosMaterias(?,?,?)", usuariosMaterias);
		
	}

	@Override
	public void updatetUsuariosMaterias(UsuariosMaterias usuariosMaterias) {
		usuariosMateriasRepository.updatetUsuariosMaterias("Call UpdateUsuariosMaterias(?,?,?,?)", "Call GetUsuariosMateriasById(?)", usuariosMaterias);
		
	}

	@Override
	public void deleteUsuariosMaterias(int idUsuariosMaterias) {
		usuariosMateriasRepository.deleteUsuariosMaterias("Call DeleteUsuariosMaterias", idUsuariosMaterias);
		
	}

	@Override
	public void deleteUsuariosMateriasByIdUsuario(int idUsuario) {
		usuariosMateriasRepository.deleteUsuariosMateriasByIdUsuario("Call DeleteUsuariosmateriasByIdUsuario", idUsuario);
		
	}

	



}
