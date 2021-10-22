package com.study.friends.domain;


import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import static javax.persistence.FetchType.LAZY;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
@Table(name="user")
@Getter
public class User extends BaseTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column
	private String password;
	
	@Column(nullable = false)
	private String email;

	@Column
	private String picture;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	@Builder
	public User(final String name, final String email, final String password, final String picture, Role role) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.picture = picture;
		this.role = role;
	}
	public User update(String name,String picture){
		this.name = name;
		this.picture = picture;
		return this;
	}

	public String getRoleKey(){
		return this.role.getKey();
	}
}
