var app = angular.module("CarController", []);

let controller = app.controller("CarController", function($scope, $http){
    $scope.cars = [];
    $scope.carsForm={
        id : "",
        name: "",
        brand:"",
        cost:"",
        photo:"",
        description:""
    };
    //Update
    __refreshCarData();

    $scope.Car = function(){
        var methode = "POST";
        var url = "/public/rest/cars";
        $http({
            methode:methode,
            url:url,
            data:angular.toJson($scope.carsForm),
            headers:{
                "Content-Type" : "application/json"
            }
        }).then(_success, _error)
    };

    $scope.Car = function () {

        let Car = {
            "name" : document.getElementById("adding").name.value,
            "brand" : document.getElementById("adding").brand.value,
            "cost" : document.getElementById("adding").cost.value
        };
        console.log(document.getElementById("adding").value);
        $http.post("/public/rest/cars", angular.toJson(Car)).then(_success,_error);
        // $http({
        //     methode: "POST",
        //     url:"/public/rest/cars",
        //     data:angular.toJson(Car),
        //     headers:{
        //         "Content-Type" : "application/json"
        //     }
        // }).then(_success, _error);
        _clearFormData();
        __refreshCarData();
    };

    $scope.deleteCar = function (Car) {
        $http.delete("/public/rest/cars",{
            params:{ id: document.getElementById(Car.id).id.value}
        }).then(_success,_error);
    };

    $scope.editCar = function (Car){
        Car.name = document.getElementById(Car.id).name.value;
        Car.brand = document.getElementById(Car.id).brand.value;
        Car.cost = document.getElementById(Car.id).cost.value;
        $http({
            method: "PUT",
            url:"/public/rest/cars",
            data: angular.toJson(Car),
            headers:{
                "Content-Type" : "application/json"
            }
        })
    };

    function _clearFormData() {
        document.getElementById("adding").name.value = "Название";
        document.getElementById("adding").brand.value = "Студия";
        document.getElementById("adding").cost.value = "Стоимость"
    }


    function _success(res) {
        __refreshCarData();
        _clearFormData();
    }
    function __refreshCarData() {
        $http({
            method: "GET",
            url:"/public/rest/cars"
        }).then(
            function (res) {
                $scope.cars = res.data;
            },
            function (res) {
                console.log("Error" + res.status + ":" + res.data);
            }
        )
    }

    function _error(res) {
        let data = res.data;
        let status = res.status;
        let header = res.header;
        let config = res.config;
        alert("Error: " + status + ":" + data);
    }

});