package com.demo.models;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class BaseNewModel extends Model<BaseNewModel>{
	public static final BaseNewModel dao = new BaseNewModel();
	
	public Page<BaseNewModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from base_new order by create_time asc");
	}
}