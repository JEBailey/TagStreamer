/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.htmlparser;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.text.ParseException;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.github.tagstream.Html;
import com.github.tagstream.api.Element;
import com.github.tagstream.api.ElementType;

public class UnusualHtmlTest {

    Stream<Element> stream;

    @Before
    public void setUp() throws ParseException, Exception {
        InputStream is = this.getClass().getResourceAsStream("/fail.html");
        stream = Html.stream(is, "UTF-8");
    }
    
    @Test
    public void docParseTagTest() throws Exception {
        long count = stream.filter(elem -> elem.getType() != ElementType.TEXT ).count();
        assertEquals(4, count);
    }

    @Test
    public void docParseTagTest2() throws Exception {
        long count = stream.filter(elem -> elem.getType() == ElementType.TEXT ).count();
        assertEquals(7, count);
    }
    
}
