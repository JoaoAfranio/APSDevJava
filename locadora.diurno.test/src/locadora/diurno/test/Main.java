package locadora.diurno.test;

import java.util.*;
import javax.ejb.embeddable.*;
import javax.naming.*;

import locadora.diurno.dal.entidade.*;
import locadora.diurno.dal.dao.*;
import locadora.diurno.dal.dao.interfaces.IModeloDAO;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Properties p = new Properties();
		p.put("locadoraDB", "new://Resource?type=DataSource");
		p.put("locadoraDB.JdbcDriver", "com.mysql.jdbc.Driver");
		p.put("locadoraDB.JdbcUrl","jdbc:mysql://localhost:3306/locadora");
		p.put("locadoraDB.userName","root");
		p.put("locadoraDB.password","root");
		
		
		Context context = EJBContainer.createEJBContainer(p).getContext();
		
		IModeloDAO modeloDAO = (IModeloDAO) context
				.lookup("java:global/locadora.diurno.dal/ModeloDAO");
	
		
		//Marca marca = new Marca();
		//marca.setDescricao("Ford");
		
		//marcaDAO.insert(marca);
		
		
		List<Modelo> modelos = modeloDAO.findByMarca("Fiat");
		
		for (Modelo modelo : modelos) {
			System.out.println(modelo.getDescricao());
			System.out.println(modelo.getMarca().getDescricao());
		}
		
		
		
	
	}
}
