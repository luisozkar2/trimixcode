package trimix.api.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import trimix.dao.PersonasDAO;
import trimix.model.Personas;
import trimix.model.Tipodocumento;

@Path("personas")
public class PersonaService {

	private List<Personas> list = null;
	PersonasDAO dao;
	
	public PersonaService () {
		dao = new PersonasDAO();
	}

	@GET
	@Path("/searchByName/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonasByNombre(@PathParam("nombre") String nombre) {
		System.out.println("GET by nombre:" + nombre);
		try {
			list = dao.findPersonasByNombre(nombre);
			return Response.ok(list).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	@GET
	@Path("/searchByTipoDocumento/{tipoDoc}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonasByTipoDocumento(@PathParam("tipoDoc") String tipoDoc) {
		System.out.println("GET getPersonasByTipoDocumento:" + tipoDoc);
		try {
			Tipodocumento td = dao.getTipoDocumento(tipoDoc);
			list = dao.findPersonaByTipoDocumento(td);
			return Response.ok(list).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonasById(@PathParam("id") Integer id) {
		System.out.println("GET by id:" + id);
		try {
			Personas p1 = dao.findPersonaById(id);
			return Response.ok(p1).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonas() {
		System.out.println("get persona ");
		try {
			list = dao.findAllPersonas();
			return Response.ok(list).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPersona(Personas p1) {
		System.out.println("add persona");
		try {
			dao.savePersona(p1);
			return Response.ok(p1).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePersona(Personas p1) {
		System.out.println("delete persona");
		try {
			dao.deletePersona(p1);
			return Response.ok(p1).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePersona(Personas p1) {
		System.out.println("update persona");
		try {
			dao.updatePersona(p1);
			return Response.ok(p1).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

}
