package peopleManager.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import peopleManager.model.Client;

@Transactional
@Singleton
public class ClientDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public ClientDAO() {
		emf =  Persistence.createEntityManagerFactory("client");
		em = emf.createEntityManager();
	}
	
	
	public void insere(Client client) {
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
	}
	
	public void remove (Client client) {
		em.getTransaction().begin();
		Client c = em.merge(client);
		em.remove(c);
		em.getTransaction().commit();
	}
	
	public void find(Client client) {
		em.getTransaction().begin();
		em.remove(findClientById(client.getId()));
		em.getTransaction().commit();
	}
	
	public Client findClientById(Integer id) {
		return em.createNamedQuery("findClient",Client.class).setParameter("id", id).getSingleResult();
	}
	
	public List<Client> getList() {
		return em.createNamedQuery("getAllClients", Client.class).getResultList();
	}


	public void update(Client client) {
		em.getTransaction().begin();
		em.merge(client);
		em.getTransaction().commit();
	}
}
