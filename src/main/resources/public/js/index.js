window.addEventListener('load', async () => {
    await getAllCourse();
} )

async function getAllCourse() {
    const res = await fetch("/course/list")
    const data = await res.json()
    if (res.ok) {
        const message = data.message
        const rows = data.data
        console.log(message)
        console.log(rows)
        const courseContainerElem = document.querySelector("#table-group")
        let html = "";
        for(let row of rows) {
            html += `<tr>
                                   <td><strong>${row.name}</strong></td>
                                   <td>${row.tutor}</td>
                                   <td>${row.openDatetime}</td>
                                   <td>${row.endDatetime}</td>
                                   <td>${row.gymRoomId}</td>
                                   <td>${row.maxPeopleLimit}</td>
                                   <td><a href="#" class="btn btn-outline-dark rounded-pill">Register</a></td>
                                 </tr>`
        }
        courseContainerElem.innerHTML = html

        // 
    } else {
        alert("Fail to fetch getAllCourse")
    }
    
}

