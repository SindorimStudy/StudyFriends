package com.study.friends.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
@Table(name="study")
@Getter
public class Study extends BaseTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long std_seq;

	@Column(nullable = false)
	private String std_title;
	
	@Column(nullable = false)
	private String std_content;
	
	@Builder
	public Study(final Long std_seq, final String std_title, final String std_content) {
		this.std_seq = std_seq;
		this.std_title = std_title;
		this.std_content = std_content;
	}
}
