package co.problemmatrix.client.persona;

import co.problemmatrix.client.utilities.FormField;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditPersona extends VerticalPanel {

	public static TextBox customerSegment = new TextBox();

	public static TextBox name = new TextBox();

	public static TextBox imageURL = new TextBox();

	public static RichTextArea behaviors = new RichTextArea();

	public static RichTextArea demographics = new RichTextArea();

	public static RichTextArea needs = new RichTextArea();

	public static RichTextArea goals = new RichTextArea();

	public static RichTextArea problems = new RichTextArea();

	public static RichTextArea whereToFind = new RichTextArea();

	public EditPersona(JSONObject personaJson) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		String personaName = ConvertJson.convertToString(personaJson.get("ID"));
		customerSegment.setValue(personaName);
		this.add(FormField.getFormField(
				"<font color=red>*</font> Persona Type", customerSegment));
		customerSegment.setWidth("500px");
		
		String nickName = ConvertJson.convertToString(personaJson.get("name"));
		name.setValue(nickName);
		this.add(FormField.getFormField(
				"Persona Name", name));
		name.setWidth("500px");

		String imageURLValue = ConvertJson.convertToString(personaJson
				.get("imageURL"));
		imageURL.setValue(imageURLValue);
		this.add(FormField.getFormField("Image URL", imageURL));
		imageURL.setWidth("500px");

		HorizontalPanel hp = new HorizontalPanel();

		String demographicsValue = ConvertJson.convertToString(personaJson
				.get("demographics"));
		demographics.setHTML(demographicsValue);
		hp.add(FormField.getFormField("Demographics", demographics));
		demographics.setSize("250px", "100px");

		String behaviorsValue = ConvertJson.convertToString(personaJson
				.get("behaviors"));
		behaviors.setHTML(behaviorsValue);
		hp.add(FormField.getFormField("Behaviors", behaviors));
		behaviors.setSize("250px", "100px");

		String whereToFindValue = ConvertJson.convertToString(personaJson
				.get("whereToFind"));
		whereToFind.setHTML(whereToFindValue);
		hp.add(FormField.getFormField("Where to Find", whereToFind));
		whereToFind.setSize("250px", "100px");

		this.add(hp);

		HorizontalPanel hp1 = new HorizontalPanel();

		String goalsValue = ConvertJson.convertToString(personaJson
				.get("goals"));
		goals.setHTML(goalsValue);
		hp1.add(FormField.getFormField("Goals", goals));
		goals.setSize("250px", "100px");

		String needsValue = ConvertJson.convertToString(personaJson
				.get("needs"));
		needs.setHTML(needsValue);
		hp1.add(FormField.getFormField("Needs", needs));
		needs.setSize("250px", "100px");

		String problemsValue = ConvertJson.convertToString(personaJson
				.get("problems"));
		problems.setHTML(problemsValue);
		hp1.add(FormField.getFormField("Problems", problems));
		problems.setSize("250px", "100px");

		this.add(hp1);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSavePersona(personaJson));
	}

}
