package com.datatorrent.app;

import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.common.util.BaseOperator;

public class OutputOperator extends BaseOperator
{
    public final transient DefaultInputPort<Object> input = new DefaultInputPort<Object>()
    {
        @Override
        public void process(Object t)
        {
            throw new RuntimeException("Error during process");
        }
    };
}
