package com.xitaso.tdb.model.block;

import com.xitaso.tdb.model.dataflow.DataFlowConnection;
import com.xitaso.tdb.model.dataflow.DataType;
import com.xitaso.tdb.model.dataflow.IDataFlowSource;
import com.xitaso.tdb.util.Checks;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BlockDataOutput implements IDataFlowSource {
    private String name;
    private DataType type;
    private final Set<DataFlowConnection> connections = new HashSet<>();

    public BlockDataOutput() {
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Checks.nonEmpty(name);
    }

    @Override
    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = Objects.requireNonNull(type);
    }

    @Override
    public void addConnection(DataFlowConnection connection) {
        this.connections.add(Objects.requireNonNull(connection));
    }

    @Override
    public void removeConnection(DataFlowConnection connection) {
        this.connections.remove(connection);
    }

    @Override
    public Set<DataFlowConnection> getConnections() {
        return new HashSet<>(this.connections);
    }
}
