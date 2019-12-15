/***********************************************************************
 * Module:  PenaltyPeriodicity.java
 * Author:  Mauricio Saca
 * Purpose: Defines the Class PenaltyPeriodicity
 ***********************************************************************/
package com.blockbuster.api.enums;

public enum PenaltyPeriodicity {

	NONE("NONE", "A tiempo", 0.0),
	
	LOW("LOW", "Periodo de 1 a 3 dias", 0.1),
	 
	MEDIUM("MEDIUM", "Periodo de 5 a 10 dias", 0.3),
	
	HIGH("HIGH", "Periodo mas de 10 dias", 0.5);
	
	String code;

	String description;
	
	Double value;

	private PenaltyPeriodicity(final String code, final String description, final Double value) {
		this.code = code;
		this.description = description;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public Double getValue() {
		return value;
	}
	
	public static PenaltyPeriodicity getPenaltyPeriodicity(final String code) {
		PenaltyPeriodicity ret = null;
        for (PenaltyPeriodicity activeEnum : values()) {
            if (activeEnum.getCode().equals(code)) {
                ret = activeEnum;
                break;
            }
        }
		return ret;
	}	
	
}
