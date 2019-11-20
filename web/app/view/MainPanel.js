Ext.define("oss.view.MainPanel", {
    extend: "Ext.panel.Panel",
    alias: 'widget.mainpanel',

    layout: 'border',

    /*defaults: {
        split: true,
        bodyStyle: 'padding: 1px'
    },*/

    items: [{
        title: '操作菜单',
        iconCls: 'dept_tree',
        region: 'west',
        xtype: 'panel',
        //margins: '3 2 2 5',
        width: 200,
        //collapsible: true,
        id: 'west-tree',
        //layout: 'fit',
        items: [{
            id: 'dept-tree',
            xtype: 'button',
            text: 'left'
        }]
    }, {
        title: '邮件管理',
        iconCls: 'email',
        //layout: 'fit',
        region: 'center',
        xtype: 'panel',
        id: 'centerPanel',
        margins: '3 5 2 0',
        items: [{
            xtype: 'button',
            text: 'center'
        }, {
            xtype: 'panel',
            id: 'centerPanelContent',
            layout: 'fit',
            items: [{
                id: 'mailListPanel',
                xtype: 'button'
            }]
        }]
    },  {
        region: 'top',
        title: "<div align='center'>ExtJS 4.0 在线投稿系统v1.0</div>",
        xtype: 'panel',
        height: 26,
        id: 'south-panel',
        margins: '3 5 3 5'
    }, {
        region: 'north',
        xtype: 'panel',
        height: 80,
        id: 'north-panel',
        margins: '2 5 3 5',
        border: 0,
        html: ""
    }]
});