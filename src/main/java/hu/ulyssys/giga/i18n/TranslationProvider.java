package hu.ulyssys.giga.i18n;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.vaadin.flow.i18n.I18NProvider;

public class TranslationProvider implements I18NProvider {

    private static final Logger logger = LoggerFactory.getLogger(
            TranslationProvider.class.getName());

    public static final String BUNDLE_PREFIX = "translate";

    public final Locale LOCALE_EN = new Locale("en", "GB");
    public final Locale LOCALE_HU = new Locale("hu", "HU");
    public final Locale LOCALE_DE = new Locale("de", "DE");

    private List<Locale> locales = Collections.unmodifiableList(
            Arrays.asList(LOCALE_EN, LOCALE_HU, LOCALE_DE));

    private static final LoadingCache<Locale, ResourceBundle> bundleCache =
            CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS)
                    .build(new CacheLoader<Locale, ResourceBundle>() {
                        @Override
                        public ResourceBundle load(Locale locale) throws
                                Exception {
                            return initializeBundle(locale);
                        }
                    });

    @Override
    public List<Locale> getProvidedLocales() {
        return locales;
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
        if (key == null) {
            logger.warn("Got lang request for key with null value!");
            return "";
        }

        final ResourceBundle bundle = bundleCache.getUnchecked(locale);

        String value;
        try {
            value = bundle.getString(key);
        } catch (final MissingResourceException e) {
            logger.warn("Missing resource", e);
            return "!" + locale.getLanguage() + ": " + key;
        }
        if (params.length > 0) {
            value = MessageFormat.format(value, params);
        }
        return value;
    }

    private static ResourceBundle initializeBundle(final Locale locale) {
        return readProperties(locale);
    }

    protected static ResourceBundle readProperties(final Locale locale) {
        final ClassLoader cl = TranslationProvider.class.getClassLoader();

        ResourceBundle propertiesBundle = null;
        try {
            propertiesBundle = ResourceBundle.getBundle(BUNDLE_PREFIX, locale,
                    cl);
        } catch (final MissingResourceException e) {
            logger.warn("Missing resource", e);
        }
        return propertiesBundle;
    }
}
