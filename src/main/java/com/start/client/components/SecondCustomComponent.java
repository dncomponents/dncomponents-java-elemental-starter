/*
 * Copyright 2023 dncomponents
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

package com.start.client.components;

import com.dncomponents.UiField;
import com.dncomponents.client.components.core.HtmlBinder;
import com.dncomponents.client.components.core.IsElementHtmlParser;
import com.dncomponents.client.views.IsElement;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;

import java.util.Map;

public class SecondCustomComponent implements IsElement {

    @UiField
    public HTMLElement root;
    @UiField
    FirstCustomComponent myFirstCustomComponent;

    {
        HtmlBinder.get(SecondCustomComponent.class, this).bind();
    }

    public SecondCustomComponent() {
        init();
    }

    private void init() {
        //init code here
         myFirstCustomComponent.setText("text from java");
    }

    @Override
    public HTMLElement asElement() {
        return root;
    }

    public static class SecondCustomComponentParser implements IsElementHtmlParser<SecondCustomComponent> {

        @Override
        public SecondCustomComponent parse(Element htmlElement, Map<String, ?> elements) {
            return replaceAndCopy(htmlElement, new SecondCustomComponent());
        }

        @Override
        public String getId() {
            return "my-second-custom-component";
        }

        private static SecondCustomComponentParser instance;

        public static SecondCustomComponentParser getInstance() {
            if (instance == null)
                instance = new SecondCustomComponentParser();
            return instance;
        }

    }

}
