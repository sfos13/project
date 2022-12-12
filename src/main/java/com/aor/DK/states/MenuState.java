package com.aor.DK.states;

import com.aor.DK.viewer.MenuViewer;
import com.aor.DK.viewer.Viewer;
import com.aor.DK.controller.Controller;
import com.aor.DK.controller.menu.MenuController;
import com.aor.DK.model.menu.Menu;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    public Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    public Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}