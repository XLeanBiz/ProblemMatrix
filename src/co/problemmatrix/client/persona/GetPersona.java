package co.problemmatrix.client.persona;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetPersona {

	public static void get(final String persona) {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		custDevService.getPersona(persona, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResult) {

				ProblemMatrixPanel.vpButtons.clear();
				ProblemMatrixPanel.vpMain.clear();

				if (jsonResult != null && !jsonResult.equals("")) {

					JSONObject personaJson = (JSONObject) JSONParser
							.parseStrict(jsonResult);

					String personaID = ConvertJson.convertToString(personaJson
							.get("ID"));

					ProblemMatrixPanel.vpButtons.add(new ButtonEditPersona(
							personaJson));

					if (personaID != null) {

						ProblemMatrixPanel.vpMain.add(new ShowPersona(
								personaJson));

					} else {

						ConvertJson.setStringValue(personaJson, persona, "ID");

						ProblemMatrixPanel.vpMain.add(new EditPersona(
								personaJson));
					}

				}
			}
		});
	}

}
