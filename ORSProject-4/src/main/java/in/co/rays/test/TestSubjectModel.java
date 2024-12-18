package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.SubjectBean;
import in.co.rays.model.SubjectModel;

public class TestSubjectModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
		testDelete();
		testSearch();
//		testFindByPK();
//		testFindByName();
	}

	private static void testFindByName() throws Exception {

		String name = "Electrical";

		SubjectModel model = new SubjectModel();

		SubjectBean bean = model.findByName(name);

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("user not found");
		}

	}

	private static void testFindByPK() throws Exception {

		long id = 2;

		SubjectModel model = new SubjectModel();

		SubjectBean bean = model.findByPK(id);

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("user not found");
		}

	}

	private static void testSearch() throws Exception {

		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (SubjectBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}

	private static void testDelete() throws Exception {

		SubjectModel model = new SubjectModel();

		model.delete(1);

	}

	private static void testUpdate() throws Exception {
		SubjectBean bean = new SubjectBean();

		bean.setId(2);
		bean.setName("Electrical");
		bean.setCourseId(1);
		bean.setDescription("Electrically");
		mailto: bean.setCreatedBy("admin@gmail.com");
		mailto: bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		SubjectBean bean = new SubjectBean();

		bean.setId(2);
		bean.setName("Electrical");
		bean.setCourseId(1);
		bean.setDescription("Electrical");
		mailto: bean.setCreatedBy("admin@gmail.com");
		mailto: bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();

		model.add(bean);

	}

}
