package com.xitaso.tdb.model;

import com.xitaso.tdb.model.controlflow.ControlFlowConnection;
import com.xitaso.tdb.model.controlflow.IControlFlowTarget;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EndPoint extends Placeable implements IControlFlowTarget {
    private final Set<ControlFlowConnection> connections = new HashSet<>();

    @Override
    public void addConnection(ControlFlowConnection connection) {
        this.connections.add(Objects.requireNonNull(connection));
    }

    @Override
    public void removeConnection(ControlFlowConnection connection) {
        this.connections.remove(connection);
    }

    @Override
    public Set<ControlFlowConnection> getConnections() {
        return new HashSet<>(this.connections);
    }
}
