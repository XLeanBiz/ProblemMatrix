package co.problemmatrix.client.interviews.problems;

import java.util.Date;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.problems.edit.EditProblemInterviewPage;
import co.problemmatrix.client.matrix.CustomerNameLink;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProblemsInterviewsListPanel extends VerticalPanel {

	public ProblemsInterviewsListPanel(JSONArray interviews) {

		this.setSpacing(20);

		if (interviews.size() > 0) {

			for (int i = interviews.size() - 1; i >= 0; i--) {

				final JSONObject interviewJson = (JSONObject) interviews.get(i);

				final String datetime = ConvertJson.getStringValue(
						interviewJson, "datetime");

				final String customerName = ConvertJson.getStringValue(
						interviewJson, "customerName");

				final String problemRate = ConvertJson.getStringValue(
						interviewJson, "problemRate");

				final String persona = ConvertJson.getStringValue(
						interviewJson, "persona");

				final String problem = ConvertJson.getStringValue(
						interviewJson, "problem");

				String dateString = "";
				if (datetime != null) {

					dateString = new Date(new Long(datetime)) + " - ";
				}

				HTML html = new HTML(dateString + "<a href=#><b>" + " "
						+ customerName + "</b> (" + persona + ") - " + problem
						+ " - <font "
						+ CustomerNameLink.getRateColor(problemRate) + ">"
						+ problemRate + "</font></a>");
				
				html.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {

						ProblemMatrixPanel.vpMain.clear();
						ProblemMatrixPanel.vpMain
								.add(new EditProblemInterviewPage(interviewJson));

						EditProblemInterviewPage.showButtons(interviewJson);
					}
				});

				this.add(html);
			}
		}
	}
}
