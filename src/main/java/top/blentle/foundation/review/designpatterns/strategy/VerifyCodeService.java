package top.blentle.foundation.review.designpatterns.strategy;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Random;

/**
 * 验证码service
 * Created by yangting on 2019/3/27.
 */
@Service
public class VerifyCodeService {

	private static final String VERIFY_CODE_CACHE = "verifyCodeCache";

	@Resource
	private CacheManager cacheManager;

	/**
	 * 发送邮件的邮箱名
	 */
	@Value("${spring.mail.username}")
	private String fromEmail;


	/**
	 * 校验验证码正确性
	 *
	 * @param mobilePhone 手机号，或邮箱地址
	 * @return 验证码是否正确
	 */
	public boolean validateVerifyCode(BusinessType type, String mobilePhone, String verifyCode) {
		Cache cache = cacheManager.getCache(VERIFY_CODE_CACHE);
		if (cache == null) {
			return false;
		}
		Cache.ValueWrapper valueWrapper = cache.get(type.name() + ":" + mobilePhone);
		if (valueWrapper == null || valueWrapper.get() == null) {
			return false;
		}
		return Objects.equals(valueWrapper.get(), verifyCode);
	}

	/**
	 * 生成6位随机验证码
	 *
	 * @return
	 */
	private String randomCode() {
		return String.valueOf(new Random().nextInt(899999) + 100000);
	}
}
