package co.problemmatrix.client.matrix;

import java.util.ArrayList;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.home.SideBar;
import co.problemmatrix.client.interviews.earlyadopters.edit.EarlyAdoptersRateListbox;
import co.problemmatrix.client.interviews.earlyadopters.edit.EditEarlyAdoptersInterviewPage;
import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterviewPage;
import co.problemmatrix.client.interviews.problems.edit.EditProblemInterviewPage;
import co.problemmatrix.client.interviews.problems.edit.ProblemRateListbox;
import co.problemmatrix.client.interviews.satisfaction.edit.EditSatisfactionInterviewPage;
import co.problemmatrix.client.interviews.solution.edit.EditSolutionInterviewPage;
import co.problemmatrix.client.interviews.solution.edit.SolutionRateListbox;
import co.problemmatrix.client.metrics.MetricsPanel;
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

	private int mustHaveProblemCount = 0;
	private int mustHaveSolutionCount = 0;
	private int earlyAdoptersCount = 0;

	private ArrayList<String> personaList = new ArrayList<String>();
	private ArrayList<String> problemsList = new ArrayList<String>();
	private ArrayList<String> solutionsList = new ArrayList<String>();

	private JSONArray[][] matrix = new JSONArray[20][20];

	public CompanyCustDevMatrix(final JSONArray problemInterviews,
			final JSONArray solutionInterviews) {

		this.setSize("100%", "100%");
		this.setBorderWidth(1);
		this.setCellSpacing(0);
		this.setCellPadding(20);
		this.setStyleName("flextable");

		writePersonaLink(this);

		getSolutions(solutionInterviews);

		getProblems(problemInterviews);

		writeInterviews();

		SideBar.metricsPanel.clear();
		SideBar.metricsPanel.add(new MetricsPanel(mustHaveProblemCount,
				mustHaveSolutionCount, earlyAdoptersCount));
	}

	private void getSolutions(final JSONArray solutionInterviews) {

		for (int i = 0; i < solutionInterviews.size(); i++) {

			final JSONObject solutionInterviewJson = (JSONObject) solutionInterviews
					.get(i);

			String persona = ConvertJson.getStringValue(solutionInterviewJson,
					"persona");

			int personaColumn = getPersonaColumn(persona);

			String solution = ConvertJson.convertToString(solutionInterviewJson
					.get("solution"));

			if (solution == null) {

				solution = ConvertJson.convertToString(solutionInterviewJson
						.get("feature"));
			}

			int solutionRow = getSolutionRow(solution);

			JSONArray interviewsArray = matrix[solutionRow][personaColumn];

			if (interviewsArray == null) {

				interviewsArray = new JSONArray();
			}

			interviewsArray.set(interviewsArray.size(), solutionInterviewJson);

			matrix[solutionRow][personaColumn] = interviewsArray;
		}
	}

	private void getProblems(final JSONArray problemInterviews) {

		for (int i = 0; i < problemInterviews.size(); i++) {

			final JSONObject problemInterviewJson = (JSONObject) problemInterviews
					.get(i);

			String persona = ConvertJson.getStringValue(problemInterviewJson,
					"persona");

			int personaColumn = getPersonaColumn(persona);

			String problem = ConvertJson.convertToString(problemInterviewJson
					.get("problem"));

			int problemRow = getProblemRow(problem, solutionsList.size());

			JSONArray interviewsArray = matrix[problemRow][personaColumn];

			if (interviewsArray == null) {

				interviewsArray = new JSONArray();
			}

			interviewsArray.set(interviewsArray.size(), problemInterviewJson);

			matrix[problemRow][personaColumn] = interviewsArray;
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

	private int getPersonaColumn(String targetPersona) {

		if (targetPersona == null) {

			targetPersona = "";
		}

		int personaColumn = personaList.indexOf(targetPersona) + 1;

		if (personaColumn == 0) {

			personaList.add(targetPersona);

			personaColumn = personaList.indexOf(targetPersona) + 1;

			PersonaLink personaLink = new PersonaLink(targetPersona);

			this.setWidget(0, personaColumn, personaLink);
		}

		return personaColumn;
	}

	private int getProblemRow(String targetProblem, final int solutionsListSize) {

		if (targetProblem == null) {

			targetProblem = "";
		}

		int problemRow = problemsList.indexOf(targetProblem) + 1;

		if (problemRow == 0) {

			problemsList.add(targetProblem);

			problemRow = problemsList.indexOf(targetProblem) + 1;
		}

		problemRow += solutionsListSize;

		this.setHTML(problemRow, 0, "<b>" + targetProblem
				+ "</b><br><font color=gray size=1>Problem</font>");

		return problemRow;
	}

	private int getSolutionRow(String targetSolution) {

		int solutionRow = solutionsList.indexOf(targetSolution) + 1;

		if (targetSolution == null) {

			targetSolution = "";
		}

		if (solutionRow == 0) {

			solutionsList.add(targetSolution);

			solutionRow = solutionsList.indexOf(targetSolution) + 1;

			this.setHTML(solutionRow, 0, "<b>" + targetSolution
					+ "</b><br><font color=gray size=1>Solution</font>");
		}

		return solutionRow;
	}

	int problemRateCount = 0;
	int solutionRateCount = 0;
	int earlyAdopterRateCount = 0;

	private void writeInterviews() {

		int row = 0;
		int column = 0;

		for (JSONArray[] rowInterviewsJson : matrix) {

			for (JSONArray cellInterviewsJson : rowInterviewsJson) {

				if (cellInterviewsJson != null) {

					VerticalPanel vpCustomers = new VerticalPanel();

					for (int i = 0; i < cellInterviewsJson.size(); i++) {

						JSONObject interviewJson = (JSONObject) cellInterviewsJson
								.get(i);

						String customerName = ConvertJson.getStringValue(
								interviewJson, "customerName");

						String rate = getRate(interviewJson);

						CustomerNameLink customerLink = getCustomerNameLink(
								customerName, rate, interviewJson);

						vpCustomers.add(customerLink);
					}

					this.setWidget(row, column, vpCustomers);
				}

				column++;
			}

			verifyMetrics();
			row++;
			column = 0;
		}
	}

	private void verifyMetrics() {

		if (problemRateCount > mustHaveProblemCount) {

			mustHaveProblemCount = problemRateCount;
		}

		if (solutionRateCount > mustHaveSolutionCount) {

			mustHaveSolutionCount = solutionRateCount;
		}

		if (earlyAdopterRateCount > earlyAdoptersCount) {

			earlyAdoptersCount = earlyAdopterRateCount;
		}

		problemRateCount = 0;
		solutionRateCount = 0;
		earlyAdopterRateCount = 0;
	}

	public static void showCustDevMatrix(final JSONArray problemInterviews,
			final JSONArray solutionInterviews) {

		ProblemMatrixPanel.vpMain.clear();
		ProblemMatrixPanel.vpMain.add(new CompanyCustDevMatrix(
				problemInterviews, solutionInterviews));

		ProblemMatrixPanel.hpButtons.clear();
	}

	private String getRate(final JSONObject interviewJson) {

		String rate = ConvertJson.getStringValue(interviewJson, "problemRate");

		if (rate != null) {

			if (ProblemRateListbox.MUST_HAVE.equals(rate)) {

				problemRateCount++;
			}

		} else {

			rate = ConvertJson.getStringValue(interviewJson, "solutionRate");

			if (rate != null) {

				if (SolutionRateListbox.MUST_HAVE.equals(rate)) {

					solutionRateCount++;
				}

			} else {

				rate = ConvertJson.getStringValue(interviewJson,
						"earlyAdopterRate");

				if (rate != null) {

					if (EarlyAdoptersRateListbox.WANT_NOW.equals(rate)) {

						earlyAdopterRateCount++;
					}
				} else {

					rate = ConvertJson.getStringValue(interviewJson,
							"satisfactionRate");
				}
			}
		}

		return rate;
	}

	private CustomerNameLink getCustomerNameLink(final String customerName,
			final String rate, final JSONObject interviewJson) {

		final CustomerNameLink customerLink = new CustomerNameLink(
				customerName, rate);
		customerLink.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String problems = ConvertJson.getStringValue(interviewJson,
						"problems");

				String solution = ConvertJson.getStringValue(interviewJson,
						"solution");

				String feature = ConvertJson.getStringValue(interviewJson,
						"feature");

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
				} else if (feature != null) {

					ProblemMatrixPanel.vpMain
							.add(new EditSatisfactionInterviewPage(
									interviewJson));
				} else {

					ProblemMatrixPanel.vpMain.add(new EditProblemInterviewPage(
							interviewJson));
				}

				ProblemMatrixPanel.hpButtons.clear();
				ProblemMatrixPanel.hpButtons.add(new ShowMatrixButton());
			}
		});

		return customerLink;
	}
}
