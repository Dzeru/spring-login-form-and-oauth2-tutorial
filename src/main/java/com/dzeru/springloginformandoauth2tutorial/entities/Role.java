package com.dzeru.springloginformandoauth2tutorial.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority
{
	USER;

	@Override
	public String getAuthority()
	{
		return name();
	}
}
