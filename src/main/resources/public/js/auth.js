window.addEventListener('load', () => {
    login()
    getUsername()
})

async function login() {
    document.querySelector("#login-form").addEventListener('submit', async (e) => {
        e.preventDefault()
        console.log("show me", e)
        const loginForm = e.target
        const username = loginForm.username.value
        const password = loginForm.password.value

        const body = {
            username,
            password
        }
        console.log(body)
        const res = await fetch("/auth/login", {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        })
        if(res.ok) {

         Swal.fire({
           icon: "success",
           title: "Login success",
           showConfirmButton: true
         }).then(() => {
           console.log("Swal.fire() resolved successfully");
           window.location.replace("/profile");
         });
        } else {
            console.log("fail to login")
            Swal.fire({
              icon: "error",
              title: "Login fail",
              text: "Wrong username / password"

            });
        }

    })
}

async function getUsername() {
  // console.log(httpResponse);
  const httpResponse = await fetch("/auth/login", {
    method: "GET",
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(body)
})
  let result = null;
  
  console.log("Hi");

  if (httpResponse.status == 200) {
    result = await httpResponse.json();

    console.log("name", result);

    document.querySelector(
      "#username-display"
    ).innerHTML = `<button class="btn btn-outline-success" type="submit"> Welcome ${result.data} </button>`;

  //   document.querySelector(
  //     "#logout-area"
  //   ).innerHTML = `<button class="btn btn-outline-success" type="submit">
  //   Log out
  // </button>`;
  } else {
    result = await httpResponse.json();
  }
}
