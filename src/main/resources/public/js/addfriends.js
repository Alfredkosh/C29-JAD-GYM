window.addEventListener("load", () => {
    getFriendList()
})
async function getFriendList() {
    let userId;
    const token = localStorage.getItem("token")
    if (!token) {
        alert("Please login first")
    }
    const payload = parseJwt(token);
    userId = payload.userId;
    const res = await fetch("/friends/friend", {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    const data = await res.json();
    if (res.ok) {
      const drop4 = document.querySelector("#friend-list");
      let html = "";
      console.log(data);

      for (const item of data) {
        const userAId = item.userAId;
        const userBId = item.userBId;

        const userAName = item.userAName;
        const userBName = item.userBName;

        const selectedUserId = userId === userAId ? userBId : userAId;
        const selectedUserName = userId === userAId ? userBName : userAName;

        console.log({
          userId,
          userAId,
          userBId,
          userAName,
          userBName,
          selectedUserId,
          selectedUserName
        })
        html += ` <li>
        <div class='frame'>
            <div class='hour'>
                ${selectedUserId}
            </div>
            <div class='full-time'>
               ${selectedUserName}
            </div>
        </div>
    </li>`
      }
      drop4.innerHTML = html

    }
}
async function addFriend() {
    const friendElem = document.querySelector("#friend-name")
    const friendId = friendElem.value
    // console.log()
    console.log(friendId)
    const token = localStorage.getItem("token")
    if (!token) {
        alert("Please login first")
    }
    const res = await fetch("/friends/friend", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
        },
        body: JSON.stringify({
            userId: friendId
        }),

    })
    const data = await res
    if (res.ok) {
        getFriendList(token);
        console.log("Success add friend")
    }
    // friendElem.addEventListener((e) => {
    //     console.log(e)
    //     // const value = e.target.value
    //     // console.log(value)
    // })
    // console.log("addFriend")
}

function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
  }
