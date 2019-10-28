package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table psy_test_item
//arp.addMapping("psy_test_item", PsyTestItemModel.class);
public class PsyTestItemModel extends Model<PsyTestItemModel>{
	public static final PsyTestItemModel dao = new PsyTestItemModel();
	
	public Page<PsyTestItemModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from psy_test_item order by create_time asc");
	}
}