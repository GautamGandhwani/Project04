package in.co.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.ItemInformationBean;
import in.co.rays.util.JDBCDataSource;

public class ItemInformationModel {
	public Integer nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_item");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	public void add(ItemInformationBean bean) throws Exception {

		int pk = nextPk();

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_item values(?,?,?,?,?,?)");

		pstmt.setLong(1, pk);
		pstmt.setString(2, bean.getTitle());
		pstmt.setString(3, bean.getOverview());
		pstmt.setLong(4, bean.getCost());
		pstmt.setDate(5, new Date(bean.getPurchaseDate().getTime()));
		pstmt.setString(6, bean.getCategory());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("Data inserted ->" + i);
	}

	public void update(ItemInformationBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_item set title = ?, overview = ?, cost = ?, purchase_date = ?, category = ? where id = ?");

		pstmt.setLong(6, bean.getId());
		pstmt.setString(1, bean.getTitle());
		pstmt.setString(2, bean.getOverview());
		pstmt.setLong(3, bean.getCost());
		pstmt.setDate(4, new Date(bean.getPurchaseDate().getTime()));
		pstmt.setString(5, bean.getCategory());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data updated => " + i);

	}

	public void delete(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_item where id = ?");

		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("Data Deteled -> " + i);
	}

	public List list() throws Exception {
		return search(null, 0, 0);
	}

	public List search(ItemInformationBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_item where 1=1");

		if (bean != null) {

			if (bean.getTitle() != null && bean.getTitle().length() > 0) {
				sql.append(" and title like '" + bean.getTitle() + "'");
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

			bean = new ItemInformationBean();

			bean.setId(rs.getLong(1));
			bean.setTitle(rs.getString(2));
			bean.setOverview(rs.getString(3));
			bean.setCost(rs.getLong(4));
			bean.setPurchaseDate(rs.getDate(5));
			bean.setCategory(rs.getString(6));

			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;
	}

	public ItemInformationBean findByName(String name) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_item where title = ?");

		pstmt.setString(1, name);

		ResultSet rs = pstmt.executeQuery();

		ItemInformationBean bean = null;

		while (rs.next()) {
			bean = new ItemInformationBean();

			bean.setId(rs.getLong(1));
			bean.setTitle(rs.getString(2));
			bean.setOverview(rs.getString(3));
			bean.setCost(rs.getLong(4));
			bean.setPurchaseDate(rs.getDate(5));
			bean.setCategory(rs.getString(6));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public ItemInformationBean findByPk(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_item where id = ?");

		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		ItemInformationBean bean = null;

		while (rs.next()) {
			bean = new ItemInformationBean();

			bean.setId(rs.getLong(1));
			bean.setTitle(rs.getString(2));
			bean.setOverview(rs.getString(3));
			bean.setCost(rs.getLong(4));
			bean.setPurchaseDate(rs.getDate(5));
			bean.setCategory(rs.getString(6));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}
}