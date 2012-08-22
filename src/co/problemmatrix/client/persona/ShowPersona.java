package co.problemmatrix.client.persona;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ShowPersona extends VerticalPanel {

	public ShowPersona(JSONObject personaJson) {

		this.setSpacing(20);

		String personaName = ConvertJson.convertToString(personaJson.get("ID"));
		if (personaName != null) {

			HTML name = new HTML("<font color=blue size=4><b>"
					+ personaName.toUpperCase() + "</b></font>");
			this.add(name);
		}

		String nickName = ConvertJson.convertToString(personaJson.get("name"));
		if (nickName != null) {

			HTML nickNameHTML = new HTML(
					"<font color=red size=4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>"
							+ nickName.toUpperCase() + "</b></font>");
			this.add(nickNameHTML);
		}

		this.add(new Label(" "));

		HorizontalPanel hp = new HorizontalPanel();
		hp.setWidth("700px");

		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		String imageURLValue = ConvertJson.convertToString(personaJson
				.get("imageURL"));

		HTML img = new HTML("<img src='" + imageURLValue + "' border=0>");
		hp.add(img);

		FlexTable table = new FlexTable();

		table.setWidth("500px");

		String demographicsValue = ConvertJson.convertToString(personaJson
				.get("demographics"));
		VerticalPanel vpDemo = new VerticalPanel();
		vpDemo.setSize("250px", "100px");
		vpDemo.add(new HTML("<b>Demographics</b>"));
		vpDemo.add(new HTML("<blockquote>" + demographicsValue
				+ "</blockquote>"));
		table.setWidget(0, 0, vpDemo);

		String behaviorsValue = ConvertJson.convertToString(personaJson
				.get("behaviors"));
		VerticalPanel vpBehavior = new VerticalPanel();
		vpBehavior.setSize("250px", "100px");
		vpBehavior.add(new HTML("<b>Behaviors</b>"));
		vpBehavior.add(new HTML("<blockquote>" + behaviorsValue
				+ "</blockquote>"));
		table.setWidget(0, 2, vpBehavior);

		String whereToFindValue = ConvertJson.convertToString(personaJson
				.get("whereToFind"));
		VerticalPanel vpWhereToFind = new VerticalPanel();
		vpWhereToFind.setSize("250px", "100px");
		vpWhereToFind.add(new HTML("<b>Where to Find</b>"));
		vpWhereToFind.add(new HTML("<blockquote>" + whereToFindValue
				+ "</blockquote>"));
		table.setWidget(0, 4, vpWhereToFind);

		table.setHTML(1, 0, "<hr>");
		table.setHTML(1, 2, "<hr>");
		table.setHTML(1, 4, "<hr>");

		String goalsValue = ConvertJson.convertToString(personaJson
				.get("goals"));
		VerticalPanel vpGoals = new VerticalPanel();
		vpGoals.setSize("250px", "100px");
		vpGoals.add(new HTML("<b>Goals</b>"));
		vpGoals.add(new HTML("<blockquote>" + goalsValue + "</blockquote>"));
		table.setWidget(2, 0, vpGoals);

		String needsValue = ConvertJson.convertToString(personaJson
				.get("needs"));
		VerticalPanel vpNeeds = new VerticalPanel();
		vpNeeds.setSize("250px", "100px");
		vpNeeds.add(new HTML("<b>Needs</b>"));
		vpNeeds.add(new HTML("<blockquote>" + needsValue + "</blockquote>"));
		table.setWidget(2, 2, vpNeeds);

		String problemsValue = ConvertJson.convertToString(personaJson
				.get("problems"));
		VerticalPanel vpProblems = new VerticalPanel();
		vpProblems.setSize("250px", "100px");
		vpProblems.add(new HTML("<b>Problems</b>"));
		vpProblems.add(new HTML("<blockquote>" + problemsValue
				+ "</blockquote>"));
		table.setWidget(2, 4, vpProblems);

		hp.add(table);
		this.add(hp);
	}

}
