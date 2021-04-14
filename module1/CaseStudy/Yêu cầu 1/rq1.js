function mouseclick() {
    let name = document.getElementById("guestname").value;
    let idNumber = document.getElementById("guestid").value;
    let dateOfBirth = document.getElementById("guestdob").value;
    let mail = document.getElementById("email").value;
    let address = document.getElementById("address").value;
    let customer = document.getElementById("guestclass");
    let textCustomer = customer.options[customer.selectedIndex].text;
    let valueCustomer = Number(customer.value);
    let discount = document.getElementById("discount").value;
    let amount = document.getElementById("amount").value;
    let rentDays = Number(document.getElementById("rentdays").value);
    let house = document.getElementById("services");
    let textHouse = house.options[house.selectedIndex].text;
    let priceHouse = Number(house.value);
    let room = document.getElementById("roomtype");
    let typeOfRoom = room.value;
    alert("Thông tin của bạn" + "\n" + "Your Name :" + name + "\n" + "ID Number :" + idNumber + "\n" + "Date Of Birth :" + dateOfBirth
        + "\n" + "Email :" + mail + "\n" + "Address :" + address + "\n" + "Customer :" + textCustomer + "\n" + "Discount Code :" + discount
        + "\n" + "Amount of people :" + amount + "\n" + "Rent Days :" + rentDays + "\n" + "Rent Days :" + rentDays
        + "\n" + "Type Of House:" + textHouse + "\n" + "Type Of Room:" + typeOfRoom
    );
    // tính số tiền cần trả
    let payMoney;
    payMoney = priceHouse * rentDays * (1 - valueCustomer / 100);
    alert("Số tiền cần phải trả là :" + payMoney + "$")
}
function resetClick() {
    confirm("Bạn chắc chắn muốn reset ??")
}