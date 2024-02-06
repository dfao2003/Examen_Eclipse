package ec.edu.ups.est.services;

import ec.edu.ups.est.business.GestionOperador;
import ec.edu.ups.est.modelo.Operador;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("operador")
public class OperadorServices {

	@Inject
	private GestionOperador gOperador;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response leer(@QueryParam("id") int id) {
		try {
			System.out.println("id=" +  id);
			Operador ope = gOperador.getOperadorPorId(id);
			return Response.ok(ope).build();
		}catch (Exception e) {
			ErrorMesaage error = new ErrorMesaage(4, "Cliente no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
}
