/**
 *    Retz
 *    Copyright (C) 2016 Nautilus Technologies, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package io.github.retz.protocol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.retz.protocol.data.ResourceQuantity;

public class StatusResponse extends Response {
    private int queueLength;
    private int runningLength;
    private ResourceQuantity totalUsed;
    private int numSlaves; // TODO: use this value in report
    private int offers;
    private ResourceQuantity totalOffered;
    private final String version;

    @JsonCreator
    public StatusResponse(@JsonProperty("queueLength") int queueLength,
                          @JsonProperty("runningLength") int runningLength,
                          @JsonProperty("totalUsed") ResourceQuantity totalUsed,
                          @JsonProperty("numSlaves") int numSlaves,
                          @JsonProperty("offers") int offers,
                          @JsonProperty("totalOffered") ResourceQuantity totalOffered,
                          @JsonProperty("version") String version) {
        this.queueLength = queueLength;
        this.runningLength = runningLength;
        this.totalUsed = totalUsed;
        this.numSlaves = numSlaves;
        this.offers = offers;
        this.totalOffered = totalOffered;
        this.version = version;
    }

    public StatusResponse(String version) {
        this.ok();
        this.version = version;
        totalOffered = new ResourceQuantity();
        totalUsed = new ResourceQuantity();
    }

    @JsonGetter("queueLength")
    public int queueLength() {
        return queueLength;
    }

    @JsonGetter("runningLength")
    public int runningLength() {
        return runningLength;
    }

    @JsonGetter("totalUsed")
    public ResourceQuantity totalUsed() {
        return totalUsed;
    }

    @JsonGetter("numSlaves")
    public int numSlaves() {
        return numSlaves;
    }

    @JsonGetter("offers")
    public int offers() {
        return offers;
    }

    @JsonGetter("totalOffered")
    public ResourceQuantity totalOffered() {
        return totalOffered;
    }

    @JsonGetter("version")
    public String version() {
        return version;
    }

    public void setOffers(int size, ResourceQuantity offered) {
        this.offers = size;
        this.totalOffered = offered;
    }

    public void setUsedResources(int queueLength, int runningLength, ResourceQuantity totalUsed) {
        this.queueLength = queueLength;
        this.runningLength = runningLength;
        this.totalUsed = totalUsed;
    }
}
