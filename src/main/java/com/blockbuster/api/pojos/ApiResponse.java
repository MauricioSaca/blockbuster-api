/***********************************************************************
 * Module:  ApiResponse.java
 * Author:  Mauricio Saca
 * Purpose: Defines the Class ApiResponse
 ***********************************************************************/
package com.blockbuster.api.pojos;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1891207967941758303L;

	@NonNull
	private Boolean success;

	@NonNull
	private String message;

}
