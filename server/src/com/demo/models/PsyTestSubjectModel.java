package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table psy_test_subject
//arp.addMapping("psy_test_subject", PsyTestSubjectModel.class);
public class PsyTestSubjectModel extends Model<PsyTestSubjectModel>{
	public static final PsyTestSubjectModel dao = new PsyTestSubjectModel();
	
	public Page<PsyTestSubjectModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from psy_test_subject order by create_time asc");
	}
}