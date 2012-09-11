package co.problemmatrix.client.interviews.solution;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.solution.edit.AddSolutionInterviewButton;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListSolutionInterviews {

	public static void list() {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		if (UniqueIDGlobalVariables.companyUniqueID != null) {

			String company = ConvertJson
					.convertToString(UniqueIDGlobalVariables.companyUniqueID
							.get("ID"));

			custDevService.listSolutionInterviews(company,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
						}

						public void onSuccess(final String jsonResults) {

							if (jsonResults != null) {

								JSONArray jsonArray = (JSONArray) JSONParser
										.parseStrict(jsonResults);

								ProblemMatrixPanel.vpMain.clear();
								ProblemMatrixPanel.vpMain
										.add(new SolutionInterviewsListPanel(
												jsonArray));

								ProblemMatrixPanel.hpButtons.clear();
								ProblemMatrixPanel.hpButtons
										.add(new AddSolutionInterviewButton());
							}
						}
					});
		}
	}

}
