package com.demo.controller;

//import java.io.File;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.demo.interfaces.ControllerInterface;
import com.demo.models.UserTypeModel;
import com.demo.utils.Const;
import com.demo.utils.CrossOrigin;
import com.demo.utils.Log;
import com.demo.utils.PageJson;
import com.demo.utils.ParamUtil;
import com.demo.utils.RecordJson;
import com.demo.utils.StatusJson;
import com.demo.utils.StringUtil;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;

@CrossOrigin
public class UserTypeController extends DefaultController<UserTypeModel>{
	
	public static final String DB_TABLE = "base_user_type";
	public static final String HTML_KEY = "user_type";
	
	@Override
	public void setData() {
		modelClass = UserTypeModel.class;
		tableName = DB_TABLE;
		htmlKey = HTML_KEY;
		entityDao = UserTypeModel.dao;
	}
	
	@CrossOrigin
	public void getAllUserType(){
		setData();
		List<UserTypeModel> UserTypeModels = entityDao.find("select * from "+DB_TABLE+" where del != 'delete'");
		JSONObject js = new JSONObject();
		if(UserTypeModels!=null&&UserTypeModels.size()>=1){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put(Const.KEY_RES_DATA, UserTypeModels);
			System.out.println(JsonKit.toJson(js));
			renderJson(JsonKit.toJson(js));
		}else{
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(js.toJSONString());
		}
	}
	


	
}
