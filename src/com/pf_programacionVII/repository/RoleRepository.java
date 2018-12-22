package com.pf_programacionVII.repository;


import java.sql.SQLException;
import java.util.ArrayList;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.model.Materia;
import com.pf_programacionVII.model.Role;
import com.pf_programacionVII.model.User;

public class RoleRepository extends Repository<Role> {

	@Override
	protected Role getObject() {
		try {
			Role role =new Role();
			role.setId(rs.getInt("role_id"));
			role.setNombre(rs.getString("nombre"));
			return role;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Role> getAll(String procedure) {
		setStoreProcedure(procedure);
		return getMany();
	}
	
	public Role getRoleById(String procedure,int roleId)
	{
	setStoreProcedure(procedure);
	ArrayList<Object> parameters=new ArrayList<>();
	parameters.add((Integer)roleId);
	setParameters(parameters);
	return getOne();
	}
	public void insertRole(String procedure,String nombreRole) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters=new ArrayList<>();
		parameters.add(nombreRole);
		setParameters(parameters);
		save();
	}
	
	//siempre el objeto carrera tiene que traer su id
	public void updatetRole(String procedureUpdateRole, String procedureGetRole, Role role) {
		ArrayList<Object> parameters = new ArrayList<>();
		Role roleServer = getRoleById(procedureGetRole, role.getId());
		setStoreProcedure(procedureUpdateRole);
		if (roleServer != null) {
			
			if (role.getNombre() != null)
				parameters.add(role.getNombre());
			else
				parameters.add(roleServer.getNombre());			
		
			parameters.add(role.getId());

			setParameters(parameters);
			save();
		}
	}
	

	public void deleteRole(String procedure,int roleId)
	{
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(roleId);
		setParameters(parameters);
		delete();
	}
	
	
	
	
	
}
