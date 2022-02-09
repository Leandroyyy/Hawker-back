package br.com.hawker.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.hawker.dao.VendedorDAO;
import br.com.hawker.to.VendedorTO;


public class VendedorBO {

	private VendedorDAO vd;
	
	public List<VendedorTO> listar() throws SQLException{
		vd = new VendedorDAO();
		return vd.select();
	}

	public VendedorTO listar(int id) throws SQLException {
		vd = new VendedorDAO();
		return vd.select(id);
	}
	
	public void cadastrar(VendedorTO vto) throws SQLException {
		vd = new VendedorDAO();
		vd.insert(vto);
	}
	
	public void atualiza(VendedorTO vto) throws SQLException {
		vd = new VendedorDAO();
		vd.update(vto);
	}
}
