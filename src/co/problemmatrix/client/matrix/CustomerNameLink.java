package co.problemmatrix.client.matrix;

import co.problemmatrix.client.interviews.problems.edit.ProblemRateListbox;

import com.google.gwt.user.client.ui.HTML;

public class CustomerNameLink extends HTML {

	public CustomerNameLink(final String customerName, final String problemRate) {

		String rateColor = "";

		if (ProblemRateListbox.MUST_HAVE.equals(problemRate)) {

			rateColor = "red";

		} else if (ProblemRateListbox.NICE_TO_HAVE.equals(problemRate)) {

			rateColor = "orange";

		} else if (ProblemRateListbox.DONT_CARE.equals(problemRate)) {

			rateColor = "blue";

		} else if (ProblemRateListbox.DONT_NEED.equals(problemRate)) {

			rateColor = "gray";

		} else if (ProblemRateListbox.DONT_HAVE.equals(problemRate)) {

			rateColor = "black";
		}

		String rateString = "";

		if (problemRate != null && problemRate.length() > 0) {

			rateString = "<font color='" + rateColor + "' size=1>" + problemRate
					+ "</font>";
		}

		this.setHTML("<a href=#>" + customerName + "</a> " + rateString);

	}
}
