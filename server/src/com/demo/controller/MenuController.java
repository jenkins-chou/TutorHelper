package com.demo.controller;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.alibaba.fastjson.JSONObject;
import com.demo.models.MenuModel;
import com.demo.models.UserModel;
import com.demo.utils.Const;
import com.demo.utils.CrossOrigin;
import com.jfinal.kit.JsonKit;


public class MenuController extends DefaultController<MenuModel> {
	public static final String DB_TABLE = "base_menu";
	public static final String HTML_KEY = "user";
	
	@Override
	public void setData() {
		modelClass =MenuModel.class;
		tableName = DB_TABLE;
		htmlKey = HTML_KEY;
		entityDao = MenuModel.dao;
	}
	
	/**
	 * 获取模块名称
	 */
	@CrossOrigin
	public void getModuleList(){
		setData();
		String user_type = getPara("user_type");
		List<MenuModel> menuModels = entityDao.find("select * from "+DB_TABLE+" where user_type = '"+user_type+"' and menu_level = 1 and del != 'delete'");
		JSONObject js = new JSONObject();
		if(menuModels!=null&&menuModels.size()>=1){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put(Const.KEY_RES_DATA, menuModels);
			System.out.println(JsonKit.toJson(js));
			renderJson(JsonKit.toJson(js));
		}else{
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(js.toJSONString());
		}
	}
	
	/**
	 * 获取子菜单名称
	 */
	@CrossOrigin
	public void getMenuList(){
		setData();
		String user_type = getPara("user_type");
		String module_id = getPara("module_id");
		List<MenuModel> menuModels = entityDao.find("select * from "+DB_TABLE+" where user_type = '"+user_type+"' and menu_parent = '"+module_id+"' and menu_level = 2 and del != 'delete'");
		JSONObject js = new JSONObject();
		if(menuModels!=null&&menuModels.size()>=1){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put(Const.KEY_RES_DATA, menuModels);
			System.out.println(JsonKit.toJson(js));
			renderJson(JsonKit.toJson(js));
		}else{
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(js.toJSONString());
		}
	}
	
	@CrossOrigin
	public void addMenu(){
		setData();
		JSONObject js = new JSONObject();
		try{
			MenuModel model = getModel(modelClass, "", true);
			System.out.println(model.toJson());
			model.set(Const.KEY_DB_DEL, Const.OPTION_DB_NORMAL);
			model.save();
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			System.out.println("---->"+JsonKit.toJson(js));
			renderJson(JsonKit.toJson(js));
			
		}catch(Exception e){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(JsonKit.toJson(js));
		}
	}
	@CrossOrigin
	public void deleteMenu(){
		setData();
		JSONObject js = new JSONObject();
		try{
			MenuModel model = getModel(modelClass, "", true);
			System.out.println(model.toJson());
			model.set(Const.KEY_DB_DEL, Const.OPTION_DB_DELETE);
			model.update();
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			System.out.println("---->"+JsonKit.toJson(js));
			renderJson(JsonKit.toJson(js));
			
		}catch(Exception e){
			e.printStackTrace();
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(JsonKit.toJson(js));
		}
	}

}
