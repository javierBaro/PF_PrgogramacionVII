package com.pf_programacionVII.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.model.User;

public class UserRepository extends Repository<User> {

	@Override
	protected User getObject() {
		try {
			User user = new User();
			user.setId(rs.getInt("usuarios_id"));
			user.setNombre(rs.getString("nombre"));
			user.setContrasena(rs.getString("contrasena"));
			user.setUsuario(rs.getString("usuario"));
			user.setPlanStudioId(rs.getInt("plan_estudio_id"));
			user.setRolesId(rs.getInt("role_id"));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<User> getAll(String procedure) {
		setStoreProcedure(procedure);
		return getMany();
	}

	public User getUserByUsuario(String procedure, String usuario) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(usuario);
		setParameters(parameters);
		return getOne();
	}

	public User getUserById(String procedure, int usuarioId) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(usuarioId);
		setParameters(parameters);
		return getOne();
	}

	public void insertUser(String procedure, User usuario) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(usuario.getNombre());
		parameters.add(usuario.getUsuario());
		parameters.add(usuario.getContrasena());
		parameters.add(usuario.getPlanStudioId());
		parameters.add(usuario.getRolesId());
		setParameters(parameters);
		save();
	}
//el objeto User siempre tiene que tener id
	public void updatetUser(String procedureUpdateUsuario, String procedureGetUsuario, User usuario) {
		ArrayList<Object> parameters = new ArrayList<>();
		User user = getUserById(procedureGetUsuario, usuario.getId());
		setStoreProcedure(procedureUpdateUsuario);
		if (user != null) {
			
			if (usuario.getNombre() != null)
				parameters.add(usuario.getNombre());
			else
				parameters.add(user.getNombre());			

			if (usuario.getUsuario() != null)
				parameters.add(usuario.getUsuario());
			else
				parameters.add(user.getUsuario());
			
			if (usuario.getContrasena() != null)
				parameters.add(usuario.getContrasena());
			else
				parameters.add(user.getContrasena());
			
			if (usuario.getPlanStudioId() != 0)
				parameters.add(usuario.getPlanStudioId());
			else
				parameters.add(user.getPlanStudioId());
			
			if (usuario.getRolesId() != 0)
				parameters.add(usuario.getRolesId());
			else
				parameters.add(user.getRolesId());
			
			parameters.add(usuario.getId());

			setParameters(parameters);
			save();
		}
	}
	public void deleteUser(String procedure,int userId)
	{
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(userId);
		setParameters(parameters);
		delete();
	}
}
