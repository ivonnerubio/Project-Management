package com.coffee.Coffee.views.list;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.coffee.Coffee.project.Project;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.awt.*;
import java.util.List;

public class ProjectForm extends FormLayout {
    TextField projectName = new TextField("Project Name");
    TextField type = new TextField("Type");
    TextField status = new TextField("Status");
    TextField geography = new TextField("Geography");
    TextField ownerOrg = new TextField("Owner Organization");


    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button cancel = new Button("Cancel");


    public ProjectForm(List<Project> projects) {
        addClassName("project-form");

        add(
                projectName,
                type,
                status,
                geography,
                ownerOrg,
                createButtonLayout()
        );
    }
    Button button = new Button("Themed button");

    private Component createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save,delete,cancel);
    }
}
