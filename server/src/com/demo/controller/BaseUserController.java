package com.demo.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.demo.models.BaseUserModel;
import com.demo.utils.Const;
import com.demo.utils.CrossOrigin;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.demo.utils.DatabaseUtil;
import com.demo.utils.Log;

@CrossOrigin
public class BaseUserController  extends Controller {
	
	public static final String DB_TABLE = "base_user";
	
	@CrossOrigin
	public void login(){
		
		String username = getPara("username");
		String password = getPara("password");
		List<BaseUserModel> userModels = BaseUserModel.dao.find("select * from "+DB_TABLE+" where username = '"+username+"' and password = '"+password+"' and del != 'delete'");
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
		
		String username = getPara("username");
		String password = getPara("password");
		String user_type = getPara("type");
		Log.i(username);
		Log.i(password);
		List<BaseUserModel> userModels = BaseUserModel.dao.find("select * from "+DB_TABLE+" where username = '"+username+"' and del != 'delete'");
		JSONObject js = new JSONObject();
		if(userModels!=null&&userModels.size()>=1){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			js.put(Const.KEY_RES_DATA, userModels);
			renderJson(JsonKit.toJson(js));
		}else{
			BaseUserModel model = getModel(BaseUserModel.class, "", true);
			model.set(Const.KEY_DB_CREATE_TIME, System.currentTimeMillis()/1000+"");
			model.set(Const.KEY_DB_DEL, Const.OPTION_DB_NORMAL);
			model.set("type_describe",getUserTypeDescribe(user_type));
			System.out.println("model:"+model);
			model.save();
			List<BaseUserModel> userModelsResult = BaseUserModel.dao.find("select * from "+DB_TABLE+" where username = '"+username+"' and del != 'delete'");
			
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put("data", userModelsResult);
			renderJson(JsonKit.toJson(js));
		}
	}
	
	@CrossOrigin
	public void updateUserInfo(){
		
		JSONObject js = new JSONObject();
		try{
			BaseUserModel model = getModel(BaseUserModel.class, "", true);
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
	
	@CrossOrigin
	public void getAll(){
		List<BaseUserModel> models = BaseUserModel.dao.find("select * from "+DB_TABLE+" where del != 'delete'");
		JSONObject js = new JSONObject();
		if(models!=null&&models.size()>=1){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put(Const.KEY_RES_DATA, models);
			System.out.println(JsonKit.toJson(js));
			renderJson(JsonKit.toJson(js));
		}else{
			System.out.println("model:");
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(js.toJSONString());
		}
	}
	
	@CrossOrigin
	public void get(){
		String id = getPara("id");
		List<BaseUserModel> models = BaseUserModel.dao.find("select * from "+DB_TABLE+" where id = "+id+" and  del != 'delete'");
		JSONObject js = new JSONObject();
		if(models!=null&&models.size()>=1){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put(Const.KEY_RES_DATA, models.get(0));
			System.out.println(JsonKit.toJson(js));
			renderJson(JsonKit.toJson(js));
		}else{
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(js.toJSONString());
		}
	}
	
	@CrossOrigin
	public void add(){
		JSONObject js = new JSONObject();
		try{
			BaseUserModel model = getModel(BaseUserModel.class, "", true);
			model.set(Const.KEY_DB_CREATE_TIME, System.currentTimeMillis()/1000+"");
			model.set(Const.KEY_DB_DEL, Const.OPTION_DB_NORMAL);
			System.out.println("model:"+model);
			model.save();
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			renderJson(JsonKit.toJson(js));
		}catch(Exception e){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(JsonKit.toJson(js));
		}
	}
	
	@CrossOrigin
	public void update(){
		JSONObject js = new JSONObject();
		try{
			BaseUserModel model = getModel(BaseUserModel.class, "", true);
			System.out.println("model:"+model);
			model.update();
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			renderJson(JsonKit.toJson(js));
		}catch(Exception e){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(JsonKit.toJson(js));
		}
	}
	
	@CrossOrigin
	public void delete(){
		JSONObject js = new JSONObject();
		try{
			BaseUserModel model = getModel(BaseUserModel.class, "", true);
			System.out.println("model:"+model);
			model.set(Const.KEY_DB_DEL, Const.OPTION_DB_DELETE);
			model.update();
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			renderJson(JsonKit.toJson(js));
		}catch(Exception e){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(JsonKit.toJson(js));
		}
	}

	
	
	@CrossOrigin
	public void getTableInfo(){
		JSONObject js = new JSONObject();
		try{
			List nameList = DatabaseUtil.getTableInfo(DB_TABLE,DatabaseUtil.TableInfoEnum._ColumnNames);
			List typeList = DatabaseUtil.getTableInfo(DB_TABLE,DatabaseUtil.TableInfoEnum._ColumnTypes);
			List commentList = DatabaseUtil.getTableInfo(DB_TABLE,DatabaseUtil.TableInfoEnum._ColumnComments);
			
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put("column_name", nameList);
			js.put("column_type", typeList);
			js.put("column_comment", commentList);
			renderJson(JsonKit.toJson(js));
		}catch(Exception e){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(JsonKit.toJson(js));
		}
	}
}
