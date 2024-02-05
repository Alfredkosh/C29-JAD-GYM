window.addEventListener('load', async () => {
    await getAllCourse();
} )

async function getAllCourse() {
    const res = await fetch("/course/list")
    const data = await res.json()
    if (res.ok) {
        const message = data.message
        const rows = data.data
        console.log(rows)
        const courseContainerElem = document.querySelector("#course-container")
        let html = "";
        for(let row of rows) {
            html += `<div class="col-md-6">
             <div class="class-item aos-init aos-animate" data-aos="fade" data-aos-delay="0">
               <figure>
                 <img src="images/video-item.jpg" alt="video">
                 <figcaption class="p-5 text-white">
                   <h2 class="text-white m-0">${row.name}</h2>
                   <p class="m-0">Lorem consequatur eligendi vel esse culpa repudiandae</p>
                   <a href="#" class="btn btn-outline-light rounded-pill">Register Now</a>
                 </figcaption>
               </figure>
             </div>
           </div>`
        }
        courseContainerElem.innerHTML = html
        // 
    } else {
        alert("Fail to fetch getAllCourse")
    }
    
}