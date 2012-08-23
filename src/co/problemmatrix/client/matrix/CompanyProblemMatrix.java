package co.problemmatrix.client.matrix;

import java.util.ArrayList;

import co.problemmatrix.client.home.ProblemMatrixPanel;
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

			int personaRow = getPersonaRow(persona, personaList, this);

			String problem = ConvertJson.convertToString(interviewJson
					.get("problem"));

			int problemRow = getProblemRow(problem, problemsList, this);

			writeCustomerName(this, personaRow, problemRow, interviewJson);
		}

	}

	private void writePersonaLink(FlexTable problemTable) {

		HTML personaTitle = new HTML("<b><font color=gray>PERSONA x PROBLEM</font></b>");
		personaTitle.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking(this.getClass().getName());

				// GetPersona.get("Event Organizer");
			}
		});

		problemTable.setWidget(0, 0, personaTitle);
	}

	private int getPersonaRow(String targetPersona,
			ArrayList<String> personaList, FlexTable problemTable) {

		int personaRow = personaList.size() + 1;

		for (int j = 0; j < personaList.size(); j++) {

			String persona = personaList.get(j);

			if (persona.equals(targetPersona)) {

				personaRow = j + 1;

				break;
			}
		}

		if (personaRow == personaList.size() + 1) {

			personaList.add(targetPersona);

			PersonaLink personaLink = new PersonaLink(targetPersona);

			problemTable.setWidget(personaRow, 0, personaLink);
		}

		return personaRow;
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

			problemTable.setHTML(0, problemRow, "<b>" + targetProblem + "</b>");
		}

		return problemRow;
	}

	private void writeCustomerName(FlexTable problemTable,
			final int customerRow, final int problemRow,
			final JSONObject interviewJson) {

		VerticalPanel customersList = new VerticalPanel();

		try {

			customersList = (VerticalPanel) problemTable.getWidget(customerRow,
					problemRow);

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

				ProblemMatrixPanel.vpMain.clear();
				ProblemMatrixPanel.vpMain.add(new EditProblemInterviewPage(
						interviewJson));
			}
		});

		customersList.add(customerLink);

		problemTable.setWidget(customerRow, problemRow, customersList);
	}
}
