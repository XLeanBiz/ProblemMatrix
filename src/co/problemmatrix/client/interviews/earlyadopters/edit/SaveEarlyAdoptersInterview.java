package co.problemmatrix.client.interviews.earlyadopters.edit;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.problemmatrix.client.interviews.earlyadopters.ListEarlyAdoptersInterviews;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SaveEarlyAdoptersInterview {

	public static void save(final JSONObject interview) {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		custDevService.saveEarlyAdoptersInterview(interview.toString(),
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(String unoUserJson) {

						String solutionID = ConvertJson
								.convertToString(interview.get("solution"));

						ListEarlyAdoptersInterviews.list(solutionID);
					}
				});

	}
}
