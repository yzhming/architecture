package com.sishuok.architecture1.customermgr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sishuok.architecture1.customermgr.service.ICustomerService;
import com.sishuok.architecture1.customermgr.vo.CustomerModel;
import com.sishuok.architecture1.customermgr.vo.CustomerQueryModel;
import com.sishuok.pageutil.Page;
import com.sishuok.util.format.DateFormatHelper;
import com.sishuok.util.json.JsonHelper;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	private ICustomerService ics = null;

	@RequestMapping(value = "toAdd", method = RequestMethod.GET)
	public String toAdd() {
		return "customer/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("cm") CustomerModel cm) {
		cm.setRegisterTime(DateFormatHelper.long2str(System.currentTimeMillis()));
		ics.create(cm);
		return "customer/success";
	}

	@RequestMapping(value = "toUpdate/{customerUuid}", method = RequestMethod.GET)
	public String toUpdate(Model model, @PathVariable("customerUuid") int customerUuid) {
		CustomerModel cm = ics.getByUuid(customerUuid);
		model.addAttribute("cm", cm);
		return "customer/update";
	}

	@RequestMapping(value = "udapte", method = RequestMethod.POST)
	public String post(@ModelAttribute("cm") CustomerModel cm) {
		ics.update(cm);
		return "customer/success";
	}

	@RequestMapping(value = "toDelete/{customerUuid}", method = RequestMethod.GET)
	public String toDelete(Model model, @PathVariable("customerUuid") int customerUuid) {
		CustomerModel cm = ics.getByUuid(customerUuid);
		model.addAttribute("cm", cm);
		return "customer/delete";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String post(@RequestParam("uuid") int customerUuid) {
		ics.delete(customerUuid);
		return "customer/success";
	}

	@RequestMapping(value = "toList", method = RequestMethod.GET)
	public String toList(@RequestParam(value = "queryJosnStr", defaultValue = "") String queryJsonStr,
			@ModelAttribute("page") Page page, Model model) {
		CustomerQueryModel cqm = null;
		if (queryJsonStr == null || queryJsonStr.trim().length() == 0) {
			cqm = new CustomerQueryModel();
		} else {
			cqm = (CustomerQueryModel) JsonHelper.str2Object(queryJsonStr, CustomerQueryModel.class);
		}

		cqm.getPage().setNowPage(page.getNowPage());
		Page dbPage = ics.getByConditionPage(cqm);

		model.addAttribute("queryJosnStr", queryJsonStr);
		model.addAttribute("page", dbPage);

		return "customer/list";
	}

}
