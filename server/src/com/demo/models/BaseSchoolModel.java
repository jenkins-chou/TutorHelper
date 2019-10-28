package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table base_school
//arp.addMapping("base_school", BaseSchoolModel.class);
public class BaseSchoolModel extends Model<BaseSchoolModel>{
	public static final BaseSchoolModel dao = new BaseSchoolModel();
	
	public Page<BaseSchoolModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from base_school order by create_time asc");
	}
}