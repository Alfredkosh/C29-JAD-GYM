window.addEventListener("load", async () => {
  const token = localStorage.getItem("token");
  if (token) {
    const payload = parseJwt(token);
    const userId = payload.userId;
  } else {
    window.location.href = "/login";
  }
});

async function QrCodeCheckOut() {
  const token = localStorage.getItem("token");
  const form = document.querySelector("#qrcode-check-in-out");
  const checkOutForm = form;
  const userId = checkOutForm.userId.value;
  const gymRoomId = checkOutForm.gymRoomId.value;

  const body = {
    userId,
    gymRoomId,
  };
  console.log(body);
  const res = await fetch("/record/checkout", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify(body),
  });
  if (res.ok) {
    Swal.fire({
      icon: "success",
      title: "Check-out success",
      showConfirmButton: true,
    }).then(() => {
      console.log("Swal.fire() check-out successfully");
      window.location.replace("/admin");
    });
  } else {
    console.log("fail to register");
    Swal.fire({
      icon: "error",
      title: "Fail to check-out",
      text: "Please try again!",
    }).then(() => {
      console.log("Swal.fire() fail to check-out");
      window.location.replace("/checkin");
    });
  }
}

function parseJwt(token) {
  var base64Url = token.split(".")[1];
  var base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
  var jsonPayload = decodeURIComponent(
    window
      .atob(base64)
      .split("")
      .map(function (c) {
        return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
      })
      .join("")
  );

  return JSON.parse(jsonPayload);
}

//   function htmlEncode(value) {
//     return $('<div/>').text(value)
//       .html();
//   }
