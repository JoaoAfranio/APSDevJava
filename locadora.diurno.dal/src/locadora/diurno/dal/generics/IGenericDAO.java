package locadora.diurno.dal.generics;

import java.util.*;

public interface IGenericDAO<T, K> {

	public void insert(T entity);
	public void insertOrUpdate(T entity);
	public T findById(K id); //throws Exception;
	public void delete(T entity);
	public void deleteById(K id);
	public List<T> findAll();
	
	
}
