package com.coffee.Coffee.views;

import com.coffee.Coffee.project.Project;
import com.coffee.Coffee.project.ProjectRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

	private final ProjectRepository repo;
	final Grid<Project> grid;

	public MainView(ProjectRepository repo) {
		this.repo = repo;
		this.grid = new Grid<>(Project.class);
		add(grid);
		listProjects();
	}

	private void listProjects() {
		grid.setItems(repo.findAll());
	}

}