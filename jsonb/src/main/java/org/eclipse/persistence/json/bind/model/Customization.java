/*******************************************************************************
 * Copyright (c) 2015 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * Roman Grigoriadi
 ******************************************************************************/

package org.eclipse.persistence.json.bind.model;

import org.eclipse.persistence.json.bind.internal.conversion.JsonbDateFormatter;

import java.text.NumberFormat;

/**
 * Customization configuration for class or field.
 * Configuration parsed from annotation is put here.
 *
 * @author Roman Grigoriadi
 */
public abstract class Customization {

    private final boolean nillable;

    private final boolean jsonbTransient;

    private final JsonbDateFormatter dateTimeFormatter;

    private final NumberFormat numberFormat;


    /**
     * Copies properties from builder an creates immutable instance.
     * @param builder not null
     */
    Customization(CustomizationBuilder builder) {
        this.nillable = builder.isNillable();
        this.jsonbTransient = builder.isJsonbTransient();
        this.dateTimeFormatter = builder.getDateFormatter();
        this.numberFormat = builder.getNumberFormat();
    }

    /**
     * Marshall null values to JSON.
     *
     * @return if true marshalling null values is active
     */
    public boolean isNillable() {
        return nillable;
    }

    /**
     * Skip marshalling / unmarshalling for this customization.
     * Works as java "transient" keyword.
     */
    public boolean isJsonbTransient() {

        return jsonbTransient;
    }

    /**
     * Date formatter for formatting dates.
     * If not set defaulted to javax.json.bind.annotation.JsonbDateFormat.DEFAULT_FORMAT.
     * @return date format
     */
    public JsonbDateFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    /**
     * Number format for formatting numbers.
     * @return number format
     */
    public NumberFormat getNumberFormat() {
        return numberFormat;
    }
}
