let btnBook = document.getElementById("book_appointment");

btnBook.addEventListener("click", async () => {
  let date = document.getElementById("inputDate").value;
  let slot = document.getElementById("slot-select").value;
  let token = sessionStorage.getItem("token");
  let name = sessionStorage.getItem("name");
  let trainerId = sessionStorage.getItem("trainerId");

  if (!token) {
    alert("Please Login First to Book an Appointment");
    window.location.href = "/login";
  } else if (date === "" || slot === "") {
    alert("Please fill all the fields");
  } else {
    let obj = {
      trainerId: trainerId,
      bookingDate: date,
      bookingSlot: slot,
    };
    await bookAnAppointment(obj, token, name);
  }
});

async function bookAnAppointment(obj, token, name) {
  try {
    let res = await fetch(`${baseUrl}/booking/create`, {
      method: "POST",
      headers: {
        "Content-type": "application/json",
        Authorization: `${token}`,
      },
      body: JSON.stringify(obj),
    });

    if (!res.ok) {
      throw new Error("Failed to book an appointment.");
    }

    let out = await res.json();

    if (out.msg == "This Slot is Not Available.") {
      alert("This Slot is Not Available.");
    } else if (out.msg == "new booking created successfully") {
      alert(`Hi, ${name} Your booking is confirmed on ${obj.bookingDate}`);
    } else {
      alert("Something went wrong");
    }
  } catch (error) {
    console.log("Error:", error);
    alert("Something went wrong");
  }
}