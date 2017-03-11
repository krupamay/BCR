angular.module('bookingPortal.controllers', []);

var bookingPortal = angular.module('bookingPortal', ['ngRoute']);

bookingPortal.config(function($routeProvider) {
        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'partial/homepage.html',
                controller  : 'homepageController'
            })

            .when('/book',{
            	templateUrl : 'pages/booking.html',
                controller  : 'bookingController'
            });
      });