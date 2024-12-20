package in.co.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;

public class TestCollegeModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		tsetUpdate();
//		testDelete();
		testSearch();
	}

	private static void testAdd() throws Exception {

		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		bean.setId(1);
		bean.setName("VIIT");
		bean.setAddress("barwani");
		bean.setState("mp");
		bean.setCity("barwani");
		bean.setPhoneNo("3246513245");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	private static void tsetUpdate() throws Exception {

		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		bean.setId(1);
		bean.setName("VIIT");
		bean.setAddress("Barwani");
		bean.setState("MP");
		bean.setCity("Barwani");
		bean.setPhoneNo("584515465121");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);
	}

	private static void testDelete() throws Exception {

		CollegeModel model = new CollegeModel();

		model.delete(1);
	}

	private static void testSearch() throws Exception {

		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		bean.setName("Arya College");

		List list = model.search(bean, 0, 0);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (CollegeBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

}
