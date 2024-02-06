package ec.edu.ups.est.services;

import java.util.List;

import ec.edu.ups.est.business.GestionRecargas;
import ec.edu.ups.est.modelo.Recarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recargas")
public class RecargaServices {
	@Inject
	private GestionRecargas gRecargas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Recarga recarga) {
		try {
			gRecargas.guardarRecarga(recarga);;
			return Response.ok(recarga).build();
		}catch (Exception e) {
			ErrorMesaage error = new ErrorMesaage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getRecargas(){
		List<Recarga> recargas = gRecargas.getClientes();
		if(recargas.size()>0)
			return Response.ok(recargas).build();
		ErrorMesaage error = new ErrorMesaage(6, "No se registran clientes");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
	}
}
