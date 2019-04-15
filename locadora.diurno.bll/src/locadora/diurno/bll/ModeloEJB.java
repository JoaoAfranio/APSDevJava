package locadora.diurno.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.diurno.bll.interfaces.IModeloEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.MensagemStatus;
import locadora.diurno.dal.dao.interfaces.IModeloDAO;
import locadora.diurno.dal.entidade.Modelo;


@Stateless
public class ModeloEJB implements IModeloEJB {

	@Inject
	private IModeloDAO modeloDAO;
	
	@Override
	public Mensagem salvar(Modelo modelo) {

		try {
			modeloDAO.insertOrUpdate(modelo);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),MensagemStatus.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
	}

	@Override
	public Mensagem excluir(Short idModelo) {
		
		
		try {
			
			Modelo modelo = obterPorId(idModelo);
			
			if(modelo == null) {
				throw new Exception("Modelo inexistente.");
			}
			
			if(modelo.getAutomoveis().size() > 0) {
				throw new Exception("Existem automoveis vinculados a essa marca");
			}
			
			modeloDAO.delete(modelo);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), MensagemStatus.erro);
		}
		
		return new Mensagem("Excluído com sucesso.",
				MensagemStatus.sucesso);
		
	}

	@Override
	public Modelo obterPorId(Short idModelo) {
		return modeloDAO.findById(idModelo);
	}

	@Override
	public List<Modelo> obterTodos() {
		return modeloDAO.findAll();
	}

}
