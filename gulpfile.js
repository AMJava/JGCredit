var gulp = require('gulp'),
    concat = require('gulp-concat'),
    livereload = require('gulp-livereload'),
    connections = require('gulp-connect'),
    clean = require('gulp-clean'),
    lr = require('tiny-lr'),
    server = lr(),
    buildPath = 'src/main/webapp/';
//gulp.task('copy-bootstrap', function() {
//  gulp.src('node_modules/bootstrap/dist/css/*')
//      .pipe(gulp.dest('public/css/bootstrap'));
//});
gulp.task('libs', function() {
  var path = [
    'node_modules/angular/angular.js',
    'node_modules/angular-ui-router/build/angular-ui-router.js',
    'node_modules/angular-resource/angular-resource.js',
    'node_modules/jquery/dist/jquery.js',
    'node_modules/angular-ui-bootstrap/ui-bootstrap.js'
  ];
  gulp.src(path)
      .pipe(gulp.dest('app/assets/libs'))
      .pipe(concat('libraries.js'))
      .pipe(gulp.dest(buildPath + 'public/js'));
});
gulp.task('clean', function() {
  var path = ['public/js/*.js', 'public/css/*.css'];
  gulp.src(path, {read: false})
      .pipe(clean());
});
gulp.task('scripts', function() {
  gulp.src(['app/scripts/**/*.js'])
      .pipe(concat('application.js'))
      .pipe(gulp.dest(buildPath+'public/js'))
});
gulp.task('css', function() {
  gulp.src(['app/assets/css/*.css'])
      .pipe(concat('style.css'))
      .pipe(gulp.dest('app/public/css'));
  gulp.src('node_modules/bootstrap/dist/**')
      .pipe(gulp.dest(buildPath + 'public/css/bootstrap'));
});
gulp.task('http-server', function() {
  connections.server({
    port: 9000,
    root: 'app',
    livereload: true
  });
});
gulp.task('watch', function() {
  server.listen(35729, function(err) {
    if (err) return console.log(err);
    gulp.watch('app/assets/libs/', ['libs']);
    gulp.watch('app/scripts/**/*.js', ['scripts']);
    gulp.watch('app/assets/css/*.css', ['css']);
  });
  gulp.start(['http-server']);
});
gulp.task('default', ['css', 'libs', 'scripts', 'watch']);