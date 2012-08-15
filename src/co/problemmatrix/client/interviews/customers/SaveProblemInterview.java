package co.problemmatrix.client.interviews.customers;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SaveProblemInterview {

	public static void save() {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		custDevService.saveProblemInterview(
				CustomerProblemInterview.interview.toString(),
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(String unoUserJson) {

						// Home.vpMain.clear();
						// Home.vpMain.add(new Home());
					}
				});

	}
}
