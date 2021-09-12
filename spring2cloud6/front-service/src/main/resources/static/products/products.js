angular.module('app').controller('productsController', function ($scope, $http, $localStorage) {
    const contextPath = 'http://localhost:5555/product-service';

    $scope.loadPage = function(pageIndex = 1) {
                $http({
                    url: contextPath + '/api/v1/products',
                    method: 'GET',
                    params: {
                    'p': pageIndex,
                    min_price: $scope.min_price,
                    max_price: $scope.max_price,
                    title: $scope.title
                    }
                }).then(function (response) {
                    $scope.productsPage = response.data;
                    $scope.navList = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
                     console.log(response);
                });
            };
    $scope.addToCart = function(productId) {
                         $http({
                                url: contextPath + '/api/v1/cart/add/' + productId,
                                method: 'GET',
                                params: {}
                         }).then(function (response) {
                                  $scope.loadCart();
                         });
                     };
    $scope.generatePagesIndexes = function (startPage, endPage) {
                    let arr = [];
                    for (let i = startPage; i < endPage + 1; i++) {
                        arr.push(i);
                    }
                    return arr;
                }
    $scope.loadPage();
});