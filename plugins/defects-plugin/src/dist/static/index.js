'use strict';
allure.api.addTab('defects', {
    title: 'Defects',
    icon: 'fa fa-flag',
    route: 'defects(/:testcaseId)',
    onEnter: (function () {
        var routeParams = Array.prototype.slice.call(arguments);
        return new allure.components.TreeLayout({
            enableGroupsInfo: false,
            routeParams: routeParams,
            tabName: 'Defects',
            baseUrl: 'defects',
            url: 'data/defects.json'
        });
    })
});
