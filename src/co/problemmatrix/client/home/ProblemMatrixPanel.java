package co.problemmatrix.client.home;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProblemMatrixPanel extends VerticalPanel {

	public static VerticalPanel vpMain = new VerticalPanel();

	public static VerticalPanel vpButtons = new VerticalPanel();

	public ProblemMatrixPanel() {

		this.setSpacing(10);
		this.setSize("100%", "100%");

		this.add(new Header());

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.add(vpButtons);
		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vpMain.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vpMain.setSize("100%", "100%");

		FlexTable table = new FlexTable();
		table.setSize("100%", "100%");
		table.setCellPadding(0);
		table.setCellSpacing(0);
		table.setStyleName("flextable");
		table.setWidget(0, 0, vpMain);

		this.add(table);
	}
}
