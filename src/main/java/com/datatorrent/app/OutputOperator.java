package com.datatorrent.app;

import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.Operator;
import com.datatorrent.common.util.BaseOperator;

public class OutputOperator extends BaseOperator
{
    protected long wId = 0;

    @Override
    public void beginWindow(long windowId) {
        wId++;
    }

    public final transient DefaultInputPort<Object> input = new DefaultInputPort<Object>()
    {
        @Override
        public void process(Object t)
        {
            if(wId % 40 == 0)
            {
                throw new RuntimeException("Error during process");
            }
        }
    };
}
