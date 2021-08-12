package com.everis.springboot.createaccount.document;



import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class SavingAccount {
	
	@Id
	private String id;
	private double amountInAccount;
	private String clientId;
	private int  movementsPerMonth;
	private String type;
	private Date modifiedAt ;
	private Date createAt;
}
