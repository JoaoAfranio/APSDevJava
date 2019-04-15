package locadora.diurno.dal.dao;

import locadora.diurno.dal.dao.interfaces.ICombustivelDAO;
import locadora.diurno.dal.entidade.Combustivel;
import locadora.diurno.dal.generics.JPAGenericDAO;

public class CombustivelDAO extends JPAGenericDAO<Combustivel, Short>
							implements ICombustivelDAO{

}
