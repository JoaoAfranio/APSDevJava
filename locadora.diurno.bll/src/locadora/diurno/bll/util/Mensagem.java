package locadora.diurno.bll.util;

public class Mensagem {

	private String texto;
	private MensagemStatus status;
	
	
	public Mensagem(String texto,
			MensagemStatus status) {
		this.texto = texto;
		this.status = status;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public MensagemStatus getStatus() {
		return status;
	}


	public void setStatus(MensagemStatus status) {
		this.status = status;
	}
	
	
}
