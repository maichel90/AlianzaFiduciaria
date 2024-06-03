package com.alianzafiduciaria.poc.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	@Id
	private String sharedKey;
	
	private String bussinesId;
	
	private String email;
	
	private String phone;
	
	private Date createDate;
	
	private Boolean removed;

}
