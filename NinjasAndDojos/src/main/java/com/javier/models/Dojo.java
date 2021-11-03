package com.javier.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")

public class Dojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size (min=3, max=20)	
	private String name;
	
	@Column(updatable=false)
	@DateTimeFormat (pattern="yyyy-MM-dd")	
	private Date created_at;
	@DateTimeFormat (pattern="yyyy-MM-dd")	
	private Date updated_at;
	
	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	private List<Ninja> ninjas;
	
	@PrePersist
	protected void onCreate(){
		this.created_at = new Date ();
		this.updated_at = new Date ();
	}
	
	public Dojo() {}
	
	public Dojo(Long id, Date created_at, Date updated_at, List<Ninja> ninjas) {
		this.id= id;
		this.created_at= created_at;
		this.updated_at= updated_at;
		this.ninjas= ninjas;
	}
	
	public Dojo(String name) {
		this.name= name;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(Date updated_at) {
		this.updated_at = updated_at;
	}

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
}
