package co.problemmatrix.client.interviews.persona.edit;

import java.util.Date;

import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class EditPersonaInterview extends VerticalPanel {
	
	public static TextBox companyField = new TextBox();

	public static TextBox interviewerField = new TextBox();

	public static DateBox dateTime = new DateBox();

	public static TextBox personaField = new TextBox();

	public static TextBox customerNameField = new TextBox();

	public static TextBox customerUniqueIDField = new TextBox();

	public static TextBox videoURLField = new TextBox();

	public static RichTextArea notes = new RichTextArea();

	public static RichTextArea problems = new RichTextArea();

	public EditPersonaInterview(JSONObject interview) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String interviewID = ConvertJson.convertToString(interview.get("ID"));

		String interviewerUniqueID = ConvertJson.convertToString(interview
				.get("interviewer"));

		String companyUniqueID = ConvertJson.convertToString(interview
				.get("company"));

		if (interviewID == null) {

			if (companyUniqueID == null
					&& UniqueIDGlobalVariables.companyUniqueID != null) {

				companyUniqueID = ConvertJson
						.convertToString(UniqueIDGlobalVariables.companyUniqueID
								.get("ID"));

				ConvertJson.setStringValue(interview, companyUniqueID,
						"company");
			}
			
			companyField.setValue(companyUniqueID);
			this.add(FormField.getFormField("Company", companyField));

			if (interviewerUniqueID == null
					&& UniqueIDGlobalVariables.uniqueID != null) {

				interviewerUniqueID = ConvertJson
						.convertToString(UniqueIDGlobalVariables.uniqueID
								.get("ID"));

				ConvertJson.setStringValue(interview, interviewerUniqueID,
						"interviewer");
			}
		}

		interviewerField.setValue(interviewerUniqueID);
		this.add(FormField.getFormField("Interviewer", interviewerField));

		String date = ConvertJson.convertToString(interview.get("datetime"));
		if (date == null) {
			dateTime.setValue(new Date());
		} else {
			dateTime.setValue(new Date(new Long(date)));
		}

		this.add(FormField.getFormField("<font color=red>*</font> Date",
				dateTime));

		String personaID = ConvertJson
				.convertToString(interview.get("persona"));
		personaField.setValue(personaID);
		this.add(FormField.getFormField("<font color=red>*</font> Persona",
				personaField));

		String customerName = ConvertJson.convertToString(interview
				.get("customerName"));
		customerNameField.setValue(customerName);
		this.add(FormField.getFormField(
				"<font color=red>*</font> Customer Name", customerNameField));

		String customerUniqueID = ConvertJson.convertToString(interview
				.get("customerUniqueID"));
		customerUniqueIDField.setValue(customerUniqueID);
		this.add(FormField.getFormField("Customer UniqueID",
				customerUniqueIDField));

		String videoURLValue = ConvertJson.convertToString(interview
				.get("videoURL"));
		videoURLField.setValue(videoURLValue);
		this.add(FormField.getFormField("Video URL", videoURLField));
		videoURLField.setWidth("300px");

		String problemsValue = ConvertJson.convertToString(interview
				.get("problems"));
		problems.setHTML(problemsValue);
		this.add(FormField.getFormField("Main Problems<br>(comma separated)",
				problems));
		problems.setSize("300px", "60px");

		String notesValue = ConvertJson.convertToString(interview.get("notes"));
		notes.setHTML(notesValue);
		this.add(FormField.getFormField("Notes", notes));
		notes.setSize("300px", "100px");
	}
}
