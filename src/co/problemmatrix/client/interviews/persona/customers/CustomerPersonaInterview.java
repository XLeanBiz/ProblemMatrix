package co.problemmatrix.client.interviews.persona.customers;

import co.problemmatrix.client.interviews.persona.edit.EditPersonaInterviewQuestions;
import co.problemmatrix.client.interviews.problems.customers.ButtonSaveProblemInterview;
import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerPersonaInterview extends VerticalPanel {

	public static JSONObject interview = new JSONObject();

	public static TextBox customerNameField = new TextBox();

	public CustomerPersonaInterview(final String persona) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		ConvertJson.setStringValue(CustomerPersonaInterview.interview, persona,
				"persona");

		String customerName = ConvertJson.convertToString(interview
				.get("customerName"));
		customerNameField.setValue(customerName);
		customerNameField.addClickHandler(getClickHandler());
		this.add(FormField.getFormField("Interviewee", customerNameField));
		customerNameField.setWidth("300px");

		this.add(new EditPersonaInterviewQuestions(interview));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveProblemInterview());
	}

	private ClickHandler getClickHandler() {

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ButtonSavePersonaInterview.prepareInterviewJson();
				SavePersonaInterviewField.save();
			}
		};

		return clickHandler;
	}
}
