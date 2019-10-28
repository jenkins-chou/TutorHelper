package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table attendance_record
//arp.addMapping("attendance_record", AttendanceRecordModel.class);
public class AttendanceRecordModel extends Model<AttendanceRecordModel>{
	public static final AttendanceRecordModel dao = new AttendanceRecordModel();
	
	public Page<AttendanceRecordModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from attendance_record order by create_time asc");
	}
}