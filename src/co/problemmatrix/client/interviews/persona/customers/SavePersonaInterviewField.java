package co.problemmatrix.client.interviews.persona.customers;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SavePersonaInterviewField {

	public static void save() {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		custDevService.savePersonaInterview(
				CustomerPersonaInterview.interview.toString(),
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(String unoUserJson) {

						String interviewID = ConvertJson
								.convertToString(CustomerPersonaInterview.interview
										.get("ID"));

						if (interviewID == null) {

							interviewID = unoUserJson;

							ConvertJson.setStringValue(
									CustomerPersonaInterview.interview,
									interviewID, "ID");
						}

					}
				});

	}
}
