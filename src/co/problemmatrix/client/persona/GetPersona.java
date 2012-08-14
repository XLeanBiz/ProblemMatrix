package co.problemmatrix.client.persona;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.problemmatrix.client.home.ProblemMatrixPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetPersona {

	public static void get(final String name) {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		custDevService.getPersona(name, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResult) {

				if (jsonResult != null && !jsonResult.equals("")) {

					JSONObject persona = (JSONObject) JSONParser
							.parseStrict(jsonResult);

					ProblemMatrixPanel.vpMain.clear();
					ProblemMatrixPanel.vpMain.add(new ShowPersona(persona));
				}
			}
		});
	}

}
