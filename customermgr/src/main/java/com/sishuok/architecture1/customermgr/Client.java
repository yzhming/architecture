package com.sishuok.architecture1.customermgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.sishuok.architecture1.customermgr.service.ICustomerService;
import com.sishuok.architecture1.customermgr.vo.CustomerModel;
import com.sishuok.architecture1.customermgr.vo.CustomerQueryModel;
import com.sishuok.pageutil.Page;

@Service
public class Client {

	@Autowired
	private ICustomerService service = null;

	public ICustomerService getService() {
		return service;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Client t = (Client) ctx.getBean("client");

		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("c1");
		cm.setPwd("c1");
		cm.setRegisterTime("1");
		cm.setShowName("c1");
		cm.setTrueName("张三");

		// t.dao.create(cm);
		System.out.println("*******test result*******");
		CustomerQueryModel cqm = new CustomerQueryModel();
		cqm.getPage().setNowPage(1);
		cqm.getPage().setPageShow(2);

		Page<CustomerModel> p = t.getService().getByConditionPage(cqm);
		System.out.println("list==" + p);


		Page<CustomerModel> p2 = t.getService().getByConditionPage(cqm);
		System.out.println("list2==" + p);
	}
}
