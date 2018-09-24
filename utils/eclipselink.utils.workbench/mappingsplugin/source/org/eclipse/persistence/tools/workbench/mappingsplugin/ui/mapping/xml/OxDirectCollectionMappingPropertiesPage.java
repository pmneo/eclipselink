/*
 * Copyright (c) 1998, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.tools.workbench.mappingsplugin.ui.mapping.xml;

import java.awt.Component;

import org.eclipse.persistence.tools.workbench.framework.context.WorkbenchContext;
import org.eclipse.persistence.tools.workbench.framework.ui.view.TabbedPropertiesPage;
import org.eclipse.persistence.tools.workbench.mappingsplugin.ui.common.UiCommonBundle;
import org.eclipse.persistence.tools.workbench.mappingsplugin.ui.mapping.ConverterPropertiesPage;
import org.eclipse.persistence.tools.workbench.mappingsplugin.ui.mapping.UiMappingBundle;
import org.eclipse.persistence.tools.workbench.mappingsplugin.ui.xml.UiXmlBundle;


final class OxDirectCollectionMappingPropertiesPage
    extends TabbedPropertiesPage
{
    // this value is queried reflectively during plug-in initialization
    private static final Class[] REQUIRED_RESOURCE_BUNDLES = new Class[] {
        UiCommonBundle.class,
        UiXmlBundle.class,
        UiMappingBundle.class,
        UiMappingXmlBundle.class
    };


    // **************** Constructors ******************************************

    OxDirectCollectionMappingPropertiesPage(WorkbenchContext context) {
        super(context);
    }


    // **************** Initialization ****************************************

    protected void initializeTabs() {
        this.addTab(this.buildGeneralPanel(), "GENERAL_TAB");
        this.addTab(this.buildConverterPanel(), "DIRECT_MAPPING_CONVERTER_TAB");
    }

    protected Component buildGeneralPanel() {
        return new OxDirectCollectionMappingGeneralPropertiesPage(getNodeHolder(), getWorkbenchContextHolder());
    }
    protected ConverterPropertiesPage buildConverterPanel() {
        return new ConverterPropertiesPage(this.getNodeHolder(), getWorkbenchContextHolder());
    }
}
