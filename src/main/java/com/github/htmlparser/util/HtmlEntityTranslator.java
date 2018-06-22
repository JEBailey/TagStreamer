/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.htmlparser.util;

import javax.json.JsonObject;

import org.apache.commons.text.translate.CharSequenceTranslator;
import org.apache.commons.text.translate.LookupTranslator;

public class HtmlEntityTranslator {

    JsonObject jsonEntities;
    JsonObject oldEntities;

    public static final CharSequenceTranslator ESCAPE_HTML = new LookupTranslator(Html5Entities.HTML50_EXTENDED_ESCAPE);
    public static final CharSequenceTranslator UNESCAPE_HTML = new LookupTranslator(Html5Entities.HTML50_EXTENDED_UNESCAPE);

    public static String encodeHTML(String text) {
        return ESCAPE_HTML.translate(text);
    }
    
    public static String decodeHTML(String text) {
        return UNESCAPE_HTML.translate(text);
    }

}
