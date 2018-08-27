package peopleManager.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import peopleManager.model.Client;

@Stateless
public class ClientDAO {

	@PersistenceContext(unitName="client")
	private EntityManager em;

	
	public void insere(Client client) {
		em.persist(client);
	}
	
	public void remove (Client client) {
		Client c = em.merge(client);
		em.remove(c);
	}
	
	public Client find(Client client) {
		 return findClientById(client.getId());
	}
	
	public Client findClientById(Integer id) {
		return em.createNamedQuery("findClientById",Client.class).setParameter("id", id).getSingleResult();
	}
	
	public List<Client> getList() {
		return em.createNamedQuery("getAllClients", Client.class).getResultList();
	}


	public void update(Client client) {
		em.merge(client);
	}
}
