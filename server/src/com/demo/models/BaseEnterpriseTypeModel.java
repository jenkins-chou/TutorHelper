package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table base_enterprise_type
//arp.addMapping("base_enterprise_type", BaseEnterpriseTypeModel.class);
public class BaseEnterpriseTypeModel extends Model<BaseEnterpriseTypeModel>{
	public static final BaseEnterpriseTypeModel dao = new BaseEnterpriseTypeModel();
	
	public Page<BaseEnterpriseTypeModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from base_enterprise_type order by create_time asc");
	}
}