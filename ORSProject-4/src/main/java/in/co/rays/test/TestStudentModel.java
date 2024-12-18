package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.StudentBean;
import in.co.rays.model.StudentModel;

public class TestStudentModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
		testDelete();
		testSearch();
//		testfindByPK();
//		testfindByEmail();
	}

	private static void testfindByEmail() throws Exception {
		
		String email="pm@gmail.com";

		StudentModel model=new StudentModel();
		
		StudentBean bean=model.findByEmail(email);
		
		if (bean != null) {
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
			
		}else {
			System.out.println("user Allready Exist");
		}	
	}

	private static void testfindByPK() throws Exception {

		long id=1;
		
		StudentModel model=new StudentModel();
		
		StudentBean bean=model.findByPK(id);
		
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("id not found");
		}
	}

	private static void testSearch() throws Exception {

		StudentBean bean=new StudentBean();
		
		StudentModel model=new StudentModel();
		
		List list=model.search(bean);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			bean=(StudentBean) it.next();
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}	
	}

	private static void testDelete() throws Exception {

		StudentModel model = new StudentModel();

		model.delete(1);
	}

	private static void testUpdate() throws Exception {

		StudentBean bean = new StudentBean();

		bean.setId(1);
		bean.setFirstName("Mohit");
		bean.setLastName("Prajapati");
		bean.setDob(new Date());
		bean.setGender("Male");
		bean.setMobileNo("9876543210");
		bean.setEmail("pm@gmail.com");
		bean.setCollegeId(1);
		bean.setCreatedBy("Mohit");
		bean.setModifiedBy("Mohit");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		StudentBean bean = new StudentBean();

//		bean.setId(1);
		bean.setFirstName("Rohit");
		bean.setLastName("Prajapat");
		bean.setDob(new Date());
		bean.setGender("Male");
		bean.setMobileNo("9876543221");
		bean.setEmail("mp@gmail.com");
		bean.setCollegeId(1);
		bean.setCreatedBy("Rohit");
		bean.setModifiedBy("Rohit");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();

		model.add(bean);
	}	
}
