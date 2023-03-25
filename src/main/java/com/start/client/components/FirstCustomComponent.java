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
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLElement;

import java.util.Map;

import static com.dncomponents.client.dom.handlers.Handlers.addClickHandler;

public class FirstCustomComponent implements IsElement {
    @UiField
    public HTMLElement root;
    @UiField
    HTMLElement customTextSpan;
    @UiField
    HTMLButtonElement clearColorBtn;

    {
        HtmlBinder.get(FirstCustomComponent.class, this).bind();
    }

    public FirstCustomComponent() {
        init();
    }

    private void init() {
        addClickHandler(clearColorBtn, mouseEvent -> setColor("unset"));
    }

    public void setColor(String color) {
        root.style.background = color;
    }

    public void setText(String text) {
        customTextSpan.textContent = text;
    }

    @Override
    public HTMLElement asElement() {
        return root;
    }

    public static class FirstCustomComponentParser implements IsElementHtmlParser<FirstCustomComponent> {

        public static final String COLOR = "color";
        public static final String TEXT = "text";

        @Override
        public FirstCustomComponent parse(Element htmlElement, Map<String, ?> elements) {
            final FirstCustomComponent firstCustomElement = new FirstCustomComponent();
            if (htmlElement.hasAttribute(COLOR)) {
                firstCustomElement.setColor(htmlElement.getAttribute(COLOR));
            }
            if (htmlElement.hasAttribute(TEXT)) {
                firstCustomElement.setText(htmlElement.getAttribute(TEXT));
            }
            return replaceAndCopy(htmlElement, firstCustomElement, COLOR, TEXT);
        }

        @Override
        public String getId() {
            return "my-first-custom-component";
        }

        private static FirstCustomComponentParser instance;

        public static FirstCustomComponentParser getInstance() {
            if (instance == null)
                instance = new FirstCustomComponentParser();
            return instance;
        }
    }

}
