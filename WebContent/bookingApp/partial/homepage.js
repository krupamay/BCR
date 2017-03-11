bookingPortal.controller("homepageController", function($scope) {

		$scope.data = {
			"details" : [
			{
				"room" : "Mars",
				"booked" : "Booked",
				"bookedBy" : 
					[{"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"},
					  {"team":"DRM Team 1",
					  "time":"12.00 PM - 1.00 PM"}]
				
			},
			{
				"room" : "Venus",
				"booked" : "Open",
				"bookedBy" : 
					[{"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"},
					  {"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"}]
				
			},
			{
				"room" : "Mercury",
				"booked" : "Booked",
				"bookedBy" : 
					[{"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"},
					  {"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"}]
				
			},
			{
				"room" : "Neptune",
				"booked" : "Open",
				"bookedBy" : 
					[{"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"},
					  {"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"}]
				
			},
			{
				"room" : "FFDR-3",
				"booked" : "Open",
				"bookedBy" : 
					[{"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"},
					  {"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"}]
				
			},
			{
				"room" : "MCR-1",
				"booked" : "Open",
				"bookedBy" : 
					[{"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"},
					  {"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"}]
				
			},
			{
				"room" : "MCR-2",
				"booked" : "Open",
				"bookedBy" : 
					[{"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"},
					  {"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"}]
				
			},
			{
				"room" : "MCR-3",
				"booked" : "Booked",
				"bookedBy" : 
					[{"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"},
					  {"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"}]
				
			},
			{
				"room" : "Pluto",
				"booked" : "Booked",
				"bookedBy" : 
					[{"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"},
					  {"team":"DRM Team 1",
					  "time":"10.30 AM - 11.00 AM"}]
				
			}
			]
		};

		$scope.openBookingModal = function () {
    		$('#book').modal('show');
		}

		var date = new Date();
		$scope.today = date;
		$scope.tomorrow = date.setDate(date.getDate() + 1);
});