package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table scient_subject
//arp.addMapping("scient_subject", ScientSubjectModel.class);
public class ScientSubjectModel extends Model<ScientSubjectModel>{
	public static final ScientSubjectModel dao = new ScientSubjectModel();
	
	public Page<ScientSubjectModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from scient_subject order by create_time asc");
	}
}