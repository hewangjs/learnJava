package com.xml.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class XMLUtils {
	
	private SAXReader reader;
	/**
	 * 读取XML文件
	 * @throws DocumentException 
	 * @throws IOException 
	 */
	public boolean readXMLFile() throws DocumentException, IOException{
		reader = new SAXReader();
		Document doc = null;
		String filePath = "E:\\3001.xml";

		doc = reader.read(new File(filePath));
		Element root = doc.getRootElement();
		TransConfBean confBean = parserObject(root);
		System.out.println(confBean.getSed());
		for(XmlItemBean xb : confBean.getSed()) {
			System.out.println(xb.getId());
		}
		return true;
	}
	/**
	 * 分别组装请求、返回报文信息
	 * 
	 * @param el
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public TransConfBean parserObject(Element el) {
		TransConfBean cmbcConf = new TransConfBean();
		List<Element> list;
		if(el.hasContent()){
			list = el.elements();
			for(Element e : list){
				if(e.getName().equals("Tita")) {
					parserSnd(e, cmbcConf);
				} else if (e.getName().equals("Tota")) {
					parserRcv(e, cmbcConf);
				}
			}
		}
		return cmbcConf;
	}
	
	/**
	 * 解析节点，对请求报文的解析
	 * 
	 * @param el
	 * @param cmbcConf
	 */
	@SuppressWarnings("unchecked")
	public void parserSnd(Element el, TransConfBean cmbcConf) {
		List<Element> list = el.elements();
		for (Element e : list) {
			if (e.getName().equals("Field")) {
				String id = e.attributeValue("id");
				String type = e.attributeValue("type");
				String length = e.attributeValue("length");
				String exchange = e.attributeValue("exchange");
				String defval = e.attributeValue("defval");
				// logger.info("item:" + id + "	default:" + defval);

				XmlItemBean item = new XmlItemBean();
				item.setId(id);
				item.setType(type);
				item.setLength(length);
				item.setDesc(exchange);
				item.setDefval(defval);
				// logger.info("item:" + id + "	default:" + defval);
				cmbcConf.addSedItem(item);
			}
		}
	}
	
	/**
	 * 解析节点,对响应报文的解析
	 * 
	 * @param el
	 * @param cmbcConf
	 */
	@SuppressWarnings("unchecked")
	public void parserRcv(Element el, TransConfBean transConf) {
		List<Element> list = el.elements();
		for (Element e : list) {
			if (e.getName().equals("Field")) {
				String id = e.attributeValue("id");
				String type = e.attributeValue("type");
				String length = e.attributeValue("length");
				String exchange = e.attributeValue("exchange");
				String defval = e.attributeValue("defval");

				XmlItemBean item = new XmlItemBean();
				item.setId(id);
				item.setType(type);
				item.setLength(length);
				item.setDesc(exchange);
				item.setDefval(defval);
				// logger.info("item:" + id + "	default:" + defval);
				// cmbcConf.addRcvItem(item);
				// 循环体内数据
				if ("E".equals(type)) {
					int count = Integer.parseInt(defval);// 循环次数
					List<Element> emus = e.elements();
					
					List<TransConfBean> ls=new ArrayList<TransConfBean>();
					for (int i = 0; i < count; i++) {
						TransConfBean childBean = new TransConfBean();
						setXmlTtem(emus,childBean);
						ls.add(childBean);
					}
					transConf.setChildBean(ls);
				}
				transConf.addRcvItem(item);
			}

		}
	}
	
	/**
	 * 将数据存入到bean中
	 * @param emus
	 * @param childBean
	 */
	private void setXmlTtem(List<Element> emus,TransConfBean childBean){
		for (Element emu : emus) {
			if (emu.getName().equals("Emu")) {
				String id = emu.attributeValue("id");
				String type = emu.attributeValue("type");
				String length = emu.attributeValue("length");
				String exchange = emu.attributeValue("exchange");
				String defval = emu.attributeValue("defval");

				XmlItemBean child = new XmlItemBean();
				child.setId(id);
				child.setType(type);
				child.setLength(length);
				child.setDesc(exchange);
				child.setDefval(defval);
				//logger.info("item:" + id + "	default:" + defval);
				childBean.addRcvItem(child);
			}
		}
	}
		
}
