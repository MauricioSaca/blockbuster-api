package com.blockbuster.api.pojos;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class JwtAuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 9103854114722798557L;

	@NonNull
	private String accessToken;

	private String tokenType = "Bearer";

}
