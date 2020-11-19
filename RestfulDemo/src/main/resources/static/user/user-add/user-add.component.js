angular.
module('userAdd', []).
component('userAdd', {
	templateUrl: 'user/user-add/user-add.template.html',
	controller: [ '$window','$http','$rootScope',
		function addUserController($window, $http,$rootScope){
			var self = this;
			self.count = 1;
			self.name = 'x-spirit'+self.count;
			self.email = self.name+'.zhang@ttu.edu';
			self.message = '';
			
			self.add = function(){
				var add_params = {name: self.name, email: self.email};
				$http({
					url:"/demo/add",
					method:"POST",
					params: add_params
				}).then(function success(response){
                    self.message = response.data.message;
					self.count=self.count + 1;
                    self.name = 'x-spirit'+self.count;
                    self.email = self.name+'.zhang@ttu.edu';
                    $rootScope.$emit('USERADD', 'hi');
				}, function error(response){
                    $window.alert(response.data.message);
				});

			}
		}
	]
});