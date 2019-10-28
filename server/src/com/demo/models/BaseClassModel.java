package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table base_class
//arp.addMapping("base_class", BaseClassModel.class);
public class BaseClassModel extends Model<BaseClassModel>{
	public static final BaseClassModel dao = new BaseClassModel();
	
	public Page<BaseClassModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from base_class order by create_time asc");
	}
}