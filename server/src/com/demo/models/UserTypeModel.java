package com.demo.models;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class UserTypeModel extends Model<UserTypeModel>{
public static final UserTypeModel dao = new UserTypeModel();
	
	public Page<UserTypeModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from base_user_type order by create_time asc");
	}
}
