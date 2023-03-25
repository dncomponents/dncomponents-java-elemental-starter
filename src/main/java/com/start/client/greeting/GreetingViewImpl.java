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

import com.dncomponents.UiField;
import com.dncomponents.client.components.core.HtmlBinder;
import com.dncomponents.client.views.appview.AbstractView;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLInputElement;

import static com.dncomponents.client.dom.handlers.Handlers.*;

public class GreetingViewImpl extends AbstractView<GreetingActivity> implements GreetingView {
    private static GreetingViewImpl instance;

    @UiField
    HTMLElement root;
    @UiField
    public HTMLHeadingElement nameLabel;

    @UiField
    public HTMLInputElement nameField;
    @UiField
    public HTMLElement errorLabel;

    HtmlBinder binder = HtmlBinder.get(GreetingViewImpl.class, this);
    @UiField
    HTMLButtonElement button;

    private GreetingViewImpl() {
        binder.bind();
        init();
    }

    private void init() {
        addClickHandler(button, e -> onNameEntered());
        addChangeHandler(nameField, e -> onNameEntered());
        addBlurHandler(nameField, e -> {});
    }

    private void onNameEntered() {
        presenter.onNameEntered(nameField.value);
    }

    @Override
    public HTMLElement asElement() {
        return root;
    }

    @Override
    public void setName(String name) {
        nameLabel.textContent = name;
    }

    @Override
    public void setError(String error) {
        if (!error.isEmpty()) {
            nameField.focus();
        }
        errorLabel.textContent = error;
    }

    public static GreetingViewImpl getInstance() {
        if (instance == null) instance = new GreetingViewImpl();
        return instance;
    }

}
