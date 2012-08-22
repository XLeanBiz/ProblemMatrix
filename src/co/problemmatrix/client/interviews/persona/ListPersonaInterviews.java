package co.problemmatrix.client.interviews.persona;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.interviews.persona.edit.AddPersonaInterviewButton;
import co.problemmatrix.client.persona.ButtonShowPersona;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListPersonaInterviews {

	public static void list(final String persona) {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		custDevService.listPersonaInterviews(persona,
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
									.add(new PersonaInterviewsListPanel(
											jsonArray));

							ProblemMatrixPanel.hpButtons.clear();
							ProblemMatrixPanel.hpButtons
									.add(new ButtonShowPersona(persona));
							ProblemMatrixPanel.hpButtons
									.add(new AddPersonaInterviewButton(persona));
						}
					}
				});
	}

}
