package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "PROD_TAB")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
	@Id
	@Column(name = "prod_id")
	@GeneratedValue
	private Integer prodId;
	@Column(name = "prod_code")
	@NonNull
	private String prodCode;
	@NonNull
	@Column(name = "prod_cost")
	private Double prodCost;
}
