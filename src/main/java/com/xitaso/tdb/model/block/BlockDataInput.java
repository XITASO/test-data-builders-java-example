package com.xitaso.tdb.model.block;

import com.xitaso.tdb.model.dataflow.DataFlowConnection;
import com.xitaso.tdb.model.dataflow.DataType;
import com.xitaso.tdb.model.dataflow.IDataFlowTarget;
import com.xitaso.tdb.util.Checks;

import java.util.Objects;

public class BlockDataInput implements IDataFlowTarget {
    private String name;
    private DataType type;
    private DataFlowConnection connection;

    public BlockDataInput() {
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
    public DataFlowConnection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(DataFlowConnection connection) {
        this.connection = connection;
    }
}
