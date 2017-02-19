package io.qameta.allure.categories;

import io.qameta.allure.Processor;
import io.qameta.allure.entity.TestCase;
import io.qameta.allure.entity.TestCaseResult;
import io.qameta.allure.entity.TestRun;

import javax.inject.Inject;
import java.util.List;

import static io.qameta.allure.categories.CategoriesPlugin.CATEGORY;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


/**
 * @author charlie (Dmitry Baev).
 */
public class CategoriesProcessor implements Processor {

    private final CategoriesReader categoriesReader;

    @Inject
    public CategoriesProcessor(CategoriesReader categoriesReader) {
        this.categoriesReader = categoriesReader;
    }

    @Override
    public void process(TestRun testRun, TestCase testCase, TestCaseResult result) {
        List<Category> categories = categoriesReader.readAll();
        for (Category category : categories) {
            if (matches(result, category)) {
                result.addExtraBlock(CATEGORY, category);
                return;
            }
        }
    }

    public static boolean matches(TestCaseResult result, Category category) {
        boolean matchesStatus = category.getMatchedStatuses().isEmpty()
                || nonNull(result.getStatus())
                && category.getMatchedStatuses().contains(result.getStatus());
        boolean matchesMessage = isNull(category.getMessageRegex())
                || nonNull(result.getStatusDetails())
                && nonNull(result.getStatusDetails().getMessage())
                && result.getStatusDetails().getMessage().matches(category.getMessageRegex());
        boolean matchesTrace = isNull(category.getMessageRegex())
                || nonNull(result.getStatusDetails())
                && nonNull(result.getStatusDetails().getTrace())
                && result.getStatusDetails().getTrace().matches(category.getTraceRegex());
        return matchesStatus && matchesMessage && matchesTrace;
    }
}
