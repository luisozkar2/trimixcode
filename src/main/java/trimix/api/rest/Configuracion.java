package trimix.api.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class Configuracion extends Application{

	public Configuracion () {
		System.out.println("Configuracion created");
	}
}
