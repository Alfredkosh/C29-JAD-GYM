// Generate QR code from user ID
function generateQRCode(userID) {
    // Create a new QRCode instance
    const qrCode = new QRCode(document.getElementById("qrcode"), {
      width: 200,
      height: 200
    });
  
    // Generate the QR code
    qrCode.makeCode(userID);
  }


  const userID = 1;
generateQRCode(userID);