package top.blentle.foundation.review.designpatterns.strategy;

/**
 * @desc 验签类型
 * @author blentle
 */
public enum IdentifyType {

	/*
	 * 普通的账号，密码验证
	 */
	pass,

	/*
	 * 短信验证码登录
	 */
	sms,

	/*
	 * 微博验证
	 */
	weibo,

	/*
	 * 微信验证
	 */
	wechat,

	/*
	 * 支付宝验证
	 */
	alipay,

	;

}
