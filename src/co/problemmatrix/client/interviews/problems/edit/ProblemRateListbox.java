package co.problemmatrix.client.interviews.problems.edit;

import com.google.gwt.user.client.ui.ListBox;

public class ProblemRateListbox extends ListBox {

	public static final String MUST_HAVE = "MUST HAVE";
	public static final String NICE_TO_HAVE = "NICE TO HAVE";
	public static final String DONT_CARE = "DON'T CARE";
	public static final String DONT_NEED = "DON'T NEED";
	public static final String DONT_HAVE = "DON'T HAVE";

	public ProblemRateListbox(final String rate) {

		this.setWidth("350px");

		this.addItem("");

		this.addItem("I MUST HAVE a solution for this problem.", MUST_HAVE);
		this.addItem("It will be NICE TO HAVE a solution for this problem.",
				NICE_TO_HAVE);
		this.addItem("I DON'T CARE about a solution for this problem.",
				DONT_CARE);
		this.addItem("I DON'T NEED a solution for this problem.", DONT_NEED);
		this.addItem("I DON'T HAVE this problem.", DONT_HAVE);

		if (MUST_HAVE.equals(rate)) {

			this.setSelectedIndex(1);

		} else if (NICE_TO_HAVE.equals(rate)) {

			this.setSelectedIndex(2);

		} else if (DONT_CARE.equals(rate)) {

			this.setSelectedIndex(3);

		} else if (DONT_NEED.equals(rate)) {

			this.setSelectedIndex(4);

		} else if (DONT_HAVE.equals(rate)) {

			this.setSelectedIndex(5);
		}
	}
}
