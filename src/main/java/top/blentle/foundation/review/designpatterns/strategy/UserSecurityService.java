package top.blentle.foundation.review.designpatterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author blentle
 * @desc 用户安全相关服务
 */
@Service
public class UserSecurityService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserSecurityService.class);

	@Resource
	private AccountService accountService;

	@Resource
	private AuthenticationManager authenticationManager;


	@Override
	public JwtUser loadUserByUsername(final String userName) {
		Account loginUser = accountService.get(Integer.valueOf(userName));
		if (loginUser == null)
			throw new UsernameNotFoundException("user: " + userName + " was not found");
		//todo:获取用户的业务池(将来按权限开功能)
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		return new JwtUser(loginUser.getId(), loginUser.getMobilePhone(), loginUser.getUserName(), loginUser.getPassword(), true, grantedAuthorities);

	}

	/**
	 * 根据用户名获取当前用户
	 *
	 * @param account
	 * @param password
	 * @return
	 */
	public JwtUser checkPassword(Account account, String password) {
		UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(account, password);
		try {
			final Authentication authentication = authenticationManager.authenticate(upToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			JwtUser currentUser = loadUserByUsername(String.valueOf(account.getId()));
			return currentUser;
		} catch (Exception e) {
			logger.error("account:[] login failed", account.getMobilePhone());
			//登录校验错误，忽略
			return null;
		}
	}

}

