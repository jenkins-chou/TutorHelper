package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table psy_test_item_type
//arp.addMapping("psy_test_item_type", PsyTestItemTypeModel.class);
public class PsyTestItemTypeModel extends Model<PsyTestItemTypeModel>{
	public static final PsyTestItemTypeModel dao = new PsyTestItemTypeModel();
	
	public Page<PsyTestItemTypeModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from psy_test_item_type order by create_time asc");
	}
}