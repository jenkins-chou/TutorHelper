package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table base_course
//arp.addMapping("base_course", BaseCourseModel.class);
public class BaseCourseModel extends Model<BaseCourseModel>{
	public static final BaseCourseModel dao = new BaseCourseModel();
	
	public Page<BaseCourseModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from base_course order by create_time asc");
	}
}