package com.xitaso.tdb.builder;

import com.xitaso.tdb.model.block.BlockDataInput;
import com.xitaso.tdb.model.dataflow.DataFlowConnection;
import com.xitaso.tdb.model.dataflow.DataType;
import com.xitaso.tdb.model.dataflow.IDataFlowSource;

public class BlockDataInputBuilder {
    public static BlockDataInputBuilder create() {
        return new BlockDataInputBuilder(new BlockDataInput());
    }

    private final BlockDataInput input;

    private BlockDataInputBuilder(BlockDataInput input) {
        this.input = input;
    }

    public BlockDataInputBuilder withName(String name) {
        this.input.setName(name);
        return this;
    }

    public BlockDataInputBuilder withType(DataType type) {
        this.input.setType(type);
        return this;
    }

    public BlockDataInputBuilder connectedTo(IDataFlowSource source) {
        final DataFlowConnection connection = new DataFlowConnection(source, this.input);
        connection.link();
        return this;
    }

    public BlockDataInput get() {
        return this.input;
    }
}
