/***********************************************************************
 * Module:  PenaltyPeriodicity.java
 * Author:  Mauricio Saca
 * Purpose: Defines the Class PenaltyPeriodicity
 ***********************************************************************/
package com.blockbuster.api.enums;

public enum PenaltyPeriodicity {

	LOW("LOW", "Periodo de 1 a 3 dias", 1D),
	 
	MEDIUM("MEDIUM", "Periodo de 1 a 5 dias", 2D),
	
	HIGH("HIGH", "Periodo de 1 a 7 dias", 3D);
	
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
