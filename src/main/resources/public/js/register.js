window.addEventListener('load', () => {
    register()
})

async function register() {
    document.querySelector("#register-form").addEventListener('submit', async (e) => {
        e.preventDefault()
        console.log(e)
        const registerForm = e.target
        const username = registerForm.username.value
        const password = registerForm.password.value
        const age = registerForm.age.value
        const email = registerForm.email.value
        const mobileNumber = registerForm.mobileNumber.value


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