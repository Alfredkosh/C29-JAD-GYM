window.addEventListener("load", async () => {
  const token = localStorage.getItem("token")
  if (token) {
    const payload = parseJwt(token)
    const userId = payload.userId
  register(token);
} else {
  window.location.href = "/login"
}
  checkUsernameAvailable();
  checkEmailAvailable();
    enableSubmitButton();
});

let flag1 = false;
let flag2 = false;


function enableSubmitButton() {
  let submit = document.querySelector("#submit-button");

  if (flag1 == true && flag2 == true) {
    submit.disabled = false;
    // $('#sumbit-button').removeAttr('disabled');
  } else {
    submit.disabled = true;
  }
}

function checkUsernameAvailable() {
  let target = document.querySelector("#check-user-available");

  target.addEventListener("click", async (e) => {
    console.log("you have click the user check button");
    e.preventDefault();
    const username = document.querySelector("#username").value;
    // checkUsernameAvailable(username);
    console.log("this is my username", username);

    let checkUsernameRes = await fetch("/auth/checkUser", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username }),
    });

    if (checkUsernameRes.status == 200) {
      document.querySelector("#check-user-available").innerHTML = "&#10004;";
      flag1 = true;
      enableSubmitButton();
    } else {
      document.querySelector("#check-user-available").innerHTML = "&#10006;";
      flag1 = false;
      enableSubmitButton();
    }
  });
}

function checkEmailAvailable() {
  let target = document.querySelector("#check-email-available");

  target.addEventListener("click", async (e) => {
    console.log("you have click the email check button");
    e.preventDefault();
    const email = document.querySelector("#email").value;
    // checkUsernameAvailable(username);
    console.log("this is my email", email);

    let checkEmailRes = await fetch("/auth/checkEmail", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ email }),
    });

    if (checkEmailRes.status == 200) {
      document.querySelector("#check-email-available").innerHTML = "&#10004;";
      flag2 = true;
      enableSubmitButton();
    } else {
      document.querySelector("#check-email-available").innerHTML = "&#10006;";
      flag2 = false;
      enableSubmitButton();
    }
  });
}

async function register(token) {
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
        headers: { 
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
          },
        body: JSON.stringify(body),
      });
      if (res.ok) {

        Swal.fire({
          icon: "success",
          title: "New user registered",
          showConfirmButton: true,
        }).then(() => {
          console.log("Swal.fire() resolved successfully12345");
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

function parseJwt (token) {
  var base64Url = token.split('.')[1];
  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
  }).join(''));

  return JSON.parse(jsonPayload);
}