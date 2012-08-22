package co.problemmatrix.client.interviews.problems.edit;

import co.problemmatrix.client.home.ProblemMatrixPanel;
import co.problemmatrix.client.utilities.UseTracking;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;

public class AddProblemInterviewButton extends Button {

	public AddProblemInterviewButton() {

		this.setText("ADD INTERVIEW");

		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking(this.getClass().getName());

				ProblemMatrixPanel.vpMain.clear();
				ProblemMatrixPanel.vpMain.add(new EditProblemInterviewPage(
						new JSONObject()));
			}
		});
	}

}
