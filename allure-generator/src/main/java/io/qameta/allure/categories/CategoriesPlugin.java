package io.qameta.allure.categories;

import com.google.inject.multibindings.OptionalBinder;
import io.qameta.allure.AbstractPlugin;

/**
 * @author charlie (Dmitry Baev).
 */
public class CategoriesPlugin extends AbstractPlugin {

    public static final String CATEGORY = "category";

    @Override
    protected void configure() {
        OptionalBinder.newOptionalBinder(binder(), CategoriesReader.class)
                .setDefault().to(DefaultCategoriesReader.class);

        processor(CategoriesProcessor.class);
        aggregateResults(CategoriesResultAggregator.class)
                .toReportData("categories.json");
    }
}
