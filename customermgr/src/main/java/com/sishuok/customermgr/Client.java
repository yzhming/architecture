package com.sishuok.customermgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.sishuok.customermgr.dao.CustomerDao;

@Service
public class Client {
	
	@Autowired
	private CustomerDao dao = null;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Client t = (Client) ctx.getBean("client");
	}
}
