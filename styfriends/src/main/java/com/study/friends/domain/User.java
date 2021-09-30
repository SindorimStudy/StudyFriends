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
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String email;
	
	@Column
	private boolean is_admin;
	
	@Builder
	public User(final Long id, final String name, final String email, final String password, final boolean is_admin) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.is_admin = is_admin;
	}
}
