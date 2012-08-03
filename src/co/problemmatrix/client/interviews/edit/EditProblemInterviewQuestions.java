package co.problemmatrix.client.interviews.edit;

import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditProblemInterviewQuestions extends VerticalPanel {

	public static TextBox problemField = new TextBox();

	public static RichTextArea problemUnderstand = new RichTextArea();

	public static RichTextArea haveProblem = new RichTextArea();

	public static RichTextArea whyHaveProblem = new RichTextArea();

	public static ProblemRateListbox problemRateField;

	public static RichTextArea howSolvingProblem = new RichTextArea();

	public static RichTextArea howLikeSolvingProblem = new RichTextArea();

	public static RichTextArea make5Problem = new RichTextArea();

	public static RichTextArea openComments = new RichTextArea();

	public EditProblemInterviewQuestions(JSONObject interview) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String problem = ConvertJson.convertToString(interview.get("problem"));
		problemField.setValue(problem);
		this.add(FormField.getVerticalFormField(
				"<font color=red>*</font> Problem", problemField));
		problemField.setWidth("500px");

		String problemUnderstandValue = ConvertJson.getStringValue(interview,
				"problemUnderstand");
		problemUnderstand.setHTML(problemUnderstandValue);
		this.add(FormField.getVerticalFormField(
				"What do you understand from this problem?", problemUnderstand));
		problemUnderstand.setSize("500px", "80px");

		String haveProblemValue = ConvertJson.getStringValue(interview,
				"haveProblem");
		haveProblem.setHTML(haveProblemValue);
		this.add(FormField.getVerticalFormField("Do you have this problem?",
				haveProblem));
		haveProblem.setSize("500px", "80px");

		String whyHaveProblemValue = ConvertJson.getStringValue(interview,
				"whyHaveProblem");
		whyHaveProblem.setHTML(whyHaveProblemValue);
		this.add(FormField.getVerticalFormField("Why?", whyHaveProblem));
		whyHaveProblem.setSize("500px", "80px");

		String problemRate = ConvertJson.getStringValue(interview,
				"problemRate");
		problemRateField = new ProblemRateListbox(problemRate);
		this.add(FormField.getVerticalFormField(
				"How do you rate this problem?", problemRateField));

		String make5ProblemValue = ConvertJson.getStringValue(interview,
				"make5Problem");
		make5Problem.setHTML(make5ProblemValue);
		this.add(FormField.getVerticalFormField(
				"What will make this problem a 5?", make5Problem));
		make5Problem.setSize("500px", "80px");

		String howSolvingProblemValue = ConvertJson.getStringValue(interview,
				"howSolvingProblem");
		howSolvingProblem.setHTML(howSolvingProblemValue);
		this.add(FormField.getVerticalFormField(
				"How are you solving this problem today?", howSolvingProblem));
		howSolvingProblem.setSize("500px", "80px");

		String howLikeSolvingProblemValue = ConvertJson.getStringValue(
				interview, "howLikeSolvingProblem");
		howLikeSolvingProblem.setHTML(howLikeSolvingProblemValue);
		this.add(FormField.getVerticalFormField(
				"How would you like this problem to be solved?",
				howLikeSolvingProblem));
		howLikeSolvingProblem.setSize("500px", "80px");

		String openCommentsValue = ConvertJson.getStringValue(interview,
				"openComments");
		openComments.setHTML(openCommentsValue);
		this.add(FormField.getVerticalFormField("Comments?", openComments));
		openComments.setSize("500px", "80px");
	}
}
