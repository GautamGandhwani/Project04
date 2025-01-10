package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.rays.bean.BaseBean;
import in.co.rays.bean.PrescriptionBean;
import in.co.rays.model.PrescriptionModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "/PrescriptionListCtl", urlPatterns = { "/ctl/PrescriptionListCtl" })
public class PrescriptionListCtl extends BaseCtl {
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
		List<PrescriptionBean> list = null;
		List<PrescriptionBean> next = null;

		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));

		PrescriptionBean bean = (PrescriptionBean) populateBean(request);
		PrescriptionModel model = new PrescriptionModel();
		try {
			list = model.search(bean, pageNo, pageSize);
			next = model.search(bean, pageNo + 1, pageSize);

			request.setAttribute("nextListSize", next.size());
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PrescriptionBean> list = null;
		List<PrescriptionBean> next = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;

		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println("Operation = " + op);
		PrescriptionBean bean = (PrescriptionBean) populateBean(request);
		PrescriptionModel model = new PrescriptionModel();
		String[] ids = request.getParameterValues("ids");
		try {
			if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				for (String id : ids) {
					model.delete(DataUtility.getLong(id));
				}
			}

			if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.PRESCRIPTION_CTL, request, response);
				return;
			}

			if (OP_SEARCH.equalsIgnoreCase(op)) {
				pageNo = 1;
			} else if (OP_RESET.equalsIgnoreCase(op) || OP_BACK.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.PRESCRIPTION_LIST_CTL, request, response);
				return;
			}

			if (OP_NEXT.equalsIgnoreCase(op)) {
				pageNo++;
			} else if (OP_PREVIOUS.equalsIgnoreCase(op)) {
				pageNo--;
			}

			list = model.search(bean, pageNo, pageSize);
			next = model.search(bean, pageNo + 1, pageSize);

			request.setAttribute("nextListSize", next.size());
			ServletUtility.setList(list, request);
			ServletUtility.setBean(bean, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getView() {
		return ORSView.PRESCRIPTION_LIST_VIEW;
	}
}