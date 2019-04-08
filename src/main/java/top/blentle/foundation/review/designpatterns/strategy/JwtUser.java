package top.blentle.foundation.review.designpatterns.strategy;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author blentle
 * @desc 已认证的用户
 */
public class JwtUser implements UserDetails {

	private Integer id;

	private String mobilePhone;

	private String username;

	private String password;

	private String email;

	/*
	 * 当前用户的权限
	 */
	private Collection<? extends GrantedAuthority> authorities;

	/*
	 * 系统暂未做用户激活、锁定状态
	 */
	private boolean active = true;

	public JwtUser(Integer id, String mobilePhone, String username, String password, boolean active, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.mobilePhone = mobilePhone;
		this.username = username;
		this.password = password;
		this.active = active;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * 账户是否未过期
	 *
	 * @return
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * 账户是否未锁定
	 *
	 * @return
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * 密码是否未过期
	 *
	 * @return
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * 账户是否激活
	 *
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
