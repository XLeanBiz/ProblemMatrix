package co.problemmatrix.client.interviews.customers;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerPage extends VerticalPanel {

	public CustomerPage() {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		VerticalPanel vp = new VerticalPanel();

		FlexTable table = new FlexTable();
		table.setSize("100%", "100%");
		table.setCellPadding(0);
		table.setCellSpacing(0);
		table.setStyleName("flextable");
		table.setWidget(0, 0, vp);

		vp.add(new CustomerProblemInterview());

		this.add(table);
	}
}
