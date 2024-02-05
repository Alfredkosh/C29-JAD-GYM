window.addEventListener('load', () => {
    login()
})

async function login() {
    document.querySelector("#login-form").addEventListener('submit', async (e) => {
        e.preventDefault()
        console.log(e)
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
            window.location.replace("/page");
        } else {
            console.log("fail to login")
        }

    })
}