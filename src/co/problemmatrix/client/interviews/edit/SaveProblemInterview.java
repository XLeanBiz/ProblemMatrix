package co.problemmatrix.client.interviews.edit;

import co.problemmatrix.client.interviews.StartupDataService;
import co.problemmatrix.client.interviews.StartupDataServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SaveProblemInterview {

	public static void save(final JSONObject interview) {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		custDevService.saveProblemInterview(interview.toString(),
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(String unoUserJson) {

						
					}
				});

	}
}
