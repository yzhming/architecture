
package com.sishuok.customermgr.dao;

import java.util.List;

import com.sishuok.customermgr.vo.CustomerModel;
import com.sishuok.customermgr.vo.CustomerQueryModel;

public interface CustomerDao {
	public void create(CustomerModel cm);
	public void update(CustomerModel cm);
	public void delete(int uuid);
	
	public CustomerModel getByUuid(int uuid);
	public List<CustomerModel> getByCondition(CustomerQueryModel cqm);
}
