package locadora.diurno.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import locadora.diurno.bll.interfaces.ICorEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.MensagemStatus;
import locadora.diurno.dal.entidade.Cor;


import javax.inject.*;

@Named
@RequestScoped
public class CorController {
	private Cor cor;
	
	@EJB
	private ICorEJB corEJB;
	
	@Inject
	private FacesContext context;
	
	
	public CorController() {
		this.cor = new Cor();
	}
	
	public void editar(Cor cor) {
		this.cor = cor;
	}
	
	public void excluir(Short idCor) {
		Mensagem msg = corEJB.excluir(idCor);
		
		if(msg.getStatus() == MensagemStatus.sucesso) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(), null));
		}
		
		if(msg.getStatus() == MensagemStatus.erro) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(), null));
		}
				
	}
	
	public void salvar() {
		
		Mensagem msg = corEJB.salvar(cor);
		
		if(msg.getStatus() == MensagemStatus.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(), null));
			
			this.cor = new Cor();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(), null));
		}
	}
	
	public List<Cor> todos(){
		return corEJB.obterTodos();
	}

	public Cor getCor() {
		return cor;
	}

	public void setcor(Cor cor) {
		this.cor = cor;
	}
	
	
}
