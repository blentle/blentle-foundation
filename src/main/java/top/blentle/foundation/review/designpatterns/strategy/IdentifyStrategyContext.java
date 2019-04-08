package top.blentle.foundation.review.designpatterns.strategy;

import org.springframework.util.Assert;

import java.util.Map;

/**
 * @desc 验签策略上下文
 * @author blentle
 */
public class IdentifyStrategyContext {

	/**
	 * 验签策略列表:
	 * 如；微信，微博，qq等
	 */
	private Map<IdentifyType, IdentifyStrategy> strategyMap;

	public IdentifyStrategyContext(Map<IdentifyType, IdentifyStrategy> strategyMap) {
		this.strategyMap = strategyMap;
	}

	public InspectResult inspectSign(ServletWrapper wrapper, String identifier, String credential, IdentifyType identifyType) {
		//check dependency
		Assert.notEmpty(strategyMap,"IdentifyStrategyContext need a strategy map included a set of identify strategies");
		IdentifyStrategy strategy = strategyMap.get(identifyType);
		return strategy.inspectSign(wrapper, identifier, credential);
	}

	public Map<IdentifyType, IdentifyStrategy> getStrategyMap() {
		return strategyMap;
	}

	public void setStrategyMap(Map<IdentifyType, IdentifyStrategy> strategyMap) {
		this.strategyMap = strategyMap;
	}
}
