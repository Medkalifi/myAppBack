package fr.moha.myApp.model;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

@Entity

public class UserApp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)

	private String userName;
	// This should allow password to be de-serialized,
	// but the JSON output of serialization won't include it.
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

	private String password;
	private boolean activated;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<RoleApp> roles = new ArrayList<RoleApp>();

	public UserApp() {

	}

	public UserApp(Long id, String userName, String password, boolean activated, Collection<RoleApp> roles) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.activated = activated;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Collection<RoleApp> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RoleApp> roles) {
		this.roles = roles;
	}

}
