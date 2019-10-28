package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table psy_test_answer_record
//arp.addMapping("psy_test_answer_record", PsyTestAnswerRecordModel.class);
public class PsyTestAnswerRecordModel extends Model<PsyTestAnswerRecordModel>{
	public static final PsyTestAnswerRecordModel dao = new PsyTestAnswerRecordModel();
	
	public Page<PsyTestAnswerRecordModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from psy_test_answer_record order by create_time asc");
	}
}