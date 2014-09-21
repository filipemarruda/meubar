
require.config({
    baseUrl: '/meubar',
    urlArgs: 'v=1.2'

});

require(
    [
        'lib/bower/jquery/dist/jquery.min.js',
        'lib/bower/angular/angular.min.js',
        'lib/bower/bootstrap/dist/js/bootstrap.min.js',
        'lib/bower/angular-resource/angular-resource.js',
        'lib/bower/angular-route/angular-route.js',
        'lib/bower/angular-ui-router/release/angular-ui-router.js',
        'lib/bower/angular-ui-utils/ui-utils.js',
        'lib/bower/angular-bootstrap/ui-bootstrap.js',
        'lib/bower/angular-ui-utils/ui-utils.js',
        'lib/bower/angular-cookies/angular-cookies.js',
        'modules/grupos/module.js',
        'modules/grupos/routes.js',
        'modules/grupos/controllers.js',
        'modules/grupos/services.js'
    ],
    function () {
        if (window.location.hash === '#_=_') window.location.hash = '#!';
        angular.bootstrap(document, ['meuBar']);
    });
