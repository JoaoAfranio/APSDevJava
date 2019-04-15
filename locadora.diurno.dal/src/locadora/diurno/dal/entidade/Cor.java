package locadora.diurno.dal.entidade;

import javax.persistence.*;
import java.util.*;

@Entity
public class Cor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idCor;
	
	private String descricao;
	
	@OneToMany(mappedBy = "cor")
	private List<Automovel> automoveis;

	
	
	public List<Automovel> getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(List<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

	public Short getIdCor() {
		return idCor;
	}

	public void setIdCor(Short idCor) {
		this.idCor = idCor;
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
		result = prime * result + ((idCor == null) ? 0 : idCor.hashCode());
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
		Cor other = (Cor) obj;
		if (idCor == null) {
			if (other.idCor != null)
				return false;
		} else if (!idCor.equals(other.idCor))
			return false;
		return true;
	}
	
	
	
}
