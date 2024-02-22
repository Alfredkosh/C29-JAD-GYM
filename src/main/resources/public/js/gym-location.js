window.addEventListener('load', async () => {
    const token = localStorage.getItem("token")
    if (token) {
      const payload = parseJwt(token)
    await getAllGym();
} else {
    window.location.href = "/login"
  } 
});

async function getAllGym() {
    const res = await fetch("/gym/details")
    const data = await res.json()
    if (res.ok) {
        const message = data.message
        const rows = data.data
        console.log(message)
        console.log(rows)

        // const courseContainerElem = document.querySelector("#table-group")
        // let html = "";
        // for(let row of rows) {
        //     html += `<div class="right-map-w3-agile" id="HPCB">
        //     <h2>Live Count : </h2>
            
        //     <ul class="add">
        //         <li class="dot">Hyson Place - Causeway Bay</li>
        //         <li class="address"> Address : 500 Hennessy Road, Lee Garden, Causeway Bay, Hong Kong</li>
        //         <li class="mobile"> Tel : 2345 4567</li>
        //         <li class="mes"> <a href="mailto:cwbpowerfitness@email.com"> Email : cwbpowerfitness@email.com</a></li>
        //         <li class="mobile"> 2345 4567</li>
        //     </ul>
        
        //     <div class="map-grid-right">
        //         <i class="fa fa-map-marker" aria-hidden="true"></i>
        //     </div>
        //     <div class="clear"></div>
        
        //         <br>
        //     <br>
        //     <br>
        //     <br>
        //     <br>
        //     <br>
        // </div>`
        // }
        // courseContainerElem.innerHTML = html

        // 
    } else {
        alert("Fail to fetch getAllGym")
    }
    
}

function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
  
    return JSON.parse(jsonPayload);
  }