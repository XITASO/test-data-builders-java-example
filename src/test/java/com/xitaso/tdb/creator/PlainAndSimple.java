package com.xitaso.tdb.creator;

import com.xitaso.tdb.model.EndPoint;
import com.xitaso.tdb.model.ExecutionChart;
import com.xitaso.tdb.model.StartPoint;
import com.xitaso.tdb.model.block.Block;
import com.xitaso.tdb.model.block.BlockDataInput;
import com.xitaso.tdb.model.block.BlockDataOutput;
import com.xitaso.tdb.model.block.BlockResult;
import com.xitaso.tdb.model.controlflow.ControlFlowConnection;
import com.xitaso.tdb.model.dataflow.DataFlowConnection;
import com.xitaso.tdb.model.dataflow.DataType;

public class PlainAndSimple implements ITestChartCreator {
    @Override
    public ExecutionChart createTestChart1() {
        final ExecutionChart ec = new ExecutionChart();

        final StartPoint sp = new StartPoint();
        ec.setStartPoint(sp);

        // -----------------------------------------------------------------------------------

        final Block b1 = new Block();
        b1.setName("Block 1");
        ec.addBlock(b1);
        final BlockDataOutput o1 = new BlockDataOutput();
        o1.setName("count");
        o1.setType(DataType.INT);
        b1.addOutput(o1);
        final BlockResult r1 = new BlockResult();
        r1.setName("done");
        b1.addResult(r1);

        final ControlFlowConnection cf_s1 = new ControlFlowConnection(sp, b1);
        cf_s1.link();
        ec.addControlFlowConnection(cf_s1);

        // -----------------------------------------------------------------------------------

        final Block b2 = new Block();
        b2.setName("Block 2");
        ec.addBlock(b2);
        final BlockDataInput i2 = new BlockDataInput();
        i2.setName("count");
        i2.setType(DataType.INT);
        b2.addInput(i2);
        final BlockResult r2a = new BlockResult();
        r2a.setName("exit");
        b2.addResult(r2a);
        final BlockResult r2b = new BlockResult();
        r2b.setName("loop");
        b2.addResult(r2b);

        final ControlFlowConnection cf_12 = new ControlFlowConnection(r1, b2);
        cf_12.link();
        ec.addControlFlowConnection(cf_12);

        final DataFlowConnection df_12 = new DataFlowConnection(o1, i2);
        df_12.link();
        ec.addDataFlowConnection(df_12);

        // -----------------------------------------------------------------------------------

        final EndPoint e1 = new EndPoint();
        ec.addEndPoint(e1);

        final ControlFlowConnection cf_2e1 = new ControlFlowConnection(r2a, e1);
        cf_2e1.link();
        ec.addControlFlowConnection(cf_2e1);

        // -----------------------------------------------------------------------------------

        final Block b3 = new Block();
        b3.setName("Block 3");
        ec.addBlock(b3);
        final BlockDataOutput o3 = new BlockDataOutput();
        o3.setName("value");
        o3.setType(DataType.FLOAT);
        b3.addOutput(o3);
        final BlockResult r3 = new BlockResult();
        r3.setName("done");
        b3.addResult(r3);

        final ControlFlowConnection cf_23 = new ControlFlowConnection(r2b, b3);
        cf_23.link();
        ec.addControlFlowConnection(cf_23);

        // -----------------------------------------------------------------------------------

        final Block b4 = new Block();
        b4.setName("Block 4");
        ec.addBlock(b4);
        final BlockDataInput i4a = new BlockDataInput();
        i4a.setName("value");
        i4a.setType(DataType.FLOAT);
        b4.addInput(i4a);
        final BlockDataInput i4b = new BlockDataInput();
        i4b.setName("count");
        i4b.setType(DataType.INT);
        b4.addInput(i4b);
        final BlockResult r4a = new BlockResult();
        r4a.setName("done");
        b4.addResult(r4a);
        final BlockResult r4b = new BlockResult();
        r4b.setName("repeat");
        b4.addResult(r4b);

        final ControlFlowConnection cf_34 = new ControlFlowConnection(r3, b4);
        cf_34.link();
        ec.addControlFlowConnection(cf_34);

        final ControlFlowConnection cf_43 = new ControlFlowConnection(r4b, b3);
        cf_43.link();
        ec.addControlFlowConnection(cf_43);

        final DataFlowConnection df_34 = new DataFlowConnection(o3, i4a);
        df_34.link();
        ec.addDataFlowConnection(df_34);

        final DataFlowConnection df_14 = new DataFlowConnection(o1, i4b);
        df_14.link();
        ec.addDataFlowConnection(df_14);

        // -----------------------------------------------------------------------------------

        final EndPoint e2 = new EndPoint();
        ec.addEndPoint(e2);

        final ControlFlowConnection cf_4e2 = new ControlFlowConnection(r4a, e2);
        cf_4e2.link();
        ec.addControlFlowConnection(cf_4e2);

        // -----------------------------------------------------------------------------------

        return ec;
    }
}
