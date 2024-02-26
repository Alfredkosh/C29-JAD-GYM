
async function getLiveCount(token) {
  const res = await fetch("/record/livecount", {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  const data = await res.json();
  if (res.ok) {
    const visitors = data.data;
    console.log("Amount =", visitors);

    for (let visitor of visitors) {
      const gymRoomId = visitor.gymRoomId
      const count = visitor.count;
      const gymRoom = document.querySelector(`#live-count-${gymRoomId}`);
      gymRoom.innerHTML = count
      
    }


  } else {
    alert("Fail to fetch getLiveCount");
  }
}

