package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CourseBean;
import in.co.rays.model.CourseModel;

public class TestCourseModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
//		testfindByPk();
//		testfindByName();
	}

	private static void testfindByName() throws Exception {

		String name = "English";

		CourseModel model = new CourseModel();

		CourseBean bean = model.findByName(name);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDuration());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

		} else {
			System.out.println("user not found");
		}

	}

	private static void testfindByPk() throws Exception {

		int id = 1;

		CourseModel model = new CourseModel();

		CourseBean bean = model.findByPk(id);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDuration());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

		} else {
			System.out.println("user not found");
		}
	}

	private static void testSearch() throws Exception {

		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		bean.setName("Bachelor of Technology");

		List list = model.search(bean, 0, 0);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (CourseBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}

	private static void testDelete() throws Exception {

		CourseModel model = new CourseModel();

		model.delete(1);

	}

	private static void testUpdate() throws Exception {

		CourseBean bean = new CourseBean();

		bean.setId(1);
		bean.setName("Hindi");
		bean.setDuration("Seven Month");
		bean.setDescription("Extra");
		bean.setCreatedBy("Mohit");
		bean.setModifiedBy("Mohit");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		model.update(bean);
	}

	private static void testAdd() throws Exception {

		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

//		bean.setId(2);
		bean.setName("Science");
		bean.setDuration("Six Month");
		bean.setDescription("Extra");
		bean.setCreatedBy("Mohit");
		bean.setModifiedBy("Mohit");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

}
