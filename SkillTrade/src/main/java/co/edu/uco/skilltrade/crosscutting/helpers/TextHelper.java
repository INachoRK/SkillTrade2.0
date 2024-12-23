package co.edu.uco.skilltrade.crosscutting.helpers;

import static co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper.getObjectHelper;

public final class TextHelper {

	private static final TextHelper INSTANCE = new TextHelper();
	public static final String EMPTY = "";
	public static final String UNDERLINE = "_";
	public static final String EMAIL_RE = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

	private TextHelper() {
		super();
	}
	
	public static final TextHelper getTextHelper() {
		return INSTANCE;
	}

	public static final boolean isNull(final String string) {
		ObjectHelper.getObjectHelper();
		return ObjectHelper.isNull(string);
	}

	public static final boolean isNullOrEmpty(final String string) {
		return isNull(string) || EMPTY.equals(applyTrim(string));
	}

	public static final String applyTrim(final String string) {
		return getDefault(string).trim();
	}

	public static final String getDefault(final String string, final String defaultValue) {
		return getObjectHelper().getDefault(string, defaultValue);
	}

	public static final String getDefault(final String string) {
		return getDefault(string, EMPTY);
	}

	public static final String concatenate(final String... strings) {
		final var sb = new StringBuilder(EMPTY);

		ObjectHelper.getObjectHelper();
		if (!ObjectHelper.isNull(strings)) {
			for (final var string : strings) {
				sb.append(applyTrim(string));
			}
		}

		return sb.toString();
	}
	
	public final boolean matchPattern(final String text, final String pattern) {
		return getDefault(text).matches(getDefault(pattern));
	}

	public static final boolean emailStringIsValid(final String emailValue) {
		return (TextHelper.getTextHelper().matchPattern(emailValue, EMAIL_RE));
	}
	
	public static boolean isPasswordValid(final String password) {
        return TextHelper.getTextHelper().matchPattern(password, PASSWORD_PATTERN);
    }


}
