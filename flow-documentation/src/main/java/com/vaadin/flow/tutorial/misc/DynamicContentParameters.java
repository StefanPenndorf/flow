/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.tutorial.misc;

import com.vaadin.flow.dom.Element;
import com.vaadin.flow.html.Input;
import com.vaadin.flow.html.NativeButton;
import com.vaadin.flow.tutorial.annotations.CodeFor;
import com.vaadin.ui.UI;

@CodeFor("miscellaneous/tutorial-dynamic-content.asciidoc")
public class DynamicContentParameters {

    void tutorialCode() {
        Input name = new Input();

        Element image = new Element("object");
        image.setAttribute("type", "image/svg+xml");
        image.getStyle().set("display", "block");

        NativeButton button = new NativeButton("Generate Image");
        button.addClickListener(event -> {
            String url = "image?name=" + name.getValue();
            image.setAttribute("data", url);
        });

        UI.getCurrent().getElement().appendChild(name.getElement(), image,
                button.getElement());
    }

}
