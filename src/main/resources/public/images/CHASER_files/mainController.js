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
		
		function validateEmail(email) {
		    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		    return re.test(email);
		};

		// on load
		$http.get('./restws/cars').then(handleGETSucess).catch(handleGETError);

		// on submit
		$scope.submit = function() {
			console.log("creating car");
			console.log($scope.car);

			$http.post('./restws/cars', $scope.car).then(handlePOSTSucess).catch(handlePOSTError);
			
		};

		$scope.showNewsletterMenuBoolean = false;
		$scope.enteredEmail = "";
		$scope.newsletterMsg = null;

		$scope.showNewsletterMenu = function() {
			$scope.showNewsletterMenuBoolean = true;
		};

		$scope.validateEmail = function() {
			if (validateEmail($scope.enteredEmail) == false)
				$scope.newsletterMsg = "Please enter a valid email";
			else
				$scope.newsletterMsg = "Thank you";
		};

	}
);