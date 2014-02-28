/*
 * Copyright (c) 2012-2014 Spotify AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spotify.statistics;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticMuninGraphProvider implements MuninGraphProvider {
  private final Map<String, MuninGraph> graphs;

  public Map<String, MuninGraph> getGraphs() {
    return graphs;
  }

  public StaticMuninGraphProvider(final List<MuninGraph> graphs) {
    Map<String, MuninGraph> graphMap = new HashMap<String, MuninGraph>();
    for (MuninGraph graph : graphs) {
      graphMap.put(graph.getName(), graph);
    }
    this.graphs = Collections.unmodifiableMap(graphMap);
  }

  public StaticMuninGraphProvider(final Map<String, MuninGraph> graphs) {
    this.graphs = Collections.unmodifiableMap(new HashMap<String, MuninGraph>(graphs));
  }
}
