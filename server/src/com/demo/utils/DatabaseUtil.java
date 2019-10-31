package com.demo.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.kit.PropKit;

import cn.jiguang.common.utils.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DatabaseUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseUtil.class);

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = PropKit.get("jdbcUrl");//"jdbc:mysql://localhost:3306/tutor_helper?useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME = PropKit.get("user");
    private static final String PASSWORD = PropKit.get("password");
    
    private static Map<String,List<String>> tableMap = new HashMap();

    private static final String SQL = "SELECT * FROM ";// ���ݿ����

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver", e);
        }
    }

    /**
     * ��ȡ���ݿ�����
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("get connection failure", e);
        }
        return conn;
    }

    /**
     * �ر����ݿ�����
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure", e);
            }
        }
    }

    /**
     * ��ȡ���ݿ��µ����б���
     */
    public static List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            //��ȡ���ݿ��Ԫ����
            DatabaseMetaData db = conn.getMetaData();
            //��Ԫ�����л�ȡ�����еı���
            rs = db.getTables(null, null, null, new String[] { "TABLE" });
            while(rs.next()) {
                tableNames.add(rs.getString(3));
            }
        } catch (SQLException e) {
            LOGGER.error("getTableNames failure", e);
        } finally {
            try {
                rs.close();
                closeConnection(conn);
            } catch (SQLException e) {
                LOGGER.error("close ResultSet failure", e);
            }
        }
        return tableNames;
    }

    /**
     * ��ȡ���������ֶ�����
     * @param tableName ����
     * @return
     */
    public static List<String> getColumnNames(String tableName) {
        List<String> columnNames = new ArrayList<>();
        //�����ݿ������
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //�����Ԫ����
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //������
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnNames.add(rsmd.getColumnName(i + 1));
            }
        } catch (SQLException e) {
            LOGGER.error("getColumnNames failure", e);
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnNames close pstem and connection failure", e);
                }
            }
        }
        return columnNames;
    }

    /**
     * ��ȡ���������ֶ�����
     * @param tableName
     * @return
     */
    public static List<String> getColumnTypes(String tableName) {
        List<String> columnTypes = new ArrayList<>();
        //�����ݿ������
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //�����Ԫ����
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //������
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnTypes.add(rsmd.getColumnTypeName(i + 1));
            }
        } catch (SQLException e) {
            LOGGER.error("getColumnTypes failure", e);
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnTypes close pstem and connection failure", e);
                }
            }
        }
        return columnTypes;
    }

    /**
     * ��ȡ�����ֶε�����ע��
     * @param tableName
     * @return
     */
    public static List<String> getColumnComments(String tableName) {
        List<String> columnTypes = new ArrayList<>();
        //�����ݿ������
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        List<String> columnComments = new ArrayList<>();//����ע�ͼ���
        ResultSet rs = null;
        try {
            pStemt = conn.prepareStatement(tableSql);
            rs = pStemt.executeQuery("show full columns from " + tableName);
            while (rs.next()) {
                columnComments.add(rs.getString("Comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnComments close ResultSet and connection failure", e);
                }
            }
        }
        return columnComments;
    }
    public static void init() {
        List<String> tableNames = getTableNames();
        //System.out.println("tableNames:" + tableNames);
        for (String tableName : tableNames) {
        	if(tableMap == null){
        		tableMap = new HashMap();
        	}
        	tableMap.put(tableName+"_ColumnNames", getColumnNames(tableName));
        	tableMap.put(tableName+"_ColumnTypes", getColumnTypes(tableName));
        	tableMap.put(tableName+"_ColumnComments", getColumnComments(tableName));
        	
        	
//            System.out.println("ColumnNames:" + getColumnNames(tableName));
//            System.out.println("ColumnTypes:" + getColumnTypes(tableName));
//            System.out.println("ColumnComments:" + getColumnComments(tableName));
        }
        
        System.out.println("--------------���ݿ���Ϣ��ʼ�����");
    }
    
    public static List getTableInfo(String tableName,TableInfoEnum e){
//    	System.out.println("getTableInfo tableName: "+tableName);
//    	System.out.println("getTableInfo TableInfoEnum: "+e);
    	if(StringUtils.isEmpty(tableName) || e == null){
    		return new ArrayList<>();
    	}
    	if(tableMap == null){
    		init();
    	}
    	List list = tableMap.get(tableName+e);
    	return list;
    }
    
    public enum TableInfoEnum {
    	_ColumnNames,
    	_ColumnTypes,
    	_ColumnComments
    }

}




