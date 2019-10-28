package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table attendance
//arp.addMapping("attendance", AttendanceModel.class);
public class AttendanceModel extends Model<AttendanceModel>{
	public static final AttendanceModel dao = new AttendanceModel();
	
	public Page<AttendanceModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from attendance order by create_time asc");
	}
}