package com.pf_programacionVII.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pf_programacionVII.model.JoinPlanEstudioMaterias;
import com.pf_programacionVII.model.MateriaRealizada;
import com.pf_programacionVII.model.Tree;
import com.pf_programacionVII.model.User;
import com.pf_programacionVII.model.UsuariosMaterias;
import com.pf_programacionVII.repository.UserRepository;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository =new UserRepository();
	private JoinPlanEstudioMateriasServiceImpl join =new JoinPlanEstudioMateriasServiceImpl();
	private UsuariosMateriasServiceImpl usuariosMateriasService = new UsuariosMateriasServiceImpl();
	private CarreraServiceImpl carreraService= new CarreraServiceImpl();
	
	
	
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

	@Override
	public boolean insertAndReplicate(User usuario) {
		
		if(getUsuarioByUsuario(usuario.getUsuario())==null)
		{
			insertUser(usuario);
			User userInsertado = getUsuarioByUsuario(usuario.getUsuario());

			for(JoinPlanEstudioMaterias join: join.getJoinByidPlanEstudio(usuario.getPlanStudioId()))
			{
				usuariosMateriasService.insertUsuariosMaterias(new UsuariosMaterias(userInsertado.getId(),join.getId(),0));
			}
			return true;
		}
		return false;	
	}
	public ArrayList<String> getStringFathersAndChildTree(User actualUser) {
		ArrayList<String> arrayList =new ArrayList<>();
		Tree tree = new Tree();
		System.out.println(actualUser);
		String carrera = carreraService.getCarreraByidPlanEstudio(actualUser.getPlanStudioId()).getNombre() ;
		arrayList.add(tree.getStringFathersAndChildTree(actualUser, carrera));
		arrayList.add(tree.getStringNoRalizado());
		return arrayList;
	}
	public ArrayList<MateriaRealizada> getMateriaRelizada(User actualUser) {
		String carrera = carreraService.getCarreraByidPlanEstudio(actualUser.getPlanStudioId()).getNombre() ;
		Tree tree = new Tree();
		tree.getStringFathersAndChildTree(actualUser,carrera);
		Set<String> nameSet = new HashSet<>();	 
		return (ArrayList<MateriaRealizada>) tree.getMateriaRealizadas().stream().filter(e -> nameSet.add(e.getNombre())).collect(Collectors.toList());
	}
	
	public void UpdateUsuariosMaterias(ArrayList<UsuariosMaterias> usuariosMaterias)
	{
		for(UsuariosMaterias usuariosMateriasItem:usuariosMaterias)
		{System.out.println("idUsuarioMateria: "+usuariosMateriasItem.getId()+
				"idUsuario: "+usuariosMateriasItem.getUsuarioId()+
				"idJoin: "+usuariosMateriasItem.getPlanEstudioMateriasId()+
				"idRealizado: "+usuariosMateriasItem.getRealizado());
			usuariosMateriasService.updatetUsuariosMaterias(usuariosMateriasItem);
		}
	}


}
