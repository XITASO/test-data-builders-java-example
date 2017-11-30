package com.xitaso.tdb.builder;

import com.xitaso.tdb.model.block.BlockResult;

public class BlockResultBuilder {
    public static BlockResultBuilder create() {
        return new BlockResultBuilder(new BlockResult());
    }

    private final BlockResult result;

    private BlockResultBuilder(BlockResult result) {
        this.result = result;
    }

    public BlockResultBuilder withName(String name) {
        this.result.setName(name);
        return this;
    }

    public BlockResult get() {
        return this.result;
    }
}
