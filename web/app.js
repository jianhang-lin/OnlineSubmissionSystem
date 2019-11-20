Ext.onReady(function () {
    Ext.QuickTips.init();
    Ext.Loader.setConfig({
        enabled: true
    });
    Ext.application({
        name: 'oss',
        appFolder: 'app',
        launch: function () {
            Ext.create("Ext.container.Viewport", {
                layout: 'fit',
                items: [{
                    width: 800,
                    height: 500,
                    xtype: 'mainpanel'
                }]
            });
        },
        controllers: [
            'ArticleController'
        ]
    })
});