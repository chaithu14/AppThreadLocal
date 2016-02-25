/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.datatorrent.app;

import org.apache.hadoop.conf.Configuration;
import com.datatorrent.lib.testbench.RandomEventGenerator;
import com.datatorrent.api.DAG;
import com.datatorrent.api.StreamingApplication;
import com.datatorrent.api.annotation.ApplicationAnnotation;


@ApplicationAnnotation(name="Demo")
public class Application implements StreamingApplication
{
    @Override
    public void populateDAG(DAG dag, Configuration conf)
    {
        RandomEventGenerator rand = dag.addOperator("rand", new RandomEventGenerator());
        OutputOperator output = dag.addOperator("output", new OutputOperator());
        dag.addStream("Process", rand.string_data,output.input).setLocality(DAG.Locality.THREAD_LOCAL);
    }

}