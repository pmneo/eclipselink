package org.eclipse.persistence.json.bind.internal.conversion;

import org.eclipse.persistence.json.bind.internal.JsonbContext;
import org.eclipse.persistence.json.bind.model.Customization;

import javax.json.*;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * @author David Král
 */
public class JsonNumberTypeConverter extends AbstractTypeConverter<JsonNumber> {

    private final static String NUMBER = "number";

    public JsonNumberTypeConverter() {
        super(JsonNumber.class);
    }

    @Override
    public JsonNumber fromJson(String jsonValue, Type type, Customization customization) {
        final JsonBuilderFactory factory = JsonbContext.getInstance().getJsonProvider().createBuilderFactory(null);
        JsonObject jsonObject;
        try {
            Integer integer = Integer.parseInt(jsonValue);

            jsonObject = factory.createObjectBuilder()
                    .add(NUMBER, integer)
                    .build();
            return jsonObject.getJsonNumber(NUMBER);
        } catch (NumberFormatException exception) {
        }
        try {
            Long l = Long.parseLong(jsonValue);

            jsonObject = factory.createObjectBuilder()
                    .add(NUMBER, l)
                    .build();
            return jsonObject.getJsonNumber(NUMBER);
        } catch (NumberFormatException exception) {
        }

        jsonObject = factory.createObjectBuilder()
                .add(NUMBER, new BigDecimal(jsonValue))
                .build();
        return jsonObject.getJsonNumber(NUMBER);
    }

    @Override
    public String toJson(JsonNumber object, Customization customization) {
        return object.toString();
    }

}
