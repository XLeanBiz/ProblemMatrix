package co.problemmatrix.client.interviews.satisfaction.edit;

import com.google.gwt.user.client.ui.ListBox;

public class SatisfactionRateListbox extends ListBox {

	public static final String MUST_HAVE = "MUST HAVE";
	public static final String NICE_TO_HAVE = "NICE TO HAVE";
	public static final String LIKE_PART = "LIKE PART";
	public static final String DONT_CARE = "DON'T CARE";
	public static final String DONT_LIKE = "DON'T LIKE";
	public static final String DONT_WANT = "DON'T WANT";

	public SatisfactionRateListbox(final String rate) {

		this.setWidth("400px");

		this.addItem("");

		this.addItem("I DON'T WANT this feature.", DONT_WANT);
		this.addItem("I DON'T CARE about this feature.", DONT_CARE);
		this.addItem("I DON'T LIKE this feature.", DONT_LIKE);
		this.addItem("I PARTIALLY LIKE this feature.", LIKE_PART);
		this.addItem("It is NICE TO HAVE this feature.", NICE_TO_HAVE);
		this.addItem("I MUST HAVE this feature.", MUST_HAVE);

		if (MUST_HAVE.equals(rate)) {

			this.setSelectedIndex(6);

		} else if (NICE_TO_HAVE.equals(rate)) {

			this.setSelectedIndex(5);

		} else if (LIKE_PART.equals(rate)) {

			this.setSelectedIndex(4);

		} else if (DONT_LIKE.equals(rate)) {

			this.setSelectedIndex(3);

		} else if (DONT_CARE.equals(rate)) {

			this.setSelectedIndex(2);

		} else if (DONT_WANT.equals(rate)) {

			this.setSelectedIndex(1);
		}
	}
}
