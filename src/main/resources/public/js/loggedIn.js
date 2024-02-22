window.addEventListener("load", async () => {
  const token = localStorage.getItem("token");
  if (token) {
    const payload = parseJwt(token);
    const userId = payload.userId;
    const isAdmin = payload.isAdmin;
    await getUsername(token);
    await addlogoutEventListener();
  } else {
    window.location.href = "/login";
  }
});

async function addlogoutEventListener() {
  document.querySelector("#logoutBtn").addEventListener("click", (e) => {
    localStorage.removeItem("token");
    window.location.reload();
  });
}

async function getUsername(token) {
  const payload = parseJwt(token);
  const isAdmin = payload.isAdmin;
  // console.log(httpResponse);
  let httpResponse = await fetch("/auth/username", {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  let result1;
  let result2;

  if (httpResponse.status == 200 && isAdmin == false) {
    result1 = await httpResponse.json();

    console.log(result1);

    // console.log("name", result);

    document.querySelector(
      "#username-display"
    ).innerHTML = `<li class="nav-item text-uppercase" >
      <a href="/profile" class="item-anchor btn btn-outline-primary rounded-pill">Welcome ${result1.data}</a>
    </li>`;
  } else if (httpResponse.status == 200 && isAdmin == true) {
    result2 = await httpResponse.json();

    document.querySelector(
      "#username-display"
    ).innerHTML = `<li class="nav-item text-uppercase" >
      <a href="/admin" class="item-anchor btn btn-outline-primary rounded-pill">Welcome ${result2.data}</a>
    </li>`;

  } else {
    await httpResponse.json();
  }
  document.querySelector(
    "#logout-area"
  ).innerHTML = `<li class="nav-item text-uppercase" >
    <a href="/index" id="logoutBtn" class="item-anchor btn btn-outline-primary rounded-pill">Log out</av>
  </li>`;

}

function parseJwt(token) {
  var base64Url = token.split(".")[1];
  var base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
  var jsonPayload = decodeURIComponent(
    window
      .atob(base64)
      .split("")
      .map(function (c) {
        return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
      })
      .join("")
  );

  return JSON.parse(jsonPayload);
}
