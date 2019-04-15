package locadora.diurno.dal.dao;

import locadora.diurno.dal.dao.interfaces.*;
import locadora.diurno.dal.entidade.*;
import locadora.diurno.dal.generics.*;

import javax.enterprise.context.*;

@RequestScoped
public class MarcaDAO 
	extends JPAGenericDAO<Marca, Short>
	implements IMarcaDAO{


	
}
