package com.xitaso.tdb.model;

import com.xitaso.tdb.model.block.Block;
import com.xitaso.tdb.model.controlflow.ControlFlowConnection;
import com.xitaso.tdb.model.dataflow.DataFlowConnection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ExecutionChart {
    private StartPoint startPoint;
    private final Set<EndPoint> endPoints = new HashSet<>();
    private final Set<Block> blocks = new HashSet<>();
    private final Set<ControlFlowConnection> controlFlowConnections = new HashSet<>();
    private final Set<DataFlowConnection> dataFlowConnections = new HashSet<>();

    public ExecutionChart() {
    }

    public StartPoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(StartPoint startPoint) {
        this.startPoint = Objects.requireNonNull(startPoint);
    }

    public void addEndPoint(EndPoint endPoint) {
        this.endPoints.add(Objects.requireNonNull(endPoint));
    }

    public void removeEndPoint(EndPoint endPoint) {
        this.endPoints.remove(endPoint);
    }

    public Set<EndPoint> getEndPoints() {
        return new HashSet<>(this.endPoints);
    }

    public void addBlock(Block block) {
        this.blocks.add(Objects.requireNonNull(block));
    }

    public void removeBlock(Block block) {
        this.blocks.remove(block);
    }

    public Set<Block> getBlocks() {
        return new HashSet<>(this.blocks);
    }

    public void addControlFlowConnection(ControlFlowConnection controlFlowConnection) {
        this.controlFlowConnections.add(Objects.requireNonNull(controlFlowConnection));
    }

    public void removeControlFlowConnection(ControlFlowConnection controlFlowConnection) {
        this.controlFlowConnections.remove(controlFlowConnection);
    }

    public Set<ControlFlowConnection> getControlFlowConnections() {
        return new HashSet<>(this.controlFlowConnections);
    }

    public void addDataFlowConnection(DataFlowConnection dataFlowConnection) {
        this.dataFlowConnections.add(Objects.requireNonNull(dataFlowConnection));
    }

    public void removeDataFlowConnection(DataFlowConnection dataFlowConnection) {
        this.dataFlowConnections.remove(dataFlowConnection);
    }

    public Set<DataFlowConnection> getDataFlowConnections() {
        return new HashSet<>(this.dataFlowConnections);
    }
}
