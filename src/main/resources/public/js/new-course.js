window.addEventListener("load", async () => {
  const token = localStorage.getItem("token")
  if (token) {
    const payload = parseJwt(token)
    const userId = payload.userId
  await newCourse(token);
} else {
  window.location.href = "/login"
}
});

async function newCourse(token) {
  document
    .querySelector("#new-course")
    .addEventListener("submit", async (e) => {
      e.preventDefault();
      console.log(e);
      const courseForm = e.target;
      const name = courseForm.name.value;
      const tutor = courseForm.tutor.value;
      const maxPeopleLimit = courseForm.maxPeopleLimit.value;
      const gymRoomId = courseForm.gymRoomId.value;
      const openDatetime = courseForm.openDatetime.value;
      const endDatetime = courseForm.endDatetime.value;

      const body = {
        name,
        tutor,
        maxPeopleLimit,
        gymRoomId,
        openDatetime: convertToUTC(openDatetime),
        endDatetime: convertToUTC(endDatetime),
      };
      console.log(body);
      const res = await fetch("/admin/newcourse", {
        method: "POST",
        headers: { "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
       },
        body: JSON.stringify(body),
      });
      if (res.ok) {
        Swal.fire({
          icon: "success",
          title: "New course added",
          showConfirmButton: true,
        }).then(() => {
          console.log("Swal.fire() resolved successfully");
          window.location.replace("/admin");
        });
      } else {
        console.log("fail to register");
        Swal.fire({
          icon: "error",
          title: "Fail to add",
          text: "Please try again!",
        });
      }
    });
}
function convertToUTC(datetimeInput) {
  const date = new Date(datetimeInput);

  const utcYear = date.getUTCFullYear();
  const utcMonth = date.getUTCMonth() + 1; // Months are zero-based, so we add 1
  const utcDay = date.getUTCDate();
  const utcHours = date.getUTCHours();
  const utcMinutes = date.getUTCMinutes();
  const utcSeconds = date.getUTCSeconds();

  const utcDatetimeString = `${utcYear}-${padZero(utcMonth)}-${padZero(utcDay)}T${padZero(utcHours)}:${padZero(utcMinutes)}:${padZero(utcSeconds)}Z`;

  return utcDatetimeString;
}

// Function to pad single-digit numbers with leading zeros
function padZero(num) {
  return num.toString().padStart(2, '0');
}

function parseJwt (token) {
  var base64Url = token.split('.')[1];
  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
  }).join(''));

  return JSON.parse(jsonPayload);
}
