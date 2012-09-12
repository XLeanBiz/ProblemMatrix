package co.problemmatrix.client.matrix;

import co.problemmatrix.client.interviews.earlyadopters.edit.EarlyAdoptersRateListbox;
import co.problemmatrix.client.interviews.problems.edit.ProblemRateListbox;
import co.problemmatrix.client.interviews.solution.edit.SolutionRateListbox;

import com.google.gwt.user.client.ui.HTML;

public class CustomerNameLink extends HTML {

	public CustomerNameLink(final String customerName, final String rate) {

		String rateColor = getRateColor(rate);

		String rateString = "";

		if (rate != null && rate.length() > 0) {

			rateString = "<font " + rateColor + " size=1>" + rate + "</font>";
		}

		this.setHTML("<a href=#>" + customerName + "</a> " + rateString);
	}

	public static String getRateColor(final String rate) {

		String rateColor = "";

		if (EarlyAdoptersRateListbox.WANT_NOW.equals(rate)) {

			rateColor = "purple";

		} else if (ProblemRateListbox.MUST_HAVE.equals(rate)) {

			rateColor = "red";

		} else if (ProblemRateListbox.NICE_TO_HAVE.equals(rate)
				|| EarlyAdoptersRateListbox.WANT_LATER.equals(rate)) {

			rateColor = "orange";

		} else if (ProblemRateListbox.DONT_CARE.equals(rate)) {

			rateColor = "blue";

		} else if (ProblemRateListbox.DONT_NEED.equals(rate)) {

			rateColor = "gray";

		} else if (ProblemRateListbox.DONT_HAVE.equals(rate)
				|| SolutionRateListbox.DONT_WANT.equals(rate)) {

			rateColor = "black";

		} else if (SolutionRateListbox.KNOW_MORE.equals(rate)) {

			rateColor = "green";
		}

		return " color='" + rateColor + "' ";
	}
}
