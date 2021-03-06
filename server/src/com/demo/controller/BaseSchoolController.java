package com.demo.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.demo.models.BaseSchoolModel;
import com.demo.utils.CheckUtils;
import com.demo.utils.Const;
import com.demo.utils.CrossOrigin;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.upload.UploadFile;
import com.demo.utils.DatabaseUtil;

@CrossOrigin
public class BaseSchoolController  extends Controller {
	
	public static final String DB_TABLE = "base_school";
	
	public static final Map<String,String> tableFilter = new HashMap();
	
	static{
		tableFilter.put("id","hidden");
		tableFilter.put("create_time","hidden");
		tableFilter.put("school_logo","custom");
		tableFilter.put("del","hidden");
	}
	
	public enum FilterType{
		hidden,//隐藏字段
		custom,//自定义
		normal//默认
	}
	
	@CrossOrigin
	public void getAll(){
		List<BaseSchoolModel> models = BaseSchoolModel.dao.find("select * from "+DB_TABLE+" where del != 'delete'");
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
		List<BaseSchoolModel> models = BaseSchoolModel.dao.find("select * from "+DB_TABLE+" where id = "+id+" and  del != 'delete'");
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
		UploadFile f = getFile("school_logo");
		
		JSONObject js = new JSONObject();
		try{
			List<BaseSchoolModel> preList = BaseSchoolModel.dao.find("select * from "+DB_TABLE + " where school_name = '"+getPara("school_name")+"'");
			if(CheckUtils.checkArrayIsNotNull(preList)){
				js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
				js.put(Const.KEY_RES_MESSAGE, "存在相同名称");
				renderJson(JsonKit.toJson(js));
			}else{
				BaseSchoolModel model = getModel(BaseSchoolModel.class, "", true);
				model.set(Const.KEY_DB_CREATE_TIME, System.currentTimeMillis()/1000+"");
				model.set(Const.KEY_DB_DEL, Const.OPTION_DB_NORMAL);
				model.set("school_logo", "upload/"+f.getFileName());
				System.out.println("model:"+model);
				model.save();
				js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
				renderJson(JsonKit.toJson(js));
			}
		}catch(Exception e){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(JsonKit.toJson(js));
		}
	}
	
	@CrossOrigin
	public void update(){
		UploadFile f = getFile("school_logo");
		//System.out.println("upload/"+f.getFileName());
		System.out.println(getPara("id"));
		JSONObject js = new JSONObject();
		try{
			BaseSchoolModel model = getModel(BaseSchoolModel.class, "", true);
			if(f !=null){
				model.set("school_logo", "upload/"+f.getFileName());
			}
			model.set("id", getPara("id"));
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
			BaseSchoolModel model = getModel(BaseSchoolModel.class, "", true);
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
			List commentList = DatabaseUtil.getTableInfo(DB_TABLE,DatabaseUtil.TableInfoEnum._ColumnComments);
			List filterList = new ArrayList();
			for(int i=0;i<nameList.size();i++){
				String filterTypeName = tableFilter.get(nameList.get(i));
				if(filterTypeName == null || filterTypeName == ""){
					filterList.add(FilterType.normal);
				}else{
					filterList.add(filterTypeName);
				}	
			}
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put("column_name", nameList);
			js.put("column_filter", filterList);
			js.put("column_comment", commentList);
			renderJson(JsonKit.toJson(js));
		}catch(Exception e){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(JsonKit.toJson(js));
		}
	}
	
	@CrossOrigin
	public void search(){
		String map = "school_name";
		String key = getPara("key");
		System.out.println(key);
		List<BaseSchoolModel> models = BaseSchoolModel.dao.find("select * from "+DB_TABLE+" where "+map+" like '%"+key+"%' and del != 'delete'");
		JSONObject js = new JSONObject();
		if(models!=null && models.size()>=1){
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
}
