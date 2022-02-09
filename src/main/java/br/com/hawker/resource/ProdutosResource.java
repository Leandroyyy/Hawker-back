package br.com.hawker.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.hawker.bo.ProdutosBO;
import br.com.hawker.to.ProdutosTO;


@Path("/produtos")
public class ProdutosResource {

	private ProdutosBO produtosBO = new ProdutosBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutosTO> buscar() throws SQLException {
		return produtosBO.listar();
	}
}
