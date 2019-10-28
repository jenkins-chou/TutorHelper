package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table early_reading
//arp.addMapping("early_reading", EarlyReadingModel.class);
public class EarlyReadingModel extends Model<EarlyReadingModel>{
	public static final EarlyReadingModel dao = new EarlyReadingModel();
	
	public Page<EarlyReadingModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from early_reading order by create_time asc");
	}
}