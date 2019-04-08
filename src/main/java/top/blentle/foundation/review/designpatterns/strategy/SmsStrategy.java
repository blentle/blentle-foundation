package top.blentle.foundation.review.designpatterns.strategy;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class SmsStrategy implements IdentifyStrategy {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private AccountService accountService;

	private VerifyCodeService verifyCodeService;

	/**
	 *
	 * @param wrapper
	 * @param identifier 手机号
	 * @param credential  验证码
	 * @return
	 */
	@Override
	public InspectResult inspectSign(ServletWrapper wrapper, String identifier, String credential) {
		//验证手机号是否注册
		//check dependency
		Assert.notNull(accountService,"UsernamePasswordStrategy need AccountService ");
		Account account = accountService.getAccountByMobilePhone(identifier);
		if (StringUtils.isBlank(identifier) || StringUtils.isBlank(credential))
			return new InspectResult(false, JsonResult.error(JsonResult.CODE_ERROR,"手机号或验证码不得为空!"));
		logger.info("account:[{}] try to login, ip:[{}]", identifier, HttpUtils.getRemoteAddr(wrapper.getRequest()));
		if (account == null)
			return new InspectResult(false, JsonResult.error(JsonResult.CODE_ERROR,"账户不存在，请先注册"));
		//check验证码
		boolean check = verifyCodeService.validateVerifyCode(BusinessType.signin, identifier, credential);
		if(!check)
			return new InspectResult(false, JsonResult.error(JsonResult.CODE_ERROR,"验证码不正确"));
		//校验成功
		return new InspectResult(true, account);
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public VerifyCodeService getVerifyCodeService() {
		return verifyCodeService;
	}

	public void setVerifyCodeService(VerifyCodeService verifyCodeService) {
		this.verifyCodeService = verifyCodeService;
	}
}
