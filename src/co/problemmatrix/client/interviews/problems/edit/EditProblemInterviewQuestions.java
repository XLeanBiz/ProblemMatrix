package co.problemmatrix.client.interviews.problems.edit;

import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditProblemInterviewQuestions extends VerticalPanel {

	public static TextBox problemField = new TextBox();

	public static RichTextArea problemUnderstand = new RichTextArea();

	public static RichTextArea whyHaveProblem = new RichTextArea();

	public static ProblemRateListbox problemRateField;

	public static RichTextArea howSolvingProblem = new RichTextArea();

	public static RichTextArea howLikeSolvingProblem = new RichTextArea();

	public static RichTextArea make5Problem = new RichTextArea();

	public static RichTextArea openComments = new RichTextArea();

	public EditProblemInterviewQuestions(final boolean shortInterview) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String problem = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("problem"));
		problemField.setValue(problem);
		problemField.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"<font color=red>*</font> Problem", problemField));
		problemField.setWidth("500px");

		String problemUnderstandValue = ConvertJson.getStringValue(
				EditProblemInterviewPage.interview, "problemUnderstand");
		problemUnderstand.setHTML(problemUnderstandValue);
		problemUnderstand.addClickHandler(getClickHandler());
		this.add(FormField
				.getVerticalFormField(
						"What does this problem <b>mean</b> to you?",
						problemUnderstand));
		problemUnderstand.setSize("500px", "80px");

		String problemRate = ConvertJson.getStringValue(
				EditProblemInterviewPage.interview, "problemRate");
		problemRateField = new ProblemRateListbox(problemRate);
		problemRateField.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"How do you <b>rate</b> this problem?", problemRateField));

		String whyHaveProblemValue = ConvertJson.getStringValue(
				EditProblemInterviewPage.interview, "whyHaveProblem");
		whyHaveProblem.setHTML(whyHaveProblemValue);
		whyHaveProblem.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField("<b>Why</b>?", whyHaveProblem));
		whyHaveProblem.setSize("500px", "80px");

		String make5ProblemValue = ConvertJson.getStringValue(
				EditProblemInterviewPage.interview, "make5Problem");
		make5Problem.setHTML(make5ProblemValue);

		if (!shortInterview) {

			make5Problem.addClickHandler(getClickHandler());
			this.add(FormField
					.getVerticalFormField(
							"What will make this problem as you <b>MUST HAVE</b> a solution for it?",
							make5Problem));
			make5Problem.setSize("500px", "80px");
		}

		String howSolvingProblemValue = ConvertJson.getStringValue(
				EditProblemInterviewPage.interview, "howSolvingProblem");
		howSolvingProblem.setHTML(howSolvingProblemValue);

		if (!shortInterview) {

			howSolvingProblem.addClickHandler(getClickHandler());
			this.add(FormField.getVerticalFormField(
					"How are you <b>solving</b> this problem today?",
					howSolvingProblem));
			howSolvingProblem.setSize("500px", "80px");
		}

		String howLikeSolvingProblemValue = ConvertJson.getStringValue(
				EditProblemInterviewPage.interview, "howLikeSolvingProblem");
		howLikeSolvingProblem.setHTML(howLikeSolvingProblemValue);
		howLikeSolvingProblem.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"How would you <b>like</b> this problem to be <b>solved</b>?",
				howLikeSolvingProblem));
		howLikeSolvingProblem.setSize("500px", "80px");

		String openCommentsValue = ConvertJson.getStringValue(
				EditProblemInterviewPage.interview, "openComments");
		openComments.setHTML(openCommentsValue);
		openComments.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField("Comments?", openComments));
		openComments.setSize("500px", "80px");
	}

	public static ClickHandler getClickHandler() {

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ButtonSaveProblemInterview.getInterviewInformation();
				ButtonSaveProblemInterview.getInterviewQuestions();
				SaveProblemInterviewField.save();
			}
		};

		return clickHandler;
	}
}
