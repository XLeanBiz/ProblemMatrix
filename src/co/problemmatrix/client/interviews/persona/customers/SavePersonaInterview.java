package co.problemmatrix.client.interviews.persona.customers;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.problemmatrix.client.interviews.persona.ListPersonaInterviews;
import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterviewPage;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SavePersonaInterview {

	public static void save() {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		custDevService.savePersonaInterview(
				EditPersonaInterviewPage.interview.toString(),
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(String unoUserJson) {

						String personaID = ConvertJson
								.convertToString(EditPersonaInterviewPage.interview
										.get("persona"));

						ListPersonaInterviews.list(personaID);
					}
				});

	}
}
