package com.xitaso.tdb.creator;

import com.xitaso.tdb.builder.BlockBuilder;
import com.xitaso.tdb.builder.BlockDataInputBuilder;
import com.xitaso.tdb.builder.EndPointBuilder;
import com.xitaso.tdb.builder.ExecutionChartBuilder;
import com.xitaso.tdb.model.ExecutionChart;
import com.xitaso.tdb.model.dataflow.DataType;

public class WithBuilders implements ITestChartCreator {
    @Override
    public ExecutionChart createTestChart1() {
        final ExecutionChartBuilder ecBuilder = ExecutionChartBuilder.create();

        // -----------------------------------------------------------------------------------

        final BlockBuilder b1Builder = BlockBuilder.create()
                .withName("Block 1")
                .addOutput("count", DataType.INT)
                .addResult("done")
                .connectedTo(ecBuilder.getStartPoint());
        ecBuilder.addBlock(b1Builder);

        // -----------------------------------------------------------------------------------

        final BlockBuilder b2Builder = BlockBuilder.create()
                .withName("Block 2")
                .addInput(BlockDataInputBuilder.create()
                        .withName("count")
                        .withType(DataType.INT)
                        .connectedTo(b1Builder.getOutputByName("count")))
                .addResult("exit")
                .addResult("loop")
                .connectedTo(b1Builder.getResultByName("done"));
        ecBuilder.addBlock(b2Builder);

        // -----------------------------------------------------------------------------------

        final EndPointBuilder e1Builder = EndPointBuilder.create().
                connectedTo(b2Builder.getResultByName("exit"));
        ecBuilder.addEndPoint(e1Builder);

        // -----------------------------------------------------------------------------------

        final BlockBuilder b3Builder = BlockBuilder.create()
                .withName("Block 3")
                .addOutput("value", DataType.FLOAT)
                .addResult("done")
                .connectedTo(b2Builder.getResultByName("loop"));
        ecBuilder.addBlock(b3Builder);

        // -----------------------------------------------------------------------------------

        final BlockBuilder b4Builder = BlockBuilder.create()
                .withName("Block 4")
                .addInput(BlockDataInputBuilder.create()
                        .withName("value")
                        .withType(DataType.FLOAT)
                        .connectedTo(b3Builder.getOutputByName("value")))
                .addInput(BlockDataInputBuilder.create()
                        .withName("count")
                        .withType(DataType.INT)
                        .connectedTo(b1Builder.getOutputByName("count")))
                .addResult("done")
                .addResult("repeat")
                .connectedTo(b3Builder.getResultByName("done"));
        ecBuilder.addBlock(b4Builder);

        ecBuilder.connect(b4Builder.getResultByName("repeat"), b3Builder);

        // -----------------------------------------------------------------------------------

        final EndPointBuilder e2Builder = EndPointBuilder.create()
                .connectedTo(b4Builder.getResultByName("done"));
        ecBuilder.addEndPoint(e2Builder);

        // -----------------------------------------------------------------------------------

        return ecBuilder.get();
    }
}
