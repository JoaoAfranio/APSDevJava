package locadora.diurno.bll.interfaces;

import java.util.List;

import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.dal.entidade.Modelo;

public interface IModeloEJB {

	public Mensagem salvar(Modelo modelo);
	
	public Mensagem excluir(Short idModelo);
	
	public Modelo obterPorId(Short idModelo);
	
	public List<Modelo> obterTodos();
	
}
