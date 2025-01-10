package in.co.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.PrescriptionBean;
import in.co.rays.util.JDBCDataSource;

public class PrescriptionModel {
	public Integer nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_prescription");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	public void add(PrescriptionBean bean) throws Exception {

		int pk = nextPk();

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_prescription values(?,?,?,?,?)");

		pstmt.setLong(1, pk);
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getDecease());
		pstmt.setDate(4, new Date(bean.getDate().getTime()));
		pstmt.setLong(5, bean.getCapacity());


		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("Data inserted ->" + i);
	}

	public void update(PrescriptionBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn
				.prepareStatement("update st_prescription set name = ?, decease = ?, date = ?,capacity=? where id = ?");

		pstmt.setLong(5, bean.getId());
		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getDecease());
		pstmt.setDate(3, new Date(bean.getDate().getTime()));
		pstmt.setLong(4, bean.getCapacity());
		
		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data updated => " + i);

	}

	public void delete(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_prescription where id = ?");

		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("Data Deteled -> " + i);
	}

	public List list() throws Exception {
		return search(null, 0, 0);
	}

	public List search(PrescriptionBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_prescription where 1=1");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "'");
			}

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		System.out.println("SQl = " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new PrescriptionBean();

			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDecease(rs.getString(3));
			bean.setDate(rs.getDate(4));
			bean.setCapacity(rs.getInt(5));

			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;
	}

	public PrescriptionBean findByName(String name) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_prescription where name = ?");

		pstmt.setString(1, name);

		ResultSet rs = pstmt.executeQuery();

		PrescriptionBean bean = null;

		while (rs.next()) {
			bean = new PrescriptionBean();

			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDecease(rs.getString(3));
			bean.setDate(rs.getDate(4));
			bean.setCapacity(rs.getInt(5));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public PrescriptionBean findByPk(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_prescription where id = ?");

		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		PrescriptionBean bean = null;

		while (rs.next()) {
			bean = new PrescriptionBean();

			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDecease(rs.getString(3));
			bean.setDate(rs.getDate(4));
			bean.setCapacity(rs.getInt(5));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}
}
