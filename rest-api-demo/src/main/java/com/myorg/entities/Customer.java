package com.myorg.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@SequenceGenerator(name = "customer_seq", initialValue = 10001)
	@GeneratedValue(generator = "customer_seq", strategy = GenerationType.SEQUENCE)
	private Long cid;
	
	@NotBlank(message = "customer name can't be blank")
	private String name;
	@NotBlank(message = "customer email can't be blank")
	private String email;
	@NotBlank(message = "customer message can't be blank")
	private String address;

}