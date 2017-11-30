package com.xitaso.tdb.builder;

import com.xitaso.tdb.model.EndPoint;
import com.xitaso.tdb.model.ExecutionChart;
import com.xitaso.tdb.model.StartPoint;
import com.xitaso.tdb.model.block.Block;
import com.xitaso.tdb.model.controlflow.ControlFlowConnection;
import com.xitaso.tdb.model.controlflow.IControlFlowSource;
import com.xitaso.tdb.model.controlflow.IControlFlowTarget;
import com.xitaso.tdb.model.dataflow.IDataFlowSource;
import com.xitaso.tdb.model.dataflow.IDataFlowTarget;

import static java.util.Objects.nonNull;

public class ExecutionChartBuilder {
    public static ExecutionChartBuilder create() {
        return new ExecutionChartBuilder(new ExecutionChart());
    }

    private final ExecutionChart executionChart;

    private ExecutionChartBuilder(ExecutionChart executionChart) {
        this.executionChart = executionChart;
        this.executionChart.setStartPoint(new StartPoint());
    }

    public ExecutionChart get() {
        return this.executionChart;
    }

    public StartPoint getStartPoint() {
        return this.executionChart.getStartPoint();
    }

    public ExecutionChartBuilder addBlock(BlockBuilder blockBuilder) {
        Block block = blockBuilder.get();
        this.executionChart.addBlock(block);
        block.getResults().forEach(this::addControlFlowConnectionFromSource);
        addControlFlowConnectionFromTarget(block);
        block.getInput().forEach(this::addDataFlowConnectionFromTarget);
        block.getOutputs().forEach(this::addDataFlowConnectionFromSource);
        return this;
    }

    public ExecutionChartBuilder addEndPoint(EndPointBuilder endPointBuilder) {
        EndPoint endPoint = endPointBuilder.get();
        this.executionChart.addEndPoint(endPoint);
        addControlFlowConnectionFromTarget(endPoint);
        return this;
    }

    private void addControlFlowConnectionFromSource(IControlFlowSource source) {
        if (nonNull(source) && nonNull(source.getConnection())) {
            this.executionChart.addControlFlowConnection(source.getConnection());
        }
    }

    private void addControlFlowConnectionFromTarget(IControlFlowTarget target) {
        if (nonNull(target)) {
            target.getConnections().forEach(this.executionChart::addControlFlowConnection);
        }
    }

    private void addDataFlowConnectionFromSource(IDataFlowSource source) {
        if (nonNull(source)) {
            source.getConnections().forEach(this.executionChart::addDataFlowConnection);
        }
    }

    private void addDataFlowConnectionFromTarget(IDataFlowTarget target) {
        if (nonNull(target) && nonNull(target.getConnection())) {
            this.executionChart.addDataFlowConnection(target.getConnection());
        }
    }

    public ExecutionChartBuilder connect(IControlFlowSource source, BlockBuilder target) {
        final Block targetBlock = target.get();
        if (!this.executionChart.getBlocks().contains(targetBlock)) {
            throw new IllegalArgumentException("Can only connect Blocks that are already part of the chart");
        }
        // further semantic checks here

        final ControlFlowConnection connection = new ControlFlowConnection(source, targetBlock);
        connection.link();
        this.executionChart.addControlFlowConnection(connection);
        return this;
    }
}
