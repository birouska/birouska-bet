package com.birouskabet.better.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class Better {
	@Id
	@GeneratedValue
	private long id;
	@Column(unique=true)
	private String personalId;
	private String name;
	private String cellphone;
	private String email;
	private String password;

}
