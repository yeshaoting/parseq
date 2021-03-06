/*
 * Copyright 2016 LinkedIn, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.linkedin.restli.client;

import java.util.Collections;
import java.util.Optional;

import org.testng.annotations.Test;

import com.linkedin.restli.client.config.BatchingConfig;
import com.linkedin.restli.client.config.ParSeqRestClientConfig;
import com.linkedin.restli.client.config.ResourceConfig;


public class TestParSeqRestClientBatchingDryRun extends ParSeqRestClientIntegrationTest {

  @Override
  public ParSeqRestClientConfig getParSeqRestClientGonfig() {
    //default batching config is: batching
    BatchingConfig defaultBatchingConfig = new BatchingConfig(true, 1024, true);
    ResourceConfig defaultResourceConfig = new ResourceConfig(Collections.emptyMap(), Optional.empty(), defaultBatchingConfig);
    return new ParSeqRestClientConfig(Collections.emptyMap(), defaultResourceConfig);
  }

  @Test
  public void testGetRequestsAreBatched() {
    testGetRequests(this.getClass().getName() + ".testGetRequestsAreBatched", true);
  }

  @Test
  public void testGetRequestsAreBatchedWithError() {
    testGetRequestsWithError(this.getClass().getName() + ".testGetRequestsAreBatchedWithError", true);
  }

  @Test
  public void testBatchGetRequestsAreBatched() {
    testBatchGetRequests(this.getClass().getName() + ".testBatchGetRequestsAreBatched", true);
  }

  @Test
  public void testGetAndBatchGetRequestsAreBatched() {
    testGetAndBatchGetRequests(this.getClass().getName() + ".testGetAndBatchGetRequestsAreBatched", true);
  }

  @Test
  public void testSingleGetRequestIsNotBatched() {
    testSingleGetRequestIsNotBatched(this.getClass().getName() + ".testSingleGetRequestIsNotBatched");
  }

  @Test
  public void testDuplicateGetRequestIsNotBatched() {
    testDuplicateGetRequestIsNotBatched(this.getClass().getName() + ".testDuplicateGetRequestIsNotBatched");
  }
}
