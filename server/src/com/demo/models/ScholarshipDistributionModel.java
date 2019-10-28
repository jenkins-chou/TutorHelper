package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table scholarship_distribution
//arp.addMapping("scholarship_distribution", ScholarshipDistributionModel.class);
public class ScholarshipDistributionModel extends Model<ScholarshipDistributionModel>{
	public static final ScholarshipDistributionModel dao = new ScholarshipDistributionModel();
	
	public Page<ScholarshipDistributionModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from scholarship_distribution order by create_time asc");
	}
}