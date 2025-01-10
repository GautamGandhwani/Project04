package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.PrescriptionBean;
import in.co.rays.bean.PurchaseBean;
import in.co.rays.model.PrescriptionModel;
import in.co.rays.model.PurchaseModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "/PurchaseCtl", urlPatterns = { "/ctl/PurchaseCtl" })
public class PurchaseCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("quantity"))) {
			request.setAttribute("quantity", PropertyReader.getValue("error.require", "Quantity"));
			pass = false;
		} else if (!DataValidator.isInteger(request.getParameter("quantity"))) {
			request.setAttribute("quantity", "Invalid Quantity");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("price"))) {
			request.setAttribute("price", PropertyReader.getValue("error.require", "Price"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("purchaseDate"))) {
			request.setAttribute("purchaseDate", PropertyReader.getValue("error.require", "Purchase Date"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("orderType"))) {
			request.setAttribute("orderType", PropertyReader.getValue("error.require", "Order Type"));
			pass = false;
		}
		return pass;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		PurchaseBean bean = new PurchaseBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setQuantity(DataUtility.getInt(request.getParameter("quantity")));
		bean.setPrice((double) DataUtility.getInt(request.getParameter("price")));
		bean.setPurchaseDate(DataUtility.getDate(request.getParameter("purchaseDate")));
		bean.setOrderType(DataUtility.getString(request.getParameter("orderType")));
		populateDTO(bean, request);
		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("opertion"));
		Long id = DataUtility.getLong(request.getParameter("id"));
		System.out.println("Id = " + id);
		if (id > 0) {
			PurchaseModel model = new PurchaseModel();

			try {
				PurchaseBean bean = model.findByPk(id);
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

		PurchaseBean bean = (PurchaseBean) populateBean(request);
		PurchaseModel model = new PurchaseModel();

		if (OP_SAVE.equalsIgnoreCase(op)) {
			try {
				model.add(bean);
				ServletUtility.setSuccessMessage("Data Added Successfully....", request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.PURCHASE_CTL, request, response);
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
			ServletUtility.redirect(ORSView.PURCHASE_LIST_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return ORSView.PURCHASE_VIEW;
	}

}
