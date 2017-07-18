angular.module('sortApp', [])
.controller('mainController', function($scope) {
  $scope.sortType     = 'name'; // значение сортировки по умолчанию
  $scope.sortReverse  = false;  // обратная сортировка
  $scope.searchSurname   = '';     // значение поиска по умолчанию
 
