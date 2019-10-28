package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table psy_test_answer
//arp.addMapping("psy_test_answer", PsyTestAnswerModel.class);
public class PsyTestAnswerModel extends Model<PsyTestAnswerModel>{
	public static final PsyTestAnswerModel dao = new PsyTestAnswerModel();
	
	public Page<PsyTestAnswerModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from psy_test_answer order by create_time asc");
	}
}