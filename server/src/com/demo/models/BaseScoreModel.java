package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table base_score
//arp.addMapping("base_score", BaseScoreModel.class);
public class BaseScoreModel extends Model<BaseScoreModel>{
	public static final BaseScoreModel dao = new BaseScoreModel();
	
	public Page<BaseScoreModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from base_score order by create_time asc");
	}
}