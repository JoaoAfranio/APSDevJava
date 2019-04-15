package locadora.diurno.bll;

import java.util.List;

import locadora.diurno.bll.interfaces.*;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.MensagemStatus;
import locadora.diurno.dal.entidade.Cor;

import javax.ejb.Stateless;
import javax.inject.*;
import locadora.diurno.dal.dao.interfaces.*;

@Stateless
public class CorEJB implements ICorEJB{
	
	@Inject
	private ICorDAO corDAO;

	@Override
	public Mensagem salvar(Cor cor) {
		
		try {
			corDAO.insertOrUpdate(cor);
		}catch(Exception ex){
			return new Mensagem("Ocorreu um erro inesperado." + ex.getMessage(), MensagemStatus.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
		
	}

	@Override
	public Mensagem excluir(Short idCor) {
		
		try {
			Cor cor = obterPorId(idCor);
			
			if(cor == null) {
				throw new Exception("Cor Inexistente");
			}
			
			if(cor.getAutomoveis().size() > 0) {
				throw new Exception("Existe carros vinculados");
			}
			
			corDAO.delete(cor);
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir." + ex.getMessage(), MensagemStatus.erro);
		}
		return new Mensagem("Cor excluida com sucesso", MensagemStatus.sucesso);
	}

	@Override
	public Cor obterPorId(Short idCor) {
		return corDAO.findById(idCor);
	}

	@Override
	public List<Cor> obterTodos() {
		return corDAO.findAll();
	}

}
