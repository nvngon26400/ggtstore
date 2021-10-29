// app.controller("user-ctrl", function($scope, $http, $location) {
//     $scope.roles = [];
//     $scope.admins = [];
//     $scope.authorities = [];
//     $scope.users = [];
//     $scope.formUsers = {};

//     $scope.initialize = function() {
//         //load all roles
//         $http.get("/rest/roles").then(resp => {
//             $scope.roles = resp.data;
//         })

//         //load staffs and directors (adminstrators)
//         $http.get("/rest/accounts?admin=true").then(resp => {
//             $scope.admins = resp.data;
//         })

//         //load authorities of staffs and directors
//         $http.get("/rest/authorities?admin=true").then(resp => {
//             $scope.authorities = resp.data;
//         }).catch(error => {})

//         //load all users
//         $http.get("/rest/accounts/users").then(resp => {
//             $scope.users = resp.data;
//         })
//     }

//     $scope.authority_of = function(acc, role) {
//         if ($scope.authorities) {
//             return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.id == role.id);
//         }
//     }

//     $scope.authority_changed = function(acc, role) {
//         var authority = $scope.authority_of(acc, role);
//         if (authority) { //da cap quyen => thu hoi quyen (xoa)
//             $scope.revoke_authority(authority);
//         } else { //chua duoc cap quyen => cap quyen(them moi)
//             authority = { account: acc, role: role };
//             $scope.grant_authority(authority);
//         }
//     }

//     //them moi authority
//     $scope.grant_authority = function(authority) {
//         $http.post(`/rest/authorities`, authority).then(resp => {
//             $scope.authorities.push(resp.data)
//             alert("Bạn đã cấp quyền thành công ^^");
//         }).catch(error => {
//             alert("	Cấp quyền thất bại");
//             console.log("error", error);
//         })
//     }

//     //xoa authority
//     $scope.revoke_authority = function(authority) {
//         $http.delete(`/rest/authorities/${authority.id}`).then(resp => {
//             var index = $scope.authorities.findIndex(a => a.id == authority.id);
//             $scope.authorities.splice(index, 1);
//             alert("Bạn đã thu hồi quyền sử dụng thành công");
//         }).catch(error => {
//             alert("Thu hồi quyền sử dụng thất bại");
//             console.log("error", error);
//         })
//     }

//     //load authorizing
//     $http.get("/rest/accounts").then(resp => {
//         $scope.cates = resp.data;
//     });

//     // Xóa form
//     $scope.reset = function() {
//             $scope.form = {
//                 createDate: new Date(), // ngày mặc định
//                 image: "logo.pngsignin-image.jpg", // ảnh mắc định
//                 available: true,
//             };
//         }
//         // HIEN THI LEN FORM
//     $scope.edit = function(item) {
//         $scope.form = angular.copy(item);
//         $(".nav-tabs a:eq(0)").tab('show')
//     }

//     // thêm mới user
//     $scope.create = function() {
//         var item = angular.copy($scope.form);
//         var username = document.myform.username.value;
//         var password = document.myform.password.value;
//         var fullname = document.myform.fullname.value;
//         var email = document.myform.email.value;
//         var atposition = email.indexOf("@");
//         var dotposition = email.lastIndexOf(".");
//         var image = document.myform.image.value;
//         var status = false;
//         if (username.length < 1) {
//             document.getElementById("username").innerHTML =
//                 " Please enter your username";
//             status = false;
//         } else {
//             document.getElementById("username").innerHTML =
//                 " ";
//             status = true;
//         }
//         if (password.length < 6) {
//             document.getElementById("password").innerHTML =
//                 " Password must be at least 6 char long";
//             status = false;
//         } else {
//             document.getElementById("password").innerHTML =
//                 " ";
//         }
//         if (image.length < 1) {
//             document.getElementById("image").innerHTML =
//                 " Please enter your image";
//             status = false;
//         } else {
//             document.getElementById("image").innerHTML =
//                 " ";
//         }
//         if (fullname.length < 1) {
//             document.getElementById("fullname").innerHTML =
//                 " Please enter your fullname";
//             status = false;
//         } else {
//             document.getElementById("fullname").innerHTML =
//                 " ";
//             status = true;
//         }
//         if (fullname.length < 1) {
//             document.getElementById("address").innerHTML =
//                 " Please enter your address";
//             status = false;
//         } else {
//             document.getElementById("address").innerHTML =
//                 " ";
//             status = true;
//         }
//         if (atposition < 1 || dotposition < (atposition + 2) ||
//             (dotposition + 2) >= email.length) {
//             document.getElementById("email").innerHTML =
//                 " Please enter your email";
//             status = false;
//         } else {
//             document.getElementById("email").innerHTML =
//                 " ";
//             status = true;
//         }
//         $http.post(`/rest/accounts`, item).then(resp => {
//             // resp.data.createDate = new Date(resp.data.createDate)
//             $scope.items.push(resp.data);
//             $scope.reset();
//             $scope.initialize();
//             swal("Thành công!", "Đã thêm 1 người dùng!", "success");
//         }).catch(error => {
//             sweetAlert("Thất bại!", "Lỗi thêm mới", "error");
//             console.log("Error", error);
//         })
//     }

//     // update
//     $scope.update = function() {
//         var item = angular.copy($scope.form);
//         $http.put(`/rest/accounts/${item.id}`, item).then(resp => {
//             var index = $scope.items.findIndex(p => p.id == item.id);
//             $scope.items[index] = item;
//             swal("Thành công!", "Cập nhật thông tin thành công!", "success");
//             $scope.initialize();
//         }).catch(error => {
//             sweetAlert("Thất bại!", "Lỗi cập nhật thông tin", "error");
//             console.log("Error", error);
//         });
//     }

//     // delete
//     $scope.delete = function(item) {
//         swal({
//             title: "Bạn có muốn xóa người dùng này không?",
//             icon: "info",
//             buttons: true,
//             dangerMode: true,
//         }).then((purchase) => {
//             if (purchase) {
//                 swal("Thành công! Người dùng đã được xóa", {
//                     icon: "success",
//                 });
//                 $http.delete(`/rest/accounts/${item.username}`).then(resp => {
//                     var index = $scope.admins.findIndex(p => p.username == item.username);
//                     $scope.admins.splice(index, 1);
//                     $scope.reset();
//                 })
//             } else {
//                 swal("Hủy thao tác!");
//             }
//         });
//     }

//     // upload hình
//     $scope.imageChanged = function(files) {
//         var data = new FormData();
//         data.append('file', files[0]);
//         $http.post('/rest/upload/images/', data, {
//             transformRequest: angular.identity,
//             headers: { 'Content-Type': undefined }
//         }).then(resp => {
//             $scope.form.image = resp.data.name;

//         }).catch(error => {
//             alert("Lỗi Upload Hình Ảnh");
//             console.log("Error", error);
//         })
//     }

//     $scope.pager = {
//         page: 0,
//         size: 5,
//         get admins() {
//             var start = this.page * this.size;
//             return $scope.admins.slice(start, start + this.size);
//         },
//         get count() {
//             return Math.ceil(1.0 * $scope.admins.length / this.size);
//         },
//         first() {
//             this.page = 0;
//         },
//         prev() {
//             this.page--;
//             if (this.page < 0) {
//                 this.last();
//             }
//         },
//         next() {
//             this.page++;
//             if (this.page >= this.count) {
//                 this.first();
//             }
//         },
//         last() {
//             this.page = this.count - 1;
//         }
//     }
//     $scope.initialize();
// });