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

import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.client.views.appview.Place;

public class HomeActivity extends AbstractActivity<HomeView, HomePlace> implements HomeView.HomePresenter {

    public HomeActivity(HomeView view, HomePlace place) {
        super(view, place);
    }

    @Override
    public void changeScreen(Place place) {
        placeManager.goTo(place);
    }
}
