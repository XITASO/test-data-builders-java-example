package com.xitaso.tdb;

import com.xitaso.tdb.creator.ITestChartCreator;
import com.xitaso.tdb.creator.PlainAndSimple;
import com.xitaso.tdb.creator.WithBuilders;
import com.xitaso.tdb.model.ExecutionChart;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {

    @Test
    public void modelTestPlain() {
        test(new PlainAndSimple());
    }

    @Test
    public void modelTestWithBuilders() {
        test(new WithBuilders());
    }

    private void test(ITestChartCreator chartCreator) {
        ExecutionChart chart = chartCreator.createTestChart1();

        assertNotNull(chart);
        assertEquals(7, chart.getControlFlowConnections().size());
        assertEquals(3, chart.getDataFlowConnections().size());
    }
}
