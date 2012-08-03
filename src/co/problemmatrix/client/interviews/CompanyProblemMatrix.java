package co.problemmatrix.client.interviews;

import java.util.ArrayList;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.edit.EditProblemInterviewPage;
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

			problemTable.setHTML(personaRow, 0, "<b>" + targetPersona + "</b>");
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

		HTML customerLink = new HTML("<a href=#>" + customerName + " - "
				+ problemRate + "</a>");
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
