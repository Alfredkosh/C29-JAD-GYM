let baseUrl=`https://gymzone.click/booking`
let btnBook = document.getElementById("book_appointment");

btnBook.addEventListener("click", async () => {
  let friends = document.getElementById("selectedFriend").value;
  let classId = document.getElementById("book-your-class").value;
  let date = document.getElementById("inputDate").value;
  let gymRoomName = document.getElementById("selectedGym").value;
  let time = document.getElementById("selectedTime").value;
  

  const obj = {
    friends,
    classId,
    date,
    gymRoomName,
    time
  }
  console.log(obj)


});

async function bookAnAppointment(obj, token, name) {
  console.log(obj)
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
      alert(`Hi, ${usernameDisplay} Your booking is confirmed on ${obj.date}`);
    } else {
      alert("Something went wrong");
    }
  } catch (error) {
    console.log("Error:", error);
    alert("Something went wrong");
  }
}
