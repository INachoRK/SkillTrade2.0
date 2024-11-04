package co.edu.uco.skilltrade.crosscutting.helpers;

import java.util.UUID;

public final class UUIDHelper {
	
	public static final String DEFAULT_UUID_AS_STRING = "00000000-0000-0000-0000-000000000000";
	public static final UUID DEFAULT_UUID = generateUUIDFromString(DEFAULT_UUID_AS_STRING);
	private static final String UUID_RE = "[a-f0-9]{8}([-][a-f0-9]{4}){3}[-][a-f0-9]{12}";
	
	private UUIDHelper() {
		super();
	}
	
	public static final UUID generateNewUUID() {
		return UUID.randomUUID();
	}
	
	public static final boolean uuidStringIsValid(final String uuidValue) {
		return (TextHelper.getTextHelper().matchPattern(uuidValue, UUID_RE));
	}
	
	public static final UUID generateUUIDFromString(final String uuidValue) {
		return (uuidStringIsValid(uuidValue)) ? UUID.fromString(uuidValue) : DEFAULT_UUID;
	}
	
	public static final UUID getDefault(final UUID uuidvalue) {
		return ObjectHelper.isNull(uuidvalue) ? DEFAULT_UUID : uuidvalue;
	}
	
	public static final boolean isDefault(final UUID uuidValue) {
		return DEFAULT_UUID.equals(getDefault(uuidValue));
	}

}
