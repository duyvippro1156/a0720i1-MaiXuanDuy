import { Component, OnInit } from '@angular/core';
import {StudentService} from '../student.service';
import {Router} from '@angular/router';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.scss']
})
export class StudentCreateComponent implements OnInit {

  formCreate!: FormGroup;

  constructor(private studentService: StudentService, private router: Router) {

  }

  validationMessage = {
    Id: [
      {type: 'required', message: 'Mã Sinh viên không để trống'},
      {type: 'exist', message: 'Mã Sinh viên đã tồn tại'}
    ],
    Name: [
      {type: 'required', message: 'Tên Sinh viên không để trống'},
      {type: 'pattern', message: 'Tên Sinh viên không được chứa ký tự đặc biết'}
    ],
    Group: [
      {type: 'required', message: 'Nhóm không để trống'},
      {type: 'pattern', message: 'Nhóm không đúng định dạng Nhóm x'},
    ],
    Topic: [
      {type: 'required', message: 'Đề tài không để trống'},
    ],
    Coach: [
      {type: 'required', message: 'GV hướng dẫn không để trống'}
    ],
    Email: [
      {type: 'required', message: 'Email không để trống'},
      {type: 'pattern', message: 'Email không đúng định dạng acb@def.com'}
    ],
    Phone: [
      {type: 'required', message: 'Số điện thoại không để trống'},
      {type: 'pattern', message: 'Số điện thoai không đúng định dạng 10-12 số'}
    ],
  };
  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.formCreate = new FormGroup({
      Id: new FormControl(''),
      Name: new FormControl('', Validators.pattern('^[a-zA-Z0-9]*$')),
      Group: new FormControl('', Validators.pattern('^Nhóm [1-9]')),
      Topic: new FormControl(''),
      Coach: new FormControl(''),
      Email: new FormControl('', Validators.pattern('^[a-z][a-z0-9_\\.]{5,32}@def.com$')),
      Phone: new FormControl('', Validators.pattern('^[0-9]{10,12}$')),
    });
  }
  createStudent() {
    if (this.formCreate.valid) {
      this.studentService.createStudent(this.formCreate.value).subscribe(data => {
        this.router.navigateByUrl('/');
      });
    }
  }
}
