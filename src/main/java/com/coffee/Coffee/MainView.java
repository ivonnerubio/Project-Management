package com.coffee.Coffee;

import com.coffee.Coffee.project.Project;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route("")
public class MainView extends VerticalLayout {

	Grid<Project> grid = new Grid<>(Project.class);
	TextField filterText = new TextField();

	public MainView(){
		addClassName("main-view");
		setSizeFull();
		configureGrid();

		add(grid);
	}


	private void configureGrid() {
		grid.addClassName("project-grid");
		grid.setSizeFull();
		grid.setColumns("id", "projectName", "status");
		grid.addColumn(project -> project.getId()).setHeader("ID");
		grid.addColumn(project -> project.getProjectName()).setHeader("Project Name");
		grid.addColumn(project -> project.getStatus()).setHeader("Status");
		grid.getColumns().forEach(col -> col.setAutoWidth(true));
	}

}