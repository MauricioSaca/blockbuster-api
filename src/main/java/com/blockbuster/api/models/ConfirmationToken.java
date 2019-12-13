/***********************************************************************
 * Module:  Authorities.java
 * Author:  Mauricio Saca
 * Purpose: Defines the Class Authorities
 ***********************************************************************/
package com.blockbuster.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "confirmation_token")
@EqualsAndHashCode(of = { "id" })
@Getter
@Setter
@NoArgsConstructor
public class ConfirmationToken implements Serializable {

	private static final long serialVersionUID = 676217465946097L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(length = 255, nullable = true)
	private String confirmationToken;

	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME", nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private UserPrincipal userPrincipal;

	public ConfirmationToken(UserPrincipal userPrincipal) {
		this.userPrincipal = userPrincipal;
		this.createDate = new Date();
		confirmationToken = UUID.randomUUID().toString();
	}

}