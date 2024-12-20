package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.TimetableBean;
import in.co.rays.model.TimetableModel;

public class TestTimetableModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testDelete();
//		testUpdate();
		testSearch();
//		testfindByPK();

	}

	private static void testfindByPK() throws Exception {

		TimetableModel model = new TimetableModel();

		TimetableBean bean = model.findByPK(1);

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("user not found");
		}

	}

	private static void testSearch() throws Exception {

		TimetableBean bean = new TimetableBean();
		TimetableModel model = new TimetableModel();

		bean.setSemester("Semester 2");

		List list = model.search(bean, 0, 0);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (TimetableBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}

	private static void testUpdate() throws Exception {

		TimetableBean bean = new TimetableBean();

		bean.setId(1);
		bean.setSemester("test");
		bean.setDescription("3rd");
		bean.setExamDate(new Date());
		bean.setExamTime("10:00AM - 12:00PM");
		bean.setCourseId(1);
		bean.setSubjectId(1);

		TimetableModel model = new TimetableModel();

		model.update(bean);

	}

	private static void testDelete() throws Exception {

		TimetableModel model = new TimetableModel();

		model.Delete(1);

	}

	private static void testAdd() throws Exception {

		TimetableBean bean = new TimetableBean();

//		bean.setId(1);
		bean.setSemester("practicle");
		bean.setDescription("3rd");
		bean.setExamDate(new Date());
		bean.setExamTime("11:00AM - 12:00PM");
		bean.setCourseId(2);
		bean.setSubjectId(2);
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		TimetableModel model = new TimetableModel();
		model.add(bean);

	}
}