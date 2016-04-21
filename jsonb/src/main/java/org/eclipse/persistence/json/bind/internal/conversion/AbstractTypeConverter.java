package org.eclipse.persistence.json.bind.internal.conversion;

import org.eclipse.persistence.json.bind.internal.JsonbContext;

import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

/**
 * @author David Král
 */
public abstract class AbstractTypeConverter<T> implements SupportedTypeConverter<T> {

    protected static final String NULL = "null";
    private final Class<T> clazzType;

    public AbstractTypeConverter(Class<T> clazzType) {
        this.clazzType = clazzType;
    }

    @Override
    public boolean supportsFromJson(Class<?> type) {
        return clazzType == type;
    }

    @Override
    public boolean supportsToJson(Class<?> type) {
        return clazzType.isAssignableFrom(type);
    }

    protected JsonObject getJsonObject(String jsonValue) {
        StringReader stringReader = new StringReader(jsonValue);
        JsonReader jsonReader = JsonbContext.getInstance().getJsonProvider().createReader(stringReader);
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        return jsonObject;
    }
}
