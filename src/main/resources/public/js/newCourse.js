window.addEventListener("load", () => {
  newCourse();
});

async function newCourse() {
  document
    .querySelector("#new-course")
    .addEventListener("submit", async (e) => {
      e.preventDefault();
      console.log(e);
      const courseForm = e.target;
      const name = courseForm.name.value;
      const tutor = courseForm.tutor.value;
      const maxPeopleLimit = courseForm.maxPeopleLimit.value;
      const location = courseForm.location.value;
      const openDatetime = courseForm.openDatetime.value;
      const endDatetime = courseForm.endDatetime.value;

      const body = {
        name,
        tutor,
        maxPeopleLimit,
        location,
        openDatetime,
        endDatetime,
      };
      console.log(body);
      const res = await fetch("/admin/newcourse", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
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
