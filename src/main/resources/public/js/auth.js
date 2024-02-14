window.addEventListener('load', () => {
    login()
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
        const data = await res.json()
        const token = data.token
        localStorage.setItem("token", token)
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