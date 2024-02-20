window.addEventListener("load", async () => {
    const token = localStorage.getItem("token")
    if (token) {
      const payload = parseJwt(token)
      const userId = payload.userId
      await QrCodeCheckIn(token)
    } else {
      window.location.href = "/login"
    }
  })
  
  
  async function QrCodeCheckIn(token) {
    document
      .querySelector("#qrcode-check-in")
      .addEventListener("submit", async (e) => {
        e.preventDefault();
        console.log(e);
        const checkInForm = e.target;
        const userId = checkInForm.userId.value;
        const gymRoomId = checkInForm.gymRoomId.value;

        const body = {
          userId,
          gymRoomId,
        };
        console.log(body);
        const res = await fetch("/record/checkin", {
          method: "POST",
          headers: { "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
         },
          body: JSON.stringify(body),
        });
        if (res.ok) {
          Swal.fire({
            icon: "success",
            title: "Check-in success",
            showConfirmButton: true,
          }).then(() => {
            console.log("Swal.fire() resolved successfully");
            window.location.replace("/admin");
          });
        } else {
          console.log("fail to register");
          Swal.fire({
            icon: "error",
            title: "Fail to check-in",
            text: "Please try again!",
          }).then(() => {
            console.log("Swal.fire() fail to check-in");
            window.location.replace("/checkin");
          });
        }
      });
  }

  
  function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
  
    return JSON.parse(jsonPayload);
  }
  
//   function htmlEncode(value) {
//     return $('<div/>').text(value)
//       .html();
//   }
  