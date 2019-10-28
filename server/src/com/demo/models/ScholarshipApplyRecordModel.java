package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table scholarship_apply_record
//arp.addMapping("scholarship_apply_record", ScholarshipApplyRecordModel.class);
public class ScholarshipApplyRecordModel extends Model<ScholarshipApplyRecordModel>{
	public static final ScholarshipApplyRecordModel dao = new ScholarshipApplyRecordModel();
	
	public Page<ScholarshipApplyRecordModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from scholarship_apply_record order by create_time asc");
	}
}