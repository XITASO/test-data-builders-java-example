package com.xitaso.tdb.model.controlflow;

import static java.util.Objects.requireNonNull;

public class ControlFlowConnection {
    public final IControlFlowSource source;
    public final IControlFlowTarget target;

    public ControlFlowConnection(IControlFlowSource source, IControlFlowTarget target) {
        this.source = requireNonNull(source);
        this.target = requireNonNull(target);
    }

    public void link() {
        this.source.setConnection(this);
        this.target.addConnection(this);
    }
}
