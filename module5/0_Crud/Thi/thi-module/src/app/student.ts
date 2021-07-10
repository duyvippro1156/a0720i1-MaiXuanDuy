export class Student {
  Id: Number;
  Name: String;
  Group: String;
  Topic: String;
  Coach: String;
  Email: String;
  Phone: String;

  constructor( Id: Number,
               Name: String,
               Group: String,
               Topic: String,
               Coach: String,
               Email: String,
               Phone: String)
  {
    this.Id = Id;
    this.Name = Name;
    this.Group = Group;
    this.Topic = Topic;
    this.Coach = Coach;
    this.Email = Email;
    this.Phone = Phone;
  }
}
