package top.blentle.foundation.review.designpatterns.strategy;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author blentle
 * @desc http 一系列有用的工具
 */
public class HttpUtils {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	private static final String DEFAULT_UTF8_ENCODING = "UTF-8";

	private static final String APPLICATION_JSON = "application/json";

	/**
	 * @param url
	 * @param params
	 * @return
	 * @desc 普通form post请求
	 */
	public static String postFormRequest(String url, Map<String, String> params) {
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<>();
		if (!CollectionUtils.isEmpty(params))
			params.forEach((k, v) -> nvps.add(new BasicNameValuePair(k, v)));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			CloseableHttpResponse response = HttpClientHolder.getHttpClient().execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null)
				return EntityUtils.toString(entity, DEFAULT_UTF8_ENCODING);
		} catch (Exception e) {
			logger.error("post form request:{} error", url, e);
		}
		return null;
	}

	/**
	 * @param url
	 * @param json
	 * @param headers
	 * @return
	 * @desc 普通json post请求
	 */
	public static String postJsonRequest(String url, String json, Map<String, String> headers) {
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
		//如果有特殊的Header
		if (!CollectionUtils.isEmpty(headers))
			headers.forEach((k, v) -> httpPost.addHeader(k, v));
		StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
		entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
		try {
			httpPost.setEntity(entity);
			CloseableHttpResponse response = HttpClientHolder.getHttpClient().execute(httpPost);
			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null)
				return EntityUtils.toString(responseEntity, DEFAULT_UTF8_ENCODING);
		} catch (Exception e) {
			logger.error("post json request:{},json:{} error", url, json, e);
		}
		return null;
	}

	/**
	 * 取得远程地址
	 *
	 * @param request
	 * @return
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-real-ip");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip != null && ip.contains(",")) {
			// 多个IP的情况
			String[] ips = StringUtils.split(ip, ",");
			for (int i = 0; i < ips.length - 1; i++) {
				String iip = ips[i].trim();
				try {
					if (!IpUtils.isPrivateIp(iip))
						return iip;
				} catch (Exception e) {
					// invalid ip,ignore
				}
			}
			return ips[ips.length - 1].trim();
		}
		return ip;
	}
}
