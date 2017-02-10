package com.sishuok.architecture1.customermgr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.sishuok.architecture1.customermgr.dao.CustomerDAO;
import com.sishuok.architecture1.customermgr.vo.CustomerModel;
import com.sishuok.architecture1.customermgr.vo.CustomerQueryModel;

@Service
public class Client {
	
	@Autowired
	private CustomerDAO dao = null;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Client t = (Client) ctx.getBean("client");

		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("c1");
		cm.setPwd("c1");
		cm.setRegisterTime("1");
		cm.setShowName("c1");
		cm.setTrueName("张三");
		
		//t.dao.create(cm);
		System.out.println("*******test result*******");
		CustomerQueryModel cqm=new CustomerQueryModel();
		cqm.getPage().setNowPage(1);
		cqm.getPage().setPageShow(2);
		
		List<CustomerModel> list = t.dao.getByConditionPage(cqm);
		System.out.println("list=="+list);
	}
}
