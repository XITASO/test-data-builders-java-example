package com.xitaso.tdb.model;

import com.xitaso.tdb.model.controlflow.ControlFlowConnection;
import com.xitaso.tdb.model.controlflow.IControlFlowSource;

public class StartPoint extends Placeable implements IControlFlowSource {
    private ControlFlowConnection connection;

    public StartPoint() {
    }

    @Override
    public ControlFlowConnection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(ControlFlowConnection connection) {
        this.connection = connection;
    }
}
