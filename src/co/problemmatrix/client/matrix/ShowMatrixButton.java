package co.problemmatrix.client.matrix;

import co.problemmatrix.client.utilities.UseTracking;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ShowMatrixButton extends Button {

	public ShowMatrixButton() {

		this.setText("Matrix");

		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking(this.getClass().getName());

				ListProblemMatrixInterviews.list();
			}
		});
	}

}
