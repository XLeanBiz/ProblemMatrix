package co.problemmatrix.client.interviews.solution.edit;

import com.google.gwt.user.client.ui.ListBox;

public class SolutionRateListbox extends ListBox {

	public static final String KNOW_MORE = "KNOW MORE";
	public static final String MUST_HAVE = "MUST HAVE";
	public static final String NICE_TO_HAVE = "NICE TO HAVE";
	public static final String DONT_CARE = "DON'T CARE";
	public static final String DONT_NEED = "DON'T NEED";
	public static final String DONT_WANT = "DON'T WANT";

	public SolutionRateListbox(final String rate) {

		this.setWidth("350px");

		this.addItem("");

		this.addItem("I DON'T WANT this solution.", DONT_WANT);
		this.addItem("I DON'T NEED this solution.", DONT_NEED);
		this.addItem("I DON'T CARE about this solution.", DONT_CARE);
		this.addItem("It will be NICE TO HAVE this solution.", NICE_TO_HAVE);
		this.addItem("I MUST HAVE this solution.", MUST_HAVE);
		this.addItem("I want to KNOW MORE about this solution.", KNOW_MORE);

		if (KNOW_MORE.equals(rate)) {

			this.setSelectedIndex(6);

		} else if (MUST_HAVE.equals(rate)) {

			this.setSelectedIndex(5);

		} else if (NICE_TO_HAVE.equals(rate)) {

			this.setSelectedIndex(4);

		} else if (DONT_CARE.equals(rate)) {

			this.setSelectedIndex(3);

		} else if (DONT_NEED.equals(rate)) {

			this.setSelectedIndex(2);

		} else if (DONT_WANT.equals(rate)) {

			this.setSelectedIndex(1);
		}
	}
}
