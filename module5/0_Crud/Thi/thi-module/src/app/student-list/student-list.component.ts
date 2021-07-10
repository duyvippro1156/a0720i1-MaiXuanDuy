import { Component, OnInit } from '@angular/core';
import {StudentService} from '../student.service';
import {Router} from '@angular/router';
import {Student} from '../student';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})
export class StudentListComponent implements OnInit {
  listStudent: Student[] =  [];
  constructor(private studentService: StudentService,
              private router: Router) { }

  ngOnInit(): void {
    this.initListStudent();
  }
  initListStudent(){
    this.studentService.getAllStudent().subscribe(data => {
      this.listStudent = data;
    });
  }

  deleteStudent(stuID) {
    this.studentService.deleteStudent(stuID).subscribe(data => {
      this.listStudent = data;
    });
  }

}
