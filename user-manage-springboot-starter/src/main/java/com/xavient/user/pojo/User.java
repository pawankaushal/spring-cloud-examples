package com.xavient.user.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 3191492162942854324L;
	@Id @GeneratedValue
	private long id;
	private String name ;
	private String role; 
}
