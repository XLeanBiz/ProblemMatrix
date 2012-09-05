package co.problemmatrix.client.matrix;

import java.util.ArrayList;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterviewPage;
import co.problemmatrix.client.interviews.problems.edit.EditProblemInterviewPage;
import co.problemmatrix.client.utilities.UseTracking;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CompanyProblemMatrix extends FlexTable {

	public CompanyProblemMatrix(JSONArray interviews) {

		this.setSize("100%", "100%");
		this.setBorderWidth(1);
		this.setCellSpacing(0);
		this.setCellPadding(20);
		this.setStyleName("flextable");

		writePersonaLink(this);

		ArrayList<String> personaList = new ArrayList<String>();

		ArrayList<String> problemsList = new ArrayList<String>();

		for (int i = 0; i < interviews.size(); i++) {

			final JSONObject interviewJson = (JSONObject) interviews.get(i);

			String persona = ConvertJson.getStringValue(interviewJson,
					"persona");
			if (persona == null) {
				persona = "";
			}

			int personaColumn = getPersonaColumn(persona, personaList, this);

			String problem = ConvertJson.convertToString(interviewJson
					.get("problem"));

			int problemRow = getProblemRow(problem, problemsList, this);

			writeCustomerName(this, problemRow, personaColumn, interviewJson);
		}

	}

	private void writePersonaLink(FlexTable problemTable) {

		HTML personaTitle = new HTML("<center><b><font color=gray>"
				+ "&nbsp;&nbsp; PROBLEM x PERSONA &nbsp;&nbsp;"
				+ "</font></b></center>");
		personaTitle.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking(this.getClass().getName());

				// GetPersona.get("Event Organizer");
			}
		});

		problemTable.setWidget(0, 0, personaTitle);
	}

	private int getPersonaColumn(String targetPersona,
			ArrayList<String> personaList, FlexTable problemTable) {

		int personaColumn = personaList.size() + 1;

		for (int j = 0; j < personaList.size(); j++) {

			String persona = personaList.get(j);

			if (persona.equals(targetPersona)) {

				personaColumn = j + 1;

				break;
			}
		}

		if (personaColumn == personaList.size() + 1) {

			personaList.add(targetPersona);

			PersonaLink personaLink = new PersonaLink(targetPersona);

			problemTable.setWidget(0, personaColumn, personaLink);
		}

		return personaColumn;
	}

	private int getProblemRow(String targetProblem,
			ArrayList<String> problemsList, FlexTable problemTable) {

		int problemRow = problemsList.size() + 1;

		if (targetProblem == null) {

			targetProblem = "";
		}

		for (int j = 0; j < problemsList.size(); j++) {

			String problem = problemsList.get(j);

			if (problem.equals(targetProblem)) {

				problemRow = j + 1;

				break;
			}
		}

		if (problemRow == problemsList.size() + 1) {

			problemsList.add(targetProblem);

			problemTable.setHTML(problemRow, 0, "<b>" + targetProblem + "</b>");
		}

		return problemRow;
	}

	private void writeCustomerName(FlexTable problemTable,
			final int problemRow, final int personaColumn,
			final JSONObject interviewJson) {

		VerticalPanel customersList = new VerticalPanel();

		try {

			customersList = (VerticalPanel) problemTable.getWidget(problemRow,
					personaColumn);

			if (customersList == null) {

				customersList = new VerticalPanel();
			}

		} catch (Exception e) {

		}

		String customerName = ConvertJson.getStringValue(interviewJson,
				"customerName");

		String problemRate = ConvertJson.getStringValue(interviewJson,
				"problemRate");

		CustomerNameLink customerLink = new CustomerNameLink(customerName,
				problemRate);
		customerLink.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String problems = ConvertJson.getStringValue(interviewJson,
						"problems");

				ProblemMatrixPanel.vpMain.clear();

				if (problems != null) {

					ProblemMatrixPanel.vpMain.add(new EditPersonaInterviewPage(
							interviewJson));
				} else {

					ProblemMatrixPanel.vpMain.add(new EditProblemInterviewPage(
							interviewJson));
				}

				ProblemMatrixPanel.hpButtons.clear();
				ProblemMatrixPanel.hpButtons.add(new ShowMatrixButton());
			}
		});

		customersList.add(customerLink);

		problemTable.setWidget(problemRow, personaColumn, customersList);
	}
}
