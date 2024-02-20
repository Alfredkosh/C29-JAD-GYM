const scanner = new Html5QrcodeScanner("reader", {
  qrbox: {
    width: 250,
    height: 250,
  },
  fps: 20,
});
scanner.render(success, error);
function success(result) {
  console.log(result)
  
  document.getElementById("result").innerHTML = `
  <label>QRcode check-in</label>
  <input type="hidden" name="userId" placeholder="result" value="${result}">
  <h2> ID : <a href="${result}">${result}</a></h2>
  <br>
  <br>
  <label>Location</label>
   <select class="form-select" name="gymRoomId" aria-label="Default select example">
   <option selected>Please select location</option>
   <option value="1">Hysan Place - Causeway Bay</option>
   <option value="2">MOKO - Mongkok</option>
  </select>
  <br>
  <br>
  <input type="submit" value="Submit">
  `;
  scanner.clear();
  document.getElementById("reader").remove();
}
function error(err) {
  console.error(err);
}
