package co.problemmatrix.client.interviews.problems.customers;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerProblemInterviewPage extends VerticalPanel {

	public CustomerProblemInterviewPage(final String problemName) {

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setWidth("100%");

		VerticalPanel vp = new VerticalPanel();

		FlexTable table = new FlexTable();
		table.setCellPadding(0);
		table.setCellSpacing(0);
		table.setStyleName("flextable");
		table.setWidget(0, 0, vp);

		vp.add(new CustomerProblemInterview(problemName));

		this.add(table);
	}
}
