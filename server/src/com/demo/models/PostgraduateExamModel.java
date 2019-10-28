package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table postgraduate_exam
//arp.addMapping("postgraduate_exam", PostgraduateExamModel.class);
public class PostgraduateExamModel extends Model<PostgraduateExamModel>{
	public static final PostgraduateExamModel dao = new PostgraduateExamModel();
	
	public Page<PostgraduateExamModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from postgraduate_exam order by create_time asc");
	}
}