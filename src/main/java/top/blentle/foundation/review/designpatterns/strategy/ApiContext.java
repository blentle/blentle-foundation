package top.blentle.foundation.review.designpatterns.strategy;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableCaching
@EnableScheduling
public class ApiContext {

	@Resource
	private AccountService accountService;

	@Resource
	private UserSecurityService userSecurityService;

	@Resource
	private VerifyCodeService verifyCodeService;

	@Bean
	IdentifyStrategyContext identifyStrategyContext() {
		return new IdentifyStrategyContext(identifyStrategyMap());
	}


	private Map<IdentifyType, IdentifyStrategy> identifyStrategyMap() {
		Map<IdentifyType, IdentifyStrategy> identifyStrategyMap = new HashMap<>();
		identifyStrategyMap.put(IdentifyType.pass, usernamePasswordStrategy());
		identifyStrategyMap.put(IdentifyType.sms, smsStrategy());
		return identifyStrategyMap;
	}

	@Bean
	UsernamePasswordStrategy usernamePasswordStrategy() {
		UsernamePasswordStrategy passwordStrategy = new UsernamePasswordStrategy();
		passwordStrategy.setAccountService(accountService);
		passwordStrategy.setUserSecurityService(userSecurityService);
		return passwordStrategy;
	}

	@Bean
	SmsStrategy smsStrategy() {
		SmsStrategy smsStrategy = new SmsStrategy();
		smsStrategy.setAccountService(accountService);
		smsStrategy.setVerifyCodeService(verifyCodeService);
		return smsStrategy;
	}
}
