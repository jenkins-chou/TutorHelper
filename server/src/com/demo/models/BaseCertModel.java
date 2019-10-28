package com.demo.models;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

//genarate with database table base_cert
//arp.addMapping("base_cert", BaseCertModel.class);
public class BaseCertModel extends Model<BaseCertModel>{
	public static final BaseCertModel dao = new BaseCertModel();
	
	public Page<BaseCertModel> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from base_cert order by create_time asc");
	}
}