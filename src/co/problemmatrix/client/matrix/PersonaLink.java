package co.problemmatrix.client.matrix;

import co.problemmatrix.client.persona.GetPersona;
import co.problemmatrix.client.utilities.UseTracking;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

public class PersonaLink extends HTML {

	public PersonaLink(final String persona) {

		this.setHTML("<a href=#><b><font color=black>" + persona + "</font></b></a>");
		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking(this.getClass().getName());

				GetPersona.get(persona);
			}
		});

	}
}
