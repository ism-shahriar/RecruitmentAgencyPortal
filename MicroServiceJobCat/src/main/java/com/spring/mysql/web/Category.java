package com.spring.mysql.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Category")
public class Category {
	
	//fields
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "catid")
    private int catId;
    
	@Column(name = "catcode")
    private String catCode;
	
    @NotBlank(message = "Name is mandatory")
    @Column(name = "catname")
    private String catName;
    
    @Column(name = "catdesc")
    private String catDesc;

 // constructor
    public Category (int catId, String catCode, String catName, String catDesc) {
    	super();
    	this.catId=catId;
    	this.catCode=catCode;
    	this.catName=catName;
    	this.catDesc=catDesc;
    }
    public Category() {
    	super();
    }
 // properties
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatCode() {
		return catCode;
	}
	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
    
}
