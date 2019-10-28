package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table scholarship
//arp.addMapping("scholarship", ScholarshipModel.class);
public class ScholarshipModel extends Model<ScholarshipModel>{
	public static final ScholarshipModel dao = new ScholarshipModel();
	
	public Page<ScholarshipModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from scholarship order by create_time asc");
	}
}