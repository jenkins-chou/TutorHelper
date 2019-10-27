package com.demo.common;

import java.util.HashMap;







import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.jfinal3.JFinal3BeetlRenderFactory;

import com.demo.controller.IndexController;
import com.demo.controller.MenuController;
import com.demo.controller.SchoolController;
import com.demo.controller.UploadController;
import com.demo.controller.UserController;
import com.demo.controller.UserTypeController;
import com.demo.models.MenuModel;
import com.demo.models.SchoolModel;
import com.demo.models.UserModel;
import com.demo.models.UserTypeModel;
import com.demo.utils.CrossInterceptor;
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
	
	public void configConstant(Constants me) {
		PropKit.use("db_config.txt");
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
		me.add("/user", UserController.class);
		me.add("/user_type", UserTypeController.class);
		me.add("/menu", MenuController.class);
		me.add("/school", SchoolController.class);
	}
	 
	public void configPlugin(Plugins me) {
		System.out.println(PropKit.get("jdbcUrl"));
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		me.add(c3p0Plugin);
		
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
	
		arp.addMapping("base_user", UserModel.class);
		arp.addMapping("base_user_type", UserTypeModel.class);
		arp.addMapping("base_menu", MenuModel.class);
		arp.addMapping("base_school", SchoolModel.class);
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
