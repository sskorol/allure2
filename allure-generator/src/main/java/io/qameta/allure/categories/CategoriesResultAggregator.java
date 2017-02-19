package io.qameta.allure.categories;

import io.qameta.allure.entity.TestCaseResult;
import io.qameta.allure.tree.TreeGroup;
import io.qameta.allure.tree.TreeResultAggregator;

import java.util.Collections;
import java.util.List;

import static io.qameta.allure.categories.CategoriesPlugin.CATEGORY;

/**
 * @author charlie (Dmitry Baev).
 */
public class CategoriesResultAggregator extends TreeResultAggregator {

    @Override
    protected List<TreeGroup> getGroups(TestCaseResult result) {
        Category category = result.getExtraBlock(CATEGORY, new Category().withName("Without category"));
        return Collections.singletonList(
                TreeGroup.values(category.getName())
        );
    }
}
