package trimix.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import trimix.model.Personas;
import trimix.model.Tipodocumento;

public class PersonasDAO {
	
	private static List<Personas> personas = new ArrayList<Personas>();
	Configuration configuration;
	ServiceRegistryBuilder registry;
	ServiceRegistry serviceRegistry;
	SessionFactory sessionFactory;
	 
	public PersonasDAO() {
        configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Personas.class);
        configuration.addAnnotatedClass(Tipodocumento.class);
        
        registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        serviceRegistry = registry.buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
		
	public void updatePersona(Personas p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(p);
        
        session.getTransaction().commit();
        session.close();
	}
	
	public void deletePersona(Personas p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(p);
        
        session.getTransaction().commit();
        session.close();
	}
	
	public List<Personas> findPersonasByNombre(String nombre) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery("Personas.findByPerNombre");
        query.setParameter("perNombre", "%" + nombre + "%");
        List<Personas> personas = query.list();
	    return personas;
	}
	
	public Personas findPersonaById(Integer id) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery("Personas.findByPerId");
        query.setParameter("perId", id);
        Personas p =(Personas) query.uniqueResult();
	    return p;
	}
	
	public List<Personas> findPersonaByTipoDocumento(Tipodocumento tipoDoc) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery("Personas.findByPerTipoDocumento");
        query.setParameter("idTipoDoc", tipoDoc);
        
	    return query.list();
	}
	
	public List<Personas> findAllPersonas() {
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("SELECT a FROM Personas a");
	    return q.list();
	}
	
	public static List<Personas> getPersonas() {
		System.out.println("PersonasDAO getPersonas");
		Personas p1 = new Personas();
		
		Tipodocumento idTipDoc = new Tipodocumento();
		p1.setPerId(1);
		p1.setIdTipoDocumento(idTipDoc);
		p1.setPerApellido("Medina");
		p1.setPerNombre("Luis Oscar");
		p1.setPerNumeroDocumento(30611170);
		
		personas.add(p1);
		
		return personas;
	}
	
	public void savePersona(Personas persona){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(persona);
        
        session.getTransaction().commit();
        session.close();
	}

	public Tipodocumento getTipoDocumento (Integer id){
		Tipodocumento td = null;
        Session session = null;
		try {
            session = sessionFactory.openSession();
            td =  (Tipodocumento) session.get(Tipodocumento.class, id);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
		return td;
	}
	
	public Tipodocumento getTipoDocumento (String tipoDOc){
		Tipodocumento td = null;
        Session session = null;
		try {
			session = sessionFactory.openSession();
	        Query query = session.getNamedQuery("Tipodocumento.findByCodigo");
	        query.setParameter("codigo", tipoDOc);
	        td =(Tipodocumento) query.uniqueResult();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
		return td;
	}
}
