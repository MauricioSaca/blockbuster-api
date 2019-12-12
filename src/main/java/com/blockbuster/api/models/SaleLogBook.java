/***********************************************************************
 * Module:  SaleLogBook.java
 * Author:  Mauricio Saca
 * Purpose: Defines the Class SaleLogBook
 ***********************************************************************/
package com.blockbuster.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.blockbuster.api.enums.PenaltyPeriodicity;
import com.blockbuster.api.enums.TransactionType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sale_log_book")
@EqualsAndHashCode(of = { "id" })
@ToString(of = { "id" })
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class SaleLogBook implements Serializable {

	private static final long serialVersionUID = -3405956927644508171L;

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = true)
	private Date startDate;

	@Column(nullable = true)
	private Date endDate;

	@Column(nullable = true)
	private Date returnDate;

	@Column(nullable = true)
	private Integer penaltyDays;

	@Column(nullable = true)
	private Double penalty;

	@Column(nullable = true)
	private Boolean enableRent;

	@Column(nullable = false)
	private Integer stock;

	@Column(nullable = false)
	private Double total;

	@Column(nullable = true)
	private Date transationDate;

	@Column(nullable = false)
	private String penaltyPeriodicity;

	@Column(nullable = false)
	private Integer transactionType;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private UserPrincipal userPrincipal;

	// Relation by enum

	public PenaltyPeriodicity getPenaltyPeriodicity() {
		return PenaltyPeriodicity.getPenaltyPeriodicity(this.penaltyPeriodicity);
	}

	public void setPenaltyPeriodicity(PenaltyPeriodicity penaltyPeriodicity) {
		this.penaltyPeriodicity = penaltyPeriodicity != null ? penaltyPeriodicity.getCode() : null;
	}

	public TransactionType getTransactionType() {
		return TransactionType.getTransactionType(this.transactionType);
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType != null ? transactionType.getCode() : null;
	}

}
