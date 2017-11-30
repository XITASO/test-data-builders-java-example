package com.xitaso.tdb.model.block;

import com.xitaso.tdb.model.controlflow.ControlFlowConnection;
import com.xitaso.tdb.model.controlflow.IControlFlowSource;
import com.xitaso.tdb.util.Checks;

public class BlockResult implements IControlFlowSource {
    private String name;
    private ControlFlowConnection connection;

    public BlockResult() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Checks.nonEmpty(name);
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
