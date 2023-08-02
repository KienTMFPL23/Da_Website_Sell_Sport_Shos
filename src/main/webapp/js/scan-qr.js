let scanner = new Instascan.Scanner({ video : document.getElementById('video')});
Instascan.Camera.getCameras().then(function(cameras){
    if (cameras.length > 0) {
        scanner.start(cameras[0]);
    }else{
        alert('Cameras found');
    }
}).catch(function(e){
    console.error(e);
});
scanner.addListener('scan',function(c){
    document.getElementById('idSanPham').value = c;
});

function themGioHang(){
    let idCTSP = document.getElementById('idSanPham');

}