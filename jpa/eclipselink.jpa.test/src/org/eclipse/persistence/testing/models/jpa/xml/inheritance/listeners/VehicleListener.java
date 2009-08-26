/*******************************************************************************
 * Copyright (c) 1998, 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/


package org.eclipse.persistence.testing.models.jpa.xml.inheritance.listeners;

import java.util.EventListener;
import org.eclipse.persistence.testing.models.jpa.xml.inheritance.Vehicle;

/**
 * A listener for the Vehicle entity.
 * 
 * It implements the following annotations:
 * - PostLoad
 * 
 * It overrides the following annotations:
 * - None
 * 
 * It inherits the following annotations:
 * - None
 */
public class VehicleListener implements EventListener {
    public static int POST_LOAD_COUNT = 0;    

	public void postLoad(Vehicle vehicle) {
        POST_LOAD_COUNT++;
	}
}
