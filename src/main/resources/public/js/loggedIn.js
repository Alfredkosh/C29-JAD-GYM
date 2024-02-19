window.addEventListener('load', async () => {
  await getUsername();
  await addlogoutEventListener();
} )
async function addlogoutEventListener() {
  document.querySelector("#logoutBtn").addEventListener("click", (e) => {
    localStorage.removeItem("token")
    window.location.reload()
  })
  
}

async function getUsername() {
// console.log(httpResponse);
  let httpResponse = await fetch("/auth/username", {
    headers: {
      "Authorization": `Bearer ${localStorage.getItem('token')}`
    }
  });
  let result;

  if (httpResponse.status == 200) {
    result = await httpResponse.json();

      // console.log("name", result);
  
      document.querySelector(
        "#username-display"
      ).innerHTML = `<li class="nav-item text-uppercase" id="username-display">
      <a href="/profile" class="item-anchor btn btn-outline-primary rounded-pill">Welcome ${result.data}</a>
    </li>`;

    document.querySelector(
      "#logout-area"
    ).innerHTML = `<li class="nav-item text-uppercase" id="username-display">
      <div  id="logoutBtn" class="item-anchor btn btn-outline-primary rounded-pill">Log out</div>
    </li>`;

    document.querySelector("#username-display .item-anchor").addEventListener("click", () => {
      // Redirect to the desired page
      window.location.href = "/profile";
    });
  } else {
    result = await httpResponse.json();
  }
}

