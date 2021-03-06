/**
 * ---------------------------------------------------------------------
 * GLPI Android Inventory Agent
 * Copyright (C) 2019 Teclib.
 *
 * https://glpi-project.org
 *
 * Based on Flyve MDM Inventory Agent For Android
 * Copyright © 2018 Teclib. All rights reserved.
 *
 * ---------------------------------------------------------------------
 *
 *  LICENSE
 *
 *  This file is part of GLPI Android Inventory Agent.
 *
 *  GLPI Android Inventory Agent is a subproject of GLPI.
 *
 *  GLPI Android Inventory Agent is free software: you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 3
 *  of the License, or (at your option) any later version.
 *
 *  GLPI Android Inventory Agent is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  ---------------------------------------------------------------------
 *  @copyright Copyright © 2019 Teclib. All rights reserved.
 *  @license   GPLv3 https://www.gnu.org/licenses/gpl-3.0.html
 *  @link      https://github.com/glpi-project/android-inventory-agent
 *  @link      https://glpi-project.org/glpi-network/
 *  ---------------------------------------------------------------------
 */

package org.glpi.inventory.agent.ui;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.glpi.inventory.agent.R;
import org.glpi.inventory.agent.core.about.About;
import org.glpi.inventory.agent.core.about.AboutPresenter;

public class FragmentAbout extends Fragment implements About.View {

    private About.Presenter presenter;
    private TextView txtAbout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_about, null);

        presenter = new AboutPresenter(this);

        txtAbout = v.findViewById(R.id.txtAbout);

        ImageView imgInventory = v.findViewById(R.id.imgInventory);
        imgInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.crashTestEasterEgg(FragmentAbout.this.getContext());
            }
        });

        presenter.loadAbout(FragmentAbout.this.getContext());

        return v;
    }

    @Override
    public void showAboutSuccess(String message) {
        txtAbout.setVisibility(View.VISIBLE);
        txtAbout.setText(message);
        txtAbout.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void showAboutFail() {
        txtAbout.setVisibility(View.GONE);
    }
}
