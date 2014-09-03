/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Segment.io, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.segment.analytics.internal;

import com.segment.analytics.json.JsonMap;
import java.util.Collections;
import java.util.Map;

public class ProjectSettings extends JsonMap {
  private static final String TIMESTAMP_KEY = "timestamp";

  public static ProjectSettings load(StringCache cache) {
    if (Utils.isNullOrEmpty(cache.get())) {
      return null;
    }
    return new ProjectSettings(Collections.unmodifiableMap(new JsonMap(cache.get())));
  }

  public static ProjectSettings create(String json, long timestamp) {
    JsonMap map = new JsonMap(json);
    map.put(TIMESTAMP_KEY, timestamp);
    return new ProjectSettings(Collections.unmodifiableMap(map));
  }

  private ProjectSettings(Map<String, Object> map) {
    super(map);
  }

  public Long timestamp() {
    return getLong(TIMESTAMP_KEY);
  }
}