package top.blentle.foundation.review.designpatterns.strategy;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountService {

	@Resource
	private IdentifyStrategyContext identifyStrategyContext;

	/**
	 * 登录验签
	 * @param wrapper
	 * @param identifier
	 * @param credential
	 * @param identifyType
	 * @return
	 */
	public InspectResult inspectSign(ServletWrapper wrapper, String identifier, String credential, IdentifyType identifyType) {
		return identifyStrategyContext.inspectSign(wrapper, identifier,credential, identifyType);
	}

	public List<Account> queryAccountByCredential(String credential) {
		//todo:
		return null;
	}

	/**
	 *
	 * @param mobile
	 * @return
	 */
	public Account getAccountByMobilePhone(String mobile) {
		//todo:
		return null;
	}

	public Account get(Integer userId) {
		return null;
	}
}
