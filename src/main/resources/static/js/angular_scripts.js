var app = angular.module('InterviewScheduler', ['ngRoute', 'toastr']);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/login", {
            templateUrl: "pages/admin-login.html"
        })
        .when("/candidate-login", {
            templateUrl: "pages/login.html"
        })
        .when("/candidate-schedule", {
            templateUrl: "pages/candidate_set_schedule.html"
        })
        .when("/hr-schedule", {
            templateUrl: "pages/hr_set_time_schedule.html"
        })
        .when("/create-interview", {
            templateUrl: "pages/upload_candidates.html"
        })
        .when("/upload-files", {
            templateUrl: "pages/upload_files.html"
        })
        .when("/generate-interview-schedule", {
            templateUrl: "pages/schedule_interview.html"
        })
        .when("/interviewer-login", {
            templateUrl: "pages/interviewer_login.html"
        })
        .when("/schedule", {
            templateUrl: "pages/schedule.html"
        });
});

app.controller('MainController', function ($scope, $location, $http, $rootScope, toastr) {

    $scope.CheckLogin = function () {
        var candidate_email = document.getElementById("candidate_email").value;
        var candidate_pass = document.getElementById("candidate_pass").value;
        var request = $http({
            method: "POST",
            url: "http://localhost:8080/schedule/candidate-auth",
            headers: {'Content-Type': 'application/json'},
            data: {
                "name": "",
                "email": candidate_email,
                "pass": candidate_pass,
                "day": 7,
                "preference": ""
            }
        }).then(function successCallback(response) {
            $rootScope.candidate_email = response.data.response
            $location.path('/candidate-schedule');
        }, function errorCallback(response) {
            // alert("Error");
            toastr.error("Error");
        });
    };

    $scope.InterviewerLogin = function () {
        var interviewer_email = document.getElementById("interviewer_email").value;
        var interviewer_pass = document.getElementById("interviewer_pass").value;
        var request = $http({
            method: "POST",
            url: "http://localhost:8080/schedule/candidate-auth",
            headers: {'Content-Type': 'application/json'},
            data: {
                "name": "",
                "email": interviewer_email,
                "pass": interviewer_pass,
                "day": 7,
                "preference": ""
            }
        }).then(function successCallback(response) {
            $rootScope.interviewer_email = response.data.response
            $location.path('/hr-schedule');
        }, function errorCallback(response) {
            // alert("Error");
            toastr.error("Error");
        });
    }

    $scope.setCandidatePreference = function () {
        var preference = [];
        preference[1] = document.getElementById("pref1select").value;
        preference[2] = document.getElementById("pref2select").value;
        preference[3] = document.getElementById("pref3select").value;
        preference[4] = document.getElementById("pref4select").value;
        for(var i = 1; i < 5; i++) {
            for(var j = i + 1; j < 5; j++) {
                if(preference[i] == preference[j]) {
                    toastr.error("No two preferences can be the same, Please change the options");
                    return;
                }
            }
        }
        var preferenceString = preference[1] + preference[2] + preference[3] + preference[4];
        var candidate_email_from_preference = document.getElementById("candidate_email_from_preference").value;

        var request = $http({
            method: "POST",
            url: "http://localhost:8080/schedule/candidate-preference?email=" + candidate_email_from_preference,
            headers: {'Content-Type': 'application/json'},
            data: {
                "day": 1,
                "preference": preferenceString
            }
        }).then(function successCallback(response) {
            alert("Hogya");
            $location.path('/candidate-schedule');
        }, function errorCallback(response) {
            toastr.error("Error");
            // alert("Error");
        });
    };

    $scope.getInterviewScheduleDate = function () {
        var array = []
        for (var i = 0; i < 5; i++) {
            array.push(i);
        }
        $scope.count = 0;
        $scope.interviewDate = array;
    }

    $scope.scheduleInterviewTime = function () {
        $scope.schedule = []
        for (var i = 0; i < 5; i++) {
            var day = "";
            for (var column = 0; column < 12; column++) {
                try {
                    var x = document.getElementById(i + '-' + column).checked;
                    if (x == true) {
                        day += '1';
                        // $scope.schedule.push(document.getElementById(i + '-' + column).value)
                    } else {
                        day += '0';
                    }
                } catch (error) {
                    console.log('worked');
                }
            }
            $scope.schedule.push(day);
        }
        // alert($scope.schedule);
        var request = $http({
            method: "POST",
            url: "http://localhost:8080/schedule/interview?email=" + $rootScope.interviewer_email,
            headers: {'Content-Type': 'application/json'},
            data: {
                "preferenceDtos": $scope.schedule
            }
        }).then(function successCallback(response) {
            // alert("Hogya");
            $location.path('/candidate-schedule');
        }, function errorCallback(response) {
            toastr.error("Error");
            // alert("Error");
        });
    }

    $scope.getEmployeeSchedule = function () {
        var request = $http({
            method: "GET",
            url: "http://localhost:8080/schedule/get-all-schedule?email=" + $rootScope.candidate_email,
            headers: {'Content-Type': 'application/json'}
        }).then(function successCallback(response) {
            // alert("Hogya");
            // $location.path('/candidate-schedule');
            $scope.scheduleDetails = response.data;

        }, function errorCallback(response) {
            toastr.error("Error");
            // alert("Error");
        });
    };

    $scope.scheduleInterview = function () {

    };

    $scope.scheduleDetails = function(index) {
        var request = $http({
            method: "GET",
            url: "http://localhost:8080/schedule/get-schedule-by-id?email=" + $rootScope.candidate_email+"&index="+index,
            headers: {'Content-Type': 'application/json'}
        }).then(function successCallback(response) {
            // alert("Hogya");
            $scope.schedule = response.data;
            $location.path('/schedule');
        }, function errorCallback(response) {
            toastr.error("Error");
            // alert("Error");
        });
    };

});