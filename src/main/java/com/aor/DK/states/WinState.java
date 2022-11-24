package com.aor.DK.states;

import com.aor.DK.Viewer.Viewer;
import com.aor.DK.Viewer.WinViewer;
import com.aor.DK.controller.Controller;
import com.aor.DK.controller.menu.MenuController;
import com.aor.DK.controller.menu.WinController;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.model.menu.WinMenu;

public class WinState extends State<WinMenu>{


    public WinState(WinMenu model) {
        super(model);
    }

    @Override
    protected Viewer<WinMenu> getViewer() {
        return new WinViewer(getModel());
    }

    @Override
    protected Controller<WinMenu> getController() {
        return new WinController(getModel());
    }
}

