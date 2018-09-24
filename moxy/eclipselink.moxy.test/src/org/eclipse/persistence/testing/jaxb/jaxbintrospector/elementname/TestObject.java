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
//     Denise Smith - October 2011 - 2.3
package org.eclipse.persistence.testing.jaxb.jaxbintrospector.elementname;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "", propOrder = { "child" })
@XmlRootElement(name = "theRoot", namespace="someUri")
public class TestObject {
     private String child;

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }
}
