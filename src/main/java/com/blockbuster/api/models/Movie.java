/***********************************************************************
 * Module:  Movie.java
 * Author:  Mauricio Saca
 * Purpose: Defines the Class Movie
 ***********************************************************************/
package com.blockbuster.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table()
@EqualsAndHashCode(of = { "id" })
@ToString(of = { "id" })
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie implements Serializable {

	private static final long serialVersionUID = -3925164314363485273L;

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private byte[] image;

	@Column(nullable = false)
	private Integer stock;

	@Column(nullable = false)
	private Double rentalPrice;

	@Column(nullable = false)
	private Double salesPrice;

	@Column(nullable = false)
	private Boolean availability;

	@Transient
	@JsonIgnore
	private MultipartFile file;

}
