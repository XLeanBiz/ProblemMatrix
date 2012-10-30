package co.problemmatrix.client.interviews.satisfaction;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.earlyadopters.edit.AddEarlyAdopterInterviewButton;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListSatisfactionInterviews {

	public static void list() {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		if (UniqueIDGlobalVariables.companyUniqueID != null) {

			String company = ConvertJson
					.convertToString(UniqueIDGlobalVariables.companyUniqueID
							.get("ID"));

			custDevService.listSatisfactionInterviews(company,
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
										.add(new SatisfactionInterviewsListPanel(
												jsonArray));

								ProblemMatrixPanel.hpButtons.clear();
								ProblemMatrixPanel.hpButtons
										.add(new AddEarlyAdopterInterviewButton());
							}
						}
					});
		}
	}

}
