package com.coffee.Coffee.views.list;

import com.coffee.Coffee.project.Project;
import com.coffee.Coffee.project.ProjectRepository;
import com.coffee.Coffee.project.ProjectService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import java.util.Collections;

@Route()
public class ListView extends VerticalLayout {

    final Grid<Project> grid;
    private final ProjectRepository repo;
    private ProjectService service;
    TextField filterText = new TextField();
    ProjectForm form;


    public ListView(ProjectRepository repo) {
        this.repo = repo;
        setSizeFull();

      //  configureGrid();
       configureForm();

        this.grid = new Grid<>(Project.class);

       add(
                  getToolbar(),
                  getContent()
        );

        listProjects();
   //     updateList();
    }

    private void updateList() {
        grid.setItems(service.findAllProjects(filterText.getValue()));
    }


    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form);
        content.setFlexGrow(2,grid);
        content.setFlexGrow(1, form);
        content.addClassName("content");
        content.setSizeFull();

        return content;
    }

    private void configureForm() {
        form = new ProjectForm(repo.findAll());
        form.setWidth("25em");

    }

    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("Status", "Project Name");
        grid.addColumn(project -> project.getStatus()).setHeader("Status");
        grid.addColumn(project -> project.getProjectName()).setHeader("Project Name");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addContactButton = new Button("Add project");

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void listProjects() {
        grid.setItems(repo.findAll());
    }

}