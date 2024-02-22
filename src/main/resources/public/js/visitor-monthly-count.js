window.addEventListener("load", async () => {
  const token = localStorage.getItem("token")
  if (token) {
    const payload = parseJwt(token)
    const userId = payload.userId
  await monthlyVisitors(token);
} else {
  window.location.href = "/login"
}
});

async function monthlyVisitors(token) {
  document
    .querySelector("#monthly-visitor")
    .addEventListener("submit", async (e) => {
      e.preventDefault();
      console.log(e);
      const countForm = e.target;
      const startDate = countForm.startDate.value;
      const endDate = countForm.endDate.value;

      const body = {
        startDate,
        endDate,
      };
      console.log(body);
      const res = await fetch("/admin/visitor", {
        method: "POST",
        headers: { "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
       },
        body: JSON.stringify(body),
        
      });
      const data = await res.json();
      console.log(data);
      if (res.ok) {
        // Swal.fire({
        //   icon: "success",
        //   title: "Here is the selected flow",
        //   showConfirmButton: true,
        // }).then(() => {
        const visitors = data.NumberOfPeople;

        console.log(visitors);


        let gymRoomId1 = 0;

        for(let visitor of visitors){
        if (visitor.gymRoomId == 1) {
            gymRoomId1 = gymRoomId1 + 1
          }

        };

        console.log(gymRoomId1)
        
//
        let gymRoomId2 = 0;

        for(let visitor of visitors){
          if (visitor.gymRoomId == 2) {
              gymRoomId2 = gymRoomId2 + 1
            }
  
          };
  
          console.log(gymRoomId2)

        const AllVisitor = visitors.length;

        console.log(AllVisitor)

        const gymRoom1 = document.querySelector("#hk")

        gymRoom1.innerHTML = `<div class="agileits-social">
        <h3>Gym - Causeway Bay</h3>
    </div>
    <div class="send-w3layouts">
        <h3>人流</h3>
        ${gymRoomId1}
     </div>`

     const gymRoom2 = document.querySelector("#mk")

     gymRoom2.innerHTML = `<div class="agileits-social">
                          <h3>Gym - Mongkok</h3>
                      </div>
                      <div class="send-w3layouts">
                          <h3>人流</h3>
                          ${gymRoomId2}
                      </div>`

      const totalNumber = document.querySelector("#totalNo")

      totalNumber.innerHTML = `<p>總人流</p>
                                           <br>
                                          ${AllVisitor}`

          console.log("Swal.fire() resolved successfully");
          // window.location.replace("/admin");
        // });
      } else {
        console.log("fail to select");
        Swal.fire({
          icon: "error",
          title: "Fail to select",
          text: "Please try again!",
        });
      }
    });
}

function parseJwt (token) {
  var base64Url = token.split('.')[1];
  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
  }).join(''));

  return JSON.parse(jsonPayload);
}
