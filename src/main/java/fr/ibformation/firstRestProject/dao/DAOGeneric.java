package fr.ibformation.firstRestProject.dao;


import java.util.List;

public interface DAOGeneric<T> {
	public void create(T c );
	
	public T readById(int id);
	
	public T readByName(String name);
	
	public void update(T c);
	
	public void deleteById(int id);
	
	public void deleteByName(T c);
	
	public List<T> getAll();
	
	
}