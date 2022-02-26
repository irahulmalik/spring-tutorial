package com.malik.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = {"string1", "string2"})
@JsonFilter("someBeanFilter")
public class SomeBean {
	
	private String string1;
	private String string2;
//	@JsonIgnore
	private String string3;
	
	public SomeBean(String string1, String string2, String string3) {
		super();
		this.string1 = string1;
		this.string2 = string2;
		this.string3 = string3;
	}
	/**
	 * @return the string1
	 */
	public String getString1() {
		return string1;
	}
	/**
	 * @param string1 the string1 to set
	 */
	public void setString1(String string1) {
		this.string1 = string1;
	}
	/**
	 * @return the string2
	 */
	public String getString2() {
		return string2;
	}
	/**
	 * @param string2 the string2 to set
	 */
	public void setString2(String string2) {
		this.string2 = string2;
	}
	/**
	 * @return the string3
	 */
	public String getString3() {
		return string3;
	}
	/**
	 * @param string3 the string3 to set
	 */
	public void setString3(String string3) {
		this.string3 = string3;
	}

}
