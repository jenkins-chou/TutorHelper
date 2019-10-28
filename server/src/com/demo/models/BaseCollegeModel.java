package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table base_college
//arp.addMapping("base_college", BaseCollegeModel.class);
public class BaseCollegeModel extends Model<BaseCollegeModel>{
	public static final BaseCollegeModel dao = new BaseCollegeModel();
	
	public Page<BaseCollegeModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from base_college order by create_time asc");
	}
}