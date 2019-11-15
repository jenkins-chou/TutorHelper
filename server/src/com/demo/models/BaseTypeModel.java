package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table base_state
//arp.addMapping("base_state", BaseStateModel.class);
public class BaseTypeModel extends Model<BaseTypeModel>{
	public static final BaseTypeModel dao = new BaseTypeModel();
	
	public Page<BaseTypeModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from base_type order by create_time asc");
	}
}