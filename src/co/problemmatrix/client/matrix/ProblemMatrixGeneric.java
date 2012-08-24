package co.problemmatrix.client.matrix;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;

public class ProblemMatrixGeneric extends FlexTable {

	public ProblemMatrixGeneric() {

		setBorderWidth(1);
		setCellPadding(20);
		setCellSpacing(0);
		setStyleName("flextable");

		HTML persona = new HTML("<center><b><font color=gray>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "PROBLEM x PERSONA"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "</font></b></center>");
		setWidget(0, 0, persona);

		HTML problem1 = new HTML("<center><b>Customer"
				+ "<br><font color=red>PROBLEM</font><br>1</b></center>");
		setWidget(1, 0, problem1);

		HTML problem2 = new HTML("<center><b>Customer"
				+ "<br><font color=red>PROBLEM</font><br>2</b></center>");
		setWidget(2, 0, problem2);

		HTML problem3 = new HTML("<center><b>Customer"
				+ "<br><font color=red>PROBLEM</font><br>3</b></center>");
		setWidget(3, 0, problem3);

		HTML problem4 = new HTML("<center><b>Customer"
				+ "<br><font color=red>PROBLEM</font><br>4</b></center>");
		setWidget(4, 0, problem4);

		HTML segment1 = new HTML(
				"<center><b>"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "Customer"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<br><font color=blue>SEGMENT</font><br>1</b></center>");
		setWidget(0, 1, segment1);

		HTML segment2 = new HTML(
				"<center><b>"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "Customer"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<br><font color=blue>SEGMENT</font><br>2</b></center>");
		setWidget(0, 2, segment2);

		HTML segment3 = new HTML(
				"<center><b>"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "Customer"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<br><font color=blue>SEGMENT</font><br>3</b></center>");
		setWidget(0, 3, segment3);

		setText(1, 1, "");
		setText(1, 2, "");
		setText(1, 3, "");
		setText(2, 1, "");
		setText(2, 2, "");
		setText(2, 3, "");
		setText(3, 1, "");
		setText(3, 2, "");
		setText(3, 3, "");
		setText(4, 1, "");
		setText(4, 2, "");
		setText(4, 3, "");

	}
}
