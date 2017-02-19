package io.qameta.allure.defects;

import io.qameta.allure.AbstractPlugin;

/**
 * @author charlie (Dmitry Baev).
 */
public class DefectsPlugin extends AbstractPlugin {

    @Override
    protected void configure() {
        aggregateResults(DefectsResultAggregator.class)
                .toReportData("defects.json");
    }
}
