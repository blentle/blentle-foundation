package top.blentle.foundation.review.designpatterns.strategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @desc Servlet包装器
 * @author blentle
 * 
 */
public class ServletWrapper {
	/**
	 * 请求
	 */
	private HttpServletRequest request;

	/**
	 * 回应
	 */
	private HttpServletResponse response;

	public ServletWrapper() {
	}

	public ServletWrapper(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
