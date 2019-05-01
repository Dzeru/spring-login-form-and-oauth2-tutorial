package com.dzeru.springloginformandoauth2tutorial.services;

import com.dzeru.springloginformandoauth2tutorial.entities.User;
import com.dzeru.springloginformandoauth2tutorial.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService
{
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User userFindByUsername = userRepo.findByUsername(username);
		User userFindByName = userRepo.findByName(username);
		User userFindByGoogleUsername = userRepo.findByGoogleUsername(username);
		User userFindByGoogleName = userRepo.findByGoogleName(username);

		if(userFindByUsername != null)
		{
			return userFindByUsername;
		}

		if(userFindByName != null)
		{
			return userFindByName;
		}

		if(userFindByGoogleUsername != null)
		{
			return userFindByGoogleUsername;
		}

		if(userFindByGoogleName != null)
		{
			return userFindByGoogleName;
		}

		return null;
	}
}

