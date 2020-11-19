/**
 * 
 */
angular.
module('userDisplay', []).
component('userDisplay', {
	templateUrl: 'user/user-display/user-display.template.html',
	controller: [ '$window','$http','$scope','$rootScope',
		function displayUserController($window, $http, $scope, $rootScope){
			var self = this;
            self.userlist = $scope.userlist=[];
			self.display = function(){
				$http({
					url:"/demo/all",
					method:"GET"
				}).then(function success(response){
				    self.userlist.splice(0, self.userlist.length);
                    response.data.forEach(function (item, index) {
                        self.userlist.push(item);
                    });
				}, function error(response){
					self.result = reponse.data;
                    $window.alert(response.data.message);
				});
			}

			$rootScope.$on('USERADD', function (event, data) {
                self.display();
            })
		}
	]
});