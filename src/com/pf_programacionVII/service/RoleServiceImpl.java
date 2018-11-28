package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.Role;
import com.pf_programacionVII.repository.RoleRepository;

public class RoleServiceImpl implements RoleService{

	RoleRepository roleRepository = new RoleRepository();
	
	@Override
	public ArrayList<Role> getAllRole() {
		return roleRepository.getAll("Call GetRoles()");
	}

	@Override
	public Role getRoleByidRole(int idRole) {
		return roleRepository.getRoleById("Call GetRoleById(?)", idRole);
	}

	@Override
	public void insertRole(String role) {
		roleRepository.insertRole("Call SetRole(?)", role);
		
	}

	@Override
	public void updateRole(Role role) {
		roleRepository.updatetRole("Call UpdateRole(?)", "Call GetRoleById(?)", role);
		
	}

	@Override
	public void deleteRole(int idRole) {
		roleRepository.deleteRole("Call DeleteRole(?)", idRole);
		
	}

}
