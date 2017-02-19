package io.qameta.allure.categories;

import java.util.List;

/**
 * @author charlie (Dmitry Baev).
 */
public interface CategoriesReader {

    List<Category> readAll();

}
