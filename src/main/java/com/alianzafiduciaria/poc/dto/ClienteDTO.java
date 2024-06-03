package com.alianzafiduciaria.poc.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
	
	private String sharedKey;
	
	private String bussinesId;
	
	private String email;
	
	private String phone;
	
	private Date createDate;
	
	private boolean removed;
	
}
