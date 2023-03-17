package com.SIMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet set;

    //  通用的增、删、改                                     可变参数
    public int updateDate(Connection conn,String sql,Object... objs) throws SQLException {
        // 连接数据库步骤
        this.conn=conn;
        //得到执行平台
        ps=conn.prepareStatement(sql);
        //3-1:给问号赋值
        for(int i = 0;i<objs.length;i++) {
            ps.setObject(i+1, objs[i]);
        }

        return ps.executeUpdate();
    }

    //通用的一次修改多条数据的方法
    public int[] updateDateMore(Connection conn,String sql,Object[][] objs) throws SQLException {
        this.conn=conn;
        //得到执行平台
        ps=conn.prepareStatement(sql);
        //3-1:给问号赋值
        for(int i = 0;i<objs.length;i++) {
            for(int j = 0;j<objs[i].length;j++) {
                ps.setObject(j+1, objs[i][j]);
            }
            ps.addBatch();
        }
        //4：执行sql语句
        return ps.executeBatch();
    }

    //  通用的查询                                         可变参数
    public ResultSet selectDate(Connection conn,String sql,Object... objs) throws SQLException {
        this.conn=conn;
        ps=conn.prepareStatement(sql);
        for(int i = 0;i<objs.length;i++) {
            ps.setObject(i+1, objs[i]);
        }
        set = ps.executeQuery();
        return set;
    }

    //通用的关闭资源的方法
    public void closeALL() {
        try {
            if(set != null) {
                set.close();
            }
            if(ps != null) {
                ps.close();
            }
            if(conn != null) {
                conn.close();
            }
//				System.out.println("所有资源关闭成功");
        }	catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
