package top.blentle.foundation.review.designpatterns.strategy;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 * 表：tbl_user
 */
public class Account implements Serializable {

	private Integer id;

	private String userName;
	
	private String email;

	private String areaNumber;
	
	private String mobilePhone;

	private String nickname;

	private String password;

	private String verificationCode;

	private String salt;
	
	private Date createDate;
	
	private String headerImage;
	
	private Date lastLoginDate;

	private Integer certificationState;
	
	private String paymentPassword;
	
	private String roleId;
	
	private int userNameChangeTimes;

	private String bgImg;
	
	private String bgImgLayout;

	private String token;
	
	private Integer language;
	
	private Double timezone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAreaNumber() {
		return areaNumber;
	}

	public void setAreaNumber(String areaNumber) {
		this.areaNumber = areaNumber;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getHeaderImage() {
		return headerImage;
	}

	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Integer getCertificationState() {
		return certificationState;
	}

	public void setCertificationState(Integer certificationState) {
		this.certificationState = certificationState;
	}

	public String getPaymentPassword() {
		return paymentPassword;
	}

	public void setPaymentPassword(String paymentPassword) {
		this.paymentPassword = paymentPassword;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public int getUserNameChangeTimes() {
		return userNameChangeTimes;
	}

	public void setUserNameChangeTimes(int userNameChangeTimes) {
		this.userNameChangeTimes = userNameChangeTimes;
	}

	public String getBgImg() {
		return bgImg;
	}

	public void setBgImg(String bgImg) {
		this.bgImg = bgImg;
	}

	public String getBgImgLayout() {
		return bgImgLayout;
	}

	public void setBgImgLayout(String bgImgLayout) {
		this.bgImgLayout = bgImgLayout;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getLanguage() {
		return language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}

	public Double getTimezone() {
		return timezone;
	}

	public void setTimezone(Double timezone) {
		this.timezone = timezone;
	}
}
