//package com.recode.agencia.security;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.Collection;
//
//public class CustomUserDetails extends User {
//
//	private static final long serialVersionUID = 1L;
//	private final Long userId;
//
//    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Long userId) {
//        super(username, password, authorities);
//        this.userId = userId;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//}


//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import java.util.Collection;
//
//public class CustomUserDetails implements UserDetails {
//
//	private static final long serialVersionUID = 1L;
//	private Long id;
//    private String username;
//    private String password;
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public CustomUserDetails(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return false;
//	}
//}
