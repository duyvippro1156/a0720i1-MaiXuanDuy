let name = document.getElementById('guestname');
let idNumber = document.getElementById('guestid');
let dateOfBirth = document.getElementById('guestdob');
let mail = document.getElementById('email');
let address = document.getElementById('address');
let customer =document.getElementById('guestclass')
let discount = document.getElementById('discount');
let amount = document.getElementById('amount');
let rentDays = document.getElementById('rentdays');
let typeOfHouse= document.getElementById('services');
let typeOfRoom= document.getElementById('roomtype');
let arrNameCustomers=[]
function mouseclick() {
    let options= parseInt(prompt('1.Hiển thị thông tin khách hàng\n'+
        '2.Chỉnh sửa thông tin khách hàng\n'+
        '3.Hiển thị giá tiền sau khi được giảm giá'));
    switch (options) {
        case 1: {
            showInformation();
            break;
        }
        case 2 :{
            break;
        }
        case 3: {
            calculate();
            break;
        }
        case 4: {
            addNameCustomer();
            break;
        }
        default:{
            break;
        }
    }
}
function showInformation() {
    alert("Thông tin của bạn\n" + "Your Name :" + name.value + "\n" + "ID Number :" + idNumber.value + "\n" + "Date Of Birth :" + dateOfBirth.value
        + "\n" + "Email :" +mail.value+ "\n" + "Address :" + address.value + "\n" + "Customer :" + customer.value + "\n" + "Discount Code :" + discount.value
        + "\n" + "Amount of people :" + amount.value + "\n" + "Rent Days :" + rentDays.value + "\n" +
        "Type Of House:" + typeOfHouse.value + "\n" + "Type Of Room:" + typeOfRoom.value
    )
}
function calculate() {
    let priceHouse=0 ;
    let discount=0;
    let price=0 ;
    rentDays=parseInt(rentDays.value)
    // Giá loại dịch vụ
    switch (typeOfHouse.value) {
        case 'Villa' :
            priceHouse = 500;
            break ;
        case 'House' :
            priceHouse = 300;
            break ;
        case 'Room' :
            priceHouse = 100;
            break ;
    }
    // Giảm giá theo địa chỉ
    switch (address.value) {
        case 'Đà Nẵng' :
            discount += 20;
            break ;
        case 'Huế' :
            discount += 10;
            break ;
        case 'Quảng Nam' :
            discount += 5;
            break ;
        default:
            break ;
    }
    // Giảm giá theo số ngày thuê phòng
    if(rentDays>7) {
        discount += 30;
    }
    else if(rentDays>=5 && rentDays<=7) {
        discount += 20;
    }
    else if(rentDays>2 && rentDays<=4) {
        discount += 10;
    }
    // Giảm giá theo loại khách hàng
    switch (customer.value) {
        case "Diamond":{
            discount +=15 ;
            break;
        }
        case "Platinum":{
            discount +=10 ;
            break;
        }
        case "Gold":{
            discount +=5 ;
            break;
        }
        case "Silver":{
            discount +=2 ;
            break;
        }
        case "Member":{
            discount +=0 ;
            break;
        }
    }
    // Tính tiền cần phải trả
    price = priceHouse*rentDays-discount;
    alert('Tổng số tiền bạn đã được giảm '+discount+'$' +'\n'+
        'Tổng số tiền bạn phải trả '+price+'$')
}
function  addNameCustomer() {
    for (let i=0; i<amount.value;i++){
        let nameCustomer=prompt('Nhập tên của khách hàng '+(i+1));
        let ageCustomer=prompt('Nhập tuổi khách hàng' +(i+1));
        let idCustomer=prompt('Nhập cmnd khách hàng' +(i+1));
        arrNameCustomers[i]= new Array();
        for(let j=0; j<3;j++ ){
            arrNameCustomers[i][0]=nameCustomer;
            arrNameCustomers[i][1]=ageCustomer;
            arrNameCustomers[i][2]=idCustomer +'<br>';
        }
    }
    console.log(arrNameCustomers)
}