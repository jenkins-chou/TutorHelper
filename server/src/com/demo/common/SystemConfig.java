package com.demo.common;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.jfinal3.JFinal3BeetlRenderFactory;

import com.demo.controller.AttendanceController;
import com.demo.controller.AttendanceRecordController;
import com.demo.controller.BaseCertController;
import com.demo.controller.BaseClassController;
import com.demo.controller.BaseCollegeController;
import com.demo.controller.BaseCommodityController;
import com.demo.controller.BaseCourseController;
import com.demo.controller.BaseEnterpriseController;
import com.demo.controller.BaseEnterpriseTypeController;
import com.demo.controller.BaseMenuController;
import com.demo.controller.BaseMessageController;
import com.demo.controller.BaseModuleController;
import com.demo.controller.BaseSchoolController;
import com.demo.controller.BaseScoreController;
import com.demo.controller.BaseStateController;
import com.demo.controller.BaseUserController;
import com.demo.controller.BaseUserTypeController;
import com.demo.controller.EarlyReadingController;
import com.demo.controller.IndexController;
import com.demo.controller.PostgraduateExamController;
import com.demo.controller.PostgraduateExamEnrollController;
import com.demo.controller.PsyTestAnswerConsultController;
import com.demo.controller.PsyTestAnswerController;
import com.demo.controller.PsyTestAnswerRecordController;
import com.demo.controller.PsyTestItemController;
import com.demo.controller.PsyTestItemTypeController;
import com.demo.controller.PsyTestSubjectController;
import com.demo.controller.ScholarshipApplyRecordController;
import com.demo.controller.ScholarshipController;
import com.demo.controller.ScholarshipDistributionController;
import com.demo.controller.ScientSubjectController;
import com.demo.controller.UploadController;
import com.demo.models.AttendanceModel;
import com.demo.models.AttendanceRecordModel;
import com.demo.models.BaseCertModel;
import com.demo.models.BaseClassModel;
import com.demo.models.BaseCollegeModel;
import com.demo.models.BaseCommodityModel;
import com.demo.models.BaseCourseModel;
import com.demo.models.BaseEnterpriseModel;
import com.demo.models.BaseEnterpriseTypeModel;
import com.demo.models.BaseMenuModel;
import com.demo.models.BaseMessageModel;
import com.demo.models.BaseModuleModel;
import com.demo.models.BaseSchoolModel;
import com.demo.models.BaseScoreModel;
import com.demo.models.BaseStateModel;
import com.demo.models.BaseUserModel;
import com.demo.models.BaseUserTypeModel;
import com.demo.models.EarlyReadingModel;
import com.demo.models.PostgraduateExamEnrollModel;
import com.demo.models.PostgraduateExamModel;
import com.demo.models.PsyTestAnswerConsultModel;
import com.demo.models.PsyTestAnswerModel;
import com.demo.models.PsyTestAnswerRecordModel;
import com.demo.models.PsyTestItemModel;
import com.demo.models.PsyTestItemTypeModel;
import com.demo.models.PsyTestSubjectModel;
import com.demo.models.ScholarshipApplyRecordModel;
import com.demo.models.ScholarshipDistributionModel;
import com.demo.models.ScholarshipModel;
import com.demo.models.ScientSubjectModel;
import com.demo.utils.CrossInterceptor;
import com.demo.utils.DatabaseUtil;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class SystemConfig extends JFinalConfig {
	
	public static final int port = 8888;
	
	
	
	public static void main(String[] args) {
		//PathKit.setWebRootPath("/WebRoot");
		
		JFinal.start("WebRoot", port, "/", 5);
		
	}
	
	public void init(){
		PropKit.use("db_config.txt");
		DatabaseUtil.init();
//		
//		List list = DatabaseUtil.getTableInfo("base_user",DatabaseUtil.TableInfoEnum._ColumnComments);
//		if(list != null){
//			System.out.println(list);
//		}
	}
	
	public void configConstant(Constants me) {
		
		init();
		
		//PropKit.use("db_config.txt");
		me.setDevMode(PropKit.getBoolean("devMode", true));//热更新调试模式
		me.setViewType(ViewType.JSP); 	
		
		JFinal3BeetlRenderFactory rf = new JFinal3BeetlRenderFactory();
		rf.config();
		me.setRenderFactory(rf);
		GroupTemplate gt = rf.groupTemplate;
		Map<String, Object> shard = new HashMap<String, Object>();// 鍏变韩鍙橀噺
		shard.put("ctx", JFinal.me().getContextPath());// 娣诲姞鍏变韩鍙橀噺涓婁笅鏂囪矾锟�?
		gt.setSharedVars(shard);// 璁剧疆鍏变韩鍙橀噺
		me.setMaxPostSize(1200000000);
		
		//me.setBaseUploadPath("/upload"); 
	}
	
	public void configRoute(Routes me) {
		me.add("/", IndexController.class);	
		me.add("/upload", UploadController.class);
		
		
		me.add("attendance",AttendanceController.class);
		me.add("attendance_record",AttendanceRecordController.class);
		me.add("base_cert",BaseCertController.class);
		me.add("base_class",BaseClassController.class);
		me.add("base_college",BaseCollegeController.class);
		me.add("base_commodity",BaseCommodityController.class);
		me.add("base_course",BaseCourseController.class);
		me.add("base_enterprise",BaseEnterpriseController.class);
		me.add("base_enterprise_type",BaseEnterpriseTypeController.class);
		me.add("base_menu",BaseMenuController.class);
		me.add("base_message",BaseMessageController.class);
		me.add("base_module",BaseModuleController.class);
		me.add("base_school",BaseSchoolController.class);
		me.add("base_score",BaseScoreController.class);
		me.add("base_state",BaseStateController.class);
		me.add("base_user",BaseUserController.class);
		me.add("base_user_type",BaseUserTypeController.class);
		me.add("early_reading",EarlyReadingController.class);
		me.add("postgraduate_exam",PostgraduateExamController.class);
		me.add("postgraduate_exam_enroll",PostgraduateExamEnrollController.class);
		me.add("psy_test_answer",PsyTestAnswerController.class);
		me.add("psy_test_answer_consult",PsyTestAnswerConsultController.class);
		me.add("psy_test_answer_record",PsyTestAnswerRecordController.class);
		me.add("psy_test_item",PsyTestItemController.class);
		me.add("psy_test_item_type",PsyTestItemTypeController.class);
		me.add("psy_test_subject",PsyTestSubjectController.class);
		me.add("scholarship",ScholarshipController.class);
		me.add("scholarship_apply_record",ScholarshipApplyRecordController.class);
		me.add("scholarship_distribution",ScholarshipDistributionController.class);
		me.add("scient_subject",ScientSubjectController.class);
	}
	 
	public void configPlugin(Plugins me) {
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		me.add(c3p0Plugin);
		
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
	
//		arp.addMapping("base_user_type", UserTypeModel.class);
//		arp.addMapping("base_menu", MenuModel.class);
//		
//		
		arp.addMapping("attendance", AttendanceModel.class);
		arp.addMapping("attendance_record", AttendanceRecordModel.class);
		arp.addMapping("base_cert", BaseCertModel.class);
		arp.addMapping("base_class", BaseClassModel.class);
		arp.addMapping("base_college", BaseCollegeModel.class);
		arp.addMapping("base_commodity", BaseCommodityModel.class);
		arp.addMapping("base_course", BaseCourseModel.class);
		arp.addMapping("base_enterprise", BaseEnterpriseModel.class);
		arp.addMapping("base_enterprise_type", BaseEnterpriseTypeModel.class);
		arp.addMapping("base_menu", BaseMenuModel.class);
		arp.addMapping("base_message", BaseMessageModel.class);
		arp.addMapping("base_module", BaseModuleModel.class);
		arp.addMapping("base_school", BaseSchoolModel.class);
		arp.addMapping("base_score", BaseScoreModel.class);
		arp.addMapping("base_state", BaseStateModel.class);
		arp.addMapping("base_user", BaseUserModel.class);
		arp.addMapping("base_user_type", BaseUserTypeModel.class);
		arp.addMapping("early_reading", EarlyReadingModel.class);
		arp.addMapping("postgraduate_exam", PostgraduateExamModel.class);
		arp.addMapping("postgraduate_exam_enroll", PostgraduateExamEnrollModel.class);
		arp.addMapping("psy_test_answer", PsyTestAnswerModel.class);
		arp.addMapping("psy_test_answer_consult", PsyTestAnswerConsultModel.class);
		arp.addMapping("psy_test_answer_record", PsyTestAnswerRecordModel.class);
		arp.addMapping("psy_test_item", PsyTestItemModel.class);
		arp.addMapping("psy_test_item_type", PsyTestItemTypeModel.class);
		arp.addMapping("psy_test_subject", PsyTestSubjectModel.class);
		arp.addMapping("scholarship", ScholarshipModel.class);
		arp.addMapping("scholarship_apply_record", ScholarshipApplyRecordModel.class);
		arp.addMapping("scholarship_distribution", ScholarshipDistributionModel.class);
		arp.addMapping("scient_subject", ScientSubjectModel.class);
	}
	
	public void configInterceptor(Interceptors me) {
		me.add(new CrossInterceptor());
	}
	
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("ctx"));
	}
	
	

	@Override
	public void configEngine(Engine arg0) {
		// TODO Auto-generated method stub
	}
}
