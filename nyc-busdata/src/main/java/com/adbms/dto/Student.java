package com.adbms.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
    private String uin;
    private String name;
    
	public String getUin() {
		return uin;
	}
	public void setUin(String uin) {
		this.uin = uin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
