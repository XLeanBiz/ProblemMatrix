package co.problemmatrix.client.interviews.earlyadopters.edit;

import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditEarlyAdoptersInterviewQuestions extends VerticalPanel {

	public static TextBox solutionField = new TextBox();

	public static EarlyAdoptersRateListbox earlyAdopterRateField;

	public static RichTextArea whyEarlyAdopter = new RichTextArea();

	public static RichTextArea threeMeetings = new RichTextArea();

	public static TextBox emailEarlyAdopter = new TextBox();

	public static RichTextArea mustHaveFeatures = new RichTextArea();

	public static RichTextArea openComments = new RichTextArea();

	public EditEarlyAdoptersInterviewQuestions(JSONObject interview,
			final boolean shortInterview) {

		this.setSpacing(20);

		String solution = ConvertJson
				.convertToString(EditEarlyAdoptersInterviewPage.interview
						.get("solution"));
		solutionField.setValue(solution);
		solutionField.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"<font color=red>*</font> Solution", solutionField));
		solutionField.setWidth("500px");

		String earlyAdopterRate = ConvertJson.getStringValue(
				EditEarlyAdoptersInterviewPage.interview, "earlyAdopterRate");
		earlyAdopterRateField = new EarlyAdoptersRateListbox(earlyAdopterRate);
		earlyAdopterRateField.addClickHandler(getClickHandler());
		this.add(FormField
				.getVerticalFormField(
						"Would you like to be an <b>Early Adopter</b> for this solution?",
						earlyAdopterRateField));

		String whyEarlyAdopterValue = ConvertJson.getStringValue(
				EditEarlyAdoptersInterviewPage.interview, "whyEarlyAdopter");
		whyEarlyAdopter.setHTML(whyEarlyAdopterValue);

		whyEarlyAdopter.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField("<b>Why</b>?", whyEarlyAdopter));
		whyEarlyAdopter.setSize("500px", "80px");

		String emailEarlyAdopterValue = ConvertJson.getStringValue(
				EditEarlyAdoptersInterviewPage.interview, "emailEarlyAdopter");
		emailEarlyAdopter.setValue(emailEarlyAdopterValue);
		emailEarlyAdopter.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"If Yes, can you please provide your <b>e-mail</b>?",
				emailEarlyAdopter));
		emailEarlyAdopter.setWidth("500px");

		String threeMeetingsValue = ConvertJson.getStringValue(
				EditEarlyAdoptersInterviewPage.interview, "threeMeetings");
		threeMeetings.setHTML(threeMeetingsValue);
		threeMeetings.addClickHandler(getClickHandler());
		this.add(FormField
				.getVerticalFormField(
						"If Yes, when can we have the first <b>three meetings</b> about this solution?",
						threeMeetings));
		threeMeetings.setSize("500px", "80px");

		String mustHaveFeaturesValue = ConvertJson.getStringValue(
				EditEarlyAdoptersInterviewPage.interview, "mustHaveFeatures");
		mustHaveFeatures.setHTML(mustHaveFeaturesValue);
		mustHaveFeatures.addClickHandler(getClickHandler());
		this.add(FormField
				.getVerticalFormField(
						"If Yes, what <b>part</b>(s) of this solution is a MUST HAVE for you?",
						mustHaveFeatures));
		mustHaveFeatures.setSize("500px", "80px");

		String openCommentsValue = ConvertJson
				.convertToString(EditEarlyAdoptersInterviewPage.interview
						.get("openComments"));
		openComments.setHTML(openCommentsValue);
		openComments.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField("Do you have any comments?",
				openComments));
		openComments.setSize("500px", "80px");
	}

	public static ClickHandler getClickHandler() {

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ButtonSaveEarlyAdoptersInterview.prepareInterviewJson();
				ButtonSaveEarlyAdoptersInterview.getInterviewQuestions();
				SaveEarlyAdoptersInterviewField.save();
			}
		};

		return clickHandler;
	}
}
