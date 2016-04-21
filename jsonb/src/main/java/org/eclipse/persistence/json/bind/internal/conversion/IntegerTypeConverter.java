package org.eclipse.persistence.json.bind.internal.conversion;

import org.eclipse.persistence.json.bind.model.Customization;

import java.lang.reflect.Type;

/**
 * @author Roman Grigoriadi
 */
public class IntegerTypeConverter extends AbstractTypeConverter<Integer> {

    public IntegerTypeConverter() {
        super(Integer.class);
    }

    @Override
    public Integer fromJson(String jsonValue, Type type, Customization customization) {
        return Integer.parseInt(jsonValue);
    }

    @Override
    public String toJson(Integer object, Customization customization) {
        return String.valueOf(object);
    }

    @Override
    public boolean supportsToJson(Class<?> type) {
        return super.supportsToJson(type)
                || type == int.class;
    }

    @Override
    public boolean supportsFromJson(Class<?> type) {
        return super.supportsFromJson(type)
                || type == int.class;
    }
}
