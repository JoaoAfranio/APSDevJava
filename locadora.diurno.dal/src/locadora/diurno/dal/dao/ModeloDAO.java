package locadora.diurno.dal.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import locadora.diurno.dal.dao.interfaces.IModeloDAO;
import locadora.diurno.dal.entidade.Modelo;
import locadora.diurno.dal.generics.JPAGenericDAO;

@RequestScoped
public class ModeloDAO
		extends JPAGenericDAO<Modelo, Short>
		implements IModeloDAO {

	@Override
	public List<Modelo> findByMarca(String nomeMarca) {
		
		TypedQuery<Modelo> query =
					em.createQuery("select m from Modelo as m where m.marca.descricao = :nomeMarca order by m.marca.descricao",Modelo.class);
		
		query.setParameter("nomeMarca", nomeMarca);
		
		return query.getResultList();
	}

	
}
