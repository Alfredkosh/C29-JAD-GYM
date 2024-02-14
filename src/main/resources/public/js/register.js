// import QRCode from "qrcode";

window.addEventListener("load", () => {
  register();
});

async function register() {
  document
    .querySelector("#register-form")
    .addEventListener("submit", async (e) => {
      e.preventDefault();
      const registerForm = e.target;
      const fullname = registerForm.fullname.value;
      const username = registerForm.username.value;
      const password = registerForm.password.value;
      const age = registerForm.age.value;
      const mobileNumber = registerForm.mobileNumber.value;
      const email = registerForm.email.value;
      const gender = registerForm.gender.value;

      const body = {
        fullname,
        username,
        password,
        age,
        mobileNumber,
        email,
        gender,
      };
      console.log(body);
      const res = await fetch("/auth/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body),
      });
      if (res.ok) {

        // const qrCodeData = {
        //   fullname,
        //   username,
        //   id,
        //   // Include any other relevant data for the QR code
        // };
        // const qrCodeString = JSON.stringify(qrCodeData);
        // const qrCodeElement = document.createElement("canvas");
        // await QRCode.toCanvas(qrCodeElement, qrCodeString);
        
        // // Append the generated QR code to the document
        // const qrCodeContainer = document.getElementById("qr-code-container");
        // qrCodeContainer.innerHTML = ""; // Clear previous QR codes
        // qrCodeContainer.appendChild(qrCodeElement);

        Swal.fire({
          icon: "success",
          title: "New user registered",
          showConfirmButton: true,
        }).then(() => {
          console.log("Swal.fire() resolved successfully");
          window.location.replace("/admin");
        });
      } else {
        console.log("fail to register");
        Swal.fire({
          icon: "error",
          title: "Register fail",
          text: "Please try again!",
        });
      }
    });
}
