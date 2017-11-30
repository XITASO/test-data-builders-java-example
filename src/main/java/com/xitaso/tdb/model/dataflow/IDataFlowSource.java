package com.xitaso.tdb.model.dataflow;

import java.util.Set;

public interface IDataFlowSource {
    String getName();

    DataType getType();

    void addConnection(DataFlowConnection connection);

    void removeConnection(DataFlowConnection connection);

    Set<DataFlowConnection> getConnections();
}
