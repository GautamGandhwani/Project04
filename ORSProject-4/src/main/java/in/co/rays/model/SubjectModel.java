package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.CourseBean;
import in.co.rays.bean.SubjectBean;
import in.co.rays.util.JDBCDataSource;

public class SubjectModel {

public int  nextPK() throws Exception {
		
		int PK=0;
		
		Connection conn =JDBCDataSource.getConnection();
		
		PreparedStatement pstmt=conn.prepareStatement("select max(id) from st_subject");
		
		ResultSet rs=pstmt.executeQuery();
		
		while (rs.next()) {
			
			PK=rs.getInt(1);
			
		}
		JDBCDataSource.closeConnection(conn);
		return PK+1;
	}

	public void add(SubjectBean bean) throws Exception {
		
		SubjectBean existbean=findByName(bean.getName());
		
		if (existbean != null) {
			
			throw new Exception("Name Allready Exist");
		}
		
		CourseModel model=new CourseModel();
		
		CourseBean coursebean=model.findByPk(bean.getId());
		
		bean.setCourseName(coursebean.getName());
		
		Connection conn=JDBCDataSource.getConnection();
		
		PreparedStatement pstmt=conn.prepareStatement("insert into st_subject values(?,?,?,?,?,?,?,?,?)");
	
		pstmt.setLong(1, nextPK());
		pstmt.setString(2, bean.getName());
		pstmt.setLong(3, bean.getCourseId());
		pstmt.setString(4, bean.getCourseName());
		pstmt.setString(5, bean.getDescription());
		pstmt.setString(6, bean.getCreatedBy());
		pstmt.setString(7, bean.getModifiedBy());
		pstmt.setTimestamp(8, bean.getCreatedDatetime());
		pstmt.setTimestamp(9, bean.getModifiedDatetime());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);
		
		System.out.println("Data Add=" + i);
	}
	public void update(SubjectBean bean) throws Exception {
		
		CourseModel model=new CourseModel();
		
		CourseBean coursebean=model.findByPk(bean.getId());
		
		bean.setCourseName(coursebean.getName());
		
		
		SubjectBean existbean=findByName(bean.getName());
		
		if (existbean != null && bean.getId() != existbean.getId()) {
			
			throw new Exception("User Not Allow to access");
		}
		
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_subject set name = ?, course_id = ?, course_name = ?, description = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");

		pstmt.setString(1, bean.getName());
		pstmt.setLong(2, bean.getCourseId());
		pstmt.setString(3, bean.getCourseName());
		pstmt.setString(4, bean.getDescription());
		pstmt.setString(5, bean.getCreatedBy());
		pstmt.setString(6, bean.getModifiedBy());
		pstmt.setTimestamp(7, bean.getCreatedDatetime());
		pstmt.setTimestamp(8, bean.getModifiedDatetime());
		pstmt.setLong(9, bean.getId());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("Data Updated = " + i);
	}
	public void delete(long id) throws Exception {
		
		Connection conn=JDBCDataSource.getConnection();
		
		PreparedStatement pstmt=conn.prepareStatement("delete from st_subject where id=?");
		
		pstmt.setLong(1, id);
		
		int i=pstmt.executeUpdate();
		
		System.out.println("Data Delete=" + i);
	}
	public List search(SubjectBean bean) throws Exception {
		
		Connection conn=JDBCDataSource.getConnection();
		
		PreparedStatement pstmt=conn.prepareStatement("select * from st_subject");
		
		ResultSet rs=pstmt.executeQuery();
		
		List list = new ArrayList();

		while (rs.next()) {
			bean = new SubjectBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setCourseId(rs.getLong(3));
			bean.setCourseName(rs.getString(4));
			bean.setDescription(rs.getString(5));
			bean.setCreatedBy(rs.getString(6));
			bean.setModifiedBy(rs.getString(7));
			bean.setCreatedDatetime(rs.getTimestamp(8));
			bean.setModifiedDatetime(rs.getTimestamp(9));
			
			list.add(bean);
	}
		JDBCDataSource.closeConnection(conn);
		return list;
		
}
	public SubjectBean findByPK(long id) throws Exception {
		
		Connection conn=JDBCDataSource.getConnection();
		
		PreparedStatement pstmt=conn.prepareStatement("select * from st_subject where id=?");
		
		pstmt.setLong(1, id);
		
		ResultSet rs=pstmt.executeQuery();
		
		SubjectBean bean=null;
		
		while (rs.next()) {
			
		 bean=new SubjectBean();
		 
		 	bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setCourseId(rs.getLong(3));
			bean.setCourseName(rs.getString(4));
			bean.setDescription(rs.getString(5));
			bean.setCreatedBy(rs.getString(6));
			bean.setModifiedBy(rs.getString(7));
			bean.setCreatedDatetime(rs.getTimestamp(8));
			bean.setModifiedDatetime(rs.getTimestamp(9));
			
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
		
	}
	public SubjectBean findByName(String name) throws Exception {
		
		Connection conn=JDBCDataSource.getConnection();
		
		PreparedStatement pstmt=conn.prepareStatement("select * from st_subject where name=?");
		
		pstmt.setString(1, name);
		
		ResultSet rs=pstmt.executeQuery();
		
		SubjectBean bean=null;
		
		while (rs.next()) {
			
		 bean=new SubjectBean();
		 
		 	bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setCourseId(rs.getLong(3));
			bean.setCourseName(rs.getString(4));
			bean.setDescription(rs.getString(5));
			bean.setCreatedBy(rs.getString(6));
			bean.setModifiedBy(rs.getString(7));
			bean.setCreatedDatetime(rs.getTimestamp(8));
			bean.setModifiedDatetime(rs.getTimestamp(9));
	}
		JDBCDataSource.closeConnection(conn);
		return null;
}
	
}