package co.problemmatrix.client.interviews.earlyadopters.customers;

import co.problemmatrix.client.StartupDataService;
import co.problemmatrix.client.StartupDataServiceAsync;
import co.problemmatrix.client.interviews.earlyadopters.edit.EditEarlyAdoptersInterviewPage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SaveEarlyAdoptersInterview {

	public static void save() {

		final StartupDataServiceAsync custDevService = GWT
				.create(StartupDataService.class);

		custDevService.saveEarlyAdoptersInterview(
				EditEarlyAdoptersInterviewPage.interview.toString(),
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(String unoUserJson) {

						Window.alert("THANK YOU VERY MUCH FOR YOUR ANSWERS!");
					}
				});

	}
}
