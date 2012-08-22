package co.problemmatrix.client.interviews.persona.edit;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.problemmatrix.client.interviews.persona.ListPersonaInterviews;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SavePersonaInterview {

	public static void save(final JSONObject interview) {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		custDevService.savePersonaInterview(interview.toString(),
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(String unoUserJson) {

						String personaID = ConvertJson
								.convertToString(interview.get("persona"));

						ListPersonaInterviews.list(personaID);
					}
				});

	}
}
