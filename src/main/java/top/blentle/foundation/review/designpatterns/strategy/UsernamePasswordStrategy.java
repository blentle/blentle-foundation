package top.blentle.foundation.review.designpatterns.strategy;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @desc 普通的用户名，密码验证
 */
public class UsernamePasswordStrategy implements IdentifyStrategy {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private AccountService accountService;

	private UserSecurityService userSecurityService;

	/**
	 *
	 * @param wrapper
	 * @param identifier  用户名
	 * @param credential  密码
	 * @return
	 */
	@Override
	public InspectResult inspectSign(ServletWrapper wrapper, String identifier, String credential) {
		//check dependency
		Assert.notNull(accountService,"UsernamePasswordStrategy need AccountService ");
		Assert.notNull(userSecurityService,"UsernamePasswordStrategy need userSecurityService ");
		if (StringUtils.isBlank(identifier) || StringUtils.isBlank(credential))
			return new InspectResult(false, JsonResult.error(JsonResult.CODE_ERROR,"账户名或密码不得为空!"));
		logger.info("account:[{}] try to login, ip:[{}]", identifier, HttpUtils.getRemoteAddr(wrapper.getRequest()));
		List<Account> accountList = accountService.queryAccountByCredential(identifier);
		if (CollectionUtils.isEmpty(accountList))
			return new InspectResult(false, JsonResult.error(JsonResult.CODE_ERROR,"账户不存在!"));
		//获取用户成功,理论上来讲，这里只能获取一个账户
		Account account = accountList.get(0);
		JwtUser check = userSecurityService.checkPassword(account, credential);
		if (check == null) {
			return new InspectResult(false, JsonResult.error("账户或密码错误！"));
		}
		//校验成功
		return new InspectResult(true, account);
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public UserSecurityService getUserSecurityService() {
		return userSecurityService;
	}

	public void setUserSecurityService(UserSecurityService userSecurityService) {
		this.userSecurityService = userSecurityService;
	}
}
