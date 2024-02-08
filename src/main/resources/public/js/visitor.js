window.addEventListener('load', async () => {
    await getAllVisitor();
} )

async function getAllVisitor() {
    const res = await fetch("/admin/visitor")
    const data = await res.json()
    if (res.ok) {
        const visitor = data.numberOfPeople
        console.log(message)

        const gymRoomId1 = visitor.reduce((count, obj) => {
        if (obj.gymRoomId === 1) {
            return count + 1;
          }
        else {
            alert("Fail to fetch getAllVisitor")
          }
        }, 0);

        const gymRoomId2 = visitor.reduce((count, obj) => {
        if (obj.gymRoomId === 2) {
                    return count + 1;
                  }
                else {
                    alert("Fail to fetch getAllVisitor")
                  }
                }, 0);

        const AllVisitor = visitor.gymRoomId.size();

        //
    } else {
        alert("Fail to fetch getAllVisitor")
    }

}