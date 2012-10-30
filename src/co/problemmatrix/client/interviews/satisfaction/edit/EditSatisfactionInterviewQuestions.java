package co.problemmatrix.client.interviews.satisfaction.edit;

import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditSatisfactionInterviewQuestions extends VerticalPanel {

	public static TextBox featureField = new TextBox();

	public static SatisfactionRateListbox satisfactionRateField;

	public static RichTextArea whyFeature = new RichTextArea();

	public static RichTextArea improveFeature = new RichTextArea();

	public static RichTextArea disappointedNoFeature = new RichTextArea();

	public static RichTextArea openComments = new RichTextArea();

	public EditSatisfactionInterviewQuestions(JSONObject interview,
			final boolean shortInterview) {

		this.setSpacing(20);

		String solution = ConvertJson
				.convertToString(EditSatisfactionInterviewPage.interview
						.get("feature"));
		featureField.setValue(solution);
		featureField.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"<font color=red>*</font> Feature", featureField));
		featureField.setWidth("500px");

		String satisfactionRate = ConvertJson.getStringValue(
				EditSatisfactionInterviewPage.interview, "satisfactionRate");
		satisfactionRateField = new SatisfactionRateListbox(satisfactionRate);
		satisfactionRateField.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"How do you <b>rate</b> this feature?", satisfactionRateField));
		String whyValue = ConvertJson.getStringValue(
				EditSatisfactionInterviewPage.interview, "whyFeature");
		whyFeature.setHTML(whyValue);

		whyFeature.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField("<b>Why</b>?", whyFeature));
		whyFeature.setSize("500px", "80px");
		String improveValue = ConvertJson.getStringValue(
				EditSatisfactionInterviewPage.interview, "improveFeature");
		improveFeature.setHTML(improveValue);
		improveFeature.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"How can we <b>improve</b> this feature?", improveFeature));
		improveFeature.setSize("500px", "80px");

		String disappointedValue = ConvertJson.getStringValue(
				EditSatisfactionInterviewPage.interview,
				"disappointedNoFeature");
		disappointedNoFeature.setHTML(disappointedValue);
		disappointedNoFeature.addClickHandler(getClickHandler());
		this.add(FormField
				.getVerticalFormField(
						"<b>How disappointed</b> would you be if you no longer can use this feature?",
						disappointedNoFeature));
		disappointedNoFeature.setSize("500px", "80px");

		String openCommentsValue = ConvertJson
				.convertToString(EditSatisfactionInterviewPage.interview
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

				ButtonSaveSatisfactionInterview.prepareInterviewJson();
				ButtonSaveSatisfactionInterview.getInterviewQuestions();
				SaveSatisfactionInterviewField.save();
			}
		};

		return clickHandler;
	}
}
