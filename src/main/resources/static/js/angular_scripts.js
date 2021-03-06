var app = angular.module('InterviewScheduler', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider
  .when("/candidate-login", {
  	templateUrl : "pages/login.html"
  })
  .when("/candidate-schedule", {
  	templateUrl :  "pages/candidate_set_schedule.html"
  })
  .when("/hr-schedule", {
  	templateUrl : "pages/hr_set_time_schedule.html"
  })
  .when("/create-interview", {
  	templateUrl : "pages/upload_candidates.html"
  })
  .when("/upload-files", {
  	templateUrl : "pages/upload_files.html"
  })
  .when("/generate-interview-schedule", {
  	templateUrl : "pages/schedule_interview.html"
  })
  .when("/interviewer-login", {
     	templateUrl : "pages/interviewer_login.html"
   });
});

app.controller('MainController',function($scope, $location, $http, $rootScope){
	
	$scope.CheckLogin = function(){
		var candidate_email = document.getElementById("candidate_email").value;
		var candidate_pass = document.getElementById("candidate_pass").value;
		var request = $http({
                    method: "POST",
                    url: "http://localhost:8080/schedule/candidate-auth",
                    headers: {'Content-Type': 'application/json'},
                    data: {
							"name" : "",
							"email" : candidate_email,
							"pass" : candidate_pass,
							"day" : 7,
							"preference" : ""
						}
                 }).then(function successCallback(response){
                 	$rootScope.candidate_email = response.data.response
                 	$location.path('/candidate-schedule');
               	}, function errorCallback(response) {
    				alert("Error");
    			});
	};

	$scope.InterviewerLogin = function() {
	    var interviewer_email = document.getElementById("interviewer_email").value;
	    var interviewer_pass = document.getElementById("interviewer_pass").value;
	    var request = $http({
                method: "POST",
                url: "http://localhost:8080/schedule/candidate-auth",
                headers: {'Content-Type': 'application/json'},
                data: {
                        "name" : "",
                        "email" : interviewer_email,
                        "pass" : interviewer_pass,
                        "day" : 7,
                        "preference" : ""
                    }
             }).then(function successCallback(response){
                $rootScope.interviewer_email = response.data.response
                $location.path('/hr-schedule');
            }, function errorCallback(response) {
                alert("Error");
            });
	}

	$scope.setCandidatePreference = function(){
		var preference1 = document.getElementById("pref1select").value;
		var preference2 = document.getElementById("pref2select").value;
		var preference3 = document.getElementById("pref3select").value;
		var preference4 = document.getElementById("pref4select").value;
		var preferenceString = preference1+preference2+preference3+preference4;
		var candidate_email_from_preference = document.getElementById("candidate_email_from_preference").value;

		var request = $http({
                    method: "POST",
                    url: "http://localhost:8080/schedule/candidate-preference?email="+candidate_email_from_preference,
                    headers: {'Content-Type': 'application/json'},
                    data: {
							"day": 1,
							"preference" : preferenceString
						}
                 }).then(function successCallback(response){
          			alert("Hogya");
                 	$location.path('/candidate-schedule');
               	}, function errorCallback(response) {
    				alert("Error");
    			});
		};

	$scope.getInterviewScheduleDate = function() {
		var array = []
		for(var i=0;i<5;i++){
			array.push(i);
		}
		$scope.count = 0;
		$scope.interviewDate = array;
	}

	$scope.scheduleInterviewTime = function(){
		$scope.schedule = []
		for(var i=0;i<5;i++){
			for(var column=0; column<12; column++){
				try{
					var x = document.getElementById(i+'-'+column).checked; 
					if(x==true){
						$scope.schedule.push(document.getElementById(i+'-'+column).value)
					}
				}catch(error){
					console.log('worked');
				}
			}
		}
		alert($scope.schedule);
	}

	$scope.getEmployeeSchedule = function() {

	}

	$scope.schedlueInterview = function() {

	}

});