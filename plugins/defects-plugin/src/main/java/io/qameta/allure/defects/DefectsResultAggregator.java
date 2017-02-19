package io.qameta.allure.defects;

import io.qameta.allure.entity.Status;
import io.qameta.allure.entity.StatusDetails;
import io.qameta.allure.entity.TestCaseResult;
import io.qameta.allure.tree.TreeGroup;
import io.qameta.allure.tree.TreeResultAggregator;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static io.qameta.allure.tree.TreeGroup.values;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Collections.unmodifiableSet;

/**
 * @author charlie (Dmitry Baev).
 */
public class DefectsResultAggregator extends TreeResultAggregator {

    private static final Set<Status> STATUSES = unmodifiableSet(new HashSet<>(asList(
            Status.FAILED, Status.BROKEN
    )));

    @Override
    protected List<TreeGroup> getGroups(TestCaseResult result) {
        String message = Optional.of(result)
                .map(TestCaseResult::getStatusDetails)
                .map(StatusDetails::getMessage)
                .orElse("Empty error details");
        return singletonList(values(message));
    }

    @Override
    protected boolean shouldProcess(TestCaseResult result) {
        return Objects.nonNull(result.getStatus()) && STATUSES.contains(result.getStatus());
    }
}
