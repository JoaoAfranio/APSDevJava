package locadora.diurno.bll.interfaces;

import java.util.List;

import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.dal.entidade.Cor;

public interface ICorEJB {
	public Mensagem salvar(Cor cor);
	
	public Mensagem excluir(Short idCor);
	
	public Cor obterPorId(Short idCor);
	
	public List<Cor> obterTodos();
	
}
