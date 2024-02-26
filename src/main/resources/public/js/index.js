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

        const gymRoomMap = {
            // Define your mapping here
            1: "Hysan Place - Causeway Bay",
            2: "MOKO - Mongkok",
            // ...
        };

        const courseContainerElem = document.querySelector("#table-group")
        let html = "";
        for(let row of rows) {
            const gymRoomName = gymRoomMap[row.gymRoomId] || "Unknown";
            html += `<tr>
                                   <td><strong>${row.name}</strong></td>
                                   <td>${row.tutor}</td>
                                   <td>${row.openDatetime}</td>
                                   <td>${row.endDatetime}</td>
                                   <td>${gymRoomName}</td>
                                   <td>${row.maxPeopleLimit}</td>
                                   <td><a href="/booking" class="btn btn-outline-dark rounded-pill">Book</a></td>
                                 </tr>`
        }
        courseContainerElem.innerHTML = html

        // 
    } else {
        alert("Fail to fetch getAllCourse")
    }



    $(document).ready(function () {
        $('a.close').click(function (event) {
            event.preventDefault();
            $('.popup').hide("slow");
        });
    });



}

