package org.ensas.productData.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.ensas.productData.idGenerators.CustomRandomIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "prod_id",strategy = "org.ensas.productData.idGenerators.CustomRandomIdGenerator")
	@GeneratedValue(generator = "prod_id")
	private Long id;
	private String name;
	@Column(name = "description")
	private String desc;
	private double price;
	
	
}
