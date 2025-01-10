package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.PrescriptionBean;
import in.co.rays.model.PrescriptionModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "/PrescriptionCtl", urlPatterns = { "/ctl/PrescriptionCtl" })
public class PrescriptionCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean isValid = true;
		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "name"));
			isValid = false;
		} else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name", "Invalid name");
			isValid = false;
		}

		if (DataValidator.isNull(request.getParameter("decease"))) {
			request.setAttribute("decease", PropertyReader.getValue("error.require", "decease"));
			isValid = false;
		}

		if (DataValidator.isNull(request.getParameter("date"))) {
			request.setAttribute("date", PropertyReader.getValue("error.require", "date"));
			isValid = false;
		} else if (!DataValidator.isDate(request.getParameter("date"))) {
			request.setAttribute("date", PropertyReader.getValue("error.date", "date"));
			isValid = false;
		}

		if (DataValidator.isNull(request.getParameter("capacity"))) {
			request.setAttribute("capacity", PropertyReader.getValue("error.require", "capacity"));
			isValid = false;
		}

		return isValid;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		PrescriptionBean bean = new PrescriptionBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setDecease(DataUtility.getString(request.getParameter("decease")));
		bean.setDate(DataUtility.getDate(request.getParameter("date")));
		bean.setCapacity(DataUtility.getInt(request.getParameter("capacity")));
		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println("Operation = " + op);
		Long id = DataUtility.getLong(request.getParameter("id"));

		System.out.println("id = " + id);

		if (id > 0) {
			PrescriptionModel model = new PrescriptionModel();

			try {
				PrescriptionBean bean = model.findByPk(id);
				ServletUtility.setBean(bean, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println("Operation = " + op);
		PrescriptionBean bean = (PrescriptionBean) populateBean(request);
		PrescriptionModel model = new PrescriptionModel();

		if (OP_SAVE.equalsIgnoreCase(op)) {
			try {
				model.add(bean);
				ServletUtility.setSuccessMessage("Data Added Successfully....", request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.PRESCRIPTION_CTL, request, response);
			return;
		}

		if (OP_UPDATE.equalsIgnoreCase(op)) {
			try {
				model.update(bean);
				ServletUtility.setBean(bean, request);
				ServletUtility.setSuccessMessage("Data Updated Successfully....", request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.PRESCRIPTION_LIST_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return ORSView.PRESCRIPTION_VIEW;
	}

}
