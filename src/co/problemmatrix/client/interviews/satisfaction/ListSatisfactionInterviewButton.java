package co.problemmatrix.client.interviews.satisfaction;

import co.problemmatrix.client.utilities.UseTracking;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ListSatisfactionInterviewButton extends Button {

	public ListSatisfactionInterviewButton() {

		this.setText("Interviews");

		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking(this.getClass().getName());

				ListSatisfactionInterviews.list();
			}
		});
	}

}
