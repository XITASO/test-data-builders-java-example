package com.xitaso.tdb.model.dataflow;

import static java.util.Objects.requireNonNull;

public class DataFlowConnection {
    public final IDataFlowSource source;
    public final IDataFlowTarget target;

    public DataFlowConnection(IDataFlowSource source, IDataFlowTarget target) {
        this.source = requireNonNull(source);
        this.target = requireNonNull(target);
    }

    public void link() {
        this.source.addConnection(this);
        this.target.setConnection(this);
    }
}
