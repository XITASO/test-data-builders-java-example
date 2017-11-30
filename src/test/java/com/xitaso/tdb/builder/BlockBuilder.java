package com.xitaso.tdb.builder;

import com.xitaso.tdb.model.block.Block;
import com.xitaso.tdb.model.block.BlockDataOutput;
import com.xitaso.tdb.model.block.BlockResult;
import com.xitaso.tdb.model.controlflow.ControlFlowConnection;
import com.xitaso.tdb.model.controlflow.IControlFlowSource;
import com.xitaso.tdb.model.dataflow.DataType;

public class BlockBuilder {
    public static BlockBuilder create() {
        return new BlockBuilder(new Block());
    }

    private final Block block;

    private BlockBuilder(Block block) {
        this.block = block;
    }

    public BlockBuilder withName(String name) {
        this.block.setName(name);
        return this;
    }

    public BlockBuilder addOutput(String name, DataType type) {
        final BlockDataOutputBuilder outputBuilder = BlockDataOutputBuilder.create()
                .withName(name)
                .withType(type);
        this.block.addOutput(outputBuilder.get());
        return this;
    }

    public BlockBuilder addResult(String name) {
        final BlockResultBuilder resultBuilder = BlockResultBuilder.create()
                .withName(name);
        this.block.addResult(resultBuilder.get());
        return this;
    }

    public BlockBuilder connectedTo(IControlFlowSource source) {
        final ControlFlowConnection connection = new ControlFlowConnection(source, this.block);
        connection.link();
        return this;
    }

    public Block get() {
        return this.block;
    }

    public BlockDataOutput getOutputByName(String name) {
        return this.block.getOutputs().stream()
                .filter((output) -> output.getName().equals(name))
                .findAny()
                .get();
    }

    public BlockBuilder addInput(BlockDataInputBuilder inputBuilder) {
        this.block.addInput(inputBuilder.get());
        return this;
    }

    public BlockResult getResultByName(String name) {
        return this.block.getResults().stream()
                .filter((result) -> result.getName().equals(name))
                .findAny()
                .get();
    }
}
