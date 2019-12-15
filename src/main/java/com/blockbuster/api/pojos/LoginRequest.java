/***********************************************************************
 * Module:  LoginRequest.java
 * Author:  Mauricio Saca
 * Purpose: Defines the Class LoginRequest
 ***********************************************************************/
package com.blockbuster.api.pojos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = -8446520507131266379L;

	@NotBlank
	private String username;

	@NotBlank
	private String password;

}
