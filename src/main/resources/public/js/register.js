window.addEventListener('load', () => {
    register()
})

async function register() {
    document.querySelector("#register-form").addEventListener('submit', async (e) => {
        e.preventDefault()
        console.log(e)
        const registerForm = e.target
        const username = loginForm.username.value
        const password = loginForm.password.value
        const password = loginForm.age.value
        const password = loginForm.email.value
        const password = loginForm.mobileNumber.value


        const body = {
            username,
            password,
            age,
            email,
            mobileNumber
        }
        console.log(body)
        const res = await fetch("/auth/register", {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        })
        if(res.ok) {
            Swal.fire({
                       icon: "success",
                       title: "New user registered",
                       showConfirmButton: true
                     }).then(() => {
                       console.log("Swal.fire() resolved successfully");
                       window.location.replace("/");
                     });
        } else {
            console.log("fail to register")
            Swal.fire({
                          icon: "error",
                          title: "Register fail",
                          text: "Please try again!"
        }

    })
}