package com.datatorrent.app;

import com.datatorrent.lib.io.fs.AbstractReconciler;

public class OutputOperator extends AbstractReconciler<String, String>
{

    @Override
    protected void processTuple(String s) {
        enqueueForProcessing(s);
    }

    @Override
    protected void processCommittedData(String s) {
        throw new RuntimeException("Error: Unable to ProcessCommittedData");
    }
}
