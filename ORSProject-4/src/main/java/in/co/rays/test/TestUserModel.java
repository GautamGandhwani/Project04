package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setFirstName("Gaurav");
		bean.setLastName("Verma");
		bean.setLogin("gv@gmail.com");
		bean.setPassword("123");
		bean.setDob(new Date());
		bean.setMobileNo("5641486542");
		bean.setRoleId(1);
		bean.setGender("Male");
		bean.setCreatedBy("ss@gmail.com");
		bean.setModifiedBy("ss@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	private static void testUpdate() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(1);
		bean.setFirstName("Mohit");
		bean.setLastName("Prajapat");
		bean.setLogin("mp@gmail.com");
		bean.setPassword("456");
		bean.setDob(new Date());
		bean.setMobileNo("212183222");
		bean.setRoleId(1);
		bean.setGender("male");
		bean.setCreatedBy("ss@gmail.com");
		bean.setModifiedBy("ss@gmail.comm");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);
	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(1);
	}

	private static void testSearch() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();

			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getLogin());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.out.print("\t"+bean.getMobileNo());
			System.out.print("\t"+bean.getRoleId());
			System.out.print("\t"+bean.getGender());
			System.out.print("\t"+bean.getCreatedBy());
			System.out.print("\t"+bean.getModifiedBy());
			System.out.print("\t"+bean.getCreatedDatetime());
			System.out.println("\t"+bean.getModifiedDatetime());	
		}
	}
}
