package co.problemmatrix.client.interviews.earlyadopters;

import java.util.Date;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.earlyadopters.edit.EditEarlyAdoptersInterviewPage;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EarlyAdoptersInterviewsListPanel extends VerticalPanel {

	public EarlyAdoptersInterviewsListPanel(JSONArray interviews) {

		this.setSpacing(20);

		for (int i = 0; i < interviews.size(); i++) {

			final JSONObject interviewJson = (JSONObject) interviews.get(i);

			final String datetime = ConvertJson.getStringValue(interviewJson,
					"datetime");

			final String customerName = ConvertJson.getStringValue(
					interviewJson, "customerName");

			final String solution = ConvertJson.getStringValue(interviewJson,
					"solution");

			String dateString = "";
			if (datetime != null) {

				dateString = new Date(new Long(datetime)) + " - ";
			}

			HTML html = new HTML(dateString + "<a href=#><b>" + " "
					+ customerName + "</b></a>");
			html.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					ProblemMatrixPanel.vpMain.clear();
					ProblemMatrixPanel.vpMain
							.add(new EditEarlyAdoptersInterviewPage(
									interviewJson));

					EditEarlyAdoptersInterviewPage.showButtons(interviewJson,
							solution);
				}
			});

			this.add(html);
		}
	}
}
