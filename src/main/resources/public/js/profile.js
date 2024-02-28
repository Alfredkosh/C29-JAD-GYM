const currentDate = new Date();
const weekdays = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
const weekdayIndex = currentDate.getDay();
const currentWeekday = weekdays[weekdayIndex];

const dateElement = document.getElementById("date");
dateElement.innerText = currentDate.toDateString();

// const weekdayElement = document.getElementById("weekday");
// weekdayElement.innerText = currentWeekday;