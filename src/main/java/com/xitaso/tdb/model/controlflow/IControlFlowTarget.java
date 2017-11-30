package com.xitaso.tdb.model.controlflow;

import java.util.Set;

public interface IControlFlowTarget {
    void addConnection(ControlFlowConnection connection);

    void removeConnection(ControlFlowConnection connection);

    Set<ControlFlowConnection> getConnections();
}
