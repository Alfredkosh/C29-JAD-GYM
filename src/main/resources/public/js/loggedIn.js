window.addEventListener('load', async () => {
   await getUsername();
   addlogoutEventListener();
} )


async function getUsername() {
    // console.log(httpResponse);
    let httpResponse = await fetch("/auth/username", {
      headers: {
        "Authorization": `Bearer ${localStorage.getItem('token')}`
      }
    });
    let result;
    console.log("Hi");
  
    if (httpResponse.status == 200) {
      result = await httpResponse.json();
  
      console.log("name", result);
  
      document.querySelector(
        "#username-display"
      ).innerHTML = `<li class="nav-item text-uppercase" id="username-display">
      <div class="item-anchor btn btn-outline-primary rounded-pill">Welcome ${result.data}</div>
    </li>`;
  
      document.querySelector(
        "#logout-area"
      ).innerHTML = `<li class="nav-item text-uppercase" id="username-display">
      <a href="/" class="item-anchor btn btn-outline-primary rounded-pill">Log out</a>
    </li>`;
    } else {
      result = await httpResponse.json();
    }
  }


  async function addlogoutEventListener() {
    localStorage.removeItem("token")
  }