package com.xitaso.tdb.builder;

import com.xitaso.tdb.model.EndPoint;
import com.xitaso.tdb.model.controlflow.ControlFlowConnection;
import com.xitaso.tdb.model.controlflow.IControlFlowSource;

public class EndPointBuilder {
    public static EndPointBuilder create() {
        return new EndPointBuilder(new EndPoint());
    }

    private final EndPoint endPoint;

    private EndPointBuilder(EndPoint endPoint) {
        this.endPoint = endPoint;
    }

    public EndPointBuilder connectedTo(IControlFlowSource source) {
        final ControlFlowConnection connection = new ControlFlowConnection(source, this.endPoint);
        connection.link();
        return this;
    }

    public EndPoint get() {
        return this.endPoint;
    }
}
