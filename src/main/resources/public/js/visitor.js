window.addEventListener('load', async () => {
    await getAllVisitor();
} )

async function getAllVisitor() {
    const res = await fetch("/admin/visitor")
    const data = await res.json()
    if (res.ok) {
        const visitors = data.numberOfPeople;
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
        <h3>Gym - Hong Kong</h3>
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



    } else {
        alert("Fail to fetch getAllVisitor")
    }

}