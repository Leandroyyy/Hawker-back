package br.com.hawker.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.hawker.dao.OfertasDAO;
import br.com.hawker.to.OfertasTO;

public class OfertasBO {

	private OfertasDAO od;
	
	public List<OfertasTO> listar() throws SQLException{
		od = new OfertasDAO();
		return od.select();
	}


}
