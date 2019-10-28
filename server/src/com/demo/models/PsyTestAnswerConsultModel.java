package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table psy_test_answer_consult
//arp.addMapping("psy_test_answer_consult", PsyTestAnswerConsultModel.class);
public class PsyTestAnswerConsultModel extends Model<PsyTestAnswerConsultModel>{
	public static final PsyTestAnswerConsultModel dao = new PsyTestAnswerConsultModel();
	
	public Page<PsyTestAnswerConsultModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from psy_test_answer_consult order by create_time asc");
	}
}