package com.pf_programacionVII.repository;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pf_programacionVII.connection.ConnectionManager;

public abstract class Repository<T> {

	private String storeProcedure;
	private ArrayList<Object> parameters = new ArrayList<>();
	private ConnectionManager conn = new ConnectionManager();
	private ArrayList<T> al = new ArrayList<>();
	protected ResultSet rs;
	private CallableStatement stmt;

	protected void stmtClose() {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	protected void resultSetClose() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected abstract T getObject();

	protected void setParameterForProcedure() {
		try {
			int count = 0;
			if (!parameters.isEmpty())
				for (Object obj : parameters) {
					count++;
					if (obj.getClass().equals(Integer.class))
						stmt.setInt(count, (Integer) obj);
					else if (obj.getClass().equals(String.class))
						stmt.setString(count, (String) obj);
					else if (obj.getClass().equals(Double.class))
						stmt.setDouble(count, (Double) obj);
					else if (obj.getClass().equals(Float.class))
						stmt.setFloat(count, (Float) obj);
					else if (obj.getClass().equals(Date.class))
						stmt.setDate(count, (Date) obj);
					else if (obj.getClass().equals(Boolean.class))
						stmt.setBoolean(count, (Boolean) obj);
				}
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	protected ArrayList<T> getMany() {
		try {
			al.clear();
			stmt = conn.conectarMySQL().prepareCall(storeProcedure);
			setParameterForProcedure();
			System.out.println("get Many: "+stmt);
			rs = stmt.executeQuery();
			while (rs.next()) {
				al.add(getObject());
			}
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resultSetClose();
			stmtClose();
			conn.cerrarMySQL();
		}
		return null;
	}

	protected T getOne() {
		try {
			al.clear();
			stmt = conn.conectarMySQL().prepareCall(storeProcedure);
			setParameterForProcedure();
			rs = stmt.executeQuery();
			System.out.println("get One: "+stmt);
			while (rs.next()) {
				return getObject();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resultSetClose();
			stmtClose();
			conn.cerrarMySQL();
		}
		return null;
	}
	
	protected void save() {
		set();
	}
	
	protected void delete() {
		set();
	}
	
	protected void set() {
		try {
			al.clear();
			stmt = conn.conectarMySQL().prepareCall(storeProcedure);
			setParameterForProcedure();
			rs = stmt.executeQuery();	
			System.out.println("Set : "+stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resultSetClose();
			stmtClose();
			conn.cerrarMySQL();
		}
	}
	
	public String getStoreProcedure() {
		return storeProcedure;
	}

	public void setStoreProcedure(String storeProcedure) {
		this.storeProcedure = storeProcedure;
	}

	public ArrayList<Object> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Object> parameters) {
		this.parameters = parameters;
	}
}
