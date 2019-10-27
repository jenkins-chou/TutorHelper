package com.demo.models;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class MenuModel extends Model<MenuModel>{
	public static final MenuModel dao = new MenuModel();
	
	public Page<MenuModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from user_menu order by create_time asc");
	}
}
