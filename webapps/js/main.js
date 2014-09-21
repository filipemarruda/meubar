
require.config({
    baseUrl: '/',
});

require(
    [
        'lib/bower/jquery/dist/jquery.min.js',
        'lib/bower/angular/angular.min.js',
        'lib/bower/bootstrap/dist/js/bootstrap.min.js',
        'lib/bower/angular-resource/angular-resource.js',
        'lib/bower/angular-cookies/angular-cookies.js',
        'lib/md5.js',
        'module.js',
        'login.js'
    ],
    function () {
        angular.bootstrap(document, ['meuBar']);
    });