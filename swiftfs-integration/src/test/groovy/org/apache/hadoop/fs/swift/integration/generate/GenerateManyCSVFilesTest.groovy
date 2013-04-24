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



package org.apache.hadoop.fs.swift.integration.generate

import groovy.util.logging.Commons
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.fs.swift.integration.IntegrationTestBase
import org.apache.hadoop.fs.swift.integration.tools.DataGenerator
import org.junit.Test

/**
 * This is an action to create a massive set of new files from 
 * a JUnit test case. This isn't the optimal way to do so
 * (hint: an MR job), but it means it can be 
 * done from a JUnit test where time can be measured easily
 */
@Commons
class GenerateManyCSVFilesTest extends IntegrationTestBase {


  @Test
  public void testGenerateCSV() throws Throwable {
    Path dataDir = new Path(DATASET_MASSIVE_CSV_PATH);
    Configuration conf = new Configuration();
    int lines = conf.getInt("test.fs.massive.lines", DEFAULT_TEST_LINES);
    int files = conf.getInt(KEY_TEST_FILES, DEFAULT_TEST_FILES);
    log.info("Writing ${lines} lines to $dataDir")

    DataGenerator generator = new DataGenerator(lines, DEFAULT_SEED);
    generateManyFiles(generator, dataDir, files)
  }

  def String filename(int fileindex) {
    String.format("data-%04d.csv", fileindex)
  }


}
