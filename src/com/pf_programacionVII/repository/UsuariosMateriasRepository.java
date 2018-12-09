package com.pf_programacionVII.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pf_programacionVII.model.User;
import com.pf_programacionVII.model.UsuariosMaterias;

public class UsuariosMateriasRepository extends Repository<UsuariosMaterias>{

	@Override
	protected UsuariosMaterias getObject() {
		try {
			UsuariosMaterias usuariosMaterias =new UsuariosMaterias();
			usuariosMaterias.setId(rs.getInt("usuarios_materias_id"));
			usuariosMaterias.setUsuarioId(rs.getInt("usuario_id"));
			usuariosMaterias.setPlanEstudioMateriasId(rs.getInt("plan_estudio_materias_id"));
			usuariosMaterias.setRealizado(rs.getInt("realizada"));
			return usuariosMaterias;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<UsuariosMaterias> getAll(String procedure) {
		setStoreProcedure(procedure);
		return getMany();
	}
	public ArrayList<UsuariosMaterias> getAllByIdUsuario(String procedure,int idUsuario) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();;
		parameters.add(idUsuario);
		setParameters(parameters);
		return getMany();
	}

	public UsuariosMaterias getUsuariosMateriasByJoinIdAndIdUsuario(String procedure,int idJoin,int idUsuario) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(idJoin);
		parameters.add(idUsuario);
		setParameters(parameters);
		return getOne();
	}

	public UsuariosMaterias getUsuariosMateriasById(String procedure, int idUsuariosMaterias) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(idUsuariosMaterias);
		setParameters(parameters);
		return getOne();
	}
	public UsuariosMaterias getUsuariosMateriasByIdUsuarioAndIdMateria(String procedure, int idUsuario,int idMateria) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add((Integer)idUsuario);
		parameters.add((Integer)idMateria);
		setParameters(parameters);
		return getOne();
	}

	public void insertUsuariosMaterias(String procedure, UsuariosMaterias usuariosMaterias) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(usuariosMaterias.getUsuarioId());
		parameters.add(usuariosMaterias.getPlanEstudioMateriasId());
		parameters.add(usuariosMaterias.getRealizado());
		setParameters(parameters);
		save();
	}
//el objeto UsuariosMaterias siempre tiene que tener id
	public void updatetUsuariosMaterias(String procedureUpdateUsuariosMaterias, String procedureGetUsuariosMaterias, UsuariosMaterias usuariosMaterias) {
		ArrayList<Object> parameters = new ArrayList<>();
		UsuariosMaterias usuariosMateriasServer = getUsuariosMateriasById(procedureGetUsuariosMaterias, usuariosMaterias.getId());
		setStoreProcedure(procedureUpdateUsuariosMaterias);
		if (usuariosMateriasServer != null) {
			
			if (usuariosMaterias.getUsuarioId() != 0)
				parameters.add(usuariosMaterias.getUsuarioId());
			else
				parameters.add(usuariosMateriasServer.getUsuarioId());			

			if (usuariosMaterias.getPlanEstudioMateriasId() != 0)
				parameters.add(usuariosMaterias.getPlanEstudioMateriasId());
			else
				parameters.add(usuariosMateriasServer.getPlanEstudioMateriasId());
			
			if (usuariosMaterias.getRealizado() != 0)
				parameters.add(usuariosMaterias.getRealizado());
			else
				parameters.add(usuariosMateriasServer.getRealizado());
			
			parameters.add(usuariosMaterias.getId());

			setParameters(parameters);
			save();
		}
	}
	public void deleteUsuariosMaterias(String procedure,int idUsuariosMaterias)
	{
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(idUsuariosMaterias);
		setParameters(parameters);
		delete();
	}
	public void deleteUsuariosMateriasByIdUsuario(String procedure,int idUsuario)
	{
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(idUsuario);
		setParameters(parameters);
		delete();
	}

}
