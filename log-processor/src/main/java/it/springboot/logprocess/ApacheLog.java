package it.springboot.logprocess;

public class ApacheLog {

	private String ip;
	private String date;
	private String method;
	private String url;
	private String protocol;
	private String httpCode;
	
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
