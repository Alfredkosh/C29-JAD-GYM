//window.addEventListener('load', async () => {
//    await getUsername();
//} )


//async function getUsername() {
//    // console.log(httpResponse);
//    const httpResponse = await fetch("/username");
//    const result;
//    console.log("Hi");
//
//    if (httpResponse.status == 200) {
//      result = await httpResponse.json();
//
//      console.log("name", result);
//
//      document.querySelector(
//        "#username-display"
//      ).innerHTML = `<button class="btn btn-outline-success" type="submit"> Welcome ${result.data} </button>`;
//
//      document.querySelector(
//        "#logout-area"
//      ).innerHTML = `<button class="btn btn-outline-success" type="submit">
//      Log out
//    </button>`;
//    } else {
//      result = await httpResponse.json();
//    }
//  }
//