package co.problemmatrix.client.interviews.solution.edit;

import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditSolutionInterviewQuestions extends VerticalPanel {

	public static TextBox solutionField = new TextBox();

	public static RichTextArea solutionUnderstand = new RichTextArea();

	public static SolutionRateListbox solutionRateField;

	public static RichTextArea whyHaveSolution = new RichTextArea();

	public static RichTextArea makeMustHaveSolution = new RichTextArea();

	public static RichTextArea howTryingSolution = new RichTextArea();

	public static RichTextArea openComments = new RichTextArea();

	public EditSolutionInterviewQuestions(JSONObject interview,
			final boolean shortInterview) {

		this.setSpacing(20);

		String solution = ConvertJson
				.convertToString(EditSolutionInterviewPage.interview
						.get("solution"));
		solutionField.setValue(solution);
		solutionField.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"<font color=red>*</font> Solution", solutionField));
		solutionField.setWidth("500px");

		String solutionUnderstandValue = ConvertJson.getStringValue(
				EditSolutionInterviewPage.interview, "solutionUnderstand");
		solutionUnderstand.setHTML(solutionUnderstandValue);
		solutionUnderstand.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField(
				"What does this solution <b>mean</b> to you?",
				solutionUnderstand));
		solutionUnderstand.setSize("500px", "80px");

		String solutionRate = ConvertJson.getStringValue(
				EditSolutionInterviewPage.interview, "solutionRate");
		solutionRateField = new SolutionRateListbox(solutionRate);

		if (!shortInterview) {

			solutionRateField.addClickHandler(getClickHandler());
			this.add(FormField.getVerticalFormField(
					"How do you <b>rate</b> this solution?", solutionRateField));
		}

		String whyHaveSolutionValue = ConvertJson.getStringValue(
				EditSolutionInterviewPage.interview, "whyHaveSolution");
		whyHaveSolution.setHTML(whyHaveSolutionValue);

		if (!shortInterview) {

			whyHaveSolution.addClickHandler(getClickHandler());
			this.add(FormField.getVerticalFormField("<b>Why</b>?",
					whyHaveSolution));
			whyHaveSolution.setSize("500px", "80px");
		}

		String makeMustHaveSolutionValue = ConvertJson.getStringValue(
				EditSolutionInterviewPage.interview, "makeMustHaveSolution");
		makeMustHaveSolution.setHTML(makeMustHaveSolutionValue);

		if (!shortInterview) {

			makeMustHaveSolution.addClickHandler(getClickHandler());
			this.add(FormField.getVerticalFormField(
					"What will make this solution a <b>MUST HAVE</b> for you?",
					makeMustHaveSolution));
			makeMustHaveSolution.setSize("500px", "80px");
		}

		String howTryingValue = ConvertJson.getStringValue(
				EditSolutionInterviewPage.interview, "howTryingSolution");
		howTryingSolution.setHTML(howTryingValue);
		howTryingSolution.addClickHandler(getClickHandler());
		this.add(FormField
				.getVerticalFormField(
						"How do you like to start <b>trying</b> this solution, if you do?",
						howTryingSolution));
		howTryingSolution.setSize("500px", "80px");

		String openCommentsValue = ConvertJson
				.convertToString(EditSolutionInterviewPage.interview
						.get("openComments"));
		openComments.setHTML(openCommentsValue);
		openComments.addClickHandler(getClickHandler());
		this.add(FormField.getVerticalFormField("Comments?", openComments));
		openComments.setSize("500px", "80px");
	}

	public static ClickHandler getClickHandler() {

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ButtonSaveSolutionInterview.prepareInterviewJson();
				ButtonSaveSolutionInterview.getInterviewQuestions();
				SaveSolutionInterviewField.save();
			}
		};

		return clickHandler;
	}
}
