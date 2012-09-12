package co.problemmatrix.client.matrix;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListProblemMatrixInterviews {

	public static void list() {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		if (UniqueIDGlobalVariables.companyUniqueID != null) {

			String companyUniqueID = ConvertJson
					.convertToString(UniqueIDGlobalVariables.companyUniqueID
							.get("ID"));

			custDevService.listProblemMatrixInterviews(companyUniqueID,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
						}

						public void onSuccess(final String jsonResults) {

							if (jsonResults != null) {

								JSONArray jsonArray = (JSONArray) JSONParser
										.parseStrict(jsonResults);

								ListSolutionMatrixInterviews.list(jsonArray);
							}
						}
					});
		}
	}
}
