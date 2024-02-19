window.addEventListener('load', async () => {
    await getLiveCount();
} )

async function getLiveCount() {
    const token = localStorage.getItem("token")
    console.log(token)
    if (!token) {
        window.location.replace("/login");
    }
    const res = await fetch("/admin/livecount", {
        headers: {
            Authorization: `Bearer ${token}`
        }
    })
    const data = await res.json()
    if (res.ok) {
        const visitors = data.PeopleAmount;
        console.log(visitors);


        let gymRoomId1 = 0;

        for(let visitor of visitors){
        if (visitor.gymRoomId == 1) {
            gymRoomId1 = gymRoomId1 + 1
          }

        };

        console.log(gymRoomId1.length)
        
//
        let gymRoomId2 = 0;

        for(let visitor of visitors){
          if (visitor.gymRoomId == 2) {
              gymRoomId2 = gymRoomId2 + 1
            }
  
          };
  
          console.log(gymRoomId2)


        const gymRoom1 = document.querySelector(".right-map-w3-agile")

        gymRoom1.innerHTML = `<h2>Live Count : ${gymRoomId1.length}</h2>
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d118112.87791707182!2d114.13127076713477!3d22.314802161154283!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3404016e86896235%3A0x8462ee33af6a1838!2sTecky%20Academy%20Kowloon%20Bay%20Branch!5e0!3m2!1szh-TW!2shk!4v1707210078315!5m2!1szh-TW!2shk" width="400" height="250" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        <ul class="add">
            <li class="dot">Hyson Place - Causeway Bay</li>
            <li class="mobile"> 2345 4567</li>
            <li class="mes"> <a href="mailto:cwbpowerfitness@email.com">cwbpowerfitness@email.com</a></li>
        </ul>
    `

     const gymRoom2 = document.querySelector(".right-map-w3-agile")

     gymRoom2.innerHTML = `<h2>Live Count : ${gymRoomId2}</h2>
     <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d118112.87791707182!2d114.13127076713477!3d22.314802161154283!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3404016e86896235%3A0x8462ee33af6a1838!2sTecky%20Academy%20Kowloon%20Bay%20Branch!5e0!3m2!1szh-TW!2shk!4v1707210078315!5m2!1szh-TW!2shk" width="400" height="250" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
     <ul class="add">
         <li class="dot">Hyson Place - Causeway Bay</li>
         <li class="mobile"> 2345 4567</li>
         <li class="mes"> <a href="mailto:cwbpowerfitness@email.com">cwbpowerfitness@email.com</a></li>
     </ul>`


    } else {
        alert("Fail to fetch getAllVisitor")
    }

}