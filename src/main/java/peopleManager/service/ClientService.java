package peopleManager.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import peopleManager.dao.ClientDAO;
import peopleManager.model.Client;

@ManagedBean(name = "clientService")
@SessionScoped
public class ClientService {

	@PersistenceContext
	private EntityManager em;

	Client client = new Client();
	private List<Client> clientList = new ArrayList<Client>();
	private ClientDAO clientDao = new ClientDAO();
	private boolean updating = false;

	@RequestScoped
	@Transactional
	public void addClient() {
		clientDao.insere(client);
		client = new Client();
	}

	@RequestScoped
	@Transactional
	public void removeClient(Client client) {
		clientDao.remove(client);
	}

	public void find(Client client) {
		clientDao.find(client);
	}

	@RequestScoped
	public List<Client> getList() {
		return clientDao.getList();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public ClientDAO getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDAO clientDao) {
		this.clientDao = clientDao;
	}

	public boolean isUpdating() {
		return updating;
	}

	public void setUpdating(boolean updating) {
		this.updating = updating;
	}

	public void update() {
		clientDao.update(client);
		setUpdating(false);
		client = new Client();
	}

	public void cancelupdate() {
		setUpdating(false);
	}

	public void editClient(Client client) {
		this.client = client;
		setUpdating(true);

	}

}
