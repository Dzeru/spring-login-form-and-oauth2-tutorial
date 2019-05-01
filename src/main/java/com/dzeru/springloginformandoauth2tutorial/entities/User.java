package com.dzeru.springloginformandoauth2tutorial.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	private String name;

	private boolean active;

	private String googleName;
	private String googleUsername;

	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
	@Enumerated(EnumType.STRING)
	private Set<Role> roles;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return isActive();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return getRoles();
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}

	public String getGoogleName()
	{
		return googleName;
	}

	public void setGoogleName(String googleName)
	{
		this.googleName = googleName;
	}

	public String getGoogleUsername()
	{
		return googleUsername;
	}

	public void setGoogleUsername(String googleUsername)
	{
		this.googleUsername = googleUsername;
	}

	@Override
	public String toString()
	{
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", active=" + active +
				", googleName='" + googleName + '\'' +
				", googleUsername='" + googleUsername + '\'' +
				", roles=" + roles +
				'}';
	}

	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return isActive() == user.isActive() &&
				Objects.equals(getId(), user.getId()) &&
				Objects.equals(getUsername(), user.getUsername()) &&
				Objects.equals(getPassword(), user.getPassword()) &&
				Objects.equals(getName(), user.getName()) &&
				Objects.equals(getGoogleName(), user.getGoogleName()) &&
				Objects.equals(getGoogleUsername(), user.getGoogleUsername()) &&
				Objects.equals(getRoles(), user.getRoles());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getId(), getUsername(), getPassword(), getName(), isActive(), getGoogleName(), getGoogleUsername(), getRoles());
	}
}

