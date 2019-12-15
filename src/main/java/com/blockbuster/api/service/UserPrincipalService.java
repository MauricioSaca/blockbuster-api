package com.blockbuster.api.service;

import com.blockbuster.api.models.Authorities;
import com.blockbuster.api.models.UserPrincipal;

public interface UserPrincipalService {

	UserPrincipal saveUserPrincipal(UserPrincipal userPrincipal, Authorities authorities);

}
