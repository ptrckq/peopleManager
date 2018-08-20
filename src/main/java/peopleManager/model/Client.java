package peopleManager.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Client")
@NamedQueries(
		value = {
				@NamedQuery(name = "getAllClients", query = "SELECT c FROM Client c"),
				@NamedQuery(name = "findClient",query="SELECT c FROM Client c where c.id = :id")}
)
@ManagedBean(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	private String name;

	@NotNull
	@Min(value = 18)
	@Max(value = 99)
	private int age;

	private String address;
	
	private Date userCreationDate;

	public Client()  {
		this.userCreationDate = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getUserCreationDate() {
		return userCreationDate;
	}

	public void setUserCreationDate() {
		Date today = new Date();
		this.userCreationDate = today;
	}

	@Override
	public String toString() {
		return this.name + "; Idade: " + this.age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
