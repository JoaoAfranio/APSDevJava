package locadora.diurno.controller;

import javax.enterprise.context.*;
import javax.ejb.*;

import locadora.diurno.bll.interfaces.*;
import locadora.diurno.dal.entidade.*;

import javax.inject.*;

import java.util.*;

@Named
@RequestScoped
public class MarcaController {

	@EJB
	private IMarcaEJB marcaEJB;
	
	
	public List<Marca> todas(){
		return marcaEJB.obterTodos();
	}
	
}
