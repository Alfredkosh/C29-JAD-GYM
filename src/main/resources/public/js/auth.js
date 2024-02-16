window.addEventListener('load', () => {
    login()
})
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
        if (res.ok) {
          const data = await res.json();
          const token = data.token;
          localStorage.setItem("token", token)
    const payload = parseJwt(token)
    console.log(payload)
    const isAdmin = payload.isAdmin
    
          // Decode the token to check if the user is an admin

  
    
        //   localStorage.setItem("token", token);
          Swal.fire({
            icon: "success",
            title: "Login success",
            showConfirmButton: true,
          }).then(() => {
            console.log("Swal.fire() resolved successfully");
            if(isAdmin){
              window.location.href = "/adminpage";
            } else{
              window.location.href = "/profile";
            }
            
          });
        } else {
          console.log("fail to login");
          Swal.fire({
            icon: "error",
            title: "Login fail",
            text: "Wrong username / password",
          });
        }
      });
}