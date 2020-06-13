package guru.springframework.spring5webapp.util;

import com.google.gson.Gson;

public final class GeneralUtilities {

	public GeneralUtilities() {
		// this class has no instances
	}

	public static String toJsonString(final Object o) {
		return new Gson().toJson(o);
	}

}
