package com.demo.controller;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.models.PsyTestAnswerModel;
import com.demo.models.PsyTestAnswerRecordModel;
import com.demo.models.PsyTestItemModel;
import com.demo.models.PsyTestSubjectModel;
import com.demo.utils.Const;
import com.demo.utils.CrossOrigin;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.demo.utils.DatabaseUtil;
import com.demo.utils.Log;

@CrossOrigin
public class PsyTestSubjectController  extends Controller {
	
	public static final String DB_TABLE = "psy_test_subject";
	
	public static final Map<String,String> tableFilter = new HashMap();
	
	static{
		tableFilter.put("id","hidden");
		tableFilter.put("create_time","hidden");
		tableFilter.put("del","hidden");
	}
	
	public enum FilterType{
		hidden,//隐藏字段
		custom,//自定义
		normal//默认
	}
	
	@CrossOrigin
	public void getAll(){
		List<PsyTestSubjectModel> models = PsyTestSubjectModel.dao.find("select * from "+DB_TABLE+" where del != 'delete'");
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
		List<PsyTestSubjectModel> models = PsyTestSubjectModel.dao.find("select * from "+DB_TABLE+" where id = "+id+" and  del != 'delete'");
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
	public void getSubjectDetail(){
		String id = getPara("id");//测试项目id
		List<PsyTestSubjectModel> models = PsyTestSubjectModel.dao.find("select * from "+DB_TABLE+" where id = "+id+" and  del != 'delete'");
		List<PsyTestItemModel> itemModels = PsyTestItemModel.dao.find("select * from psy_test_item where subject_id = "+id+" and  del != 'delete'");
		List<PsyTestAnswerModel> answerModels = PsyTestAnswerModel.dao.find("select * from psy_test_answer where subject_id = "+id+" and  del != 'delete'");
		
		Log.i("models:"+models.toString());
		Log.i("itemModels:"+itemModels.toString());
		Log.i("answerModels:"+answerModels.toString());
		
		JSONObject js = new JSONObject();
		if(models!=null && 
				models.size()>=1 && 
				itemModels!=null && 
				itemModels.size()>=1 && 
				answerModels!=null && 
				answerModels.size()>=1){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put(Const.KEY_RES_DATA, models.get(0));
			js.put("subject_item", itemModels);
			js.put("item_answer", answerModels);
			System.out.println(JsonKit.toJson(js));
			renderJson(JsonKit.toJson(js));
		}else{
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(js.toJSONString());
		}
	}
	
	@CrossOrigin
	public void addAnswerRecored(){
		JSONObject js = new JSONObject();
		try{
			PsyTestAnswerRecordModel model = getModel(PsyTestAnswerRecordModel.class, "", true);
			model.set(Const.KEY_DB_CREATE_TIME, System.currentTimeMillis()/1000+"");
			model.set(Const.KEY_DB_DEL, Const.OPTION_DB_NORMAL);
			model.set("state", "complete");
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
	public void getUserRecord(){
		String user_id = getPara("user_id");//测试项目id
		List<PsyTestAnswerRecordModel> models = PsyTestAnswerRecordModel.dao.find("select b.*,a.id as record_id from psy_test_answer_record a,psy_test_subject b where a.user_id = "+user_id+" and a.subject_id = b.id and a.del != 'delete' and b.del != 'delete'");
		Log.i("user_id:"+user_id);
		Log.i("models:"+models.toString());
		
		JSONObject js = new JSONObject();
		if(models!=null && 
				models.size()>=1){
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
			js.put(Const.KEY_RES_DATA, models);
			System.out.println(JsonKit.toJson(js));
			renderJson(JsonKit.toJson(js));
		}else{
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(JsonKit.toJson(js));
		}
	}
	
	/**
	 * 计算得分
	 */
	@CrossOrigin
	public void getUserRecordScore(){
		String record_id = getPara("record_id");//回答记录id
		List<PsyTestAnswerRecordModel> models = PsyTestAnswerRecordModel.dao.find("select * from psy_test_answer_record  where id = "+record_id +" and del != 'delete'");
		JSONObject js = new JSONObject();
		
		//Log.i("getUserRecordScore:"+models.toString());
		if(models!=null && 
				models.size()==1){
			
			PsyTestAnswerRecordModel model = models.get(0);
			JSONArray ja = JSONArray.parseArray(model.getStr("answers"));
			//List<String> tempList = new ArrayList<String>();
			
			StringBuilder temps = new StringBuilder("(");
			for(int i = 0;i<ja.size();i++){
				JSONObject tempObj = JSONObject.parseObject(ja.get(i)+"");
				
				temps.append(tempObj.getString("answer_id"));
				if(i<ja.size()-1){
					temps.append(",");
				}
				//Log.i("JSONArray:"+tempObj.getString("answer_id")+"");
			}
			temps.append(")");
			Log.i("StringBuilder:"+temps.toString());
			
			//Log.i("getUserRecordScore:"+model.toJson());
			
			String sql = "select * from psy_test_answer where id in "+temps.toString()+" and del != 'delete'";
			System.out.println("sql:"+sql);
			List<PsyTestAnswerModel> answersModels = PsyTestAnswerModel.dao.find(sql);
			
			if(answersModels!=null && 
					answersModels.size()>=1){
				int finalScore = 0;
				for(int i = 0;i<answersModels.size();i++){
					finalScore += answersModels.get(i).getInt("score");
				}
				js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_200);
				js.put(Const.KEY_RES_DATA, finalScore);
				System.out.println(js);
				renderJson(JsonKit.toJson(js));
				
			}else{
				js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
				renderJson(JsonKit.toJson(js));
			}
			
		}else{
			js.put(Const.KEY_RES_CODE, Const.KEY_RES_CODE_201);
			renderJson(JsonKit.toJson(js));
		}
	}
	
	@CrossOrigin
	public void add(){
		JSONObject js = new JSONObject();
		try{
			PsyTestSubjectModel model = getModel(PsyTestSubjectModel.class, "", true);
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
			PsyTestSubjectModel model = getModel(PsyTestSubjectModel.class, "", true);
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
			PsyTestSubjectModel model = getModel(PsyTestSubjectModel.class, "", true);
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
		String map = "subject_title";
		String key = getPara("key");
		List<PsyTestSubjectModel> models = PsyTestSubjectModel.dao.find("select * from "+DB_TABLE+" where "+map+" like '%"+key+"%' and del != 'delete'");
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
