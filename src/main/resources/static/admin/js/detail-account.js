const host = "http://localhost:8080/rest";
const host1 = "http://localhost:8080/rest/khachhang";
const app = angular.module("DetailAccountApp", []);
app.controller("DetailAccountCtrl", function ($scope, $http) {
    $scope.checkInsert = false;
    //Lấy URL hiện tại
    const urlCurrent = new URL(location.href);
    // Lấy param
    const idKhachhang = urlCurrent.searchParams.get("idKhachhang");
    const url = `${host}/khachhang/${idKhachhang}`;
    $scope.load_all = function () {
        console.log("idKhachhang", idKhachhang);
        $http.get(url).then((resp) => {
            $scope.danhMuc = resp.data;
            console.log("Sucsess", resp.data);
        })
    }
    $scope.delete = function (filename) {
        $http.delete(url).then(resp => {
            console.log("Đã xóa", resp.data);
            alert("Tồn tại khoá ngoại không thể xoá!")
        }).catch(error => {
            alert("Tồn tại khoá ngoại không thể xoá!")
            console.log("Error", error);
        });
    }
    $scope.updateKhachhang = (danhMuc) => {
        $http.put(url, danhMuc).then(resp => {
            alert("Sửa thành công!");
            console.log("sucesss", resp.data)
        })
    };
    $scope.insertKhachhang = (danhMuc) => {
        $http.post(host1, danhMuc).then(resp => {
            alert("Thêm mới thành công!");
            console.log("sucesss", resp.data)
        })
    }
    $scope.deleteKhachhang = (id) => {
        $http.delete(url).then(resp => {
            alert("Xóa thành công!");
            location.replace("/admin/customer")
        }).catch((resp)=>{
            alert("Không thể xoá do tồn tại sản phẩm có danh mục này!");
        });
    }
    $scope.reset = () => {
        $scope.danhMuc = null;
        $scope.checkInsert = true;
    }
    $scope.load_all();
});