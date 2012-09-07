package co.problemmatrix.client.interviews.earlyadopters;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.earlyadopters.edit.AddEarlyAdopterInterviewButton;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListEarlyAdoptersInterviews {

	public static void list(final String solutionName) {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		custDevService.listEarlyAdoptersInterviews(solutionName,
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
									.add(new EarlyAdoptersInterviewsListPanel(
											jsonArray));

							ProblemMatrixPanel.hpButtons.clear();
							ProblemMatrixPanel.hpButtons
									.add(new AddEarlyAdopterInterviewButton(
											solutionName));
						}
					}
				});
	}

}
