package in.co.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.StudentBean;
import in.co.rays.util.JDBCDataSource;

public class StudentModel {

	public int nextPK() throws Exception {

		int PK = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_student");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			PK = rs.getInt(1);

		}
		JDBCDataSource.closeConnection(conn);
		return PK + 1;
	}

	public void add(StudentBean bean) throws Exception {

		CollegeModel model = new CollegeModel();

		CollegeBean collegebean = model.findByPk(bean.getCollegeId());

		bean.setCollegeName(collegebean.getName());

		StudentBean existbean = findByEmail(bean.getEmail());

		if (existbean != null) {

			throw new Exception("Email Allready Exist");
		}

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_student values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

		pstmt.setLong(1, nextPK());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setDate(4, new Date(bean.getDob().getTime()));
		pstmt.setString(5, bean.getGender());
		pstmt.setString(6, bean.getMobileNo());
		pstmt.setString(7, bean.getEmail());
		pstmt.setLong(8, bean.getCollegeId());
		pstmt.setString(9, bean.getCollegeName());
		pstmt.setString(10, bean.getCreatedBy());
		pstmt.setString(11, bean.getModifiedBy());
		pstmt.setTimestamp(12, bean.getCreatedDatetime());
		pstmt.setTimestamp(13, bean.getModifiedDatetime());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("Data Add=" + i);

	}

	public void update(StudentBean bean) throws Exception {

		CollegeModel model = new CollegeModel();

		CollegeBean collegebean = model.findByPk(bean.getCollegeId());

		bean.setCollegeName(collegebean.getName());

		StudentBean existbean = findByEmail(bean.getEmail());

		if (existbean != null && bean.getId() != existbean.getId()) {

			throw new Exception("User Not Allow to Access");
		}

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_student set first_name = ?, last_name = ?, dob = ?, gender = ?, mobile_no = ?, email = ?, college_id = ?, college_name = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ?  where id = ?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setDate(3, new Date(bean.getDob().getTime()));
		pstmt.setString(4, bean.getGender());
		pstmt.setString(5, bean.getMobileNo());
		pstmt.setString(6, bean.getEmail());
		pstmt.setLong(7, bean.getCollegeId());
		pstmt.setString(8, bean.getCollegeName());
		pstmt.setString(9, bean.getCreatedBy());
		pstmt.setString(10, bean.getModifiedBy());
		pstmt.setTimestamp(11, bean.getCreatedDatetime());
		pstmt.setTimestamp(12, bean.getModifiedDatetime());
		pstmt.setLong(13, bean.getId());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("Data Update=" + i);

	}

	public void delete(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_student where id=?");

		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("Data Delete=" + i);
	}

	public List search(StudentBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_student where 1=1");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and first_name like '" + bean.getFirstName() + "'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		System.out.println("SQL = " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollegeId(rs.getLong(8));
			bean.setCollegeName(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));

			list.add(bean);

		}
		JDBCDataSource.closeConnection(conn);
		return list;

	}

	public StudentBean findByPK(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_student where id=?");

		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		StudentBean bean = null;

		while (rs.next()) {
			bean = new StudentBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollegeId(rs.getLong(8));
			bean.setCollegeName(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public StudentBean findByEmail(String email) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_student where Email=?");

		pstmt.setString(1, email);

		ResultSet rs = pstmt.executeQuery();

		StudentBean bean = null;

		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollegeId(rs.getLong(8));
			bean.setCollegeName(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));

		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public List list() throws Exception {
		return search(null, 0, 0);
	}
}
