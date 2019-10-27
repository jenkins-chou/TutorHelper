package com.demo.controller;

//import java.io.File;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.demo.interfaces.ControllerInterface;
import com.demo.models.UserModel;
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
public class UserController extends DefaultController<UserModel>{
	
	public static final String DB_TABLE = "base_user";
	public static final String HTML_KEY = "user";
	
	@Override
	public void setData() {
		modelClass = UserModel.class;
		tableName = DB_TABLE;
		htmlKey = HTML_KEY;
		entityDao = UserModel.dao;
	}
	
	@CrossOrigin
	public void login(){
		setData();
		String username = getPara("username");
		String password = getPara("password");
		List<UserModel> userModels = entityDao.find("select * from "+DB_TABLE+" where username = '"+username+"' and password = '"+password+"' and del != 'delete'");
		JSONObject js = new JSONObject();
		if(userModels!=null&&userModels.size()==1){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put(Const.KEY_RES_DATA, userModels.get(0));
			System.out.println(JsonKit.toJson(js));
			renderJson(JsonKit.toJson(js));
		}else{
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(js.toJSONString());
		}
	}
	@CrossOrigin
	public void register() {
		setData();
		String username = getPara("username");
		String password = getPara("password");
		String user_type = getPara("type");
		Log.i(username);
		Log.i(password);
		List<UserModel> userModels = entityDao.find("select * from "+DB_TABLE+" where username = '"+username+"' and del != 'delete'");
		JSONObject js = new JSONObject();
		if(userModels!=null&&userModels.size()>=1){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			js.put(Const.KEY_RES_DATA, userModels);
			renderJson(JsonKit.toJson(js));
		}else{
			UserModel model = getModel(modelClass, "", true);
			model.set(Const.KEY_DB_CREATE_TIME, System.currentTimeMillis()/1000+"");
			model.set(Const.KEY_DB_DEL, Const.OPTION_DB_NORMAL);
			model.set("type_describe",getUserTypeDescribe(user_type));
			System.out.println("model:"+model);
			model.save();
			List<UserModel> userModelsResult = entityDao.find("select * from "+DB_TABLE+" where username = '"+username+"' and del != 'delete'");
			
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put("data", userModelsResult);
			renderJson(JsonKit.toJson(js));
		}
	}
	
	@CrossOrigin
	public void updateUserInfo(){
		setData();
		JSONObject js = new JSONObject();
		try{
			UserModel model = getModel(modelClass, "", true);
			System.out.println(model.toJson());
			model.update();
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			System.out.println("---->"+JsonKit.toJson(js));
			renderJson(JsonKit.toJson(js));
			
		}catch(Exception e){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(JsonKit.toJson(js));
		}
		
	}
	
	public static String getUserTypeDescribe(String userType){
		System.out.println("userType:"+userType);
		if(userType != null && userType != ""){
			switch(userType){
				case "1":
					return "学生";
				case "2":
					return "教师";
				case "3":
					return "管理员";
				case "4":
					return "系统管理员";
					default:
						return "学生";
			}
		}else{
			return "";
		}
		
	}


	
}
