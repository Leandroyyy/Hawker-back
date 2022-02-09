package br.com.hawker.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.hawker.dao.ProdutosDAO;
import br.com.hawker.to.ProdutosTO;

public class ProdutosBO {

	private ProdutosDAO pd;
	
	public List<ProdutosTO> listar() throws SQLException{
		pd = new ProdutosDAO();
		return pd.select();
	}

}
