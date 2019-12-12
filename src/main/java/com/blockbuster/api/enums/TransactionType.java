/***********************************************************************
 * Module:  TransactionType.java
 * Author:  Mauricio Saca
 * Purpose: Defines the Class TransactionType
 ***********************************************************************/
package com.blockbuster.api.enums;

public enum TransactionType {

	RENT(1, "Rent"),
	 
	PURCHASE(2, "Purchase");
	
	Integer code;

	String description;

	private TransactionType(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static TransactionType getTransactionType(final Integer code) {
		TransactionType ret = null;
        for (TransactionType activeEnum : values()) {
            if (activeEnum.getCode().intValue() == code.intValue()) {
                ret = activeEnum;
                break;
            }
        }
		return ret;
	}	
	
}
