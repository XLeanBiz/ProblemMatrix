package co.problemmatrix.client.matrix;

import java.util.ArrayList;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.earlyadopters.edit.EditEarlyAdoptersInterviewPage;
import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterviewPage;
import co.problemmatrix.client.interviews.problems.edit.EditProblemInterviewPage;
import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterviewPage;
import co.problemmatrix.client.utilities.UseTracking;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CompanyCustDevMatrix extends FlexTable {

	public CompanyCustDevMatrix(final JSONArray problemInterviews,
			final JSONArray solutionInterviews) {

		this.setSize("100%", "100%");
		this.setBorderWidth(1);
		this.setCellSpacing(0);
		this.setCellPadding(20);
		this.setStyleName("flextable");

		writePersonaLink(this);

		ArrayList<String> personaList = new ArrayList<String>();

		ArrayList<String> problemsList = new ArrayList<String>();

		ArrayList<String> solutionsList = new ArrayList<String>();

		for (int i = 0; i < solutionInterviews.size(); i++) {

			final JSONObject solutionInterviewJson = (JSONObject) solutionInterviews
					.get(i);

			String persona = ConvertJson.getStringValue(solutionInterviewJson,
					"persona");
			if (persona == null) {
				persona = "";
			}

			int personaColumn = getPersonaColumn(persona, personaList, this);

			String solution = ConvertJson.convertToString(solutionInterviewJson
					.get("solution"));

			int solutionRow = getSolutionRow(solution, solutionsList, this);

			writeCustomerName(this, solutionRow, personaColumn,
					solutionInterviewJson);
		}

		for (int i = 0; i < problemInterviews.size(); i++) {

			final JSONObject problemInterviewJson = (JSONObject) problemInterviews
					.get(i);

			String persona = ConvertJson.getStringValue(problemInterviewJson,
					"persona");
			if (persona == null) {
				persona = "";
			}

			int personaColumn = getPersonaColumn(persona, personaList, this);

			String problem = ConvertJson.convertToString(problemInterviewJson
					.get("problem"));

			int problemRow = getProblemRow(problem, problemsList, this,
					solutionsList.size());

			writeCustomerName(this, problemRow + solutionsList.size(),
					personaColumn, problemInterviewJson);
		}

	}

	private void writePersonaLink(FlexTable problemTable) {

		HTML personaTitle = new HTML(
				"<center><b><font color=gray>"
						+ "&nbsp;&nbsp; SOLUTION / PROBLEM <br>x<br> PERSONA &nbsp;&nbsp;"
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
			ArrayList<String> problemsList, FlexTable problemTable,
			final int solutionsListSize) {

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

			problemTable.setHTML(solutionsListSize + problemRow, 0, "<b>"
					+ targetProblem
					+ "</b><br><font color=gray size=1>Problem</font>");
		}

		return problemRow;
	}

	private int getSolutionRow(String targetSolution,
			ArrayList<String> solutionsList, FlexTable table) {

		int solutionRow = solutionsList.size() + 1;

		if (targetSolution == null) {

			targetSolution = "";
		}

		for (int j = 0; j < solutionsList.size(); j++) {

			String solution = solutionsList.get(j);

			if (solution.equals(targetSolution)) {

				solutionRow = j + 1;

				break;
			}
		}

		if (solutionRow == solutionsList.size() + 1) {

			solutionsList.add(targetSolution);

			table.setHTML(solutionRow, 0, "<b>" + targetSolution
					+ "</b><br><font color=gray size=1>Solution</font>");
		}

		return solutionRow;
	}

	private void writeCustomerName(FlexTable table, int row,
			final int personaColumn, final JSONObject interviewJson) {

		VerticalPanel customersList = new VerticalPanel();

		String customerName = ConvertJson.getStringValue(interviewJson,
				"customerName");

		String rate = ConvertJson.getStringValue(interviewJson, "problemRate");
		if (rate == null) {

			rate = ConvertJson.getStringValue(interviewJson, "solutionRate");
		}
		if (rate == null) {

			rate = ConvertJson
					.getStringValue(interviewJson, "earlyAdopterRate");
		}

		try {

			customersList = (VerticalPanel) table.getWidget(row, personaColumn);

			if (customersList == null) {

				customersList = new VerticalPanel();
			}

		} catch (Exception e) {

		}

		CustomerNameLink customerLink = new CustomerNameLink(customerName, rate);
		customerLink.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String problems = ConvertJson.getStringValue(interviewJson,
						"problems");

				String solution = ConvertJson.getStringValue(interviewJson,
						"solution");

				ProblemMatrixPanel.vpMain.clear();

				if (problems != null) {

					ProblemMatrixPanel.vpMain.add(new EditPersonaInterviewPage(
							interviewJson));

				} else if (solution != null) {

					String earlyAdopterRate = ConvertJson.getStringValue(
							interviewJson, "earlyAdopterRate");

					if (earlyAdopterRate != null) {

						ProblemMatrixPanel.vpMain
								.add(new EditEarlyAdoptersInterviewPage(
										interviewJson));
					} else {

						ProblemMatrixPanel.vpMain
								.add(new EditSolutionInterviewPage(
										interviewJson));
					}
				} else {

					ProblemMatrixPanel.vpMain.add(new EditProblemInterviewPage(
							interviewJson));
				}

				ProblemMatrixPanel.hpButtons.clear();
				ProblemMatrixPanel.hpButtons.add(new ShowMatrixButton());
			}
		});

		customersList.add(customerLink);

		table.setWidget(row, personaColumn, customersList);
	}

	public static void showCustDevMatrix(final JSONArray problemInterviews,
			final JSONArray solutionInterviews) {

		ProblemMatrixPanel.vpMain.clear();
		ProblemMatrixPanel.vpMain.add(new CompanyCustDevMatrix(
				problemInterviews, solutionInterviews));

		ProblemMatrixPanel.hpButtons.clear();
	}
}
