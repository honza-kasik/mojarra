/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2008 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
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

package com.sun.faces.facelets.tag.jsf.core;

import javax.faces.component.UIOutput;
import javax.faces.component.UIParameter;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.NumberConverter;
import javax.faces.validator.DoubleRangeValidator;
import javax.faces.validator.LengthValidator;
import javax.faces.validator.LongRangeValidator;

import com.sun.faces.facelets.tag.AbstractTagLibrary;

/**
 * For Tag details, see JSF Core <a target="_new"
 * href="http://java.sun.com/j2ee/javaserverfaces/1.1_01/docs/tlddocs/f/tld-summary.html">taglib
 * documentation</a>.
 * 
 * @author Jacob Hookom
 * @version $Id$
 */
public final class CoreLibrary extends AbstractTagLibrary {

    public final static String Namespace = "http://java.sun.com/jsf/core";

    public final static CoreLibrary Instance = new CoreLibrary();

    public CoreLibrary() {
        super(Namespace);

        this.addTagHandler("actionListener", ActionListenerHandler.class);

        this.addTagHandler("attribute", AttributeHandler.class);

        this.addConverter("convertDateTime", DateTimeConverter.CONVERTER_ID, ConvertDateTimeHandler.class);

        this.addConverter("convertNumber", NumberConverter.CONVERTER_ID, ConvertNumberHandler.class);

        this.addConverter("converter", null, ConvertDelegateHandler.class);

        this.addTagHandler("facet", FacetHandler.class);

        this.addTagHandler("loadBundle", LoadBundleHandler.class);

        this.addComponent("param", UIParameter.COMPONENT_TYPE, null);
        
        this.addTagHandler("phaseListener", PhaseListenerHandler.class);

        this.addComponent("selectItem", UISelectItem.COMPONENT_TYPE, null);

        this.addComponent("selectItems", UISelectItems.COMPONENT_TYPE, null);
        
        this.addTagHandler("setPropertyActionListener", SetPropertyActionListenerHandler.class);
        
        this.addComponent("subview", "javax.faces.NamingContainer", null);
        
        this.addValidator("validateLength", LengthValidator.VALIDATOR_ID);
        
        this.addValidator("validateLongRange", LongRangeValidator.VALIDATOR_ID);
        
        this.addValidator("validateDoubleRange", DoubleRangeValidator.VALIDATOR_ID);

        this.addValidator("validator", null, ValidateDelegateHandler.class);

        this.addTagHandler("valueChangeListener",
                ValueChangeListenerHandler.class);

        this.addTagHandler("view", ViewHandler.class);
        
        this.addComponent("verbatim", "javax.faces.HtmlOutputText",
                          "javax.faces.Text", VerbatimHandler.class);
    }
}
