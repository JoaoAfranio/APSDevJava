package locadora.diurno.dal.entidade;

import javax.persistence.*;

import java.util.*;

@Entity
public class Automovel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAutomovel;
	
	private Integer ano;
	
	private Double valor;
	
	private Short quantidadePortas;
	
	@ManyToOne
	@JoinColumn(name = "idCor")
	private Cor cor;
	
	@ManyToOne
	@JoinColumn(name = "idModelo")
	private Modelo modelo;
	
	@ManyToOne
	@JoinColumn(name = "idCombustivel")
	private Combustivel combustivel;
	
	
	@ManyToMany
	@JoinTable(name = "AutomovelOpcional",
			joinColumns = @JoinColumn(name = "idAutomovel"),
			inverseJoinColumns = @JoinColumn(name = "idOpcional"))
	private List<Opcional> opcionais;


	public Integer getIdAutomovel() {
		return idAutomovel;
	}


	public void setIdAutomovel(Integer idAutomovel) {
		this.idAutomovel = idAutomovel;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Short getQuantidadePortas() {
		return quantidadePortas;
	}


	public void setQuantidadePortas(Short quantidadePortas) {
		this.quantidadePortas = quantidadePortas;
	}


	public List<Opcional> getOpcionais() {
		return opcionais;
	}


	public void setOpcionais(List<Opcional> opcionais) {
		this.opcionais = opcionais;
	}


	public Cor getCor() {
		return cor;
	}


	public void setCor(Cor cor) {
		this.cor = cor;
	}


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public Combustivel getCombustivel() {
		return combustivel;
	}


	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAutomovel == null) ? 0 : idAutomovel.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovel other = (Automovel) obj;
		if (idAutomovel == null) {
			if (other.idAutomovel != null)
				return false;
		} else if (!idAutomovel.equals(other.idAutomovel))
			return false;
		return true;
	}
	
		
	
	
}
