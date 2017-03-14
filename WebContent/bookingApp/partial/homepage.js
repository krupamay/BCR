bookingPortal.controller("homepageController", function($scope, $http) {
	$http.get("http://localhost:8080/BCR/rest/book/getBookingStatus")
    .then(function(response) {
        $scope.data = response.data;
    });
	
		$scope.openBookingModal = function (roomId) {
    		$('#book').modal('show');
    		$http.get("http://localhost:8080/BCR/rest/book/"+roomId)
    	    .then(function(response) {
    	        $scope.dataOfRoom = response.data;
    	    });
		}

		var date = new Date();
		var month = date.getUTCMonth() + 1;
		month = month.toString();
		var day = date.getUTCDate();
		var year = date.getUTCFullYear();
		
		if(month.length === 1){
			month = '0' + month;
		}
		
		$scope.today = day + "-" + month + "-" + year;
		
		 var dt2 = new Date();
	     dt2.setDate(dt2.getDate() + 1);

		var month2 = dt2.getUTCMonth() + 1;
		month2 = month2.toString();
		var day2 = dt2.getUTCDate();
		var year2 = dt2.getUTCFullYear();
		
		if(month2.length === 1){
			month2 = '0' + month2;
		}
		
		$scope.tomorrow = day2 + "-" + month2 + "-" + year2;
		
		console.log($scope.today);
		console.log($scope.tomorrow);
		
		 $scope.formObject = {};
		 
		 $scope.bookRoom = function(){
			 var paramObject =  {};
			 paramObject.empId = $scope.formObject.empId;
			 paramObject.teamName = $scope.formObject.teamName;
			 paramObject.bookingDate = $scope.formObject.bookingDate;
			 paramObject.startTime = $scope.formObject.startTime;
			 paramObject.endTime = $scope.formObject.endTime;
			 paramObject.roomNo = $scope.dataOfRoom[0].roomNo;
			 paramObject.purpose = $scope.formObject.purpose;
			 
			 JSON.stringify(paramObject);
			 
			 $http.post("http://localhost:8080/BCR/rest/book/bookroom", paramObject).
			    then(function(data, status, headers, config) {
			    	$scope.bookingSuccess = true;
			      }).
			      then(function(data, status, headers, config) {
			       
			      });
			 
			 $timeout( function(){
		    		$scope.bookingSuccess = false; 
		    		}, 3000);
		 }
		 
});