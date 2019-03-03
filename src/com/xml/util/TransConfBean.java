package com.xml.util;

import java.util.ArrayList;
import java.util.List;

public class TransConfBean {
	private String name;
	private List<XmlItemBean> sed = new ArrayList<XmlItemBean>();
	private List<XmlItemBean> rcv = new ArrayList<XmlItemBean>();
	// 存入孩子
	
	private List<TransConfBean> childBean;

	public List<TransConfBean> getChildBean() {
		return childBean;
	}
	public void setChildBean(List<TransConfBean> childBean) {
		this.childBean = childBean;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<XmlItemBean> getSed() {
		return sed;
	}
	public void setSed(List<XmlItemBean> sed) {
		this.sed = sed;
	}
	public List<XmlItemBean> getRcv() {
		return rcv;
	}
	public void setRcv(List<XmlItemBean> rcv) {
		this.rcv = rcv;
	}
	
	public void addSedItem(XmlItemBean item) {
		sed.add(item);
	}
	
	public void addRcvItem(XmlItemBean item) {
		rcv.add(item);
	}
}
