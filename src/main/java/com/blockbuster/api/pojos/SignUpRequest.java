package com.blockbuster.api.pojos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest implements Serializable {

	private static final long serialVersionUID = -4244587127242978606L;

	private String name;

	private String lastName;

	private String username;

	private String password;

	private String email;

}
