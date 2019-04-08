package top.blentle.foundation.review.designpatterns.strategy;

/**
 * @desc 验签策略接口
 * @author blentle
 */
public interface IdentifyStrategy {

	/**
	 * 验签
	 * @param wrapper
	 * @param identifier
	 * @param credential
	 * @return
	 */
	InspectResult inspectSign(ServletWrapper wrapper, String identifier, String credential);
}
