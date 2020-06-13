package guru.springframework.spring5webapp.util;

import com.google.gson.Gson;

/**
 * @author Bruno S. Alessi <bruno_alessi@yahoo.com.br>
 * @since 2020-06-13
 */
public final class GeneralUtilities {

	public GeneralUtilities() {
		// this class has no instances
	}

	public static String toJsonString(final Object o) {
		return new Gson().toJson(o);
	}

}
