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

package com.start.client.greeting;

import com.dncomponents.Template;
import com.dncomponents.client.components.core.HtmlBinder;
import com.dncomponents.client.views.appview.AbstractView;
import elemental2.dom.HTMLElement;

@Template
public class GreetingViewImpl extends AbstractView<GreetingActivity> implements GreetingView {
    HtmlBinder binder = HtmlBinder.create(GreetingViewImpl.class, this);
    private static GreetingViewImpl instance;
    String name = "";
    String error = "";


    private GreetingViewImpl() {
        binder.bindAndUpdateUi();
    }

    void onNameEntered() {
        presenter.onNameEntered(name);
    }

    @Override
    public void sayHi() {
        error = null;
        binder.updateUi();
    }

    @Override
    public void setError(String error) {
          this.error = error;
        binder.updateUi();
    }

    boolean isValid() {
        return !(name == null || name.isEmpty() || name.length() < 4);
    }

    String getValidationMessage() {
        if (isValid()) {
            return "Should be 4 characters long!";
        } else {
            return "Looks good";
        }
    }
    String getValidationColor(){
        if (isValid()) {
            return "greenyellow !important";
        } else {
            return "red !important";
        }
    }

    @Override
    public HTMLElement asElement() {
        return binder.getRoot();
    }

    public static GreetingViewImpl getInstance() {
        if (instance == null) instance = new GreetingViewImpl();
        return instance;
    }
}
