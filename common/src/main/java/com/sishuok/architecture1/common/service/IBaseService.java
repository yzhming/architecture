package com.sishuok.architecture1.common.service;

import com.sishuok.architecture1.common.vo.BaseModel;
import com.sishuok.pageutil.Page;

public interface IBaseService<M, QM extends BaseModel> {

	public void create(M cm);

	public void update(M cm);

	public void delete(int uuid);

	public M getByUuid(int uuid);

	public Page getByConditionPage(QM qm);

}
