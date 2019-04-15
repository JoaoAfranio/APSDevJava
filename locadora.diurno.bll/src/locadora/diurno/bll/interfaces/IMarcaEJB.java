package locadora.diurno.bll.interfaces;

import locadora.diurno.dal.entidade.*;
import locadora.diurno.bll.util.*;
import java.util.*;

public interface IMarcaEJB {

	public Mensagem salvar(Marca marca);
	
	public Mensagem excluir(Short idMarca);
	
	public Marca obterPorId(Short idMarca);
	
	public List<Marca> obterTodos();
	
}
