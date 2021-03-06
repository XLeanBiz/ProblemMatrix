package co.problemmatrix.client.interviews.persona.edit;

import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditPersonaInterviewQuestions extends VerticalPanel {

	public static RichTextArea describeYourself = new RichTextArea();

	public static RichTextArea routine = new RichTextArea();

	public static RichTextArea goals = new RichTextArea();

	public static RichTextArea mainProblems = new RichTextArea();

	public static RichTextArea findOthers = new RichTextArea();

	public static RichTextArea openComments = new RichTextArea();

	public EditPersonaInterviewQuestions(JSONObject interview,
			final boolean shortInterview) {

		this.setSpacing(20);

		String personaName = ConvertJson.convertToString(interview
				.get("persona"));

		String describeYourselfValue = ConvertJson.convertToString(interview
				.get("describeYourself"));
		describeYourself.setHTML(describeYourselfValue);
		describeYourself.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"How do you <b>describe yourself</b> as " + personaName + "?",
				describeYourself));
		describeYourself.setSize("500px", "80px");

		String routineValue = ConvertJson.convertToString(interview
				.get("routine"));
		routine.setHTML(routineValue);

		if (!shortInterview) {

			routine.addClickHandler(getClickHandler());
			this.add(FormField.getVerticalFormField(
					"What are your <b>main activities</b> as " + personaName + "?",
					routine));
			routine.setSize("500px", "80px");
		}

		String goalsValue = ConvertJson.convertToString(interview.get("goals"));
		goals.setHTML(goalsValue);

		if (!shortInterview) {
			goals.addClickHandler(getClickHandler());
			this.add(FormField
					.getVerticalFormField("What are <b>your goals</b> as "
							+ personaName + "?", goals));
			goals.setSize("500px", "80px");
		}

		String mainProblemsValue = ConvertJson.convertToString(interview
				.get("mainProblems"));
		mainProblems.setHTML(mainProblemsValue);
		mainProblems.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"What are your <b>main problems</b> as " + personaName + "?",
				mainProblems));
		mainProblems.setSize("500px", "80px");

		String findOthersValue = ConvertJson.convertToString(interview
				.get("findOthers"));
		findOthers.setHTML(findOthersValue);

		if (!shortInterview) {

			findOthers.addClickHandler(getClickHandler());
			this.add(FormField
					.getVerticalFormField("How can I <b>find other</b> "
							+ personaName + " like you?", findOthers));
			findOthers.setSize("500px", "80px");
		}

		String openCommentsValue = ConvertJson.convertToString(interview
				.get("openComments"));
		openComments.setHTML(openCommentsValue);
		openComments.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField("Do you have any comments?", openComments));
		openComments.setSize("500px", "80px");
	}

	public static ClickHandler getClickHandler() {

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ButtonSavePersonaInterview.prepareInterviewJson();
				ButtonSavePersonaInterview.getInterviewQuestions();
				SavePersonaInterviewField.save();
			}
		};

		return clickHandler;
	}
}
