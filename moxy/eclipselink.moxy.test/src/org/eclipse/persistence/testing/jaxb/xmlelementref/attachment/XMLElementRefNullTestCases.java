/*
 * Copyright (c) 2011, 2018 Oracle and/or its affiliates. All rights reserved.
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
// Oracle = 2.2 - Initial implementation
package org.eclipse.persistence.testing.jaxb.xmlelementref.attachment;

import java.io.InputStream;
import java.util.ArrayList;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.bind.attachment.AttachmentUnmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.testing.jaxb.JAXBTestCases;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class XMLElementRefNullTestCases extends JAXBWithJSONTestCases {

    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlelementref/attachment/employeeNull.xml";
    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlelementref/attachment/employeeNull.json";

    public XMLElementRefNullTestCases(String name) throws Exception {
        super(name);
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
        Class[] classes = new Class[2];
        classes[0] = ObjectFactory.class;
        classes[1] = Employee.class;
        setClasses(classes);
    }

    @Override
    protected Object getControlObject() {
        ObjectFactory factory = new ObjectFactory();
        Employee employee = new Employee();

        employee.ref1 = new JAXBElement(new QName("fooA"), Byte[].class, null);

        employee.ref2 = new ArrayList<JAXBElement>();
        employee.ref2.add(new JAXBElement(new QName("fooC"), String.class, null));
        employee.ref2.add(new JAXBElement(new QName("fooB"), Byte[].class, null));
        employee.ref2.add(new JAXBElement(new QName("fooB"), Byte[].class, null));
        employee.ref2.add(new JAXBElement(new QName("fooC"), String.class, null));
        return employee;
    }

    @Override
    protected Object getJSONReadControlObject() {
        ObjectFactory factory = new ObjectFactory();
        Employee employee = new Employee();

        employee.ref1 = new JAXBElement(new QName("fooA"), Byte[].class, null);

        employee.ref2 = new ArrayList<JAXBElement>();
        employee.ref2.add(new JAXBElement(new QName("fooC"), String.class, null));
        employee.ref2.add(new JAXBElement(new QName("fooC"), String.class, null));
        employee.ref2.add(new JAXBElement(new QName("fooB"), Byte[].class, null));
        employee.ref2.add(new JAXBElement(new QName("fooB"), Byte[].class, null));

        return employee;
    }

}
