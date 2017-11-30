package com.xitaso.tdb.model.block;

import com.xitaso.tdb.model.Placeable;
import com.xitaso.tdb.model.controlflow.ControlFlowConnection;
import com.xitaso.tdb.model.controlflow.IControlFlowTarget;
import com.xitaso.tdb.util.Checks;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Block extends Placeable implements IControlFlowTarget {
    private String name;

    private final Set<BlockResult> results = new HashSet<>();
    private final Set<BlockDataInput> inputs = new HashSet<>();
    private final Set<BlockDataOutput> outputs = new HashSet<>();
    private final Set<ControlFlowConnection> connections = new HashSet<>();

    public Block() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Checks.nonEmpty(name);
    }


    public void addResult(BlockResult result) {
        this.results.add(Objects.requireNonNull(result));
    }

    public void removeResult(BlockResult result) {
        this.results.remove(result);
    }

    public Set<BlockResult> getResults() {
        return new HashSet<>(this.results);
    }

    public void addOutput(BlockDataOutput output) {
        this.outputs.add(Objects.requireNonNull(output));
    }

    public void removeOutput(BlockDataOutput output) {
        this.outputs.remove(output);
    }

    public Set<BlockDataOutput> getOutputs() {
        return new HashSet<>(this.outputs);
    }

    public void addInput(BlockDataInput input) {
        this.inputs.add(Objects.requireNonNull(input));
    }

    public void removeInput(BlockDataInput input) {
        this.inputs.remove(input);
    }

    public Set<BlockDataInput> getInput() {
        return new HashSet<>(this.inputs);
    }

    @Override
    public void addConnection(ControlFlowConnection connection) {
        this.connections.add(Objects.requireNonNull(connection));
    }

    @Override
    public void removeConnection(ControlFlowConnection connection) {
        this.connections.remove(connection);
    }

    @Override
    public Set<ControlFlowConnection> getConnections() {
        return new HashSet<>(this.connections);
    }
}
