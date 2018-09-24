/*
 * Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

package org.eclipse.samples;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.eclipse.persistence.testing.perf.jpa.model.metaannotations.EListener;

@Entity
@EntityListeners(EListener.class)
public @interface LoggableEntity { }
