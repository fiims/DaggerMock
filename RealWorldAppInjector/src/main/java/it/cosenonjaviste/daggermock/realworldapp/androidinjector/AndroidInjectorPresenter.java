/*
 *   Copyright 2016 Fabio Collini.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package it.cosenonjaviste.daggermock.realworldapp.androidinjector;

import android.app.Activity;

import it.cosenonjaviste.daggermock.realworldapp.services.MainService;
import it.cosenonjaviste.daggermock.realworldapp.services.SnackBarManager;

public class AndroidInjectorPresenter {

    private MainService mainService;

    private AndroidInjectorView view;

    private SnackBarManager snackBarManager;

    public AndroidInjectorPresenter(MainService mainService, AndroidInjectorView view, SnackBarManager snackBarManager) {
        this.mainService = mainService;
        this.view = view;
        this.snackBarManager = snackBarManager;
    }

    public void loadData() {
        try {
            String s = mainService.doSomething();
            view.showText(s);
        } catch (Exception e) {
            snackBarManager.showMessage((Activity) view, e.getMessage());
        }
    }
}
