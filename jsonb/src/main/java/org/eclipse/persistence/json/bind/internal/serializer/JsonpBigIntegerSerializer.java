/*******************************************************************************
 * Copyright (c) 2016 Oracle and/or its affiliates. All rights reserved.
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

package org.eclipse.persistence.json.bind.internal.serializer;

import javax.json.stream.JsonGenerator;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Serializes BigDecimal.
 *
 * @author Roman Grigoriadi
 */
class JsonpBigIntegerSerializer extends AbstractJsonpSerializer<BigInteger> {

    @Override
    void writeValue(BigInteger value, JsonGenerator jsonGenerator) {
        if (isIEEE754(value)){
            jsonGenerator.write(value);
        }else{
            jsonGenerator.write(value.toString());
        }
    }

    @Override
    void writeValue(String keyName, BigInteger value, JsonGenerator jsonGenerator) {
        if (isIEEE754(value)){
            jsonGenerator.write(keyName, value);
        }else{
            jsonGenerator.write(keyName, value.toString());
        }
    }

    @Override
    <X> boolean supports(X value) {
        Objects.requireNonNull(value);
        return value instanceof BigInteger;
    }

    private boolean isIEEE754(BigInteger value) {
        int valBits = value.abs().bitLength();
        // Integer whose absolute value is greater than 9007199254740991 is considered as
        // non IEEE 754-2008 binary64 compliant
        return valBits <= 53;
    }
}
