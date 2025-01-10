package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.ItemInformationBean;
import in.co.rays.bean.PrescriptionBean;
import in.co.rays.model.ItemInformationModel;
import in.co.rays.model.PrescriptionModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "/ItemInformationCtl", urlPatterns = { "/ctl/ItemInformationCtl" })
public class ItemInformationCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("title"))) {
			request.setAttribute("title", PropertyReader.getValue("error.require", "title"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("title"))) {
			request.setAttribute("title", "Invalid title");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("overview"))) {
			request.setAttribute("overview", PropertyReader.getValue("error.require", "overview"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("overview"))) {
			request.setAttribute("overview", "Invalid overview");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("cost"))) {
			request.setAttribute("cost", PropertyReader.getValue("error.require", "Cost"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("purchaseDate"))) {
			request.setAttribute("purchaseDate", PropertyReader.getValue("error.require", "Purchase Date"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("category"))) {
			request.setAttribute("category", PropertyReader.getValue("error.require", "category"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("category"))) {
			request.setAttribute("category", "Invalid category");
			pass = false;
		}
		return pass;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		ItemInformationBean bean = new ItemInformationBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setTitle(DataUtility.getString(request.getParameter("title")));
		bean.setOverview(DataUtility.getString(request.getParameter("overview")));
		bean.setCost(DataUtility.getLong(request.getParameter("cost")));
		bean.setPurchaseDate(DataUtility.getDate(request.getParameter("purchaseDate")));
		bean.setCategory(DataUtility.getString(request.getParameter("category")));
		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = DataUtility.getLong(request.getParameter("id"));
		ItemInformationModel model = new ItemInformationModel();
		System.out.println("id = " + id);

		if (id > 0) {
			try {
				ItemInformationBean bean = model.findByPk(id);
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

		ItemInformationBean bean = (ItemInformationBean) populateBean(request);
		ItemInformationModel model = new ItemInformationModel();

		if (OP_SAVE.equalsIgnoreCase(op)) {
			try {
				model.add(bean);
				ServletUtility.setSuccessMessage("Data Added Successfully....", request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.ITEMINFORMATION_CTL, request, response);
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
			ServletUtility.redirect(ORSView.ITEMINFORMATION_LIST_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return ORSView.ITEMINFORMATION_VIEW;
	}
}