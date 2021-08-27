package fr.moha.myApp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity

public class RoleApp {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String role;
	
	public RoleApp() {
		
	}
	
	
	public RoleApp(Long id, String roleName) {
		super();
		this.id = id;
		this.role = roleName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return role;
	}
	public void setRoleName(String roleName) {
		this.role = roleName;
	}

	
	
}
