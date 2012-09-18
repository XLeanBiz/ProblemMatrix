package co.problemmatrix.client.interviews.solution;

import java.util.Date;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterviewPage;
import co.problemmatrix.client.matrix.CustomerNameLink;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SolutionInterviewsListPanel extends VerticalPanel {

	public SolutionInterviewsListPanel(JSONArray interviews) {

		this.setSpacing(20);

		for (int i = 0; i < interviews.size(); i++) {

			final JSONObject interviewJson = (JSONObject) interviews.get(i);

			final String datetime = ConvertJson.getStringValue(interviewJson,
					"datetime");

			final String customerName = ConvertJson.getStringValue(
					interviewJson, "customerName");

			final String solution = ConvertJson.getStringValue(interviewJson,
					"solution");

			final String solutionRate = ConvertJson.getStringValue(
					interviewJson, "solutionRate");

			final String persona = ConvertJson.getStringValue(interviewJson,
					"persona");

			String dateString = "";
			if (datetime != null) {

				dateString = new Date(new Long(datetime)) + " - ";
			}

			HTML html = new HTML(dateString + "<a href=#><b>" + " "
					+ customerName + "</b> (" + persona + ") - " + solution
					+ " - <font " + CustomerNameLink.getRateColor(solutionRate)
					+ ">" + solutionRate + "</font></a>");

			html.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					ProblemMatrixPanel.vpMain.clear();
					ProblemMatrixPanel.vpMain
							.add(new EditSolutionInterviewPage(interviewJson));

					EditSolutionInterviewPage.showButtons(interviewJson);
				}
			});

			this.add(html);
		}
	}
}
