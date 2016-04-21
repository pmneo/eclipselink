/*******************************************************************************
 * Copyright (c) 2015 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * <p>
 * Contributors:
 * Roman Grigoriadi
 ******************************************************************************/

package org.eclipse.persistence.json.bind.model;

import org.eclipse.persistence.json.bind.internal.AnnotationIntrospector;
import org.eclipse.persistence.json.bind.internal.JsonbContext;

import javax.json.bind.config.PropertyVisibilityStrategy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Optional;
import java.util.function.Function;

/**
 * Abstract class for getting / setting value into the property.
 *
 * @author Roman Grigoriadi
 */
public abstract class PropertyValuePropagation {

    /**
     * Mode of property propagation get or set.
     */
    public enum OperationMode {
        GET, SET
    }

    /**
     * Property can be written (unmarshalled from json)
     */
    protected boolean writable;

    /**
     * Property can be read (marshalled to json)
     */
    protected boolean readable;

    /**
     * Construct a property propagation.
     * @param property provided property
     */
    protected PropertyValuePropagation(Property property) {
        initReadable(property.getField(), property.getGetter());
        initWritable(property.getField(), property.getSetter());
    }

    /**
     * Create typed instance to use.
     * @param property property to create from
     * @return propagation instance
     */
    public static PropertyValuePropagation createInstance(Property property) {
        return new MethodHandleValuePropagation(property);
    }

    private void initReadable(Field field, Method getter) {

        final boolean fieldReadable = field == null || (field.getModifiers() & (Modifier.TRANSIENT | Modifier.STATIC)) == 0;
        if (!fieldReadable) {
            readable = false;
            return;
        }
        if (getter != null) {
            if (!isVisible(getter)) {
                return; //don't check field if getter is not visible
            }
            if (!Modifier.isPublic(getter.getModifiers()) || getter.getDeclaringClass().isAnonymousClass()) {
                getter.setAccessible(true);
            }
            acceptMethod(getter, OperationMode.GET);
            readable = true;
        } else if (isVisible(field)) {
            if (!Modifier.isPublic(field.getModifiers()) || field.getDeclaringClass().isAnonymousClass()) {
                field.setAccessible(true);
            }
            acceptField(field, OperationMode.GET);
            readable = true;
        }
    }

    private void initWritable(Field field, Method setter) {

        final boolean fieldWritable = field == null || (field.getModifiers() & (Modifier.TRANSIENT | Modifier.STATIC | Modifier.FINAL)) == 0;
        if (!fieldWritable) {
            writable = false;
            return;
        }
        if (setter != null) {
            if (!isVisible(setter) || setter.getDeclaringClass().isAnonymousClass()) {
                return;
            }
            if (!Modifier.isPublic(setter.getModifiers())) {
                setter.setAccessible(true);
            }
            acceptMethod(setter, OperationMode.SET);
            writable = true;
        } else if (isVisible(field) && !field.getDeclaringClass().isAnonymousClass()) {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            acceptField(field, OperationMode.SET);
            writable = true;
        }
    }

    private boolean isVisible(Field field) {
        if (field == null) {
            return false;
        }
        return isVisible(strategy -> strategy.isVisible(field), field.getDeclaringClass())
                .orElse(Modifier.isPublic(field.getModifiers()));
    }

    private boolean isVisible(Method method) {
        if (method == null) {
            return false;
        }
        return isVisible(strategy -> strategy.isVisible(method), method.getDeclaringClass())
                .orElse(Modifier.isPublic(method.getModifiers()));
    }

    /**
     * Look up class and package level @JsonbVisibility, or global config PropertyVisibilityStrategy.
     * If any is found it is used for resolving visibility by calling provided visibilityCheckFunction.
     *
     * @param visibilityCheckFunction function declaring visibility check
     * @param declaringClass class to lookup annotation onto
     * @return Optional with result of visibility check, or empty optional if no strategy is found
     */
    private Optional<Boolean> isVisible(Function<PropertyVisibilityStrategy, Boolean> visibilityCheckFunction, Class<?> declaringClass) {
        final Optional<PropertyVisibilityStrategy> classLevelStrategy =
                AnnotationIntrospector.getInstance().getPropertyVisibilityStrategy(declaringClass);
        Optional<PropertyVisibilityStrategy> strategy =
                Optional.ofNullable(classLevelStrategy.orElse(JsonbContext.getInstance().getPropertyVisibilityStrategy()));

        return strategy.map(visibilityCheckFunction);
    }

    /**
     * Accept a {@link Method} to use value propagation.
     * @param method method
     * @param mode read or write
     */
    protected abstract void acceptMethod(Method method, OperationMode mode);

    /**
     * Accept a {@link Field} to use for value propagation.
     * @param field field
     * @param mode mod
     */
    protected abstract void acceptField(Field field, OperationMode mode);

    /**
     * Set a value to a field. Based on policy invokes a setter or sets directly to a field.
     *
     * @param object object to set value in
     * @param value value to set, null is valid
     */
    abstract void setValue(Object object, Object value);

    /**
     * Gets a value of a field. Based on policy invokes a getter or gets directly from a field.
     *
     * @param object object to get from
     */
    abstract Object getValue(Object object);

    /**
     * Property is writable. Based on access policy and java field modifiers.
     * @return true if can be deserialized from JSON
     */
    public boolean isWritable() {
        return writable;
    }

    /**
     * Property is readable. Based on access policy and java field modifiers.
     * @return true if can be serialized to JSON
     */
    public boolean isReadable() {
        return readable;
    }
}
