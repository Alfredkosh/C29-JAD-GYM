//qr code js//

// When scan is successful function will produce data
function onScanSuccess(qrCodeMessage) {
  document.getElementById("qrResult").innerHTML =
    '<span class="qrResult">' + qrCodeMessage + "</span>";
}

// When scan is unsuccessful function will produce error message
function onScanError(errorMessage) {
  // Handle Scan Error
}

// Setting up Qr Scanner properties
var html5QrCodeScanner = new Html5QrcodeScanner("qrReader", {
  fps: 10,
  qrBox: 250
});

// in
html5QrCodeScanner.render(onScanSuccess, onScanError);

//qr code js end//