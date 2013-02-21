

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *       http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.hadoop.fs.swift.integration.pig

import org.junit.Test
import org.apache.pig.ExecType
import org.apache.pig.PigServer
import org.apache.pig.impl.PigContext
import org.apache.pig.impl.util.PropertiesUtil

public class TestPig {

  @Test
  public void testCreateServerInstance() throws Throwable {
    Properties properties = PropertiesUtil.loadDefaultProperties()
    PigContext context = new PigContext(ExecType.LOCAL,
                                        properties)
    PigServer pig = new PigServer(ExecType.LOCAL);
//    pig.registerScript("/path/to/test.pig");
  }
}
