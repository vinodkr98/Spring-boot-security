package com.example.security.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.security.domain.User;

public  class UserDetailsImpl implements UserDetails {

	private User user;
	public UserDetailsImpl(User user){
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Set<Role> roles = user.getRoles();
		for( Role role : roles ){
			authorities.add( new SimpleGrantedAuthority(role.getRoleName()));
		}
		return authorities;
	}
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	@Override
	public String getUsername(){
		return user.getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
