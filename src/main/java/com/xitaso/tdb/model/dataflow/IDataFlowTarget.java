package com.xitaso.tdb.model.dataflow;

public interface IDataFlowTarget {
    String getName();

    DataType getType();

    /**
     * May return null
     */
    DataFlowConnection getConnection();

    void setConnection(DataFlowConnection connection);
}
