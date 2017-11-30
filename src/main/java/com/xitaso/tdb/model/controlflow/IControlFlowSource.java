package com.xitaso.tdb.model.controlflow;

public interface IControlFlowSource {
    /**
     * May return null
     */
    ControlFlowConnection getConnection();

    void setConnection(ControlFlowConnection connection);
}
