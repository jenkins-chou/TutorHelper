package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table base_enterprise
//arp.addMapping("base_enterprise", BaseEnterpriseModel.class);
public class BaseEnterpriseModel extends Model<BaseEnterpriseModel>{
	public static final BaseEnterpriseModel dao = new BaseEnterpriseModel();
	
	public Page<BaseEnterpriseModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from base_enterprise order by create_time asc");
	}
}