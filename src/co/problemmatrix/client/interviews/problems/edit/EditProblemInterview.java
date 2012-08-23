package co.problemmatrix.client.interviews.problems.edit;

import java.util.Date;

import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class EditProblemInterview extends VerticalPanel {

	public static TextBox companyField = new TextBox();

	public static TextBox interviewerField = new TextBox();

	public static TextBox personaField = new TextBox();

	public static DateBox dateTime = new DateBox();

	public static TextBox customerNameField = new TextBox();

	public static TextBox customerUniqueIDField = new TextBox();

	public static TextBox videoURLField = new TextBox();

	public static RichTextArea notes = new RichTextArea();

	public EditProblemInterview() {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String companyUniqueID = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("company"));

		if (companyUniqueID == null
				&& UniqueIDGlobalVariables.companyUniqueID != null) {

			companyUniqueID = ConvertJson
					.convertToString(UniqueIDGlobalVariables.companyUniqueID
							.get("ID"));

			ConvertJson.setStringValue(EditProblemInterviewPage.interview,
					companyUniqueID, "company");
		}

		companyField.setValue(companyUniqueID);
		this.add(FormField.getFormField("<font color=red>*</font> Company",
				companyField));

		String interviewerUniqueID = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("interviewer"));
		if (interviewerUniqueID == null
				&& UniqueIDGlobalVariables.uniqueID != null) {

			interviewerUniqueID = ConvertJson
					.convertToString(UniqueIDGlobalVariables.uniqueID.get("ID"));

			ConvertJson.setStringValue(EditProblemInterviewPage.interview,
					interviewerUniqueID, "interviewer");
		}
		interviewerField.setValue(interviewerUniqueID);
		this.add(FormField.getFormField("Interviewer", interviewerField));

		String persona = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("persona"));
		personaField.setValue(persona);
		this.add(FormField.getFormField("<font color=red>*</font> Persona",
				personaField));

		String date = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("datetime"));
		if (date == null) {
			dateTime.setValue(new Date());
		} else {
			dateTime.setValue(new Date(new Long(date)));
		}

		this.add(FormField.getFormField("<font color=red>*</font> Date",
				dateTime));

		String customerName = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("customerName"));
		customerNameField.setValue(customerName);
		this.add(FormField.getFormField(
				"<font color=red>*</font> Customer Name", customerNameField));

		String customerUniqueID = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("customerUniqueID"));
		customerUniqueIDField.setValue(customerUniqueID);
		this.add(FormField
				.getFormField(
						"Customer <a href='http://uniqueid.co' target='_blank'>UniqueID</a>",
						customerUniqueIDField));

		String videoURLValue = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("videoURL"));
		videoURLField.setValue(videoURLValue);
		this.add(FormField.getFormField("Interview's Video URL", videoURLField));
		videoURLField.setWidth("300px");

		String notesValue = ConvertJson
				.convertToString(EditProblemInterviewPage.interview
						.get("notes"));
		notes.setHTML(notesValue);
		this.add(FormField.getFormField("Interview Notes", notes));
		notes.setSize("300px", "100px");
	}
}
