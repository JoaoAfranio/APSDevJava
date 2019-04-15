package locadora.diurno.dal.dao.interfaces;

import locadora.diurno.dal.generics.*;
import locadora.diurno.dal.entidade.*;
import java.util.*;

public interface IModeloDAO
		extends IGenericDAO<Modelo, Short>{

	public List<Modelo> findByMarca(String nomeMarca);
}
