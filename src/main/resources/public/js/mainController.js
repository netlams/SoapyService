/****************
mainController.js
-desc: 		controller module for non-view specific functionalties
-author: 	Dau Lam
-date: 		07/21/2017

*****************/

var app = angular.module('carApp', []);

app.controller('mainController', 
	function($scope, $http) {
		$scope.list = [];
		$scope.car = { 	name: null,
						color: null,
						carType: null,
						fuelAmount: null };

		var handleGETSucess = function(resp) {
			console.log("sux");
			console.log(resp.data);

			$scope.list = resp.data;
		};
		var handleGETError= function(resp) {
			console.error("error during GET cars");
			console.log(resp);
		};

		var handlePOSTSucess = function(resp) {
				console.log(resp.data);
				if (resp.data.respCode == 0) {
					document.getElementById("create-car-form").reset();
					$scope.formMsg = "Success!";

					// reload
					$http.get('./restws/cars').then(handleHTTPSucess).catch(handleHTTPError);
					$scope.$apply();
				}
				else {
					$scope.formMsg = "Failed! " + esp.data.exceptionMsg;
				}
			};
		var handlePOSTError= function(resp) {
			console.error("error during GET cars");
			console.log(resp);
			$scope.formMsg = "Failed! " + resp.data.exceptionMsg;
		};

		// on load
		$http.get('./restws/cars').then(handleGETSucess).catch(handleGETError);

		// on submit
		$scope.submit = function() {
			console.log("creating car");
			console.log($scope.car);

			$http.post('./restws/cars', $scope.car).then(handlePOSTSucess).catch(handlePOSTError);
			
		};
	}
);