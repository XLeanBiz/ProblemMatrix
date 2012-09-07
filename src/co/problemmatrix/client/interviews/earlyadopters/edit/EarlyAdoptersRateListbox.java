package co.problemmatrix.client.interviews.earlyadopters.edit;

import com.google.gwt.user.client.ui.ListBox;

public class EarlyAdoptersRateListbox extends ListBox {

	public static final String WANT_NOW = "WANT NOW";
	public static final String WANT_LATER = "WANT LATER";
	public static final String DONT_WANT = "DON'T WANT";
	public static final String KNOW_MORE = "KNOW MORE";

	public EarlyAdoptersRateListbox(final String rate) {

		this.setWidth("400px");

		this.addItem("");

		this.addItem(
				"No, I DON'T WANT to be an early adopter for this solution.",
				DONT_WANT);
		this.addItem("Maybe, I want to KNOW MORE about this solution.",
				KNOW_MORE);
		this.addItem(
				"Yes, I want to be an early adopters for this solution, but LATER.",
				WANT_LATER);
		this.addItem(
				"Yes, I want to be an early adopters for this solution NOW.",
				WANT_NOW);

		if (DONT_WANT.equals(rate)) {

			this.setSelectedIndex(1);

		} else if (KNOW_MORE.equals(rate)) {

			this.setSelectedIndex(2);

		} else if (WANT_LATER.equals(rate)) {

			this.setSelectedIndex(3);

		} else if (WANT_NOW.equals(rate)) {

			this.setSelectedIndex(4);
		}
	}
}
