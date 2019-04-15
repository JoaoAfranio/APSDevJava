package locadora.diurno.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.diurno.bll.interfaces.ICombustivelEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.MensagemStatus;
import locadora.diurno.dal.dao.interfaces.ICombustivelDAO;
import locadora.diurno.dal.entidade.Combustivel;

@Stateless
public class CombustivelEJB implements ICombustivelEJB{
	
	@Inject
	private ICombustivelDAO combustivelDAO;
	
	@Override
	public Mensagem salvar(Combustivel combustivel) {
		try {
			combustivelDAO.insertOrUpdate(combustivel);
		}catch(Exception ex){
			return new Mensagem("Ocorreu um erro inesperado." + ex.getMessage(), MensagemStatus.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
	}

	@Override
	public Mensagem excluir(Short idCombustivel) {
		Combustivel combustivel = obterPorId(idCombustivel);
		
		if(combustivel == null) {
			return new Mensagem("Combustível inexistente", MensagemStatus.erro);
		}
		
		if(combustivel.getAutomoveis().size() > 0) {
			return new Mensagem("Existe carros vinculados", MensagemStatus.erro);
		}
		
		try {
			combustivelDAO.deleteById(idCombustivel);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir combustivel" + ex, MensagemStatus.erro);
		}
			return new Mensagem("Combustível excluído com sucesso", MensagemStatus.sucesso);
	}

	@Override
	public Combustivel obterPorId(Short idCombustivel) {
		return combustivelDAO.findById(idCombustivel);
	}

	@Override
	public List<Combustivel> obterTodos() {
		return combustivelDAO.findAll();
	}

}
