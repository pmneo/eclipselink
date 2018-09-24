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
package org.eclipse.persistence.tools.workbench.mappingsmodel.spi.meta;

/**
 * Interface defining a lightweight wrapper around the
 * Java metadata required by the TopLink Mapping Workbench.
 *
 * @see java.lang.Class
 * @see ExternalClassRepository
 * @see ExternalClass
 */
public interface ExternalClassDescription extends ClassDescription {

    /**
     * Returns the "array depth" of the class represented
     * by this object. If the class is an "array" class this is
     * the number of dimensions in the array (e.g. int[] has
     * an array depth of 1, java.lang.Object[][] has an
     * array depth of 2). If the class is not an "array" class
     * this method returns 0.
     *
     * Typically this can be calculated from the type's name.
     * For example, an object whose type is declared int[][]
     * has a class whose name is "[[I"; and the number of
     * square brackets indicate that the array depth is 2.
     *
     * @see java.lang.Class#getName()
     */
    int getArrayDepth();

    /**
     * Returns the name of the "element type" of the class
     * represented by this object. If the class is an "array"
     * class this is the name of the type of elements held
     * by the array (e.g. int[] has an element type of int,
     * java.lang.Object[][] has an element type of
     * java.lang.Object). If the class is not an "array" class
     * this method simply returns the class name.
     *
     * Typically this can be calculated from the type's name.
     * For example, an object whose type is declared int[][]
     * has a class whose name is "[[I"; and the "I" indicates
     * that the element type is int.
     *
     * @see java.lang.Class#getName()
     */
    String getElementTypeName();

    /**
     * Returns the ExternalClass object corresponding to this
     * ExternalClassDescription object.
     * This allows the ExternalClassDescription object to postpone
     * loading the metadata until it is actually needed by the
     * TopLink Mapping Workbench. The name and
     * description are required beforehand because
     * they are used by the user to select an ExternalClass
     * to load. The array depth and element type name
     * enable the TopLink Mapping Workbench to maintain
     * only the metadata about "non-array" classes.
     * The synthetic indicator allows the TopLink Mapping
     * Workbench to cull out, unsupported, synthetic
     * members from any selection lists.
     *
     * If there are any problems loading the metadata,
     * this method throws a ExternalClassNotFoundException.
     * If this type has an array depth that is not equal to zero,
     * this method throws a ExternalClassNotFoundException.
     *
     * @see java.lang.Class#forName(java.lang.String)
     */
    ExternalClass getExternalClass() throws ExternalClassNotFoundException;

    /**
     * Determines if the specified ExternalClassDescription
     * object represents a synthetic type.
     * The TopLink Mapping Workbench will not
     * map synthetic members.
     *
     * Typically this can be calculated from the type's name.
     *
     * For example, java.util.Vector$1 is a synthetic class that
     * was generated by the compiler when it compiled the
     * anonymous inner class Vector uses to implement the
     * Enumeration interface.
     *
     * See "The Java Virtual Machine Specification" 4.7.6:
     * "A class member that does not appear in the source
     * code must be marked using a Synthetic attribute."
     */
    boolean isSynthetic();

}
