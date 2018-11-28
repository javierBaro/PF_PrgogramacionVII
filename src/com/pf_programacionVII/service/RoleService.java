package com.pf_programacionVII.service;

import java.util.ArrayList;
import com.pf_programacionVII.model.Role;

public interface RoleService {

	public ArrayList<Role> getAllRole() ;
	public Role getRoleByidRole(int idRole);
	public void insertRole(String role);
	public void updateRole(Role role);
    public void deleteRole(int idRole);
}
