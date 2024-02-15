window.addEventListener("load", async () => {
  const token = localStorage.getItem("token")
  if (token) {
    const payload = parseJwt(token)
    const userId = payload.userId
    generateQrCode(userId)
    console.log({userId})
  } else {
    location.href.replace = "/login"
  }
})

function generateQrCode(userId) {
  let finalURL =
  'https://chart.googleapis.com/chart?cht=qr&chl=' +
       userId +
        '&chs=160x160&chld=L|0'
  
      // Replace the src of the image with
      // the QR code image
      $('.qr-code').attr('src', finalURL);  
} 

function parseJwt (token) {
  var base64Url = token.split('.')[1];
  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
  }).join(''));

  return JSON.parse(jsonPayload);
}


function htmlEncode(value) {
  return $('<div/>').text(value)
    .html();
}

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