package org.nbu.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * All user types are differentiated only by role. The role can be CUSTOMER, EMPLOYEE and OWNER
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Id
	private String name;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	public Role(String name) {
		this.name = name;
	}

}
