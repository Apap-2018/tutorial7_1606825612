package com.apap.tutorial7.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name= "car")
public class CarModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 952493577366630675L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max=50)
	@Column(name="brand", nullable=false)
	private String brand;
	
	@NotNull
	@Size(max=50)
	@Column(name="type", nullable=false)
	private String type;
	
	@NotNull
	@Column(name="price", nullable=false)
	private long price;
	
	@NotNull
	@Column(name="amount", nullable=false)
	private Integer amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dealer_id", referencedColumnName = "id", nullable = false)
	@JsonIgnoreProperties("listCar")
	private DealerModel dealer;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public DealerModel getDealer() {
		return dealer;
	}

	public void setDealer(DealerModel dealer) {
		this.dealer = dealer;
	}
	
	
	
}
