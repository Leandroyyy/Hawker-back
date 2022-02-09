package br.com.hawker.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.hawker.bo.VendedorBO;
import br.com.hawker.to.VendedorTO;

//Todos os metodos utilizamos a comunicação co JSON

@Path("/vendedor")
public class VendedorResource {

	private VendedorBO vendedorBO = new VendedorBO();
	
	//Listar todos os vendedores
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VendedorTO> buscar() throws SQLException {
		return vendedorBO.listar();
	}
	
	//Buscar somente um vendedor
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public VendedorTO buscar(@PathParam("id") int id) throws SQLException {
		return vendedorBO.listar(id);
	}

	//Cadastrar novo vendedor
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(VendedorTO vendedor, @Context UriInfo uriInfo) throws SQLException {
	vendedorBO.cadastrar(vendedor);
	UriBuilder builder = uriInfo.getAbsolutePathBuilder();
	builder.path(Integer.toString(vendedor.getId()));
	return Response.created(builder.build()).build();
	}
	
	//Atualizar dados do vendedor
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(VendedorTO vendedor, @PathParam("id") int id) throws SQLException
	{
	vendedor.setId(id);
	vendedorBO.atualiza(vendedor);
	return Response.ok().build();
	}

}
