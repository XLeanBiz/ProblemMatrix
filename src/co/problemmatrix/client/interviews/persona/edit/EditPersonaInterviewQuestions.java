package co.problemmatrix.client.interviews.persona.edit;

import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

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

	public EditPersonaInterviewQuestions(JSONObject interview) {

		this.setSpacing(20);

		String personaName = ConvertJson.convertToString(interview
				.get("persona"));

		String describeYourselfValue = ConvertJson.convertToString(interview
				.get("describeYourself"));
		describeYourself.setHTML(describeYourselfValue);
		this.add(FormField.getVerticalFormField(
				"How do you <b>describe yourself</b> as " + personaName + "?",
				describeYourself));
		describeYourself.setSize("500px", "80px");

		String routineValue = ConvertJson.convertToString(interview
				.get("routine"));
		routine.setHTML(routineValue);
		this.add(FormField.getVerticalFormField(
				"How is <b>your routine</b> as " + personaName + "?", routine));
		routine.setSize("500px", "80px");

		String goalsValue = ConvertJson.convertToString(interview.get("goals"));
		goals.setHTML(goalsValue);
		this.add(FormField.getVerticalFormField(
				"What are <b>your goals</b> as " + personaName + "?", goals));
		goals.setSize("500px", "80px");

		String mainProblemsValue = ConvertJson.convertToString(interview
				.get("mainProblems"));
		mainProblems.setHTML(mainProblemsValue);
		this.add(FormField.getVerticalFormField(
				"What are your <b>main problems</b> as " + personaName + "?",
				mainProblems));
		mainProblems.setSize("500px", "80px");

		String findOthersValue = ConvertJson.convertToString(interview
				.get("findOthers"));
		findOthers.setHTML(findOthersValue);
		this.add(FormField.getVerticalFormField("How can I <b>find other</b> "
				+ personaName + " like you?", findOthers));
		findOthers.setSize("500px", "80px");

		String openCommentsValue = ConvertJson.convertToString(interview
				.get("openComments"));
		openComments.setHTML(openCommentsValue);
		this.add(FormField.getVerticalFormField("Comments?", openComments));
		openComments.setSize("500px", "80px");
	}
}
