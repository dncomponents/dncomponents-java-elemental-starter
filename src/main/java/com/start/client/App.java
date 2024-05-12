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

package com.start.client;

import com.dncomponents.client.components.core.AppTemplates;
import com.dncomponents.client.components.core.HtmlBinder;
import com.dncomponents.client.components.core.TemplateParser;
import com.dncomponents.client.dom.History;
import com.google.gwt.core.client.EntryPoint;
import com.start.client.components.HelloComponent;
import elemental2.dom.DomGlobal;

public class App implements EntryPoint {
    HelloComponent component;

    @Override
    public void onModuleLoad() {
        AppTemplates.register();
        TemplateParser.setDebug(true);
        //java 11
        var mainApp = new MainApp();
        DomGlobal.document.body.appendChild(mainApp.asElement());
//        HtmlBinder.cssDevMode();
        History.fireCurrentHistoryState();
    }
}
