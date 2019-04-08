package top.blentle.foundation.review.designpatterns.strategy;

/**
 * @desc 验签结果
 * @author blentle
 */
public class InspectResult {

	/*
	 * 是否验签通过
	 */
	private boolean authenticated;

	/*
	 * 验签未通过的
	 * 提示信息
	 */
	private JsonResult<?> jsonResult;

	/*
	 * 验签通过的账户
	 */
	private Account account;

	public InspectResult(boolean authenticated, JsonResult<?> jsonResult) {
		this.authenticated = authenticated;
		this.jsonResult = jsonResult;
	}

	public InspectResult(boolean authenticated, Account account) {
		this.authenticated = authenticated;
		this.account = account;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public JsonResult<?> getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JsonResult<?> jsonResult) {
		this.jsonResult = jsonResult;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
