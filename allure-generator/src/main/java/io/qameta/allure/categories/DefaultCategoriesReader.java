package io.qameta.allure.categories;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.qameta.allure.entity.Status.BROKEN;
import static io.qameta.allure.entity.Status.FAILED;

/**
 * @author charlie (Dmitry Baev).
 */
public class DefaultCategoriesReader implements CategoriesReader {

    @Override
    public List<Category> readAll() {
        return Collections.unmodifiableList(Arrays.asList(
                new Category().withName("Unknown failure").withMatchedStatuses(FAILED),
                new Category().withName("Unknown error").withMatchedStatuses(BROKEN)
        ));
    }
}
