/**
 * 
 */
package com.sample.springboot.model;

/**
 * @author mycom
 *
 */
public class Owner {

	private Integer id;
	
	private String login;
	
	private String url;
	
	private String avatar_url;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the avatar_url
	 */
	public String getAvatar_url() {
		return avatar_url;
	}

	/**
	 * @param avatar_url the avatar_url to set
	 */
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	
}
