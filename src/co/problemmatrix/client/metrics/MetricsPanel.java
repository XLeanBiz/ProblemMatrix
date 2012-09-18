package co.problemmatrix.client.metrics;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MetricsPanel extends VerticalPanel {

	public MetricsPanel(final int mustHaveProblemCount,
			final int mustHaveSolutionCount, final int earlyAdoptersCount) {

		this.add(mustHaveProblemBar(mustHaveProblemCount));

		this.add(mustHaveSolutionBar(mustHaveSolutionCount));

		this.add(earlyAdoptersBar(earlyAdoptersCount));

	}

	private HorizontalPanel mustHaveProblemBar(final int mustHaveProblemCount) {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		HTML title = new HTML("Must Have <b>Problem</b>: ");
		title.setWidth("130px");
		title.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		hp.add(title);

		Grid bar = new Grid(1, 12);

		bar.setWidth("100px");
		bar.getRowFormatter().setStyleName(0, "metricBarGray");

		for (int i = 0; ((i < 12) && (i < mustHaveProblemCount)); i++) {

			bar.getCellFormatter().setStyleName(0, i, "metricBarBlue");
		}

		hp.add(bar);

		return hp;
	}

	private HorizontalPanel mustHaveSolutionBar(final int mustHaveSolutionCount) {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		HTML title = new HTML("Must Have <b>Solution</b>: ");
		title.setWidth("130px");
		title.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		hp.add(title);

		Grid bar = new Grid(1, 12);

		bar.setWidth("100px");
		bar.getRowFormatter().setStyleName(0, "metricBarGray");

		for (int i = 0; ((i < 12) && (i < mustHaveSolutionCount)); i++) {

			bar.getCellFormatter().setStyleName(0, i, "metricBarBlue");
		}

		hp.add(bar);

		return hp;
	}

	private HorizontalPanel earlyAdoptersBar(final int earlyAdoptersCount) {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		HTML title = new HTML("<b>Early Adopters</b>: ");
		title.setWidth("130px");
		title.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		hp.add(title);

		Grid bar = new Grid(1, 5);

		bar.setWidth("100px");
		bar.getRowFormatter().setStyleName(0, "metricBarGray");

		for (int i = 0; ((i < 5) && (i < earlyAdoptersCount)); i++) {

			bar.getCellFormatter().setStyleName(0, i, "metricBarBlue");
		}

		hp.add(bar);

		return hp;
	}
}