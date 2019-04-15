package locadora.diurno.dal.generics;

import java.util.List;
import javax.persistence.*;

import java.lang.reflect.*;

public class JPAGenericDAO<T, K> 
			implements IGenericDAO<T, K> {

	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> classe;
	
	@SuppressWarnings("unchecked")
	public JPAGenericDAO() {
		this.classe = (Class<T>) 
				((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Override
	public void insert(T entity) {
		em.persist(entity);
	}

	@Override
	public void insertOrUpdate(T entity) {
		em.merge(entity);		
	}

	@Override
	public T findById(K id) {
		T entity = em.find(classe, id);
		return entity;
	}

	@Override
	public void delete(T entity) {
		em.remove(entity);
		
	}

	@Override
	public void deleteById(K id) {
		T entity = findById(id);
		delete(entity);
	}

	@Override
	public List<T> findAll() {
		String nome = classe.getSimpleName();
		
		TypedQuery<T> query 
			= em.createQuery("select t from " + nome + " as t",
					classe);
		
		return query.getResultList();
	}

	
	
}
