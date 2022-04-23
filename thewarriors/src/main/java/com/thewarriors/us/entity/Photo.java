package com.thewarriors.us.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "photo")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Photo {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(unique = true)
	private String name;
	
	@Column(name = "awslink")
	private String awsLink;
	
	@Column(name = "opensealink")
	private String openseaLink;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "used")
	private boolean isUsed;
	
    @ManyToMany(targetEntity = SumoLayer.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SumoLayer> sumolayers;

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

	public String getAwsLink() {
		return awsLink;
	}

	public void setAwsLink(String awsLink) {
		this.awsLink = awsLink;
	}

	public String getOpenseaLink() {
		return openseaLink;
	}

	public void setOpenseaLink(String openseaLink) {
		this.openseaLink = openseaLink;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<SumoLayer> getSumolayers() {
		return sumolayers;
	}

	public void setSumolayers(List<SumoLayer> sumolayers) {
		this.sumolayers = sumolayers;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	
}
