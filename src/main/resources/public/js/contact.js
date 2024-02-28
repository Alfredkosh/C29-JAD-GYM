const form = document.getElementById("submit-contact");

function handleSubmit(event) {
  event.preventDefault(); // Prevent the default form submission

  // Perform any necessary form validation or data manipulation here

  // Redirect to another page after form submission
  window.location.href = "/thank-you";
}

form.addEventListener("submit", handleSubmit);