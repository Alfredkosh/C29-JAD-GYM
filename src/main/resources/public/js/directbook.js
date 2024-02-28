window.addEventListener("load", async () => {
  // Get the current URL
  const url = new URL(window.location.href);

  // Get the search parameters from the URL
  const searchParams = new URLSearchParams(url.search);

  // Get the value of the 'courseId' query parameter
  const courseId = searchParams.get("courseId");

  console.log(courseId);
  const token = localStorage.getItem("token");
  if (token) {
    const payload = parseJwt(token);
    const userId = payload.userId;
    await getCourseById(token, courseId);
  } else {
    window.location.href = "/login";
  }
});

async function getCourseById(token, courseId) {
  const res = await fetch(`/course/${courseId}`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  const data = await res.json();
  if (res.ok) {
    const message = data.message;
    const rows = data.data;
    console.log(message);
    console.log(rows);

    const gymRoomMap = {
      // Define your mapping here
      1: "Hysan Place - Causeway Bay",
      2: "MOKO - Mongkok",
      // ...
    };

    const classElem = document.querySelector("#main_cont");
    const gymRoomName = gymRoomMap[rows.gymRoomId] || "Unknown";

    classElem.innerHTML = ` <div id="navbar">
        <a href="/classes">Appointments </a>
    </div>

    <div id="main_body">
      <div class="row">
        <div class="col-4 time-col">
          <div class="listContainer">
            <h4>Class</h4>
            <div class="wording">${rows.name}</div>
            </div>
        </div>
        <div class="col-4">
          <div class="listContainer ">
            <h4>Start Time</h4>
            <div class="wording">${rows.openDatetime}</div>
            </div>
        </div>
        <div class="col-4 time-col">
          <div class="listContainer ">
            <h4>End Time</h4>
            <div class="wording">${rows.endDatetime}</div>
            </div>
        </div>
        
      </div>
      <div class="row">
        <div class="col-4 time-col">
          <div class="listContainer ">
            <h4>Gym Room</h4>
            <div class="wording">${gymRoomName}</div>
            </div>
        </div>

        <div class="col-4 friend-col">
          <h4>Other Friends</h4>
          <div class="listContainer">

            <div class="dropdown4">
              <span class="selLabel4">Select Place </span>
              <input type="hidden" id="selectedFriend" name="selectedFriend">
              <ul id="dropdown4-list" class="dropdown4-list">
               
              </ul>
            </div>
          </div>
        </div>
        <div class="col-4"></div>
      </div>
  

    </div>

      <br>


    
      </div>
    <div>

</div>
`;
$(".selLabel4").click(function () {
    $(".dropdown4").toggleClass("active");
  });
    await getFriends(token);
  } else {
    alert("Fail to fetch getAllCourse");
  }
}

function parseJwt(token) {
  var base64Url = token.split(".")[1];
  var base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
  var jsonPayload = decodeURIComponent(
    window
      .atob(base64)
      .split("")
      .map(function (c) {
        return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
      })
      .join("")
  );

  return JSON.parse(jsonPayload);
}

async function getFriends(token) {
  let userId;
  if (token) {
    const payload = parseJwt(token);
    userId = payload.userId;
  }
  const res = await fetch("/friends/friend", {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  const data = await res.json();
  if (res.ok) {
    const drop4 = document.querySelector("#dropdown4-list");
    console.log(drop4)
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
        selectedUserName,
      });
      html += `<li data-value="${selectedUserId}">
            <span>${selectedUserName}</span>
          </li>`;
    }
    drop4.innerHTML = html;

    $(".dropdown4-list li").click(function () {
      const selectedValue = $(this).data("value");
      $("#selectedFriend").val(selectedValue);
      $(".selLabel4").text($(this).text());
      $(".dropdown4").removeClass("active");
      $(".selected-listItem p span").text($(".selLabel4").text());
    });
  }
}
