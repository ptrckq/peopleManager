package peopleManager.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import peopleManager.dao.ClientDAO;
import peopleManager.model.Client;

@ManagedBean(name = "clientService")
@SessionScoped
public class ClientService {


	
	Client client;
	private List<Client> clientList ;
	
	@EJB
	private ClientDAO clientDao ;
	
	private boolean updating;
	
	
	public ClientService() {
		updating = false;
		client = new Client();
		clientList = new ArrayList<Client>();
	}
	
	@RequestScoped
	public void addClient(Client client) {
		clientDao.insere(client);
	}

	@RequestScoped
	public void removeClient(Client client) {
		clientDao.remove(client);
	}

	@RequestScoped
	public void update(Client client) {
		clientDao.update(client);
		setUpdating(false);
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

	
	public void cancelupdate() {
		setUpdating(false);
	}

	public void editClient(Client client) {
		this.client = client;
		setUpdating(true);
	}
	

}
