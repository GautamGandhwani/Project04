package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
//		testFindByPK();
//		testFindByRollNo();
	}

	private static void testFindByRollNo() throws Exception {

		String rollno = "BE101";

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findByRollNo(rollno);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getStudentId());
			System.out.println(bean.getName());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

		} else {
			System.out.println("user not found");
		}
	}

	private static void testFindByPK() throws Exception {

		long id = 1;

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findByPK(id);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getStudentId());
			System.out.println(bean.getName());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

		} else {
			System.out.println("id not found");
		}
	}

	private static void testSearch() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = new MarksheetBean();

		bean.setRollNo("ROLL011");

		List list = model.search(bean, 0, 0);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.delete(1);
	}

	private static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(1);
		bean.setRollNo("BE101");
		bean.setStudentId(1);
		bean.setChemistry(50);
		bean.setPhysics(50);
		bean.setMaths(50);
		bean.setCreatedBy("omni");
		bean.setModifiedBy("omni");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		MarksheetModel model = new MarksheetModel();

		model.update(bean);
	}

	private static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

//		bean.setId(1);
		bean.setRollNo("BE102");
		bean.setStudentId(1);
		bean.setChemistry(60);
		bean.setPhysics(60);
		bean.setMaths(60);
		bean.setCreatedBy("om");
		bean.setModifiedBy("om");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		MarksheetModel model = new MarksheetModel();

		model.add(bean);
	}
}
