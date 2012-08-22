package co.problemmatrix.client.interviews.problems.customers;

import co.problemmatrix.client.interviews.problems.edit.ProblemRateListbox;
import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomerProblemInterview extends VerticalPanel {

	public static JSONObject interview = new JSONObject();

	public static TextBox customerNameField = new TextBox();

	public static TextBox problemNameField = new TextBox();

	public static RichTextArea problemUnderstand = new RichTextArea();

	public static RichTextArea haveProblem = new RichTextArea();

	public static RichTextArea whyHaveProblem = new RichTextArea();

	public static ProblemRateListbox problemRateField;

	public static RichTextArea howSolvingProblem = new RichTextArea();

	public static RichTextArea make5Problem = new RichTextArea();

	public static RichTextArea howLikeSolvingProblem = new RichTextArea();

	public static RichTextArea openComments = new RichTextArea();

	public CustomerProblemInterview(final String problemName) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String customerName = ConvertJson.convertToString(interview
				.get("customerName"));
		customerNameField.setValue(customerName);
		customerNameField.addClickHandler(getClickHandler());
		this.add(FormField.getFormField("Interviewee", customerNameField));
		customerNameField.setWidth("300px");

		// String problem = ConvertJson
		// .convertToString(InitializeInterviewDatabase.companyData
		// .get("Problem"));
		problemNameField.setValue(problemName);
		problemNameField.addClickHandler(getClickHandler());
		this.add(FormField.getFormField("Problem", problemNameField));
		problemNameField.setWidth("300px");

		String problemUnderstandValue = ConvertJson.convertToString(interview
				.get("problemUnderstand"));
		problemUnderstand.setHTML(problemUnderstandValue);
		problemUnderstand.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"What do you understand from this problem?", problemUnderstand));
		problemUnderstand.setSize("500px", "80px");

		String haveProblemValue = ConvertJson.convertToString(interview
				.get("haveProblem"));
		haveProblem.setHTML(haveProblemValue);
		haveProblem.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField("Do you have this problem?",
				haveProblem));
		haveProblem.setSize("500px", "80px");

		String whyHaveProblemValue = ConvertJson.convertToString(interview
				.get("whyHaveProblem"));
		whyHaveProblem.setHTML(whyHaveProblemValue);
		whyHaveProblem.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField("Why?", whyHaveProblem));
		whyHaveProblem.setSize("500px", "80px");

		String problemRate = ConvertJson.convertToString(interview
				.get("problemRate"));
		problemRateField = new ProblemRateListbox(problemRate);
		problemRateField.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"How do you rate this problem?", problemRateField));

		String make5ProblemValue = ConvertJson.convertToString(interview
				.get("make5Problem"));
		make5Problem.setHTML(make5ProblemValue);
		make5Problem.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"What will make this problem a 5?", make5Problem));
		make5Problem.setSize("500px", "80px");

		String howSolvingProblemValue = ConvertJson.convertToString(interview
				.get("howSolvingProblem"));
		howSolvingProblem.setHTML(howSolvingProblemValue);
		howSolvingProblem.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"How are you solving this problem today?", howSolvingProblem));
		howSolvingProblem.setSize("500px", "80px");

		String howLikeSolvingProblemValue = ConvertJson.getStringValue(
				interview, "howLikeSolvingProblem");
		howLikeSolvingProblem.setHTML(howLikeSolvingProblemValue);
		howLikeSolvingProblem.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"How would you like this problem to be solved?",
				howLikeSolvingProblem));
		howLikeSolvingProblem.setSize("500px", "80px");

		String openCommentsValue = ConvertJson.convertToString(interview
				.get("openComments"));
		openComments.setHTML(openCommentsValue);
		openComments.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField("Comments?", openComments));
		openComments.setSize("500px", "80px");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveProblemInterview());
	}

	private ClickHandler getClickHandler() {

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ButtonSaveProblemInterview.prepareInterviewJson();
				SaveProblemInterviewField.save();
			}
		};

		return clickHandler;
	}
}
