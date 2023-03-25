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

package com.start.client.home;

import com.dncomponents.UiField;
import com.dncomponents.client.components.core.HtmlBinder;
import com.start.client.greeting.GreetingPlace;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLElement;

import static com.dncomponents.client.dom.handlers.Handlers.addClickHandler;

public class HomeViewImpl implements HomeView {
    private static HomeViewImpl instance;

    @UiField
    HTMLElement root;
    @UiField
    HTMLButtonElement greetingButton;
    HomeActivity presenter;

    {
        HtmlBinder.get(HomeViewImpl.class, this).bind();
    }

    public HomeViewImpl() {
        init();
    }

    private void init() {
        addClickHandler(greetingButton, e -> presenter.changeScreen(new GreetingPlace()));
    }

    @Override
    public HTMLElement asElement() {
        return root;
    }

    public static HomeViewImpl getInstance() {
        if (instance == null) instance = new HomeViewImpl();
        return instance;
    }

    @Override
    public void setPresenter(HomeActivity presenter) {
        this.presenter = presenter;
    }
}
