package co.problemmatrix.client.interviews;

import java.util.ArrayList;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CompanyProblemMatrix extends VerticalPanel {

	public CompanyProblemMatrix(JSONArray interviews) {

		this.setSpacing(20);

		FlexTable problemTable = new FlexTable();

		problemTable.setBorderWidth(1);
		problemTable.setCellSpacing(0);
		problemTable.setCellPadding(20);

		ArrayList<String> personaList = new ArrayList<String>();

		ArrayList<String> problemsList = new ArrayList<String>();

		for (int i = 0; i < interviews.size(); i++) {

			final JSONObject interviewJson = (JSONObject) interviews.get(i);

			String customerName = ConvertJson.getStringValue(interviewJson,
					"customerName");

			String persona = ConvertJson.getStringValue(interviewJson,
					"persona");

			int personaRow = getPersonaRow(persona, personaList, problemTable);

			String problem1 = ConvertJson.convertToString(interviewJson
					.get("problem1"));

			int problemRow = getProblemRow(problem1, problemsList, problemTable);

			writeCustomerName(problemTable, personaRow, problemRow,
					customerName);

			String problem2 = ConvertJson.convertToString(interviewJson
					.get("problem2"));

			problemRow = getProblemRow(problem2, problemsList, problemTable);

			writeCustomerName(problemTable, personaRow, problemRow,
					customerName);
		}

		this.add(problemTable);

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
			final String customerName) {

		String customersList = "";

		try {

			customersList = problemTable.getHTML(customerRow, problemRow);

		} catch (Exception e) {

		}

		problemTable.setHTML(customerRow, problemRow, customersList + "<br>"
				+ customerName);
	}
}
