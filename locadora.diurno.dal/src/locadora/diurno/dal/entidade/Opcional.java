package locadora.diurno.dal.entidade;

import javax.persistence.*;

import java.util.*;

@Entity
public class Opcional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idOpcional;
	
	private String descricao;
	
	
	@ManyToMany(mappedBy = "opcionais")
	private List<Automovel> automoveis;


	public List<Automovel> getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(List<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

	public Short getIdOpcional() {
		return idOpcional;
	}

	public void setIdOpcional(Short idOpcional) {
		this.idOpcional = idOpcional;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOpcional == null) ? 0 : idOpcional.hashCode());
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
		Opcional other = (Opcional) obj;
		if (idOpcional == null) {
			if (other.idOpcional != null)
				return false;
		} else if (!idOpcional.equals(other.idOpcional))
			return false;
		return true;
	}
	
	
	
	
	
}
