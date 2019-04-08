package top.blentle.foundation.review.designpatterns.strategy;

import java.io.Serializable;

/**
 * 返回结果类
 * 所有controller返回结果使用它返回
 * @author blentle
 */
public class JsonResult<T> implements Serializable {

	/**
	 * 成功状态码
	 * success
	 */
	private static final String CODE_SUCCESS = "1";

	/**
	 * 失败状态码
	 * error
	 */
	public static final String CODE_ERROR = "0";

	/**
	 * 没有权限:如登录权限，系统业务池的权限
	 * unauthorized
	 */
	public static final String CODE_UN = "-1";

	/**
	 * 不接受的请求
	 */
	public static final String CODE_FORB = "406";

	/**
	 * 返回的状态码
	 */
	private String statusCode = JsonResult.CODE_ERROR;

	/**
	 * 返回结果描述
	 */
	private String msg = null;

	/**
	 * 返回结果
	 */
	private T result;

	public JsonResult() {

	}

	public JsonResult(String statusCode) {
		this.statusCode = statusCode;
	}

	public JsonResult(String statusCode, String msg) {
		this.statusCode = statusCode;
		this.msg = msg;
	}

	public JsonResult(String statusCode, T result) {
		this.statusCode = statusCode;
		this.result = result;
	}

	public JsonResult(String statusCode, String msg, T result) {
		this.statusCode = statusCode;
		this.msg = msg;
		this.result = result;
	}

	/**
	 * 返回成功
	 * @return
	 */
	public static <T> JsonResult<T> success() {
		return new JsonResult<>(CODE_SUCCESS, "操作成功");
	}

	/**
	 * 返回成功
	 * @return
	 */
	public static <T> JsonResult<T> success(String msg) {
		return new JsonResult<>(CODE_SUCCESS, msg);
	}

	/**
	 * 返回成功
	 * @param result
	 * @param <T>
	 * @return
	 */
	public static <T> JsonResult<T> success(T result) {
		return new JsonResult<>(CODE_SUCCESS, result);
	}

	/**
	 * 返回成功
	 * @param msg
	 * @param result
	 * @param <T>
	 * @return
	 */
	public static <T> JsonResult<T> success(String msg,T result) {
		return new JsonResult<>(CODE_SUCCESS, msg,result);
	}

	/**
	 * 返回失败
	 * @param statusCode
	 * @param msg
	 * @param <T>
	 * @return
	 */
	public static <T> JsonResult<T> error(String statusCode,String msg) {
		return new JsonResult<>(statusCode,msg);
	}

	/**
	 * 返回失败
	 * @param msg
	 * @param <T>
	 * @return
	 */
	public static <T> JsonResult<T> error(String msg) {
		return new JsonResult<>(CODE_ERROR,msg);
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}

