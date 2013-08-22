package com.example.gittestproject.utils;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.TypeReference;

/**
 * This class provides convenience methods to convert JSON to POJOs and vice
 * versa
 * 
 * @author Suyash
 * 
 */
public class JsonUtils {

	@SuppressWarnings("deprecation")
	public static <T> Object getPojoFromJson(String jsonString,
			Class<T> pojoClass) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper
				.configure(
						DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
		mapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES,
				false);
		return mapper.readValue(jsonString, pojoClass);
	}

	@SuppressWarnings("deprecation")
	public static String getJsonFromPojo(Object pojo)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES,
				false);
		return mapper.writeValueAsString(pojo);
	}
	
	public static <T> List getPojoListFromJson(String jsonString,
			Class<T> pojoClass) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper
				.configure(
						DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
		mapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES,
				false);
		List<T> list = mapper.readValue(jsonString, new TypeReference<List<T>>() {});
		return list;
	}

}
