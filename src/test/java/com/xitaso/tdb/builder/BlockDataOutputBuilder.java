package com.xitaso.tdb.builder;

import com.xitaso.tdb.model.block.BlockDataOutput;
import com.xitaso.tdb.model.dataflow.DataType;

public class BlockDataOutputBuilder {
    public static BlockDataOutputBuilder create() {
        return new BlockDataOutputBuilder(new BlockDataOutput());
    }

    private final BlockDataOutput output;

    private BlockDataOutputBuilder(BlockDataOutput output) {
        this.output = output;
    }

    public BlockDataOutput get() {
        return this.output;
    }

    public BlockDataOutputBuilder withName(String name) {
        this.output.setName(name);
        return this;
    }

    public BlockDataOutputBuilder withType(DataType type) {
        this.output.setType(type);
        return this;
    }
}
