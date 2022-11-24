package com.aor.DK.states;

import com.aor.DK.Viewer.MenuViewer;
import com.aor.DK.Viewer.Viewer;
import com.aor.DK.controller.Controller;
import com.aor.DK.controller.menu.MenuController;
import com.aor.DK.model.menu.Menu;

public class WinState extends State<Menu> {
    public WinState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}

