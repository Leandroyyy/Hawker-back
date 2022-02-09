package br.com.hawker.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.hawker.bo.OfertasBO;
import br.com.hawker.to.OfertasTO;
import br.com.hawker.to.VendedorTO;

@Path("/ofertas")
public class OfertasResource {

	private OfertasBO ofertasBO = new OfertasBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<OfertasTO> buscar() throws SQLException {
		return ofertasBO.listar();
	}

}
