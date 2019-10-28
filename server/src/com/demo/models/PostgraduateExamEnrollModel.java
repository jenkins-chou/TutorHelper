package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table postgraduate_exam_enroll
//arp.addMapping("postgraduate_exam_enroll", PostgraduateExamEnrollModel.class);
public class PostgraduateExamEnrollModel extends Model<PostgraduateExamEnrollModel>{
	public static final PostgraduateExamEnrollModel dao = new PostgraduateExamEnrollModel();
	
	public Page<PostgraduateExamEnrollModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from postgraduate_exam_enroll order by create_time asc");
	}
}