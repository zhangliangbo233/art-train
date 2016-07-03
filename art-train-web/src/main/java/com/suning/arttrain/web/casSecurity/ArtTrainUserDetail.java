package com.suning.arttrain.web.casSecurity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ArtTrainUserDetail implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4872762588638339672L;

	private long id;

	private String username;

	private boolean enabled;

	private Collection<GrantedAuthority> authorities;

	public ArtTrainUserDetail() {
	}

	public ArtTrainUserDetail(long id, String username, boolean enabled,
			Collection<GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	public long getId() {
		return id;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
